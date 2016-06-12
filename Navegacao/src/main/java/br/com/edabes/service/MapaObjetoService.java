package br.com.edabes.service;

import java.util.ArrayList;

import br.com.edabes.dto.MapaObjetoDTO;

public interface MapaObjetoService {

    ArrayList<MapaObjetoDTO> carregaObjetosMapa(MapaObjetoDTO mapaObjetoDTO);

    String carregaObjetosMapaTreinamento() throws Exception;

}
