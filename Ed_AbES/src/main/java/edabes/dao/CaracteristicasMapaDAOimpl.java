package edabes.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edabes.entidades.Mapa;

@Repository
@Transactional
public class CaracteristicasMapaDAOimpl implements CaracteristicasMapaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Metodo para buscar um mapa pelo nome
	 * @param String nome - Nome do mapa
	 * @return Mapa mapa - Objeto com as informacoes do mapa
	 */
	public Mapa buscaMapaPorNome(String nome) {
		Mapa mapa = null;
		List<Mapa> list = null;
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MAPA where NOME_MAPA = :nome");
			query.setParameter("nome", nome);
			list = query.list();

			if (!list.isEmpty() && list != null) {
				mapa = (Mapa) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapa;
	}
	
	/**
	 * Metodo para buscar uma lista de mapas pelo objetivo
	 * @param String objetivo - Objetivo do mapa
	 * @return List<Mapa> listaMapas - Lista de mapas
	 */
	public List<Mapa> buscaMapasPorObjetivo(String objetivo) {
		List<Mapa> listaMapas = null;
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MAPA where OBJETIVO LIKE :objetivo");
			query.setParameter("objetivo", objetivo);
			listaMapas = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaMapas;

	}
	
	/**
	 * Metodo para salvar as caracteristicas do mapa
	 * @param Mapa caracteristicasMapa - Objeto com as caracteristicas do mapa
	 * @return boolean caracteristicasSalvas - True se as caracteristicas forem salvas 
	 * com sucesso
	 */
	public boolean salvaCaracteristicasMapa(Mapa caracteristicasMapa) {
		Session session;
		boolean caracteristicasSalvas = false;
		Mapa mapaJaExistente = null;

		try {
			session = sessionFactory.getCurrentSession();

			mapaJaExistente = (Mapa) buscaMapaPorNome(caracteristicasMapa.getNomeMapa());

			if (mapaJaExistente == null) {
				session.save(caracteristicasMapa);
				caracteristicasSalvas = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return caracteristicasSalvas;
	}
	
	/**
	 * Metodo para buscar todos os mapas
	 * @return ArrayList<Mapa> listaDeMapas - Lista com todos os mapas
	 */
	public ArrayList<Mapa> buscaListaDeMapas() {
		ArrayList<Mapa> liataDeMapas = new ArrayList<Mapa>();
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MAPA");
			
			liataDeMapas = (ArrayList<Mapa>) query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return liataDeMapas;
	}

}
