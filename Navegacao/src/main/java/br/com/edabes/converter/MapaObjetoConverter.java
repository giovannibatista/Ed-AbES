package br.com.edabes.converter;

import br.com.edabes.dto.AudioIconicoDTO;
import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.dto.ObjetoDTO;
import br.com.edabes.model.AudioIconico;
import br.com.edabes.model.MapaObjeto;
import br.com.edabes.model.Objeto;

public class MapaObjetoConverter implements Converter<MapaObjeto, MapaObjetoDTO> {

    private Converter<Objeto, ObjetoDTO> objetoConverter = new ObjetoConverter();
    private Converter<AudioIconico, AudioIconicoDTO> audioConverter = new AudioIconicoConverter();

    @Override
    public MapaObjetoDTO converteModelParaDTO(MapaObjeto model) {
	MapaObjetoDTO mapaObjetoDTO = new MapaObjetoDTO();
	mapaObjetoDTO.setId(model.getId());
	mapaObjetoDTO.setIdMapa(model.getIdMapa());
	mapaObjetoDTO.setAltura(model.getAltura());
	mapaObjetoDTO.setLargura(model.getLargura());
	mapaObjetoDTO.setAngulo(model.getAngulo());
	mapaObjetoDTO.setCoordenadaX(model.getCoordenadaX());
	mapaObjetoDTO.setCoordenadaY(model.getCoordenadaY());
	mapaObjetoDTO.setProfundidade(model.getProfundidade());
	mapaObjetoDTO.setAudioDescricao(model.getAudioDescricao());

	mapaObjetoDTO.setAudioIconico(model.getAudioIconico() != null
		? audioConverter.converteModelParaDTO(model.getAudioIconico()) : new AudioIconicoDTO());

	mapaObjetoDTO.setObjeto(
		model.getObjeto() != null ? objetoConverter.converteModelParaDTO(model.getObjeto()) : new ObjetoDTO());
	return mapaObjetoDTO;
    }

    @Override
    public MapaObjeto converteDTOParaModel(MapaObjetoDTO dto) {
	MapaObjeto mapaObjeto = new MapaObjeto();
	mapaObjeto.setId(dto.getId());
	mapaObjeto.setIdMapa(dto.getIdMapa());
	mapaObjeto.setAltura(dto.getAltura());
	mapaObjeto.setLargura(dto.getLargura());
	mapaObjeto.setAngulo(dto.getAngulo());
	mapaObjeto.setCoordenadaX(dto.getCoordenadaX());
	mapaObjeto.setCoordenadaY(dto.getCoordenadaY());
	mapaObjeto.setProfundidade(dto.getProfundidade());
	mapaObjeto.setAudioDescricao(dto.getAudioDescricao());

	mapaObjeto.setAudioIconico(dto.getAudioIconico() != null
		? audioConverter.converteDTOParaModel(dto.getAudioIconico()) : new AudioIconico());

	mapaObjeto.setObjeto(
		dto.getObjeto() != null ? objetoConverter.converteDTOParaModel(dto.getObjeto()) : new Objeto());

	return mapaObjeto;
    }

}
