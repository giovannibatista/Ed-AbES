package edabes.entidades;

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
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPA_EXPORTADO_SEQ")
    @SequenceGenerator(name = "MAPA_EXPORTADO_SEQ", sequenceName = "MAPA_EXPORTADO_SEQ", allocationSize = 1)
	private int mapaId;
	
	@Column(name = "NOME_MAPA")
	private String nomeMapa;

	@Column(name = "DESCRICAO")
	private String descricaoMapa;
	
	@Column(name = "OBJETIVO")
	private String objetivoMapa;
	
	@Column(name = "TIPO_MAPA")
	private int tipoMapa;
	
	@Column(name = "CRIADOR")
	private int criadorMapa;
	
	@Column(name = "NOME_CRIADOR")
	private String nomeCriador;
	
	@Column(name = "DT_CRIACAO")
	private Date dataDeCriacao;
	
	@Column(name = "DT_ALTERACAO")
	private Date dataAlteracao;
	
	@Column(name = "UNIDADE_MEDIDA")
	private String unidadeDeMedida;
	
	@Column(name = "ANDAR")
	private String andar;
		
	public MapaExportado() {
	}

	public int getMapaId() {
		return mapaId;
	}

	public void setMapaId(int mapaId) {
		this.mapaId = mapaId;
	}

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public String getDescricaoMapa() {
		return descricaoMapa;
	}

	public void setDescricaoMapa(String descricaoMapa) {
		this.descricaoMapa = descricaoMapa;
	}

	public String getObjetivoMapa() {
		return objetivoMapa;
	}

	public void setObjetivoMapa(String objetivoMapa) {
		this.objetivoMapa = objetivoMapa;
	}

	public int getTipoMapa() {
		return tipoMapa;
	}

	public void setTipoMapa(int tipoMapa) {
		this.tipoMapa = tipoMapa;
	}

	public int getCriadorMapa() {
		return criadorMapa;
	}

	public void setCriadorMapa(int criadorMapa) {
		this.criadorMapa = criadorMapa;
	}

	public String getNomeCriador() {
		return nomeCriador;
	}

	public void setNomeCriador(String nomeCriador) {
		this.nomeCriador = nomeCriador;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
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

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
	
	
}
