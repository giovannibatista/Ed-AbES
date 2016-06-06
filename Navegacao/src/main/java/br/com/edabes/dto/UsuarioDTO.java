package br.com.edabes.dto;

public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer anoNascimento;
    private String cidade;
    private String pais;
    private String genero;
    private String senha;

    public UsuarioDTO() {
	super();
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