package com.rocketdonation.web;

import com.rocketdonation.domain.organizacao.ContaBancaria;
import com.rocketdonation.domain.organizacao.Endereco;
import com.rocketdonation.domain.organizacao.Organizacao;
import com.rocketdonation.dto.CadastroOrg;
import com.rocketdonation.services.CadastroOrgService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("organizacao")
public class OrgController {

    private final CadastroOrgService cadastroService;

    public OrgController(CadastroOrgService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping
    public Organizacao save(@RequestBody @Valid CadastroOrg org) {

        return cadastroService.saveOrg(org);
    }

}
