package edabes.services;

import java.util.ArrayList;
import java.util.List;

import edabes.dto.MapaDesenhoDTO;
import edabes.dto.MapaExportDTO;
import edabes.dto.ObjetoAlteracoesDTO;
import edabes.dto.ObjetoMapaDTO;
import edabes.entidades.Mapa;

public interface MapaDesenhoService {

	public ArrayList<ObjetoMapaDTO> buscaTodosOsObjetosDoMapa(int idMapa);
	
	public MapaDesenhoDTO montaDTO(int id);
	
	public boolean salvarMudancas(List<ObjetoAlteracoesDTO> listaDeObjetos, int idMapa);
	
	MapaExportDTO buscaMapaExportDTO(int idMapa);
	
	public Mapa buscaMapaPorId(int id);
	
}
