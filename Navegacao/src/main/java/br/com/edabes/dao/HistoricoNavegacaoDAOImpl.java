package br.com.edabes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.model.HistoricoNavegacao;

@Repository
@Transactional
public class HistoricoNavegacaoDAOImpl implements HistoricoNavegacaoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HistoricoNavegacao incluirHistoricoNavegacao(HistoricoNavegacao historicoNavegacao) {
	Session session;
	try {
	    session = sessionFactory.getCurrentSession();

	    historicoNavegacao.setId((Integer)session.save(historicoNavegacao));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return historicoNavegacao;
    }

    @Override
    public List<HistoricoNavegacao> listarHistoricoNavegacao(HistoricoNavegacao historicoNavegacao) {
	List<HistoricoNavegacao> historicoNavegacaos = new ArrayList<HistoricoNavegacao>();
	Session session;
	;
	try {

	    session = sessionFactory.getCurrentSession();
	    Example example = Example.create(historicoNavegacao);

	    historicoNavegacaos = session.createCriteria(HistoricoNavegacao.class).add(example).list();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}

	return historicoNavegacaos;
    }

}
