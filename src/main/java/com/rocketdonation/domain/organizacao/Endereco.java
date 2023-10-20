package com.rocketdonation.domain.organizacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @NotBlank(message = "Insira o cep da organização.")
    @Length(message = "O cep deve conter no minimo {min} e max{max} numero.")
    private String cep;

    @NotBlank(message = "Insira o nome da rua/avenida.")
    private String rua;

    @NotNull(message = "Insira o numero.")
    @Positive
    private Integer numero;

    @Length(max = 150, message = "O complemento deve ter no máximo {max} caracteres.")
    private String complemento;

    public Endereco(String cep, String rua, Integer numero, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
}
