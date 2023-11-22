package com.rocketdonation.domain.organizacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "conta_bancaria")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCc;

    @NotBlank(message = "Insira o numero da agência.")
    @Length(min = 4, max = 5, message = "A agência deve conter entre {min} e {max} números.")
    private String agenciaConta;

    @NotBlank(message = "Insira o numero da conta.")
    @Length(min = 7, max = 9, message = "A conta deve conter entre {min} e {max} números.")
    private String numeroConta;

    @NotBlank(message = "Insira a chave pix.")
    @Length(max = 150, message = "A chave deve conter no máximo {max} caracteres ou números.")
    private String chavePix;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_email_org")
//    private Organizacao emailOrg;

    public ContaBancaria(String agenciaConta, String numeroConta, String chavePix) {
        this.agenciaConta = agenciaConta;
        this.numeroConta = numeroConta;
        this.chavePix = chavePix;
    }
}
