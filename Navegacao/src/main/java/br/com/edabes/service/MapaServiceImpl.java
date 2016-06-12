package br.com.edabes.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.MapaConverter;
import br.com.edabes.dao.MapaDAO;
import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.Mapa;
import br.com.edabes.utils.FileUtils;

@Service
public class MapaServiceImpl implements MapaService {

    @Autowired
    private MapaDAO mapaDAO;
    
    private Converter<Mapa, MapaDTO> converter;
    private final String mapaTreinamentoJson = "resources\\json\\mapaTreinamento.json";

    public MapaServiceImpl() {
	converter = new MapaConverter();
    }

    public ArrayList<MapaDTO> listarMapas() throws Exception {
	ArrayList<MapaDTO> mapasDTOs = new ArrayList<MapaDTO>();
	try {
	    ArrayList<Mapa> mapas = mapaDAO.listarMapas();
	    
	    mapas.forEach(m -> mapasDTOs.add(converter.converteModelParaDTO(m)));

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
	    Mapa mapa = mapaDAO.consultarMapa(converter.converteDTOParaModel(consulta));
	    mapaDTO = converter.converteModelParaDTO(mapa);
	}catch(Exception e){
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

    @Override
    public MapaDTO consultaMapaTreinamento() throws Exception {
	String mapa = "";
	MapaDTO mapaDTO = null;
	try{
	    FileUtils fileUtils = new FileUtils();
	    mapa = fileUtils.FileToString(mapaTreinamentoJson);
	    Gson gson = new Gson();
	    mapaDTO = gson.fromJson(mapa, MapaDTO.class);
	    
	    
	}catch(Exception e){
	    e.printStackTrace();
	    throw e;
	}
	return mapaDTO;
    }

}
