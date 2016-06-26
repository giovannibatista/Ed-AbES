package br.com.edabes.dao;

import java.util.List;

import br.com.edabes.model.MapaObjeto;
import br.com.edabes.model.MapaObjetoExportado;

public interface MapaObjetoDAO {

    List<MapaObjeto> carregarObjetosMapa(MapaObjeto mapaObjeto);

    void importarMapaObjeto(MapaObjeto objeto);

    List<MapaObjetoExportado> carregarObjetosMapaPublico(MapaObjetoExportado mapaObjeto);

}
