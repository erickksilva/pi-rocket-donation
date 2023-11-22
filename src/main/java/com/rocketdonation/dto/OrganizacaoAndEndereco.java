package com.rocketdonation.dto;

import com.rocketdonation.domain.organizacao.Organizacao;

public record OrganizacaoAndEndereco(
        String email,
        String categoria,
        String missao,
        String site,
        String rua,
        Integer numero,
        String cep,
        String zona,
        String complemento
) {

    public static OrganizacaoAndEndereco of(Organizacao organizacao) {
        return new OrganizacaoAndEndereco(organizacao.getEmailOrg(), organizacao.getCategoria(),
                organizacao.getMissao(), organizacao.getSite(), organizacao.getEndereco().getRua(),
                organizacao.getEndereco().getNumero(), organizacao.getEndereco().getCep(), organizacao.getEndereco().getZona(),
                organizacao.getEndereco().getComplemento());
    }
}
