package edabes.dto;

import org.springframework.stereotype.Component;

@Component
public class MapaDTO {

	
	private int idMapa;
	
	
	public MapaDTO() {
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}
	
}
