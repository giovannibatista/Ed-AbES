package br.com.edabes.service;

import java.util.ArrayList;

import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.dto.NavegacaoDTO;

public interface NavegacaoService {
    
    	NavegacaoDTO carregarObejtosParaNavegacao(ArrayList<MapaObjetoDTO> mapaObjetoDTOs);
}
