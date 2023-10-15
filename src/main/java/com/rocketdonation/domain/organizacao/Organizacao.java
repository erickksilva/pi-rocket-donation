package com.rocketdonation.domain.organizacao;

import com.rocketdonation.domain.postagem.Postagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public record Organizacao(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idOrg,

        @NotBlank(message = "Insira o nome")
        @Length(max = 100, min = 5, message = "O nome da organização deve estar entre {min} e {max} caracter.")
        String nomeOrg,

        @NotBlank(message = "Insira o telefone")
        @Length(min = 14, max = 14, message = "O telefone deve conter ${max} numeros")
        @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{9}$", message = "Formato do telefone inválido.")
        String telefoneOrg,

        @NotBlank
        @Email(message = "Insira um email valido exemplo: fulano@gmail.com")
        @Length(max = 100, message = "O email deve ser menor que ${max} caracter.")
        String emailOrg,

        @NotBlank(message = "Insira o site da organização")
        @Length(max = 120, message = "O site deve ter no máximo ${max} caracter.")
        String site_org,

        @NotBlank(message = "Insira a missão da organização.")
        @Length(max = 200, message = "O site deve ter no máximo ${max} caracter.")
        String missao_org,

        @NotBlank(message = "Insira a categoria da organização, exemplo: cultura, racismo etc...")
        @Length(max = 50, message = "O site deve ter no máximo ${max} caracter.")
        String categoria_org,

        Date dataCadastro,

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
        ContaBancaria contaBancaria,

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
        Endereco endereco_cep,

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        Postagem postagem

) {
}
