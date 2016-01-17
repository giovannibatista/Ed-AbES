package edabes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edabes.dto.ListarMapaDTO;
import edabes.entidades.Mapa;
import edabes.entidades.MapaExportado;
import edabes.entidades.MapaObjeto;
import edabes.entidades.MapaObjetoExportado;
import edabes.mapper.MapaObjetoMapper;

@Repository
@Transactional
public class MapaDAOExportadoImpl implements MapaDAOExportado{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MapaObjetoMapper mapperService;
	
	public MapaDAOExportadoImpl() {
	}
	
	/**
	 * Metodo para buscar os objetos do mapa exportado
	 * @param int idMapa - Identificador do mapa
	 * @return ArrayList<MapaObjetoExportado> listaMapaObjetos - Lista com todos os 
	 * objeto do mapa exportado
	 */
	public ArrayList<MapaObjetoExportado> buscaListaDeMapaObjetosExportados(int idMapa) {
		ArrayList<MapaObjetoExportado> listaMapaObjetos = new ArrayList<MapaObjetoExportado>();
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			
			query = session.createQuery("from MapaObjetoExportado where ID_MAPA = :idMapa");
			query.setParameter("idMapa", idMapa);
			
			listaMapaObjetos = (ArrayList<MapaObjetoExportado>) query.list();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listaMapaObjetos;
	}
	
	/**
	 * Metodo para excluir todos os objetos do mapa exportado
	 * @param int idMapa - Identificador do mapa
	 */
	public void excluirObjetosExportados(int idMapa) {
		Session session;
		Query query = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("delete MapaObjetoExportado where ID_MAPA = :idMapa");
			query.setParameter("idMapa", idMapa);
			int result = query.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo para exportar o mapa
	 * @param MapaExportado - Objeto com as informacoes do mapa exportado
	 * @return int idMapaExportado - Identificados do mapa exportado. Sera -1 caso
	 * tenha ocorrido alguma falha
	 */
	public int disponibilizarMapa(MapaExportado mapaExportado) {
		Session session;
		boolean mapaDisponivel = false;
		ArrayList<MapaObjeto> listaDeObjetos = null;
		int idMapaExportado = -1;
		
		try {
			session = sessionFactory.getCurrentSession();
			
			mapaExportado.setMapaId(0);
			session.save(mapaExportado);
			
			idMapaExportado = buscaIdMapaExportadoPorNome(mapaExportado.getNomeMapa());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idMapaExportado;

	}
	
	/**
	 * Metodo para salvar um objeto no mapa exportado
	 * @param MapaObjetoExportado mapaObjetoExportado - Objeto com informacoes do objeto
	 * do mapa
	 */
	public void salvarMapaObjeto(MapaObjetoExportado mapaObjetoExportado) {
		Session session;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.save(mapaObjetoExportado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo para atualizar o mapa exportado
	 * @param MapaExportado mapaExportado - Objeto com informacoes do mapa exportado
	 * @return boolean mapaDisponivel - Retorna true caso o mapa tenha sido atualizado com sucesso
	 */
	public boolean atualizaMapaExportado(MapaExportado mapaExportado) {
		Session session;
		Query query = null;
		boolean mapaDisponivel = false;
		int result = -1;
		
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery("update MapaExportado set DESCRICAO = :descricao, OBJETIVO = :objetivo, TIPO_MAPA = :tipoMapa, DT_ALTERACAO = :dataAlteracao, UNIDADE_MEDIDA = :unidadeMedida where NOME_MAPA = :nomeMapa");
			query.setParameter("nomeMapa", mapaExportado.getNomeMapa());
			query.setParameter("descricao", mapaExportado.getDescricaoMapa());
			query.setParameter("objetivo", mapaExportado.getObjetivoMapa());
			query.setParameter("tipoMapa", mapaExportado.getTipoMapa());
			query.setParameter("dataAlteracao", new Date());
			query.setParameter("unidadeMedida", mapaExportado.getUnidadeDeMedida());
			
			result = query.executeUpdate();
			
			if(result > 0) {
				mapaDisponivel = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapaDisponivel;
		
	}
	
	/**
	 * Metodo para verificar se o mapa ja foi exportado atraves do nome
	 * @param String nomeMapa
	 * @return boolean mapaJaExistente - True se o mapa ja foi exportado
	 */
	public boolean verificaMapaExportado(String nomeMapa) {
		List<Mapa> list = null;
		Session session;
		Query query = null;
		boolean mapaJaExistente = false;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MapaExportado where NOME_MAPA = :nomeMapa");
			query.setParameter("nomeMapa", nomeMapa);
			list = query.list();

			if (!list.isEmpty() && list != null) {
				mapaJaExistente = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapaJaExistente;
	}
	
	/**
	 * Metodo para verificar se o mapa ja foi exportado atraves do id
	 * @param int idMapa - Identificador do mapa
	 * @return boolean mapaJaExistente - True se o mapa ja foi exportado
	 */
	public boolean verificaMapaExportado(int idMapa) {
		List<Mapa> list = null;
		Session session;
		Query query = null;
		boolean mapaJaExistente = false;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MapaExportado where ID_MAPA = :idMapa");
			query.setParameter("idMapa", idMapa);
			list = query.list();

			if (!list.isEmpty() && list != null) {
				mapaJaExistente = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapaJaExistente;
	}
	
	/**
	 * Metodo para buscar o mapa exportado pelo id
	 * @param int idMapaExportado - Identificador do mapa exportado
	 * @return MapaExportado mapaExportado - Objeto com informacoes do mapa exportado
	 */
	public MapaExportado buscaMapaPorIdExportado(int idMapaExportado) {
		MapaExportado mapaExportado = null;
		List<MapaExportado> list = null;
		Session session;
		Query query = null;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MapaExportado where ID_MAPA = :idMapaExportado");
			query.setParameter("idMapaExportado", idMapaExportado);
			list = query.list();

			if (!list.isEmpty() && list != null) {
				mapaExportado = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapaExportado;
	}
	
	/**
	 * Metodo para buscar o id do mapa exportado atraves do nome
	 * @param String nomeMapa
	 * @return int idMapaExportado - Identificador do mapa exportado
	 */
	public int buscaIdMapaExportadoPorNome(String nomeMapa) {
		MapaExportado mapaExportado = null;
		List<MapaExportado> list = null;
		Session session;
		Query query = null;
		int idMapaExportado = -1;

		try {
			session = sessionFactory.getCurrentSession();
			query = session
					.createQuery("from MapaExportado where NOME_MAPA = :nomeMapa");
			query.setParameter("nomeMapa", nomeMapa);
			list = query.list();

			if (!list.isEmpty() && list != null) {
				mapaExportado = list.get(0);
				idMapaExportado = mapaExportado.getMapaId();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idMapaExportado;
	}
	
	/**
	 * Metodo par abuscar todos os mapa exportados
	 * @return ArrayList<ListarMapaDTO> listaMapasExportados - Lista de ListarMapaDTO que
	 * possuem informacoes do mapas exportados
	 */
	public ArrayList<ListarMapaDTO> buscaListaDeMapasExportados() {
		ArrayList<MapaExportado> listaDeMapas = new ArrayList<MapaExportado>();
		ArrayList<ListarMapaDTO> listaMapasExportados = new ArrayList<ListarMapaDTO>();
		Session session;
		Query query = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery("from MapaExportado");
			
			listaDeMapas = (ArrayList<MapaExportado>) query.list();

			for(MapaExportado mapa : listaDeMapas) {
				ListarMapaDTO dto = new ListarMapaDTO();
				dto.copiaMapaExportado(mapa);
				listaMapasExportados.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaMapasExportados;
	}
	
}
