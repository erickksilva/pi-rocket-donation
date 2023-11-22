package com.rocketdonation.domain.doador;

import com.rocketdonation.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Doador {

    @Id
    private String email;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email") // Estabelece o relacionamento com a classe User
    @MapsId
    private User user;

    @NotBlank(message = "Insira o nome.")
    @Length(max = 35, message = "O primeiro nome deve conter no máximo {max} caracteres.")
    private String nome;

    @NotBlank(message = "Insira o sobrenome.")
    @Length(max = 70, message = "O segundo nome deve conter no máximo {max} caracteres.")
    private String sobrenome;

    @NotBlank(message = "Insira o telefone")
    @Length(min = 14, max = 14, message = "O telefone deve conter ${max} números")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{9}$", message = "Formato do telefone inválido.")
    private String telefone;



}
