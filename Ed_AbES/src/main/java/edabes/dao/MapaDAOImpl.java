package edabes.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edabes.dto.ListarMapaDTO;
import edabes.dto.ObjetoAlteracoesDTO;
import edabes.entidades.Categoria;
import edabes.entidades.Mapa;
import edabes.entidades.MapaObjeto;
import edabes.entidades.Objeto;
import edabes.entidades.Subcategoria;
import edabes.mapper.MapaObjetoMapper;

@Repository
@Transactional
public class MapaDAOImpl implements MapaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private MapaObjetoMapper mapperService;

    public MapaDAOImpl() {
    }

    /**
     * Metodo para buscar um mapa pelo nome
     * 
     * @param String
     *            nome - Nome do mapa
     * @return Mapa mapa - Objeto com informacoes do mapa
     */
    public Mapa buscaMapaPorNome(String nome) {
	return buscaMapaPorNome(nome, 0);
    }

    /**
     * Metodo para buscar um mapa pelo nome
     * 
     * @param String
     *            nome - Nome do mapa
     * @param Integer
     *            id - Id do mapa
     * @return Mapa mapa - Objeto com informacoes do mapa
     */
    public Mapa buscaMapaPorNome(String nome, Integer id) {
	Mapa mapa = null;
	List<Mapa> listaMapas = null;
	Session sessao;
	Query query = null;
	String sql = "";
	try {
	    sessao = sessionFactory.getCurrentSession();

	    if (id > 0) {
		query = sessao.createQuery("from Mapa where NOME_MAPA = :nome and ID_MAPA <> :id");
		query.setParameter("nome", nome);
		query.setParameter("id", id);
	    } else {
		query = sessao.createQuery("from Mapa where NOME_MAPA = :nome");
		query.setParameter("nome", nome);

	    }
	    listaMapas = query.list();

	    if (!listaMapas.isEmpty() && listaMapas != null) {
		mapa = (Mapa) listaMapas.get(0);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapa;
    }

    /**
     * Metodo para excluir um mapa
     * 
     * @param int
     *            idMapa - Identificador do mapa
     * @return boolean mapaExcluido - True caso o mapa tenha sido excluido com
     *         sucesso
     */
    public boolean excluirMapa(int idMapa) {
	Session session;
	Query query = null;
	boolean mapaExcluido = false;
	boolean objetosDoMapaExluidos = false;

	try {
	    excluirObjetosDoMapa(idMapa);

	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("delete Mapa where ID_MAPA = :idMapa");
	    query.setParameter("idMapa", idMapa);

	    int result = query.executeUpdate();
	    if (result > 0) {
		mapaExcluido = true;
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapaExcluido;
    }
    
 
    /**
     * Metodo para excluir todos os objetos de um mapa
     * 
     * @param int
     *            idMapa - Identificador do mapa
     */
    public void excluirObjetosDoMapa(int idMapa) {
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("delete MapaObjeto where ID_MAPA = :idMapa");
	    query.setParameter("idMapa", idMapa);
	    int result = query.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /**
     * Metodo para buscar uma lista de mapas pelo objetivo
     * 
     * @param String
     *            objetivo - Objetivo do mapa
     * @return List<Mapa> listaMaps - Lista de mapas
     */
    public List<Mapa> buscaMapasPorObjetivo(String objetivo) {
	List<Mapa> listaMapas = null;
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from MAPA where OBJETIVO LIKE :objetivo");
	    query.setParameter("objetivo", objetivo);
	    listaMapas = query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaMapas;

    }

    /**
     * Metodo para buscar um mapa pelo id
     * 
     * @param int
     *            mapaId - Identificador do mapa
     * @return Mapa mapa - Objeto com informacoes do mapa
     */
    public Mapa buscaMapaPorId(int mapaId) {
	Mapa mapa = null;
	List<Mapa> list = null;
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where ID_MAPA = :mapaId");
	    query.setParameter("mapaId", mapaId);
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
     * Metodo para salvar um objeto em um mapa
     * 
     * @param MapaObjeto
     *            mapaObjeto - Objeto do mapa
     */
    public void salvarMapaObjeto(MapaObjeto mapaObjeto) {
	Session session;

	try {
	    session = sessionFactory.getCurrentSession();
	    session.save(mapaObjeto);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /**
     * Metodo para buscar uma lista de mapas pela data de criacao
     * 
     * @param Date
     *            dataCriacao - Data de criacado do mapa
     * @return List<Mapa> listaMapa - Lista de mapas
     */
    public Mapa buscaMapaPorDataCriacao(Date dataCriacao) {
	List<Mapa> listaMapa = null;
	Session session;
	Mapa mapa = null;
	Calendar calendar = Calendar.getInstance();
	java.sql.Date sqlDataCriacao = null;
	Query query = null;

	try {
	    calendar.setTime(dataCriacao);
	    sqlDataCriacao = new java.sql.Date(calendar.getTime().getTime());
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where DT_CRIACAO LIKE :dataCriacao");
	    query.setParameter("dataCriacao", sqlDataCriacao);
	    listaMapa = query.list();

	    if (!listaMapa.isEmpty() && listaMapa != null) {
		mapa = (Mapa) listaMapa.get(0);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapa;
    }

    /**
     * Metodo para salvar as caracteristicas do mapa e retornar o identificador
     * 
     * @param Mapa
     *            caracteristicasMapa - Objeto com as caracteristicas do mapa
     * @return int mapaId - Identificador do mapa. Sera -1 caso ocorra alguma
     *         falha
     */
    public int salvarERecuperarCaracteristicasMapaId(Mapa caracteristicasMapa) {
	int mapaId = -1;
	boolean mapaSalvo = false;
	Mapa mapa = null;

	mapaSalvo = salvaCaracteristicasMapa(caracteristicasMapa);

	if (mapaSalvo) {
	    mapa = (Mapa) buscaMapaPorNome(caracteristicasMapa.getNomeMapa());
	    mapaId = mapa.getMapaId();
	}

	return mapaId;
    }

    /**
     * Metodo para salvar as caracteristicas do mapa
     * 
     * @param Mapa
     *            caracteristicasMapa - Objeto com as caracteristicas do mapa
     * @return boolean caracteristicasSavlas - True caso o mapa tenha sido salvo
     *         com sucesso
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
     * Metodo para salvar as edicoes nas caracteritiscas do mapa
     * 
     * @param Mapa
     *            caracteristicasMapa - Objeto com as alteracoes nas
     *            caracteristicas do mapa
     * @return int idResult - Identificador do mapa atualizado
     */
    public int salvaEdicaoCaracteristicasMapa(Mapa caracteristicasMapa) {
	Session session;
	Query query = null;
	int idResult = -1;
	Mapa mapaJaExistente = null;
	int result;

	try {

	    mapaJaExistente = (Mapa) buscaMapaPorNome(caracteristicasMapa.getNomeMapa(),
		    caracteristicasMapa.getMapaId());

	    if (mapaJaExistente == null) {
		session = sessionFactory.getCurrentSession();

		query = session.createQuery(
			"update Mapa set NOME_MAPA = :nome, DESCRICAO = :descricao, OBJETIVO = :objetivo, TIPO_MAPA = :tipoMapa, DT_ALTERACAO = :dataAlteracao, UNIDADE_MEDIDA = :unidadeMedida, ANDAR = :andar where ID_MAPA = :idMapa");
		query.setParameter("idMapa", caracteristicasMapa.getMapaId());
		query.setParameter("nome", caracteristicasMapa.getNomeMapa());
		query.setParameter("descricao", caracteristicasMapa.getDescricaoMapa());
		query.setParameter("objetivo", caracteristicasMapa.getObjetivoMapa());
		query.setParameter("tipoMapa", caracteristicasMapa.getTipoMapa());
		query.setParameter("dataAlteracao", new Date());
		query.setParameter("unidadeMedida", caracteristicasMapa.getUnidadeDeMedida());
		query.setParameter("andar", caracteristicasMapa.getAndar());

		result = query.executeUpdate();

		if (result > 0) {
		    idResult = caracteristicasMapa.getMapaId();
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return idResult;

    }

    /**
     * Metodo para buscar informacoes de todos os mapas
     * 
     * @return ArrayList<ListarMapaDTO> listaMapas - Lista com ListarMapaDTO que
     *         possuem informacoes dos mapas
     */
    public ArrayList<ListarMapaDTO> buscaListaDeMapas() {
	ArrayList<Mapa> listaDeMapas = new ArrayList<Mapa>();
	ArrayList<ListarMapaDTO> listaMapas = new ArrayList<ListarMapaDTO>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa");

	    listaDeMapas = (ArrayList<Mapa>) query.list();

	    for (Mapa mapa : listaDeMapas) {
		ListarMapaDTO dto = new ListarMapaDTO();
		dto.copiaMapa(mapa);
		listaMapas.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaMapas;
    }

    /**
     * Metodo para buscar somente os mapas criados pelo usuario
     * 
     * @param int
     *            idUsuario - Identificador do usuario
     * @return ArrayList<ListarMapaDTO> listaMapasDoUsuario - Lista com
     *         ListarMapaDTO que possuem informacoes dos mapas
     */
    public ArrayList<ListarMapaDTO> buscaListaDeMapasCriadosDoUsuario(int idUsuario) {
	ArrayList<Mapa> listaDeMapas = new ArrayList<Mapa>();
	ArrayList<ListarMapaDTO> listaMapasDoUsuario = new ArrayList<ListarMapaDTO>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where Criador = :idCriador AND Importado = 0");
	    query.setParameter("idCriador", idUsuario);

	    listaDeMapas = (ArrayList<Mapa>) query.list();

	    for (Mapa mapa : listaDeMapas) {
		ListarMapaDTO dto = new ListarMapaDTO();
		dto.copiaMapa(mapa);
		listaMapasDoUsuario.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaMapasDoUsuario;
    }

    /**
     * Metodo para buscar somente os mapas importados pelo usuario
     * 
     * @param int
     *            idUsuario - Identificador do usuario
     * @return ArrayList<ListarMapaDTO> listaMapasImportadosDoUsuario - Lista
     *         com ListarMapaDTO que possuem informacoes dos mapas
     */
    public ArrayList<ListarMapaDTO> buscaListaDeMapasImportadosDoUsuario(int idUsuario) {
	ArrayList<Mapa> listaDeMapas = new ArrayList<Mapa>();
	ArrayList<ListarMapaDTO> listaMapasImportadosDoUsuario = new ArrayList<ListarMapaDTO>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where IMPORTADO = :idUsuario");
	    query.setParameter("idUsuario", idUsuario);

	    listaDeMapas = (ArrayList<Mapa>) query.list();

	    for (Mapa mapa : listaDeMapas) {
		ListarMapaDTO dto = new ListarMapaDTO();
		dto.copiaMapa(mapa);
		listaMapasImportadosDoUsuario.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaMapasImportadosDoUsuario;
    }

    /**
     * Metodo para buscar as categorias de objetos do mapa
     * 
     * @return ArrayList<Categoria> listaCategorias - Lista contendo as
     *         categorias de objetos do mapa
     */
    public ArrayList<Categoria> buscaCategorias() {
	ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();

	    // if(tipoMapa > 1) { //Seleciona somente as categorias da navegação
	    // livre
	    query = session.createQuery("from Categoria");
	    /*
	     * } else { //Seleciona somente as categorias do desafio query =
	     * session.createQuery("from Categoria where TITULO <> 'Desafio'");
	     * }
	     */
	    listaCategorias = (ArrayList<Categoria>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaCategorias;
    }

    /**
     * Metodo para buscar as subcategorias de uma categoria de objetos do mapa
     * 
     * @param int
     *            idCategoria - Identificador da categoria do mapa * @param int
     *            tipoMapa - Tipo do Mapa
     * @return ArrayList<Subcategoria> listaSubcategorias - Lista contendo as
     *         subcategorias de uma categoria de objetos do mapa
     */
    public ArrayList<Subcategoria> buscaSubcategorias(int idCategoria) {
	ArrayList<Subcategoria> listaSubcategorias = new ArrayList<Subcategoria>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Subcategoria where ID_CATEGORIA = :idCategoria");
	    query.setParameter("idCategoria", idCategoria);

	    listaSubcategorias = (ArrayList<Subcategoria>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaSubcategorias;
    }

    /**
     * Metodo para buscar os objetos de uma subcategoria
     * 
     * @param int
     *            idSubcategoria - Identificador da subcategoria
     * @param int
     *            tipoMapa - Tipo do Mapa
     * @return ArrayList<Objeto> listaObjetos - Lista de objetos da subcategoria
     */
    public ArrayList<Objeto> buscaObjetosPorSubcategoria(int idSubcategoria) {
	ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Objeto where SUBCATEGORIA = :idSubcategoria");
	    query.setParameter("idSubcategoria", idSubcategoria);

	    listaObjetos = (ArrayList<Objeto>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaObjetos;
    }

    /**
     * Metodo para buscar todos os MapaObjetos do mapa
     * 
     * @param int
     *            idMapa - Identificador do mapa
     * @return ArrayList<MapaObjeto> listaMapaObjetos - Lista do MapaObjetos do
     *         mapa
     */
    public ArrayList<MapaObjeto> buscaListaDeMapaObjetos(int idMapa) {
	ArrayList<MapaObjeto> listaMapaObjetos = new ArrayList<MapaObjeto>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();

	    query = session.createQuery("from MapaObjeto where ID_MAPA = :idMapa");
	    query.setParameter("idMapa", idMapa);

	    listaMapaObjetos = (ArrayList<MapaObjeto>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaMapaObjetos;
    }

    /**
     * Metodo para buscar todos os objetos do mapa
     * 
     * @param int
     *            idMapa - Identificador do mapa
     * @return ArrayList<Objeto> listaDeObjetosDoMapa - Lista do objetos do mapa
     */
    public ArrayList<Objeto> buscaListaObjetosByMapa(int idMapa) {
	ArrayList<Objeto> listaDeObjetosDoMapa = new ArrayList<Objeto>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery(
		    "from Objeto where ID_OBJETO IN (SELECT mapobj.idObjeto FROM MapaObjeto as mapobj WHERE mapobj.idMapa = :idMapa)");
	    query.setParameter("idMapa", idMapa);

	    listaDeObjetosDoMapa = (ArrayList<Objeto>) query.list();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listaDeObjetosDoMapa;
    }

    /**
     * Metodo para retornar um hashmap contendo o id do objeto e as informacoes
     * do objeto
     * 
     * @param int
     *            idMapa - Identificador do mapa
     * @return HashMap<Integer, Objeto> returnObject - Hashmap contendo o id do
     *         objeto e as informacoes do mesmo
     */
    public HashMap<Integer, Objeto> buscaObjetosDoMapa(int idMapa) {
	ArrayList<Objeto> objetosDoMapa = new ArrayList<Objeto>();
	HashMap<Integer, Objeto> returnObject = new HashMap<Integer, Objeto>();

	objetosDoMapa = buscaListaObjetosByMapa(idMapa);

	for (Objeto obj : objetosDoMapa) {
	    returnObject.put(obj.getId(), obj);
	}

	return returnObject;
    }

    /**
     * Metodo para salvar as mudancas no desenho do mapa
     * 
     * @param List<ObjetoAlteracoesDTO>
     *            listaDeObjetos - Alteracoes nos MapaObjeto do mapa
     * @param int
     *            idMapa - Idntificador do mapa
     * @return boolean mudancasEfetuadas - True caso as mudancas tenham sido
     *         salvas com sucesso
     */
    public boolean salvarMudancasDoDesenhoMapa(List<ObjetoAlteracoesDTO> listaDeObjetos, int idMapa) {
	boolean mudancasEfetuadas = true;
	boolean mapaObjetoSalvo = false;

	for (ObjetoAlteracoesDTO objetoAlteracoesDTO : listaDeObjetos) {
	    mapaObjetoSalvo = salvarMapaObjeto(objetoAlteracoesDTO, idMapa);

	    if (!mapaObjetoSalvo) {
		mudancasEfetuadas = false;
	    }

	}

	return mudancasEfetuadas;
    }

    /**
     * Metodo para salvar os objetos no mapa
     * 
     * @param ObjetoAlteracoesDTO
     *            objetosDoMapa - Objetos a serem salvos no mapa
     * @param int
     *            idMapa - Identificador do mapa
     * @return boolean operacaoRealizada - True caso os objetos tenham sidos
     *         salvos com sucesso
     */
    public boolean salvarMapaObjeto(ObjetoAlteracoesDTO objetosDoMapa, int idMapa) {
	boolean operacaoRealizada = false;
	Session session;
	Query query = null;
	int result = -1;
	MapaObjeto mapaObj = null;

	// get the entity based on DTO
	mapaObj = mapperService.toEntity(objetosDoMapa, idMapa);

	try {

	    session = sessionFactory.getCurrentSession();

	    if (objetosDoMapa.getOperacao() == 1) { // objeto novo
		session.save(mapaObj);
		operacaoRealizada = true;

	    } else if (objetosDoMapa.getOperacao() == 2) { // objeto existente
							   // atualizado
		query = session.createQuery(" update MapaObjeto " + " set AUDIO_DESCRICAO = :audioDescricao, "
			+ " LARGURA = :largura, " + " ALTURA = :altura, " + " PROFUNDIDADE = :profundidade, "
			+ " COORDENADA_X = :coordenadaX, " + " COORDENADA_Y = :coordenadaY, "
			+ (mapaObj.getIdArquivoAudio() == null ? " ANGULO = :angulo"
				: " ANGULO = :angulo, " + " ID_ARQUIVO_AUDIO = :idArquivoAudio ")
			+ " where ID_MAPA_OBJETO = :idMapaObjeto"

		);
		query.setParameter("profundidade", mapaObj.getProfundidade());
		query.setParameter("coordenadaX", mapaObj.getCoordenadaX());
		query.setParameter("coordenadaY", mapaObj.getCoordenadaY());
		query.setParameter("idMapaObjeto", mapaObj.getId());
		query.setParameter("audioDescricao", mapaObj.getAudioDescricao());
		query.setParameter("largura", mapaObj.getLargura());
		query.setParameter("altura", mapaObj.getAltura());
		query.setParameter("angulo", mapaObj.getAngulo());
		if (mapaObj.getIdArquivoAudio() != null) {
		    query.setParameter("idArquivoAudio", mapaObj.getIdArquivoAudio());
		}

		result = query.executeUpdate();

		if (result > 0) {
		    operacaoRealizada = true;
		}

	    } else if (objetosDoMapa.getOperacao() == 3) {
		query = session.createQuery("delete MapaObjeto where ID_MAPA_OBJETO = :idMapaObjeto");
		query.setParameter("idMapaObjeto", mapaObj.getId());
		result = query.executeUpdate();

		if (result > 0) {
		    operacaoRealizada = true;
		}
	    }

	} catch (Exception e) {
	    System.out.println("----> " + e.getMessage());
	    e.printStackTrace();
	}

	return operacaoRealizada;
    }

    /**
     * Metodo para verificar se o mapa ja foi importado pelo usuario
     * 
     * @param int
     *            idUsuario - Identificador do usuario
     * @param String
     *            nomeMapa - Nome do mapa
     * @return boolean mapaImportado - True caso o mapa ja tenho sido importado
     *         pelo usuario
     */
    public boolean verificaMapaImportado(int idUsuario, String nomeMapa) {
	boolean mapaImportado = false;
	ArrayList<Mapa> listaMapas = new ArrayList<Mapa>();
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where NOME_MAPA = :nomeMapa AND IMPORTADO = :idUsuario");
	    query.setParameter("nomeMapa", nomeMapa);
	    query.setParameter("idUsuario", idUsuario);

	    listaMapas = (ArrayList<Mapa>) query.list();

	    if (!listaMapas.isEmpty()) {
		mapaImportado = true;
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapaImportado;
    }

    /**
     * Metodo para importar um mapa
     * 
     * @param Mapa
     *            mapa - Mapa que sera importado
     * @return int idMapaImportado - Identificador do mapa importado. Sera -1
     *         caso ocorra alguma falha
     */
    public int importarMapa(Mapa mapa) {
	Session session;
	int idMapaImportado = -1;

	try {

	    session = sessionFactory.getCurrentSession();
	    session.save(mapa);

	    System.out.println("ID NOVO -> " + mapa.getMapaId());

	    // idMapaImportado =
	    // buscaIdMapaImportadoPorNome(mapa.getNomeMapa());

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mapa.getMapaId();
    }

    /**
     * Metodo para buscar o id do mapa importado pelo nome
     * 
     * @param String
     *            nome - Nome do mapa
     * @return int idMapaImportado - Identificador do mapa importado. Sera -1
     *         caso ocorra alguma falha
     */
    public int buscaIdMapaImportadoPorNome(String nome) {
	int idMapaImportado = -1;
	List<Mapa> list = null;
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Mapa where NOME_MAPA = :nome");
	    query.setParameter("nome", nome);
	    list = query.list();

	    if (!list.isEmpty() && list != null) {
		idMapaImportado = list.get(0).getMapaId();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return idMapaImportado;
    }

    /**
     * Metodo para atualizar um mapa importado
     * 
     * @param Mapa
     *            mapaImportado - Mapa importado pelo usuario
     * @return int idMapaImportado - Identificador do mapa importado. Sera -1
     *         caso ocorra alguma falha
     */
    public int atualizaMapaImportado(Mapa mapaImportado) {
	Session session;
	Query query = null;
	int idMapaImportado = -1;
	Mapa mapaJaExistente = null;
	int result;

	try {
	    session = sessionFactory.getCurrentSession();

	    query = session.createQuery(
		    "update Mapa set DESCRICAO = :descricao, OBJETIVO = :objetivo, TIPO_MAPA = :tipoMapa, DT_ALTERACAO = :dataAlteracao, UNIDADE_MEDIDA = :unidadeMedida where ID_MAPA = :idMapa AND IMPORTADO = :=importado");
	    query.setParameter("idMapa", mapaImportado.getMapaId());
	    query.setParameter("descricao", mapaImportado.getDescricaoMapa());
	    query.setParameter("objetivo", mapaImportado.getObjetivoMapa());
	    query.setParameter("tipoMapa", mapaImportado.getTipoMapa());
	    query.setParameter("dataAlteracao", new Date());
	    query.setParameter("unidadeMedida", mapaImportado.getUnidadeDeMedida());
	    query.setParameter("importado", mapaImportado.getImportadoPor());

	    result = query.executeUpdate();

	    if (result > 0) {
		idMapaImportado = mapaImportado.getMapaId();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return idMapaImportado;

    }

}
