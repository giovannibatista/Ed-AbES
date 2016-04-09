package br.com.edabes.dto;

public class MapaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer tipoMapa;

    public MapaDTO() {
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

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Integer getTipoMapa() {
	return tipoMapa;
    }

    public void setTipoMapa(Integer tipoMapa) {
	this.tipoMapa = tipoMapa;
    }

}
