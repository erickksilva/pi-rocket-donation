package com.rocketdonation.domain.doador;

import com.rocketdonation.domain.organizacao.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public record Doador(

        @Id
        @Length(max = 100, message = "O email deve ter no máximo {max} caracter.")
        @Email
        String email,

        @NotBlank(message = "Insira o nome.")
        @Length(max = 35, message = "O primeiro nome deve conter no máximo {max} caracter.")
        String nome,

        @NotBlank(message = "Insira o sobrenome.")
        @Length(max = 70, message = "O segundo nome deve conter no máximo {max} caracter.")
        String sobrenome,

        @NotBlank(message = "Insira o telefone")
        @Length(min = 14, max = 14, message = "O telefone deve conter ${max} numeros")
        @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{9}$", message = "Formato do telefone inválido.")
        String telefone,

        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
        Endereco endereco_cep

) {
}
