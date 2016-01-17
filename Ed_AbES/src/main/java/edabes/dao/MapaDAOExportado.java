package edabes.dao;

import java.util.ArrayList;

import edabes.dto.ListarMapaDTO;
import edabes.entidades.MapaExportado;
import edabes.entidades.MapaObjetoExportado;

public interface MapaDAOExportado {

	public ArrayList<MapaObjetoExportado> buscaListaDeMapaObjetosExportados(int idMapa);
	
	public void excluirObjetosExportados(int idMapa);
	
	public int disponibilizarMapa(MapaExportado mapaExportado);
	
	public void salvarMapaObjeto(MapaObjetoExportado mapaObjetoExportado);
	
	public boolean atualizaMapaExportado(MapaExportado mapaExportado);
	
	public boolean verificaMapaExportado(String nomeMapa);
	
	public boolean verificaMapaExportado(int idMapa);
	
	public MapaExportado buscaMapaPorIdExportado(int idMapaExportado);
	
	public int buscaIdMapaExportadoPorNome(String nomeMapa);
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapasExportados();
	
}
