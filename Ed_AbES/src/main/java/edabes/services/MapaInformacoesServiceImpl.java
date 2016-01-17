package edabes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.MapaDAO;
import edabes.dto.MapaCaracteristicasDTO;
import edabes.dto.MapaDTO;
import edabes.entidades.Mapa;

@Service
@Transactional
public class MapaInformacoesServiceImpl implements
		MapaInformacoesService {

	@Autowired
    private MapaDTO mapaDTO;
	
	@Autowired
    private MapaDAO mapaDAO;
	
	public MapaInformacoesServiceImpl() {
	}
	
	/**
	 * Metodo para salvas ou editar as caracteristicas do mapa
	 * @param Mapa mapa - Mapa que sera salvo
	 * @param String acao - Acao que sera executada (Criar um mapa novo ou Atualizar um mapa existente)
	 * @param int idMapaEditado - Identificador do mapa editado (Pode ser zero caso seja a criacao de um novo mapa)
	 * @return MapaDTO mapaDTO - DTO com informacoes do mapa salvo ou editado
	 */
	public MapaDTO salvarCaracteristicasMapa(Mapa mapa, String acao, int idMapaEditado) {
		int idMapa = -1;
		
		if(acao.equals("Criar")) {
			idMapa = mapaDAO.salvarERecuperarCaracteristicasMapaId(mapa);
			mapaDTO.setIdMapa(idMapa);
		} else {
			mapa.setMapaId(idMapaEditado);
			idMapa = mapaDAO.salvaEdicaoCaracteristicasMapa(mapa);
			mapaDTO.setIdMapa(idMapa);
		}

		return mapaDTO; 
	}
	
	/**
	 * Metodo para montar o DTO com informacoes das caracteristicas do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return MapaCaracteristicasDTO dto - DTO com informacoes das caracteristicas do mapa
	 */
	public MapaCaracteristicasDTO montaDTO(int idMapa) {
		MapaCaracteristicasDTO dto = new MapaCaracteristicasDTO();
		Mapa mapa = null;
		
		mapa = mapaDAO.buscaMapaPorId(idMapa);
		
		if(mapa != null) {
			dto.setIdMapa(mapa.getMapaId());
			dto.setNomeMapa(mapa.getNomeMapa());
			dto.setDescricaoMapa(mapa.getDescricaoMapa());
			dto.setObjetivoMapa(mapa.getObjetivoMapa());
			dto.setUnidadeDeMedida(mapa.getUnidadeDeMedida());
			dto.setTipoMapa(mapa.getTipoMapa());
			dto.setAndar(mapa.getAndar());
		}
		
		return dto;
	}

}
