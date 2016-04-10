package br.com.edabes.dao;

import java.util.ArrayList;

import br.com.edabes.model.Mapa;

public interface MapaDAO {
    
    public ArrayList<Mapa> listarMapas() throws Exception;

    public Mapa consultaMapa(Mapa mapa);
}
