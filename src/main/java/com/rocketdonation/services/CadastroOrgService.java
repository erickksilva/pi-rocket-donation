package com.rocketdonation.services;

import com.rocketdonation.domain.User;
import com.rocketdonation.domain.organizacao.ContaBancaria;
import com.rocketdonation.domain.organizacao.Endereco;
import com.rocketdonation.domain.organizacao.Organizacao;
import com.rocketdonation.dto.CadastroOrg;
import com.rocketdonation.dto.OrganizacaoAndEndereco;
import com.rocketdonation.repositorys.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroOrgService {
    private final ContaRepository contaRepository;
    private final DoadorRepository doadorRepository;
    private final EnderecoRepository enderecoRepository;
    private final OrgRepository orgRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    public CadastroOrgService(ContaRepository contaRepository, DoadorRepository doadorRepository, EnderecoRepository enderecoRepository,
                              OrgRepository orgRepository, UserRepository userRepository, UserService userService) {
        this.contaRepository = contaRepository;
        this.doadorRepository = doadorRepository;
        this.enderecoRepository = enderecoRepository;
        this.orgRepository = orgRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Organizacao findBy(String email, Organizacao org) {


        Organizacao orgUpdate = orgRepository.findByemailOrg(email);

        if (orgUpdate != null) {
            orgUpdate.setCategoria(org.getCategoria());
            orgUpdate.setMissao(org.getMissao());
            orgUpdate.setSite(org.getSite());
            orgUpdate.getEndereco().setCep(org.getEndereco().getCep());
            orgUpdate.getEndereco().setRua(org.getEndereco().getRua());
            orgUpdate.getEndereco().setNumero(org.getEndereco().getNumero());
            orgUpdate.getEndereco().setNumero(org.getEndereco().getNumero());
            orgUpdate.getEndereco().setComplemento(org.getEndereco().getComplemento());
            orgUpdate.getEndereco().setZona(org.getEndereco().getZona());

            orgRepository.save(orgUpdate);
            return orgUpdate;
        }

        return null;
    }

    public List<Organizacao> findAll() {
        return orgRepository.findAll();
    }

    public List<OrganizacaoAndEndereco> listarOrganizacoesDTO() {
        List<Organizacao> organizacoes = orgRepository.findAll();
        return organizacoes.stream()
                .map(OrganizacaoAndEndereco::of)
                .collect(Collectors.toList());
    }


    public List<Organizacao> findAllCategoria(String categoria) {
        return orgRepository.listarCategoria(categoria);
    }

    public Organizacao saveOrg(CadastroOrg org) {
        System.out.println("Passei por aqui");
        User user = new User(org.emailOrg(), org.nomeOrg(), org.chavePix());
        userService.createUser(user);

        Organizacao organizacao = new Organizacao(user.getEmail(), org.siteOrg(), org.missaoOrg(), org.categoriaOrg(), new Date());

        Endereco endereco = new Endereco(org.cep(), org.rua(), org.numero(), org.complemento(), org.zona());

        ContaBancaria conta = new ContaBancaria(org.agenciaConta(), org.numeroConta(), org.chavePix());

        organizacao.setEndereco(endereco);
        organizacao.setContaBancaria(conta);

        enderecoRepository.save(endereco);
        contaRepository.save(conta);
        orgRepository.save(organizacao);

        return organizacao;
    }

    public List<Organizacao> buscarOrganizacoes(String zona, String categoria, String missao) {
        Specification<Organizacao> spec = Specification.where(null);

        if (zona != null && !zona.isEmpty()) {
            spec = spec.and(OrganizacaoSpecifications.filtrarPorZonaCategoriaMissao(zona, null, null));
        }
        if (categoria != null && !categoria.isEmpty()) {
            spec = spec.and(OrganizacaoSpecifications.filtrarPorZonaCategoriaMissao(null, categoria, null));
        }
        if (missao != null && !missao.isEmpty()) {
            spec = spec.and(OrganizacaoSpecifications.filtrarPorZonaCategoriaMissao(null, null, missao));
        }

        return orgRepository.findAll(spec);
    }

//    public List<Organizacao> buscarOrganizacoes(String zona, String categoria, String missao) {
//        Specification<Organizacao> spec = OrganizacaoSpecifications.filtrarPorZonaCategoriaMissao(zona, categoria, missao);
//        return orgRepository.findAll(spec);
//    }


}
