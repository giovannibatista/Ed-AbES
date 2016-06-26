package br.com.edabes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.model.Mapa;
import br.com.edabes.model.MapaExportado;

@Repository
@Transactional
public class MapaDAOImpl implements MapaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public MapaDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Mapa> listarMapasCriadosDoUsuario(Mapa mapa) throws Exception {
	ArrayList<Mapa> mapas = new ArrayList<Mapa>();
	Session session;
	Query query;
	try {

	    // TRAZER SOH OS CAMPOS DA TELA
	    session = sessionFactory.getCurrentSession();
	    query = session
		    .createQuery("from Mapa m where m.criador = :criador AND importado = 0 order by dt_alteracao desc");
	    query.setParameter("criador", mapa.getCriador());

	    mapas = (ArrayList<Mapa>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapas;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Mapa> listarMapasImportadosDoUsuario(Mapa mapa) throws Exception {
	ArrayList<Mapa> mapas = new ArrayList<Mapa>();
	Session session;
	Query query;
	try {

	    // TRAZER SOH OS CAMPOS DA TELA
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa m where IMPORTADO = :idUsuario order by dt_alteracao desc");
	    query.setParameter("idUsuario", mapa.getImportadoPor());

	    mapas = (ArrayList<Mapa>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapas;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<MapaExportado> listarMapasPublicos() throws Exception {
	ArrayList<MapaExportado> mapas = new ArrayList<MapaExportado>();
	Session session;
	Query query;
	try {

	    // TRAZER SOH OS CAMPOS DA TELA
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from MapaExportado m order by dt_criacao desc");

	    mapas = (ArrayList<MapaExportado>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapas;
    }

    @Override
    public Mapa consultarMapa(Mapa mapa) {
	Session session;
	Query query = null;
	try {

	    session = sessionFactory.getCurrentSession();
	    if (mapa.getId() != null) {
		query = session.createQuery("from Mapa m where m.id = :id");
		query.setParameter("id", mapa.getId());
	    } else if (!mapa.getNome().isEmpty()) {
		query = session.createQuery("from Mapa m where m.nome = :nome");
		query.setParameter("nome", mapa.getNome());
	    }

	    mapa = (Mapa) query.uniqueResult();
	} catch (NonUniqueResultException non) {
	    non.printStackTrace();
	    throw non;
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapa;
    }

    @Override
    public MapaExportado consultarMapaPublico(MapaExportado mapa) {
	Session session;
	Query query;
	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from MapaExportado m where m.id = :id");
	    query.setParameter("id", mapa.getId());

	    mapa = (MapaExportado) query.uniqueResult();
	} catch (NonUniqueResultException non) {
	    non.printStackTrace();
	    throw non;
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapa;
    }

    @Override
    public Integer salvarMapa(Mapa mapa) {
	Session session;
	try {

	    session = sessionFactory.getCurrentSession();
	    session.save(mapa);

	    System.out.println("ID NOVO -> " + mapa.getId());

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapa.getId();
    }

}
