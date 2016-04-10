package br.com.edabes.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.MapaConverterImpl;
import br.com.edabes.dao.MapaDAO;
import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.Mapa;

@Service
public class MapaServiceImpl implements MapaService {

    @Autowired
    private MapaDAO mapaDAO;
    
    private Converter<Mapa, MapaDTO> mapaConverter;

    public MapaServiceImpl() {
	mapaConverter = new MapaConverterImpl();
    }

    public ArrayList<MapaDTO> listarMapas() throws Exception {
	ArrayList<MapaDTO> mapasDTOs = new ArrayList<MapaDTO>();
	try {
	    ArrayList<Mapa> mapas = mapaDAO.listarMapas();
	    
	    mapas.forEach(m -> mapasDTOs.add(mapaConverter.converteModelParaDTO(m)));

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapasDTOs;
    }

    @Override
    public MapaDTO consultaMapa(MapaDTO consulta) {
	MapaDTO mapaDTO = new MapaDTO();
	try{
	    Mapa mapa = mapaDAO.consultaMapa(mapaConverter.converteDTOParaModel(consulta));
	    mapaDTO = mapaConverter.converteModelParaDTO(mapa);
	}catch(Exception e){
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

}
