package br.com.edabes.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.model.Mapa;

@Repository
@Transactional
public class MapaDAOImpl implements MapaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public MapaDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Mapa> listarMapas() {
	ArrayList<Mapa> mapas = new ArrayList<Mapa>();
	Session session;
	Query query;
	try {
	    
	    //TRAZER SOH OS CAMPOS DA TELA
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa m");
	    mapas = (ArrayList<Mapa>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mapas;
    }

}
