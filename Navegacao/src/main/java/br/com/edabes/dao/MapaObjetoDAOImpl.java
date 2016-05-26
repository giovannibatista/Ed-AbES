
package br.com.edabes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.model.MapaObjeto;

@Repository
@Transactional
public class MapaObjetoDAOImpl implements MapaObjetoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public MapaObjetoDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MapaObjeto> carregarObjetosMapa(MapaObjeto mapaObjeto) {
	List<MapaObjeto> mapaObjetos = new ArrayList<MapaObjeto>();
	Session session;
	try {
	   
	    session = sessionFactory.getCurrentSession();
	    Example example = Example.create(mapaObjeto);
	    
	    mapaObjetos =  session.createCriteria(MapaObjeto.class).add(example).list();

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	}
	return mapaObjetos;
    }

}
