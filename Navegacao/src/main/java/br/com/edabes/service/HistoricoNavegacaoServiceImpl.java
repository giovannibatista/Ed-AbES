package br.com.edabes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.HistoricoNavegacaoConverter;
import br.com.edabes.dao.HistoricoNavegacaoDAO;
import br.com.edabes.dto.HistoricoNavegacaoDTO;
import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.model.HistoricoNavegacao;
import br.com.edabes.model.MapaObjeto;

@Service
public class HistoricoNavegacaoServiceImpl implements HistoricoNavegacaoService {

    @Autowired
    private HistoricoNavegacaoDAO historicoNavegacaoDAO;
    private Converter<HistoricoNavegacao, HistoricoNavegacaoDTO> converter;

    public HistoricoNavegacaoServiceImpl() {
	converter = new HistoricoNavegacaoConverter();
    }

    @Override
    public Boolean incluirHistoricoNavegacao(HistoricoNavegacaoDTO historicoNavegacaoDTO) {
	HistoricoNavegacao historicoNavegacao = null;
	try {
	    historicoNavegacao = new HistoricoNavegacao();
	    historicoNavegacao = converter.converteDTOParaModel(historicoNavegacaoDTO);

	    historicoNavegacao = historicoNavegacaoDAO.incluirHistoricoNavegacao(historicoNavegacao);
	} catch (Exception e) {
	    throw e;
	}
	return historicoNavegacao != null ? true : false;
    }

    @Override
    public List<HistoricoNavegacaoDTO> listarHistoricoNavegacao(HistoricoNavegacaoDTO historicoNavegacaoDTO) {
	ArrayList<HistoricoNavegacaoDTO> historicoNavegacaoDTOs = new ArrayList<HistoricoNavegacaoDTO>();
	HistoricoNavegacao historicoNavegacao = null;
	try {
	    historicoNavegacao = converter.converteDTOParaModel(historicoNavegacaoDTO);
	    List<HistoricoNavegacao> historicoNavegacoes = historicoNavegacaoDAO
		    .listarHistoricoNavegacao(historicoNavegacao);
	    historicoNavegacoes.forEach(m -> historicoNavegacaoDTOs.add(converter.converteModelParaDTO(m)));
	} catch (Exception e) {
	    throw e;
	}
	return historicoNavegacaoDTOs;
    }

}
