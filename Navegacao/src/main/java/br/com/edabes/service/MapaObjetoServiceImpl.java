package br.com.edabes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.MapaObjetoConverter;
import br.com.edabes.dao.MapaObjetoDAO;
import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.model.MapaObjeto;
import br.com.edabes.utils.FileUtils;

@Service
public class MapaObjetoServiceImpl implements MapaObjetoService {

    @Autowired
    private MapaObjetoDAO mapaObjetoDAO;

    private final String objetosTreinamentoJson = "resources\\json\\objetosTreinamento.json";

    private Converter<MapaObjeto, MapaObjetoDTO> converter;

    public MapaObjetoServiceImpl() {
	converter = new MapaObjetoConverter();
    }

    @Override
    public ArrayList<MapaObjetoDTO> carregaObjetosMapa(MapaObjetoDTO mapaObjetoDTO) {
	ArrayList<MapaObjetoDTO> mapaObjetoDTOs = new ArrayList<MapaObjetoDTO>();
	MapaObjeto mapaObjeto = null;
	try {
	    mapaObjeto = converter.converteDTOParaModel(mapaObjetoDTO);

	    List<MapaObjeto> mapaObjetos = mapaObjetoDAO.carregarObjetosMapa(mapaObjeto);

	    mapaObjetos.forEach(m -> mapaObjetoDTOs.add(validaPontoInicialFinal(converter.converteModelParaDTO(m))));

	} catch (Exception e) {
	    throw e;
	}
	return mapaObjetoDTOs;
    }

    public MapaObjetoDTO validaPontoInicialFinal(MapaObjetoDTO mapaObjetoDTO) {
	if (mapaObjetoDTO.getObjeto().getDescricao().equalsIgnoreCase("ponto inicio")) {
	    mapaObjetoDTO.setPontoInicial(true);
	}
	if (mapaObjetoDTO.getObjeto().getDescricao().equalsIgnoreCase("ponto fim")) {
	    mapaObjetoDTO.setPontoFinal(true);
	}

	return mapaObjetoDTO;
    }

    @Override
    public String carregaObjetosMapaTreinamento() throws Exception {
	String objetos = "";
	try {
	    FileUtils fileUtils = new FileUtils();
	    objetos = fileUtils.FileToString(objetosTreinamentoJson);
	} catch (Exception e) {
	    throw e;
	}
	return objetos;
    }

}
