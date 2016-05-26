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

@Service
public class MapaObjetoServiceImpl implements MapaObjetoService {

    @Autowired
    private MapaObjetoDAO mapaObjetoDAO;

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

	    // TODO: Refatorar para validar ponto inicial e final
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

}
