package br.com.edabes.dao;

import java.util.ArrayList;

import br.com.edabes.model.Mapa;

public interface MapaDAO {
    
    ArrayList<Mapa> listarMapas() throws Exception;

    Mapa consultarMapa(Mapa mapa);
}
