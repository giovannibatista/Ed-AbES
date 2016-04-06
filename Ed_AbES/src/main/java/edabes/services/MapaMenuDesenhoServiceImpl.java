package edabes.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.MapaDAO;
import edabes.dto.CategoriaDTO;
import edabes.dto.ObjetoDTO;
import edabes.dto.SubcategoriaDTO;
import edabes.entidades.Categoria;
import edabes.entidades.MapaObjeto;
import edabes.entidades.Objeto;
import edabes.entidades.Subcategoria;

@Service
@Transactional
public class MapaMenuDesenhoServiceImpl implements MapaMenuDesenhoService {

	@Autowired
    private MapaDAO mapaDAO;
	
	/**
	 * Metodo para buscar as informacoes do menu do desenho do mapa
	 * @param int tipoMapa - Tipo do mapa (Desafio ou Navegacao Livre)
	 * @return ArrayList<CategoriaDTO> listaCategoriaDTO - Lista contendo os objetos do menu
	 */
	public ArrayList<CategoriaDTO> buscaInformacoesInciais(int tipoMapa) {
		ArrayList<CategoriaDTO> listaCategoriaDTO = new ArrayList<CategoriaDTO>();
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		CategoriaDTO categoriaDTO = null;
		
		listaCategorias = mapaDAO.buscaCategorias();
		
		for (Categoria categoria : listaCategorias) {
			categoriaDTO = new CategoriaDTO();
			
			categoriaDTO.setIdCategoria(categoria.getId());
			categoriaDTO.setTitulo(categoria.getTitulo());
			categoriaDTO.setListaDeSubcategoria(buscaListaSubcategoriaDTO(categoria.getId(), tipoMapa));
			
			listaCategoriaDTO.add(categoriaDTO);
		}
		
		return listaCategoriaDTO;
	}
	
	/**
	 * Metodo para buscar as subcategorias dos objetos do menu
	 * @param int cateforiaId - Identificador da categoria
	 * @param int tipoMapa - Tipo do Mapa
	 * @return ArrayList<SubcategoriaDTO> listaDeSubcategoriasDTO lista com as subcategorias e os
	 * seus objetos
	 */
	public ArrayList<SubcategoriaDTO> buscaListaSubcategoriaDTO(int categoriaId, int tipoMapa) {
		ArrayList<SubcategoriaDTO> listaDeSubcategoriasDTO = new ArrayList<SubcategoriaDTO>();
		ArrayList<Subcategoria> listaDeSubcategorias = new ArrayList<Subcategoria>();
		SubcategoriaDTO subcategoriaDTO = null;
		
		
		listaDeSubcategorias = mapaDAO.buscaSubcategorias(categoriaId, tipoMapa);
		
		for (Subcategoria sub : listaDeSubcategorias) {
			subcategoriaDTO = new SubcategoriaDTO();
			
			subcategoriaDTO.setIdSubcategoria(sub.getId());
			subcategoriaDTO.setTitulo(sub.getTitulo());
			subcategoriaDTO.setListaObjetos(buscaListaObjetos(sub.getId(), tipoMapa));
			
			listaDeSubcategoriasDTO.add(subcategoriaDTO);
		}
		
		return listaDeSubcategoriasDTO;
	}
	
	/**
	 * Metodo para buscas os objetos de uma subcategoria
	 * @param int idSubcategoria - Identificador da subcategoria
	 * @param int tipoMapa - Tipo do Mapa
	 * @return ArrayList<ObjetoDTO> listaDeObjetosDTO - Lista de objetos da subcategoria
	 */
	public ArrayList<ObjetoDTO> buscaListaObjetos(int idSubcategoria, int tipoMapa) {
		ArrayList<ObjetoDTO> listaDeObjetosDTO = new ArrayList<ObjetoDTO>();
		ArrayList<Objeto> listaDeObjetos = new ArrayList<Objeto>();
		ObjetoDTO objetoDTO = null;
		
		listaDeObjetos = mapaDAO.buscaObjetosPorSubcategoria(idSubcategoria, tipoMapa);
		
		for(Objeto obj : listaDeObjetos) {
			objetoDTO = new ObjetoDTO();
			
			objetoDTO.setIdObjeto(obj.getId());
			objetoDTO.setAltura(obj.getAltura());
			objetoDTO.setLargura(obj.getLargura());
			objetoDTO.setNome(obj.getNome());
			objetoDTO.setImagemMapa(obj.getImagemMapa());
			objetoDTO.setImagemMenu(obj.getImagemMenu());
			
			listaDeObjetosDTO.add(objetoDTO);
		}
		
		
		return listaDeObjetosDTO;
	}

	public ArrayList<ObjetoDTO> buscaListaObjetos(int idSubcategoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
