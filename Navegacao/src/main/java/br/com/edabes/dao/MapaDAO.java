package br.com.edabes.dao;

import java.util.ArrayList;

import br.com.edabes.model.Mapa;
import br.com.edabes.model.MapaExportado;

public interface MapaDAO {

    ArrayList<Mapa> listarMapasCriadosDoUsuario(Mapa mapa) throws Exception;

    ArrayList<MapaExportado> listarMapasPublicos() throws Exception;

    Mapa consultarMapa(Mapa mapa);

    MapaExportado consultarMapaPublico(MapaExportado mapa);

    Integer salvarMapa(Mapa mapa);

    ArrayList<Mapa> listarMapasImportadosDoUsuario(Mapa mapa) throws Exception;

}
