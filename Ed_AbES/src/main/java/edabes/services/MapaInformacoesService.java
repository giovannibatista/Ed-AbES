package edabes.services;

import edabes.dto.MapaCaracteristicasDTO;
import edabes.dto.MapaDTO;
import edabes.entidades.Mapa;

public interface MapaInformacoesService {

	public MapaDTO salvarCaracteristicasMapa(Mapa mapa, String acao, int idMapaEditado);
	
	public MapaCaracteristicasDTO montaDTO(int idMapa);
	
}
