package br.com.edabes.dto;

public class AudioIconicoDTO {

    private Integer id;
    private String arquivo;
    private String descricao;

    public AudioIconicoDTO() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getArquivo() {
	return arquivo;
    }

    public void setArquivo(String arquivo) {
	this.arquivo = arquivo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    @Override
    public String toString() {
	return "AudioIconicoDTO [id=" + id + ", arquivo=" + arquivo + ", descricao=" + descricao + "]";
    }

}
