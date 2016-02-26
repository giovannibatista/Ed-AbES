package edabes.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.MapaDAO;
import edabes.dao.MapaDAOExportado;
import edabes.dto.MapaDesenhoDTO;
import edabes.dto.MapaExportDTO;
import edabes.dto.ObjetoAlteracoesDTO;
import edabes.dto.ObjetoMapaDTO;
import edabes.entidades.Mapa;
import edabes.entidades.MapaExportado;
import edabes.entidades.MapaObjeto;
import edabes.entidades.MapaObjetoExportado;
import edabes.entidades.Objeto;

@Service
@Transactional
public class MapaDesenhoServiceImpl implements MapaDesenhoService {

	@Autowired
    private MapaDAO mapaDAO;
	
	@Autowired
    private MapaDAOExportado mapaDAOExportado;
	
	@Autowired
	private AudioService audioService;
	
	/**
	 * Metodo para exportar um mapa
	 * @param int idMapa - Identificador do mapa
	 * @return MapaExportDTO mapaExport - Informacoes do mapa exportado
	 */
	public MapaExportDTO buscaMapaExportDTO(int idMapa) {
		MapaExportDTO mapaExport = new MapaExportDTO();
		Mapa mapa = null;
		MapaExportado mapaExportado = null;
		boolean mapaDisponivel = false;
		boolean mapaJaExiste = false;
		int idMapaExportado = -1;
		ArrayList<MapaObjeto> listaDeObjetos = null;
		MapaObjetoExportado objetoExportado = null;
		
		mapaExport.setObjectList(buscaTodosOsObjetosDoMapa(idMapa));
		mapa = mapaDAO.buscaMapaPorId(idMapa);
		
		
		if(mapa != null) {
			mapaJaExiste = mapaDAOExportado.verificaMapaExportado(mapa.getNomeMapa());
			mapaExportado = copiaDadosMapa(mapa);
			listaDeObjetos = mapaDAO.buscaListaDeMapaObjetos(idMapa);
		
			if(!mapaJaExiste) {
				idMapaExportado = mapaDAOExportado.disponibilizarMapa(mapaExportado);
				
				
			} else {
				mapaDisponivel = mapaDAOExportado.atualizaMapaExportado(mapaExportado);
				
				idMapaExportado = mapaDAOExportado.buscaIdMapaExportadoPorNome(mapaExportado.getNomeMapa());
				
				mapaDAOExportado.excluirObjetosExportados(idMapaExportado);
				
			}
			
			if(listaDeObjetos != null) {
				for (MapaObjeto objeto : listaDeObjetos) {
					objetoExportado = new MapaObjetoExportado();
					objetoExportado.setIdMapa(idMapaExportado);
					objetoExportado.setAltura(objeto.getAltura());
					objetoExportado.setAudioDescricao(objeto.getAudioDescricao());
					objetoExportado.setCoordenadaX(objeto.getCoordenadaX());
					objetoExportado.setCoordenadaY(objeto.getCoordenadaY());
					objetoExportado.setIdObjeto(objeto.getIdObjeto());
					objetoExportado.setLargura(objeto.getLargura());
					objetoExportado.setProfundidade(objeto.getProfundidade());
					objetoExportado.setIdArquivoAudio(objeto.getIdArquivoAudio() == null ? null : objeto.getIdArquivoAudio());
					mapaDAOExportado.salvarMapaObjeto(objetoExportado);
				}
				mapaDisponivel = true;
			}
			
			if(mapaDisponivel) {
				//idMapaExportado = mapaDAO.buscaIdMapaExportadoPorNome(mapaExportado.getNomeMapa());
				mapaExport.setIdMapa(idMapaExportado);
				mapaExport.setDescricaoMapa(mapaExportado.getDescricaoMapa());
				mapaExport.setNomeMapa(mapaExportado.getNomeMapa());
				mapaExport.setObjetivoMapa(mapaExportado.getObjetivoMapa());
				mapaExport.setTipoMapa(mapaExportado.getTipoMapa());
				mapaExport.setUnidadeDeMedida(mapaExportado.getUnidadeDeMedida());
				mapaExport.setCriadorDoMapa(mapaExportado.getNomeCriador());
			}
		}
		
		return (mapaExport);
	}
	
	/**
	 * Metodo para copiar os dados de um mapa para um mapa exportado
	 * @param Mapa mapa - Mapa
	 * @return MapaExportado mapaExportado
	 */
	public MapaExportado copiaDadosMapa(Mapa mapa) {
		MapaExportado mapaExportado = new MapaExportado();
		mapaExportado.setCriadorMapa(mapa.getCriadorMapa());
		mapaExportado.setDataDeCriacao(mapa.getDataDeCriacao());
		mapaExportado.setDataAlteracao(mapa.getDataAlteracao());
		mapaExportado.setDescricaoMapa(mapa.getDescricaoMapa());
		mapaExportado.setNomeCriador(mapa.getNomeCriador());
		mapaExportado.setNomeMapa(mapa.getNomeMapa());
		mapaExportado.setObjetivoMapa(mapa.getObjetivoMapa());
		mapaExportado.setTipoMapa(mapa.getTipoMapa());
		mapaExportado.setUnidadeDeMedida(mapa.getUnidadeDeMedida());
		//mapaExportado.setMapaId(mapa.getMapaId());
		
		return mapaExportado;
		
	}
	
	/**
	 * Metodo para buscar todos os objetos do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return ArrayList<ObjetoMapaDTO> listaDeObjetosDoMapa - Lista de objetos do mapa
	 */
	public ArrayList<ObjetoMapaDTO> buscaTodosOsObjetosDoMapa(int idMapa) {
		ArrayList<ObjetoMapaDTO> listaDeObjetosDoMapa = new ArrayList<ObjetoMapaDTO>();
			
		listaDeObjetosDoMapa = montaListaObjetosMapa(idMapa);
		
		return listaDeObjetosDoMapa;
	}
	
	/**
	 * Metodo para retornar uma lista com todos os objetos do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return ArrayList<ObjetoMapaDTO> listaDeObjetosDoMapa - Lista de objetos do mapa
	 */
	public ArrayList<ObjetoMapaDTO> montaListaObjetosMapa(int idMapa) {
		ArrayList<ObjetoMapaDTO> listaDeObjetosDoMapa = new ArrayList<ObjetoMapaDTO>();
		ArrayList<MapaObjeto> listaMapaObjeto = null;
		HashMap<Integer, Objeto> listaObjetos = null;
		Objeto curentObj = null;
		ObjetoMapaDTO dto = null;
		
		listaMapaObjeto = mapaDAO.buscaListaDeMapaObjetos(idMapa);
		listaObjetos = mapaDAO.buscaObjetosDoMapa(idMapa);
		
		for (MapaObjeto mapaObjeto : listaMapaObjeto) {
			dto = new ObjetoMapaDTO();
			
			dto.setProfundidade(mapaObjeto.getProfundidade());
			dto.setCoordenadaX(mapaObjeto.getCoordenadaX());
			dto.setCoordenadaY(mapaObjeto.getCoordenadaY());
			dto.setAltura(mapaObjeto.getAltura());
			dto.setLargura(mapaObjeto.getLargura());
			dto.setIdMapaObjeto(mapaObjeto.getId());
			dto.setIdMapaObjeto(mapaObjeto.getId());
			dto.setAudioDescricao(mapaObjeto.getAudioDescricao());
			dto.setAngulo(mapaObjeto.getAngulo());
			dto.setIdObjeto(mapaObjeto.getIdObjeto());
			dto.setArquivoAudio(audioService.buscarAudio(mapaObjeto.getIdArquivoAudio()));
			
			
			//get the current object we are dealing with
			curentObj = listaObjetos.get(mapaObjeto.getIdObjeto());
			
			//populate with Object only data
			dto.setImagemMapa(curentObj.getImagemMapa());
			dto.setNome(curentObj.getNome());
			
			listaDeObjetosDoMapa.add(dto);
		}
		
		return listaDeObjetosDoMapa;
	}
	
	/**
	 * Metodo para buscar uma mapa pelo id
	 * @param int id - Identificador do mapa
	 * @return Mapa mapa - Mapa pesquisado
	 */
	public Mapa buscaMapaPorId(int id) {
		Mapa mapa = null;
		
		mapa = mapaDAO.buscaMapaPorId(id);
		
		return mapa;
	}
	
	/**
	 * Metodo para montar o dto do desenho do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return MapaDesenhoDTO dto - DTO com informacoes do desenho do mapa
	 */
	public MapaDesenhoDTO montaDTO(int idMapa) {
		MapaDesenhoDTO dto = new MapaDesenhoDTO();
		Mapa caracteristicasDoMapa = null;
		ArrayList<ObjetoMapaDTO> listaDeObjetosDoMapa = new ArrayList<ObjetoMapaDTO>();
		
		caracteristicasDoMapa = buscaMapaPorId(idMapa);
		dto.setCaracteristicasMapa(caracteristicasDoMapa);
		
		listaDeObjetosDoMapa = buscaTodosOsObjetosDoMapa(idMapa);
		dto.setListaObjetosMapa(listaDeObjetosDoMapa);;
		
		return dto;
	}
	
	/**
	 * Metodo para salvar as mudancas no desenho do mapa
	 * @param List<ObjetoAlteracoesDTO> listaDeObjetos - Lista de objetos do desenho do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return boolean mudancasSalvas - True caso as mudancas tenham sido salvas com sucesso
	 */
	public boolean salvarMudancas(List<ObjetoAlteracoesDTO> listaDeObjetos, int idMapa) {
		boolean mudancasSalvas = false;
		
		mudancasSalvas = mapaDAO.salvarMudancasDoDesenhoMapa(listaDeObjetos, idMapa);
		
		return mudancasSalvas;
	}
	
	
}