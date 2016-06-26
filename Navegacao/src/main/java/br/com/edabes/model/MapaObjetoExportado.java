package br.com.edabes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MAPA_OBJETO_EXPORTADO")
public class MapaObjetoExportado {

    @Id
    @Column(name = "ID_MAPA_OBJETO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAPA_OBJETO_EXPORTADO_SEQ")
    @SequenceGenerator(name = "MAPA_OBJETO_EXPORTADO_SEQ", sequenceName = "MAPA_OBJETO_EXPORTADO_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "ID_MAPA")
    private Integer idMapa;

    @OneToOne
    @JoinColumn(name = "ID_OBJETO")
    private Objeto objeto;

    @Column(name = "PROFUNDIDADE")
    private Integer profundidade;

    @Column(name = "AUDIO_DESCRICAO")
    private String audioDescricao;

    @Column(name = "COORDENADA_X")
    private Integer coordenadaX;

    @Column(name = "COORDENADA_Y")
    private Integer coordenadaY;

    @Column(name = "ALTURA")
    private Integer altura;

    @Column(name = "LARGURA")
    private Integer largura;

    @Column(name = "ANGULO")
    private Integer angulo;

    @OneToOne
    @JoinColumn(name = "ID_ARQUIVO_AUDIO")
    private AudioIconico audioIconico;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getIdMapa() {
	return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
	this.idMapa = idMapa;
    }

    public Objeto getObjeto() {
	return objeto;
    }

    public void setObjeto(Objeto objeto) {
	this.objeto = objeto;
    }

    public Integer getProfundidade() {
	return profundidade;
    }

    public void setProfundidade(Integer profundidade) {
	this.profundidade = profundidade;
    }

    public String getAudioDescricao() {
	return audioDescricao;
    }

    public void setAudioDescricao(String audioDescricao) {
	this.audioDescricao = audioDescricao;
    }

    public Integer getCoordenadaX() {
	return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
	this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
	return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
	this.coordenadaY = coordenadaY;
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

    public Integer getAngulo() {
	return angulo;
    }

    public void setAngulo(Integer angulo) {
	this.angulo = angulo;
    }

    public AudioIconico getAudioIconico() {
	return audioIconico;
    }

    public void setAudioIconico(AudioIconico audioIconico) {
	this.audioIconico = audioIconico;
    }

    @Override
    public String toString() {
	return "MapaObjetoExportado [id=" + id + ", idMapa=" + idMapa + ", objeto=" + objeto + ", profundidade="
		+ profundidade + ", audioDescricao=" + audioDescricao + ", coordenadaX=" + coordenadaX
		+ ", coordenadaY=" + coordenadaY + ", altura=" + altura + ", largura=" + largura + ", angulo=" + angulo
		+ ", audioIconico=" + audioIconico + "]";
    }

}
