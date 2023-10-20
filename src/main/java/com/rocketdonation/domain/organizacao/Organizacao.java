package com.rocketdonation.domain.organizacao;

import com.rocketdonation.domain.postagem.Postagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "organizacao")
public class Organizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrg;

    @NotBlank(message = "Insira o nome")
    @Length(max = 100, min = 5, message = "O nome da organização deve estar entre {min} e {max} caracteres.")
    private String nomeOrg;

    @NotBlank(message = "Insira o telefone")
    @Length(min = 14, max = 14, message = "O telefone deve conter {max} números")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{9}$", message = "Formato do telefone inválido.")
    private String telefoneOrg;

    @NotBlank
    @Email(message = "Insira um e-mail válido, por exemplo: fulano@gmail.com")
    @Length(max = 100, message = "O e-mail deve ter no máximo {max} caracteres.")
    private String emailOrg;

    @NotBlank(message = "Insira o site da organização")
    @Length(max = 120, message = "O site deve ter no máximo {max} caracteres.")
    private String siteOrg;

    @NotBlank(message = "Insira a missão da organização.")
    @Length(max = 200, message = "A missão deve ter no máximo {max} caracteres.")
    private String missaoOrg;

    @NotBlank(message = "Insira a categoria da organização, exemplo: cultura, racismo etc...")
    @Length(max = 50, message = "A categoria deve ter no máximo {max} caracteres.")
    private String categoriaOrg;

    private Date dataCadastro;

    private Long idPost;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco enderecoCep;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id")
    private ContaBancaria contaBancaria;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacao_id") // Especifique o nome da coluna de junção, se necessário
    private List<Postagem> postagens; // Use uma lista para representar várias postagens


    public Organizacao(String nomeOrg, String telefoneOrg, String emailOrg, String siteOrg, String missaoOrg,
                       String categoriaOrg, Date dataCadastro, Long idPost, Endereco enderecoID, ContaBancaria contaId) {
        this.nomeOrg = nomeOrg;
        this.telefoneOrg = telefoneOrg;
        this.emailOrg = emailOrg;
        this.siteOrg = siteOrg;
        this.missaoOrg = missaoOrg;
        this.categoriaOrg = categoriaOrg;
        this.dataCadastro = dataCadastro;
        this.idPost = idPost;
        this.enderecoCep = enderecoID;
        this.contaBancaria = contaId;
    }


    public void setNewEnderecoId(String cep) {
        enderecoCep.setCep(cep);
    }

    public void setNewContaId(Long id) {
        contaBancaria.setIdCc(id);
    }
}
