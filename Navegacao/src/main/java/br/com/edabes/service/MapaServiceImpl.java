package br.com.edabes.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edabes.dao.MapaDAO;
import br.com.edabes.dto.MapaDTO;

@Service
public class MapaServiceImpl implements MapaService {
    
    @Autowired
    private MapaDAO mapaDAO;

    public MapaServiceImpl() {
    }

    public ArrayList<MapaDTO> listarMapas() {
	mapaDAO.listarMapas();
	return null;
    }

}
