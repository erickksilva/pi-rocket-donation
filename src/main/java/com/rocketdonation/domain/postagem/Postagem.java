package com.rocketdonation.domain.postagem;

import com.rocketdonation.domain.organizacao.Organizacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Postagem {

    @Id
    private Long idPost;

    @NotBlank(message = "Insira o titulo.")
    @Length(max = 60, message = "O titulo deve conter no máximo {max} caracteres.")
    private String titulo;

    private Date dataPost;

    @NotBlank(message = "Insira a primeira parte da noticia.")
    @Length(max = 1000, message = "A primeira parte da noticia deve conter no máximo {max} caracteres.")
    private String texto1;

    @NotBlank(message = "Insira a segunda parte da noticia.")
    @Length(max = 1000, message = "A segunda parte da noticia deve conter no máximo {max} caracteres.")
    private String texto2;

    @NotBlank(message = "Insira a url da foto.")
    @Length(max = 150, message = "A url deve conter no máximo {max} caracteres.")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "organizacao_id")
    private Organizacao organizacao_id;

}
