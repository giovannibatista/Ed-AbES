package br.com.edabes.dao;

import java.util.List;

import br.com.edabes.model.MapaObjeto;

public interface MapaObjetoDAO {

    List<MapaObjeto> carregarObjetosMapa(MapaObjeto mapaObjeto);

}
