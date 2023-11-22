package com.rocketdonation.domain.postagem;

import com.rocketdonation.domain.organizacao.Organizacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Noticia {

    @Id
    private Long idNoticia;

    @NotBlank(message = "Insira o titulo.")
    @Length(max = 60, message = "O titulo deve conter no máximo {max} caracteres.")
    private String titulo;

    private Date dataNoticia;

    @NotBlank(message = "Insira a primeira parte da noticia.")
    @Length(max = 1000, message = "A primeira parte da noticia deve conter no máximo {max} caracteres.")
    private String texto1;

    @NotBlank(message = "Insira a segunda parte da noticia.")
    @Length(max = 1000, message = "A segunda parte da noticia deve conter no máximo {max} caracteres.")
    private String texto2;

    @NotBlank(message = "Insira a url da foto.")
    @Length(max = 150, message = "A url deve conter no máximo {max} caracteres.")
    private String imgUrl;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_email_org")
    private Organizacao fkEmailOrg;

}
