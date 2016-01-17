package edabes.dto;

import org.springframework.stereotype.Component;

@Component
public class MapaImportadoDTO {

	private int idMapa;
	private int idUsuario;
	
	public MapaImportadoDTO() {
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	
}
