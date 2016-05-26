package br.com.edabes.model;

import java.util.Date;

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
@Table(name = "HISTORICO_NAVEGACAO")
public class HistoricoNavegacao {

    @Id
    @Column(name = "ID_HISTORICO_NAVEGACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORICO_NAVEGACAO_SEQ")
    @SequenceGenerator(name = "HISTORICO_NAVEGACAO_SEQ", sequenceName = "HISTORICO_NAVEGACAO_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "LOG")
    private String log;

    @Column(name = "DATA_NAVEGACAO")
    private Date dataNavegacao;

    @Column(name = "TEMPO_NAVEGACAO")
    private String tempoNavegacao;

    @Column(name = "ID_USUARIO")
    private Integer usuario;

    @OneToOne
    @JoinColumn(name = "ID_MAPA")
    private Mapa mapa;

    public HistoricoNavegacao() {
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

    public Mapa getMapa() {
	return mapa;
    }

    public void setMapa(Mapa mapa) {
	this.mapa = mapa;
    }

}
