package br.com.edabes.dao;

import java.util.List;

import br.com.edabes.model.HistoricoNavegacao;

public interface HistoricoNavegacaoDAO {
    
    HistoricoNavegacao incluirHistoricoNavegacao(HistoricoNavegacao historicoNavegacao);
    List<HistoricoNavegacao> listarHistoricoNavegacao(HistoricoNavegacao historicoNavegacao);

}
