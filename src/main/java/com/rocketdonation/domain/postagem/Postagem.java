package com.rocketdonation.domain.postagem;

import com.rocketdonation.domain.organizacao.Organizacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public record Postagem(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idPost,

        @NotBlank(message = "Insira o titulo.")
        @Length(max = 60, message = "O titulo deve conter no {max} caracter.")
        String titulo,

        Date dataPost,

        @NotBlank(message = "Insira a primeira parte da noticia.")
        @Length(max = 100, message = "A primeira parte da noticia deve conter no máximo {max} caracter.")
        String texto1,

        @NotBlank(message = "Insira a segunda parte da noticia.")
        @Length(max = 100, message = "A segunda parte da noticia deve conter no máximo {max} caracter.")
        String descricao2,

        @NotBlank(message = "Insira a url da foto.")
        @Length(max = 100, message = "A url deve conter no máximo {max} caracter.")
        String imgUrl,

        Organizacao organizacao


) {
}
