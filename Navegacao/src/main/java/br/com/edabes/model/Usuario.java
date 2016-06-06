package br.com.edabes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ANO_NASCIMENTO")
    private Integer anoNascimento;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "SENHA")
    private String senha;

    public Usuario() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSobrenome() {
	return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
	this.sobrenome = sobrenome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Integer getAnoNascimento() {
	return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
	this.anoNascimento = anoNascimento;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getPais() {
	return pais;
    }

    public void setPais(String pais) {
	this.pais = pais;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    @Override
    public String toString() {
	return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
		+ ", anoNascimento=" + anoNascimento + ", cidade=" + cidade + ", pais=" + pais + ", genero=" + genero
		+ ", senha=" + senha + "]";
    }

}