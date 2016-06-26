package br.com.edabes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MAPA_EXPORTADO")
public class MapaExportado {

    @Id
    @Column(name = "ID_MAPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAPA_EXPORTADO_SEQ")
    @SequenceGenerator(name = "MAPA_EXPORTADO_SEQ", sequenceName = "MAPA_EXPORTADO_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME_MAPA")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBJETIVO")
    private String objetivo;

    @Column(name = "TIPO_MAPA")
    private Integer tipoMapa;

    @Column(name = "CRIADOR")
    private Integer criador;

    @Column(name = "NOME_CRIADOR")
    private String nomeCriador;

    @Column(name = "DT_CRIACAO")
    private Date dataCriacao;

    @Column(name = "DT_ALTERACAO")
    private Date dataAlteracao;

    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeDeMedida;

    @Column(name = "IMPORTADO")
    private Integer importadoPor;

    @Column(name = "ANDAR")
    private String andar;

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

    public Integer getCriador() {
	return criador;
    }

    public void setCriador(Integer criador) {
	this.criador = criador;
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

    public Date getDataAlteracao() {
	return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
	this.dataAlteracao = dataAlteracao;
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
	return "MapaExportado [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", objetivo=" + objetivo
		+ ", tipoMapa=" + tipoMapa + ", criador=" + criador + ", nomeCriador=" + nomeCriador + ", dataCriacao="
		+ dataCriacao + ", dataAlteracao=" + dataAlteracao + ", unidadeDeMedida=" + unidadeDeMedida
		+ ", importadoPor=" + importadoPor + ", andar=" + andar + "]";
    }

}
