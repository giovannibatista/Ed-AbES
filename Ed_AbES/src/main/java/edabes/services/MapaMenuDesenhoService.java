package edabes.services;

import java.util.ArrayList;

import edabes.dto.CategoriaDTO;
import edabes.dto.ObjetoDTO;
import edabes.dto.SubcategoriaDTO;
import edabes.entidades.MapaObjeto;

public interface MapaMenuDesenhoService {
	
	public ArrayList<CategoriaDTO> buscaInformacoesInciais(int tipoMapa);
	
	public ArrayList<SubcategoriaDTO> buscaListaSubcategoriaDTO(int categoriaId);
	
	public ArrayList<ObjetoDTO> buscaListaObjetos(int idSubcategoria);
	
}
