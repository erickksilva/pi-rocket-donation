package com.rocketdonation.dto;

public record CadastroOrg(

        String nomeOrg,
        String telefoneOrg,
        String emailOrg,
        String siteOrg,
        String missaoOrg,
        String categoriaOrg,

        String cep,

        String rua,

        Integer numero,
        String complemento,

        String agenciaConta,
        String numeroConta,

        String chavePix

) {
}
