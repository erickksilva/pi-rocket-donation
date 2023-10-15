package com.rocketdonation.domain.organizacao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

@Entity
public record Endereco(

        @Id
        @NotBlank(message = "Insira o cep da organização.")
        String cep,

        @NotBlank(message = "Insira o nome da rua/avenida.")
        String rua,

        @NotNull(message = "Insira o numero.")
        @Positive
        Integer numero,

        @Length(max = 150, message = "O complemento deve ter no máximo {max} caracter.")
        String complemento

) {
}
