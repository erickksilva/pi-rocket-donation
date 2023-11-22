package com.rocketdonation.domain.organizacao;

import com.rocketdonation.domain.doador.Doador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

    @NotBlank(message = "Insira a zona de localidade da organização")
    @Length(max = 50, message = "A zona deve ter no máximo {max} caracteres.")
    private String zona;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_email_doador")
    private Doador doador;

    public Endereco(String cep, String rua, Integer numero, String complemento, String zona) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.zona = zona;
    }

//    public Endereco(String cep, String rua, Integer numero, String complemento, String zona, Organizacao fkEmailOrg) {
//        this.cep = cep;
//        this.rua = rua;
//        this.numero = numero;
//        this.complemento = complemento;
//        this.zona = zona;
//        this.fkEmailOrg = fkEmailOrg;
//    }
}
