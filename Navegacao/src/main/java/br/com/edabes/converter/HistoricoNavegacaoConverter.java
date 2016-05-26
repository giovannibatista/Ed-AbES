package br.com.edabes.converter;

import br.com.edabes.dto.HistoricoNavegacaoDTO;
import br.com.edabes.dto.MapaDTO;
import br.com.edabes.model.HistoricoNavegacao;
import br.com.edabes.model.Mapa;

public class HistoricoNavegacaoConverter implements Converter<HistoricoNavegacao, HistoricoNavegacaoDTO> {
    
    private Converter<Mapa, MapaDTO> mapaConverter = new MapaConverter();

    @Override
    public HistoricoNavegacaoDTO converteModelParaDTO(HistoricoNavegacao model) {
	HistoricoNavegacaoDTO dto = new HistoricoNavegacaoDTO();
	dto.setId(model.getId());
	dto.setLog(model.getLog());
	dto.setMapa(mapaConverter.converteModelParaDTO(model.getMapa()));
	dto.setDataNavegacao(model.getDataNavegacao());
	dto.setTempoNavegacao(model.getTempoNavegacao());
	dto.setUsuario(model.getUsuario());
	return dto;
    }

    @Override
    public HistoricoNavegacao converteDTOParaModel(HistoricoNavegacaoDTO dto) {
	HistoricoNavegacao model = new HistoricoNavegacao();
	model.setId(dto.getId());
	model.setLog(dto.getLog());
	model.setMapa(mapaConverter.converteDTOParaModel(dto.getMapa()));
	model.setDataNavegacao(dto.getDataNavegacao());
	model.setTempoNavegacao(dto.getTempoNavegacao());
	model.setUsuario(dto.getUsuario());
	return model;
    }

}
