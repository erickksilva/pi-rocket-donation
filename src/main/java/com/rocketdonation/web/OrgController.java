package com.rocketdonation.web;

import com.rocketdonation.domain.organizacao.Organizacao;
import com.rocketdonation.dto.CadastroOrg;
import com.rocketdonation.dto.OrganizacaoAndEndereco;
import com.rocketdonation.repositorys.UserRepository;
import com.rocketdonation.security.CustomUserDetails;
import com.rocketdonation.services.CadastroOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("organizacao")
public class OrgController {

    @Autowired
    private UserRepository userRepository;

    private final CadastroOrgService cadastroService;

    public OrgController(CadastroOrgService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping
    public Organizacao save(@RequestBody @Valid CadastroOrg org) {
        System.out.println("Vim Aqui");
        return cadastroService.saveOrg(org);
    }

    @GetMapping
    public List<OrganizacaoAndEndereco> findAllOrg() {
        return cadastroService.listarOrganizacoesDTO();
    }

    @PutMapping("/{email}")
    public Organizacao updateOrg(@PathVariable String email, @Valid @RequestBody Organizacao organizacao) {
        return cadastroService.findBy(email, organizacao);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Organizacao> findAllCategoria(@PathVariable String categoria) {

        return cadastroService.findAllCategoria(categoria);

    }

    @GetMapping("/categorias")
    public List<Organizacao> buscarOrganizacoes(
            @RequestParam(name = "zona", required = false) String zona,
            @RequestParam(name = "categoria", required = false) String categoria,
            @RequestParam(name = "missao", required = false) String missao
    ) {
        return cadastroService.buscarOrganizacoes(zona, categoria, missao);
    }

    // @GetMapping("/{id}")
    // public OrganizacaoAndEndereco getOrganizacaoById(@PathVariable Long id) {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

    //     OrganizacaoAndEndereco orgAndEndereco = userRepository.findOrgAndEnderecoById(id, userDetails.getId());
    //     return orgAndEndereco;
    // }

    @GetMapping("/teste")
    public void teste() {
        // Obter a autenticação do contexto de segurança
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof CustomUserDetails) {
                // Se o principal for uma instância de CustomUserDetails, você pode acessar o
                // e-mail
                String email = ((CustomUserDetails) principal).getUsername();

                // Faça o que for necessário com o e-mail do usuário
                System.out.println("E-mail do usuário autenticado: " + email);
            } else {
                System.out.println("Principal não é uma instância de CustomUserDetails.");
            }
        } else {
            System.out.println("Usuário não autenticado");
        }
    }

}
