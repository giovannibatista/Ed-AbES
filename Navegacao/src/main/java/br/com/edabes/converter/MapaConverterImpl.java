package br.com.edabes.converter;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.Mapa;

public class MapaConverterImpl implements Converter<Mapa, MapaDTO> {
    
    
    public MapaConverterImpl() {
	super();
	// TODO Auto-generated constructor stub
    }

    public MapaDTO converteModelParaDTO(Mapa mapa) {
	MapaDTO mapaDTO = new MapaDTO();

	if (mapa == null) {
	    return new MapaDTO();
	}

	mapaDTO.setId(mapa.getId());
	mapaDTO.setNome(mapa.getNome());
	mapaDTO.setDescricao(mapa.getDescricao());
	mapaDTO.setObjetivo(mapa.getObjetivo());
	mapaDTO.setTipoMapa(mapa.getTipoMapa());
	mapaDTO.setDataAlteracao(mapa.getDataAlteracao());
	mapaDTO.setDataCriacao(mapa.getDataCriacao());
	mapaDTO.setAndar(mapa.getAndar());
	mapaDTO.setImportadoPor(mapa.getImportadoPor());
	mapaDTO.setNomeCriador(mapa.getNomeCriador());
	mapaDTO.setUnidadeDeMedida(mapa.getUnidadeDeMedida());

	return mapaDTO;
    }

    public Mapa converteDTOParaModel(MapaDTO mapaDTO) {
	Mapa mapa = new Mapa();

	if (mapaDTO == null) {
	    return new Mapa();
	}

	mapa.setId(mapaDTO.getId());
	mapa.setNome(mapaDTO.getNome());
	mapa.setDescricao(mapaDTO.getDescricao());
	mapa.setObjetivo(mapaDTO.getObjetivo());
	mapa.setTipoMapa(mapaDTO.getTipoMapa());
	mapa.setDataAlteracao(mapaDTO.getDataAlteracao());
	mapa.setDataCriacao(mapaDTO.getDataCriacao());
	mapa.setAndar(mapaDTO.getAndar());
	mapa.setImportadoPor(mapaDTO.getImportadoPor());
	mapa.setNomeCriador(mapaDTO.getNomeCriador());
	mapa.setUnidadeDeMedida(mapaDTO.getUnidadeDeMedida());

	return mapa;
    }

   
}
