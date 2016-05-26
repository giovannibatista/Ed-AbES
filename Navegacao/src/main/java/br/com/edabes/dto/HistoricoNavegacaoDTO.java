package br.com.edabes.dto;

import java.util.Date;

public class HistoricoNavegacaoDTO {

    private Integer id;

    private String log;

    private Date dataNavegacao;

    private String tempoNavegacao;

    private Integer usuario;

    private MapaDTO mapa;

    public HistoricoNavegacaoDTO() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getLog() {
	return log;
    }

    public void setLog(String log) {
	this.log = log;
    }

    public Date getDataNavegacao() {
	return dataNavegacao;
    }

    public void setDataNavegacao(Date dataNavegacao) {
	this.dataNavegacao = dataNavegacao;
    }

    public String getTempoNavegacao() {
	return tempoNavegacao;
    }

    public void setTempoNavegacao(String tempoNavegacao) {
	this.tempoNavegacao = tempoNavegacao;
    }

    public Integer getUsuario() {
	return usuario;
    }

    public void setUsuario(Integer usuario) {
	this.usuario = usuario;
    }

    public MapaDTO getMapa() {
	return mapa;
    }

    public void setMapa(MapaDTO mapa) {
	this.mapa = mapa;
    }

}
