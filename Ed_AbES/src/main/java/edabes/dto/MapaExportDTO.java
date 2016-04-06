package edabes.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MapaExportDTO {
	
	private int idMapa;
	private String nomeMapa;
	private String descricaoMapa;
	private String objetivoMapa;
	private String criadorDoMapa;
	private String unidadeDeMedida;
	private int tipoMapa;
	private String andar;
	private List<ObjetoMapaDTO> objectList;
	
	public MapaExportDTO() {
	}
	
	public List<ObjetoMapaDTO> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<ObjetoMapaDTO> objectList) {
		this.objectList = objectList;
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
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

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public int getTipoMapa() {
		return tipoMapa;
	}

	public void setTipoMapa(int tipoMapa) {
		this.tipoMapa = tipoMapa;
	}

	public String getCriadorDoMapa() {
		return criadorDoMapa;
	}

	public void setCriadorDoMapa(String criadorDoMapa) {
		this.criadorDoMapa = criadorDoMapa;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
}
