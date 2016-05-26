package br.com.edabes.service;

import java.util.List;

import br.com.edabes.dto.HistoricoNavegacaoDTO;

public interface HistoricoNavegacaoService {

    Boolean incluirHistoricoNavegacao(HistoricoNavegacaoDTO historicoNavegacaoDTO);

    List<HistoricoNavegacaoDTO> listarHistoricoNavegacao(HistoricoNavegacaoDTO historicoNavegacaoDTO);

}