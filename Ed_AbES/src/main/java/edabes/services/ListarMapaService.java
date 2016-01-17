package edabes.services;

import java.util.ArrayList;

import edabes.dto.ListarMapaDTO;

public interface ListarMapaService {
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapasDoUsuario(int idUsuario);

	public ArrayList<ListarMapaDTO> buscaListaDeMapas();
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapasExportados();
	
	public boolean importarMapa(int idUsuario, int idMapaExportado);
	
}
