package edabes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.MapaDAO;

@Service
@Transactional
public class MapaExclusaoServiceImpl implements MapaExclusaoService {

	@Autowired
    private MapaDAO mapaDAO;
	
	/**
	 * Metodo para excluir um mapa
	 * @param int idMapa - Identificador do mapa
	 * @param int idUsuario - Identificador do usuario
	 * @return boolean mapaExcluido - True caso o mapa tenha sido excluido com sucesso
	 */
	public boolean excluirMapa(int idMapa, int idUsuario) {
		boolean mapaExcluido = false;
		boolean isMapaImportado = false;
		
		mapaExcluido = mapaDAO.excluirMapa(idMapa);
		mapaExcluido = true;
		
		return mapaExcluido;
	}
	
}
