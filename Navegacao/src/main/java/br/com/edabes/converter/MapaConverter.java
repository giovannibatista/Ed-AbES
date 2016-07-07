package br.com.edabes.converter;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.Mapa;

public class MapaConverter implements Converter<Mapa, MapaDTO> {

    public MapaConverter() {
	super();
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
	mapaDTO.setCriador(mapa.getCriador());

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
	mapa.setCriador(mapaDTO.getCriador());

	return mapa;
    }

}
