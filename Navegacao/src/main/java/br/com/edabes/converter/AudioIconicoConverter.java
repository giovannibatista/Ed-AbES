package br.com.edabes.converter;

import br.com.edabes.dto.AudioIconicoDTO;
import br.com.edabes.model.AudioIconico;

public class AudioIconicoConverter implements Converter<AudioIconico, AudioIconicoDTO> {

    @Override
    public AudioIconicoDTO converteModelParaDTO(AudioIconico model) {
	AudioIconicoDTO dto = new AudioIconicoDTO();
	dto.setId(model.getId());
	dto.setArquivo(model.getArquivo());
	dto.setDescricao(model.getDescricao());
	return dto;
    }

    @Override
    public AudioIconico converteDTOParaModel(AudioIconicoDTO dto) {
	AudioIconico model = new AudioIconico();
	model.setId(dto.getId());
	model.setArquivo(dto.getArquivo());
	model.setDescricao(dto.getDescricao());
	return model;
    }

}
