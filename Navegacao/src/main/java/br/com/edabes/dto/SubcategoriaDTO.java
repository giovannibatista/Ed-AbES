package br.com.edabes.dto;

public class SubcategoriaDTO {

    private Integer id;
    private Integer idCategoria;
    private String titulo;

    public SubcategoriaDTO() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getIdCategoria() {
	return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
	this.idCategoria = idCategoria;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    @Override
    public String toString() {
	return "SubcategoriaDTO [id=" + id + ", idCategoria=" + idCategoria + ", titulo=" + titulo + "]";
    }

}
