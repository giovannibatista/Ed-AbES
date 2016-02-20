package edabes.dao;

import java.util.ArrayList;

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
			System.out.println("3");
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
			query = session.createQuery("from UPLOAD_ARQUIVO_AUDIOS");

			listaAudios = (ArrayList<Audio>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaAudios;
	}
}
