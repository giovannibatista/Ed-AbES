package edabes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edabes.entidades.Audio;

@Repository
@Transactional
public class AudioDAOImpl implements AudioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public AudioDAOImpl() {
	}

	public boolean salvarAudio(Audio audio) {
		boolean audioCadastrado = false;
		Session session;
		try {
			session = sessionFactory.getCurrentSession();

			session.save(audio);
			audioCadastrado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return audioCadastrado;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Audio> listaAudios() {

		ArrayList<Audio> listaAudios = new ArrayList<Audio>();
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery("from Audio");

			listaAudios = (ArrayList<Audio>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaAudios;
	}
	
	public Audio buscarAudio(Integer idArquivoAudio) {
		Audio audio = null;
		Session session;
		
		try {
			session = sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Audio where ID_ARQUIVO_AUDIO = :idArquivoAudio");
			query.setParameter("idArquivoAudio", idArquivoAudio);
			
			List<Audio> list = (ArrayList<Audio>) query.list();
			
			if(!list.isEmpty() && list != null) {
				audio = (Audio) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return audio;
	}

	
}
