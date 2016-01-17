package edabes.dto;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import edabes.entidades.Mapa;
import edabes.entidades.MapaExportado;

@Component
public class ListarMapaDTO {
	
	private int mapaId;
	
	private String nomeMapa;

	private String descricaoMapa;
	
	private String objetivoMapa;
	
	private int tipoMapa;
	
	private int criadorMapa;
	
	private String nomeCriador;
	
	private String dataDeCriacao;
	
	private String unidadeDeMedida;
	
	private boolean importado;
	
	public ListarMapaDTO() {
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

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public String getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(String dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public int getMapaId() {
		return mapaId;
	}

	public void setMapaId(int mapaId) {
		this.mapaId = mapaId;
	}
	
	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public void copiaMapa(Mapa mapa) {
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy"); 
		String dataFormatada = "";
		
		setMapaId(mapa.getMapaId());
		setNomeMapa(mapa.getNomeMapa());
		setDescricaoMapa(mapa.getDescricaoMapa());
		setObjetivoMapa(mapa.getObjetivoMapa());
		setTipoMapa(mapa.getTipoMapa());
		setCriadorMapa(mapa.getCriadorMapa());
		setNomeCriador(mapa.getNomeCriador());
		setUnidadeDeMedida(mapa.getUnidadeDeMedida());
		dataFormatada = formataData.format(mapa.getDataDeCriacao());
		setDataDeCriacao(dataFormatada);
		if(mapa.getImportadoPor() > 0) {
			setImportado(true);
		} else {
			setImportado(false);
		}
		
	}
	
	public void copiaMapaExportado(MapaExportado mapa) {
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy"); 
		String dataFormatada = "";
		
		setMapaId(mapa.getMapaId());
		setNomeMapa(mapa.getNomeMapa());
		setDescricaoMapa(mapa.getDescricaoMapa());
		setObjetivoMapa(mapa.getObjetivoMapa());
		setTipoMapa(mapa.getTipoMapa());
		setCriadorMapa(mapa.getCriadorMapa());
		setNomeCriador(mapa.getNomeCriador());
		setUnidadeDeMedida(mapa.getUnidadeDeMedida());
		dataFormatada = formataData.format(mapa.getDataDeCriacao());
		setDataDeCriacao(dataFormatada);
		setImportado(false);
	}
	
}
