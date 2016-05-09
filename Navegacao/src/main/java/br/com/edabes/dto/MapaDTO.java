package br.com.edabes.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MapaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private String objetivo;
    private Integer tipoMapa;
    private Date dataAlteracao;
    private Date dataCriacao;
    private String nomeCriador;
    private String unidadeDeMedida;
    private Integer importadoPor;
    private String andar;

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

    public String getObjetivo() {
	return objetivo;
    }

    public void setObjetivo(String objetivo) {
	this.objetivo = objetivo;
    }

    public Integer getTipoMapa() {
	return tipoMapa;
    }

    public void setTipoMapa(Integer tipoMapa) {
	this.tipoMapa = tipoMapa;
    }

    public Date getDataAlteracao() {
	return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
	this.dataAlteracao = dataAlteracao;
    }

    public String getNomeCriador() {
	return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
	this.nomeCriador = nomeCriador;
    }

    public Date getDataCriacao() {
	return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
	this.dataCriacao = dataCriacao;
    }

    public String getUnidadeDeMedida() {
	return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
	this.unidadeDeMedida = unidadeDeMedida;
    }

    public Integer getImportadoPor() {
	return importadoPor;
    }

    public void setImportadoPor(Integer importadoPor) {
	this.importadoPor = importadoPor;
    }

    public String getAndar() {
	return andar;
    }

    public void setAndar(String andar) {
	this.andar = andar;
    }

    @Override
    public String toString() {
	return "MapaDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", tipoMapa=" + tipoMapa
		+ ", dataAlteracao=" + dataAlteracao + ", dataDeCriacao=" + dataCriacao + ", nomeCriador=" + nomeCriador
		+ ", unidadeDeMedida=" + unidadeDeMedida + ", importadoPor=" + importadoPor + ", andar=" + andar + "]";
    }

}
