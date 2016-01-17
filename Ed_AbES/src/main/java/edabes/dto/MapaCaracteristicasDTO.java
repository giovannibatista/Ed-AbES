package edabes.dto;

import org.springframework.stereotype.Component;

@Component
public class MapaCaracteristicasDTO {
	
	private int idMapa;
	private String nomeMapa;
	private String descricaoMapa;
	private String objetivoMapa;
	private String unidadeDeMedida;
	private int tipoMapa;
	private String andar;
	
	public MapaCaracteristicasDTO() {
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

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
}
