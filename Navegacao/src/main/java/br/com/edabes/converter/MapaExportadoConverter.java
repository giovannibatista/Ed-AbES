package br.com.edabes.converter;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.MapaExportado;

public class MapaExportadoConverter implements Converter<MapaExportado, MapaDTO> {


	public MapaExportadoConverter() {
		super();
	}

	public MapaDTO converteModelParaDTO(MapaExportado mapa) {
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

	public MapaExportado converteDTOParaModel(MapaDTO mapaDTO) {
	    MapaExportado mapa = new MapaExportado();

		if (mapaDTO == null) {
			return new MapaExportado();
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
