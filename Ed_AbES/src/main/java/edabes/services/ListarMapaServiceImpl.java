package edabes.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.MapaDAO;
import edabes.dao.MapaDAOExportado;
import edabes.dto.ListarMapaDTO;
import edabes.entidades.Mapa;
import edabes.entidades.MapaExportado;
import edabes.entidades.MapaObjeto;
import edabes.entidades.MapaObjetoExportado;
import edabes.utils.DateUtils;

@Service
@Transactional
public class ListarMapaServiceImpl implements ListarMapaService {

	@Autowired
    private MapaDAO mapaDAO;
	
	@Autowired
    private MapaDAOExportado mapaDAOExportado;
	
	/**
	 * Metodo para buscar os mapas do usuario
	 * @param int idUsuario - Identificador do usuario
	 * @return ArrayList<ListarMapaDTO> listaMapasDoUsuario - Lista de mapas do usuario
	 */
	public ArrayList<ListarMapaDTO> buscaListaDeMapasDoUsuario(int idUsuario) {
		ArrayList<ListarMapaDTO> listaMapasDoUsuario = null;
		ArrayList<ListarMapaDTO> listaMapasImportadosDoUsuario = null;
		
		listaMapasDoUsuario = mapaDAO.buscaListaDeMapasCriadosDoUsuario(idUsuario);
		listaMapasImportadosDoUsuario = mapaDAO.buscaListaDeMapasImportadosDoUsuario(idUsuario);
		
		listaMapasDoUsuario.addAll(listaMapasImportadosDoUsuario);
		
		return listaMapasDoUsuario;
	}
	
	/**
	 * Metodo para buscar todos os mapas
	 * @return ArrayList<ListarMapaDTO> listaMapas - Lista com todos os mapas
	 */
	public ArrayList<ListarMapaDTO> buscaListaDeMapas() {
		ArrayList<ListarMapaDTO> listaMapas = null;
		
		listaMapas = mapaDAO.buscaListaDeMapas();
		
		return listaMapas;
	}
	
	/**
	 * Metodo para buscar os mapas exportados
	 * @return ArrayList<ListarMapaDTO> listaMapas - Lista de mapas exportados
	 */
	public ArrayList<ListarMapaDTO> buscaListaDeMapasExportados() {
		ArrayList<ListarMapaDTO> listaMapas = null;
		
		listaMapas = mapaDAOExportado.buscaListaDeMapasExportados();
		
		return listaMapas;
	}
	
	/**
	 * Metodo para importar um mapa
	 * @param int idUsuario - Identificador do usuario
	 * @param int idMapaExportado - Identificador do mapa exportado
	 * @return boolean importado - True caso o mapa tenha sido importado
	 */
	public boolean importarMapa(int idUsuario, int idMapaExportado) {
		boolean importado = false;
		MapaExportado mapaExportado = null;
		boolean mapaJaImportado = false;
		Mapa mapaImportado = null;
		ArrayList<MapaObjetoExportado> listaDeObjetosDoMapa = null;
		int idMapaImportado = -1;
		MapaObjeto objetoImportado = null;
		
		try {
			mapaExportado = mapaDAOExportado.buscaMapaPorIdExportado(idMapaExportado);
			
			mapaJaImportado = mapaDAO.verificaMapaImportado(idUsuario, mapaExportado.getNomeMapa());
			
			mapaImportado = new Mapa();
			
			
			mapaImportado.setNomeMapa(montaNomeMapaImportado(mapaExportado.getNomeMapa()));
			mapaImportado.setDescricaoMapa(mapaExportado.getDescricaoMapa());
			mapaImportado.setObjetivoMapa(mapaExportado.getObjetivoMapa());
			mapaImportado.setTipoMapa(mapaExportado.getTipoMapa());
			mapaImportado.setCriadorMapa(mapaExportado.getCriadorMapa());
			mapaImportado.setNomeCriador(mapaExportado.getNomeCriador());
			mapaImportado.setUnidadeDeMedida(mapaExportado.getUnidadeDeMedida());
			mapaImportado.setDataAlteracao(mapaExportado.getDataAlteracao());
			mapaImportado.setDataDeCriacao(mapaExportado.getDataDeCriacao());
			mapaImportado.setAndar(mapaExportado.getAndar());
			mapaImportado.setImportadoPor(idUsuario);
			
			if(!mapaJaImportado) {
				idMapaImportado = mapaDAO.importarMapa(mapaImportado); //se nao exite cria um mapa novo
			} else {
				idMapaImportado = mapaDAO.atualizaMapaImportado(mapaImportado); //se ja existe atualiza o mapa
				
				mapaDAO.excluirObjetosDoMapa(idMapaImportado); //deleta os objetos do mapa para escrever os novos objetos
			}
			
			if(idMapaImportado > 0) {
				listaDeObjetosDoMapa = mapaDAOExportado.buscaListaDeMapaObjetosExportados(mapaExportado.getMapaId());
				
				for (MapaObjetoExportado objetoExportado : listaDeObjetosDoMapa) {
					objetoImportado = new MapaObjeto();
					objetoImportado.setIdMapa(idMapaImportado);
					objetoImportado.setAltura(objetoExportado.getAltura());
					objetoImportado.setAngulo(objetoExportado.getAngulo());
					objetoImportado.setAudioDescricao(objetoExportado.getAudioDescricao());
					objetoImportado.setCoordenadaX(objetoExportado.getCoordenadaX());
					objetoImportado.setCoordenadaY(objetoExportado.getCoordenadaY());
					objetoImportado.setIdObjeto(objetoExportado.getIdObjeto());
					objetoImportado.setLargura(objetoExportado.getLargura());
					objetoImportado.setProfundidade(objetoExportado.getProfundidade());
					objetoImportado.setProfundidade(objetoExportado.getProfundidade());
					objetoImportado.setIdArquivoAudio(objetoExportado.getIdArquivoAudio());
					mapaDAO.salvarMapaObjeto(objetoImportado);
				}
				
				importado = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return importado;
	}
	
	private String montaNomeMapaImportado(String nomeMapa){
		String nomeMapaImportado = "";
		
		if(nomeMapa.length() < 70){
			nomeMapaImportado = nomeMapa + " importado em " + DateUtils.getDateFormatString();
		}else{
			nomeMapaImportado = nomeMapa + DateUtils.getDateFormatString();
		}
		
		return nomeMapaImportado;
	}

}
