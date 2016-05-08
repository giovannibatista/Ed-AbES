package br.com.edabes.service;

import java.util.ArrayList;

import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.dto.NavegacaoDTO;
import br.com.edabes.dto.SubcategoriaDTO;

public class NavegacaoServiceImpl implements NavegacaoService {

    private NavegacaoDTO navegacaoDTO;

    public NavegacaoServiceImpl() {
	navegacaoDTO = new NavegacaoDTO();
    }

    @Override
    public NavegacaoDTO carregarObejtosParaNavegacao(ArrayList<MapaObjetoDTO> mapaObjetoDTOs) {
	try {
	    navegacaoDTO = new NavegacaoDTO();

	    for (MapaObjetoDTO mapaObjetoDTO : mapaObjetoDTOs) {
		if (carregarListaObjetosNivelSolo(mapaObjetoDTO)) {
		    continue;
		} else if (carregarListaObjetos(mapaObjetoDTO)) {
		    continue;
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return navegacaoDTO;
    }

    private boolean carregarListaObjetos(MapaObjetoDTO mapaObjetoDTO) {
	if (mapaObjetoDTO.getObjeto().getNivel() != 0) {
	    navegacaoDTO.getObjetos().add(mapaObjetoDTO);
	    return true;
	}
	return false;
    }


    private Boolean carregarListaObjetosNivelSolo(MapaObjetoDTO mapaObjetoDTO) {
	if (mapaObjetoDTO.getObjeto().getNivel() == 0) {
	    SubcategoriaDTO subcategoriaDTO = mapaObjetoDTO.getObjeto().getSubcategoria();
	    if (subcategoriaDTO.getTitulo().equalsIgnoreCase("Chão")
		    || subcategoriaDTO.getTitulo().equalsIgnoreCase("Tapete")) {
		navegacaoDTO.getObjetosNivelSolo().add(mapaObjetoDTO);
		return true;
	    }
	}
	return false;
    }

}
