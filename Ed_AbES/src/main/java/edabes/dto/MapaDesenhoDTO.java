package edabes.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edabes.entidades.Mapa;

@Component
public class MapaDesenhoDTO {

	private ArrayList<ObjetoMapaDTO> listaObjetosMapa;
	private Mapa caracteristicasMapa;
	
	public MapaDesenhoDTO() {
	}

	public ArrayList<ObjetoMapaDTO> getListaObjetosMapa() {
		return listaObjetosMapa;
	}

	public void setListaObjetosMapa(ArrayList<ObjetoMapaDTO> listaObjetosMapa) {
		this.listaObjetosMapa = listaObjetosMapa;
	}

	public Mapa getCaracteristicasMapa() {
		return caracteristicasMapa;
	}

	public void setCaracteristicasMapa(Mapa caracteristicasMapa) {
		this.caracteristicasMapa = caracteristicasMapa;
	}

}
