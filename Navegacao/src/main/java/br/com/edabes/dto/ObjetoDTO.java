package br.com.edabes.dto;

public class ObjetoDTO {

    private Integer id;
    private Integer altura;
    private Integer largura;
    private String nome;
    private String descricao;
    private SubcategoriaDTO subcategoria;
    private String imagemMapa;
    private Integer nivel;

    public ObjetoDTO() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getAltura() {
	return altura;
    }

    public void setAltura(Integer altura) {
	this.altura = altura;
    }

    public Integer getLargura() {
	return largura;
    }

    public void setLargura(Integer largura) {
	this.largura = largura;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public SubcategoriaDTO getSubcategoria() {
	return subcategoria;
    }

    public void setSubcategoria(SubcategoriaDTO subcategoria) {
	this.subcategoria = subcategoria;
    }

    public String getImagemMapa() {
	return imagemMapa;
    }

    public void setImagemMapa(String imagemMapa) {
	this.imagemMapa = imagemMapa;
    }

    public Integer getNivel() {
	return nivel;
    }

    public void setNivel(Integer nivel) {
	this.nivel = nivel;
    }

    @Override
    public String toString() {
	return "ObjetoDTO [id=" + id + ", altura=" + altura + ", largura=" + largura + ", nome=" + nome + ", descricao="
		+ descricao + ", subcategoria=" + subcategoria.toString() + ", imagemMapa=" + imagemMapa + ", nivel=" + nivel
		+ "]";
    }

}
