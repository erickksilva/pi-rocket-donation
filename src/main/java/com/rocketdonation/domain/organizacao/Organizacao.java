package com.rocketdonation.domain.organizacao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rocketdonation.domain.postagem.Noticia;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity(name = "organizacao")
public class Organizacao {

    @Id
    @NotBlank
    @Email(message = "Insira um e-mail válido, por exemplo: fulano@gmail.com")
    @Length(max = 100, message = "O e-mail deve ter no máximo {max} caracteres.")
    private String emailOrg;

    @NotBlank(message = "Insira o site da organização")
    @Length(max = 120, message = "O site deve ter no máximo {max} caracteres.")
    private String site;

    @NotBlank(message = "Insira a missão da organização.")
    @Length(max = 200, message = "A missão deve ter no máximo {max} caracteres.")
    private String missao;

    @NotBlank(message = "Insira a categoria da organização, exemplo: cultura, racismo etc...")
    @Length(max = 50, message = "A categoria deve ter no máximo {max} caracteres.")
    private String categoria;

    private Date dataCadastro;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_endereco")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_cc")
    private ContaBancaria contaBancaria;

    @JsonIgnore
    @OneToMany(mappedBy = "fkEmailOrg", cascade = CascadeType.ALL)
    private List<Noticia> noticias;

    public Organizacao(String emailOrg, String site, String missao, String categoria, Date dataCadastro) {
        this.emailOrg = emailOrg;
        this.site = site;
        this.missao = missao;
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
    }
}
