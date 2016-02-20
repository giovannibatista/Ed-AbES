package edabes.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edabes.dto.CategoriaDTO;
import edabes.dto.ListObjetoAlteracoesDTO;
import edabes.dto.ListarMapaDTO;
import edabes.dto.MapaCaracteristicasDTO;
import edabes.dto.MapaDTO;
import edabes.dto.MapaDesenhoDTO;
import edabes.dto.MapaExportDTO;
import edabes.dto.ObjetoMapaDTO;
import edabes.entidades.Mapa;
import edabes.entidades.Usuario;
import edabes.services.ListarMapaService;
import edabes.services.MapaDesenhoService;
import edabes.services.MapaExclusaoService;
import edabes.services.MapaInformacoesService;
import edabes.services.MapaMenuDesenhoService;

@Controller
public class MapaController extends EdController {	
	
	@Autowired 
	private MapaInformacoesService mapaInformacoesService;
	
	@Autowired 
	private ListarMapaService listarMapaService;
	
	@Autowired
	private MapaDesenhoService mapaDesenhoService;
	
	@Autowired
	private MapaExclusaoService mapaExclusaoService;
	
	@Autowired
	private MapaDTO mapaDTO;
	
	@Autowired
	private MapaMenuDesenhoService mapaMenuDesenhoService;
	
	@Autowired
	private MapaCaracteristicasDTO mapaCaracteristicasDTO;
	
	@Autowired
	private MapaDesenhoDTO mapaDesenhoDTO;
	
	/**
	 * Metodo para buscar as caracteristicas do mapa e redirecionar para pagina
	 * de edicao das caracteristicas
	 * @param int id - ID do mapa editado
	 * @param HttpSession session - Sessao do usuario
	 * @return ModelAndView mv - Redirecionamento para pagina de edicao ou login caso o usuario nao esteja logado
	 */
	@RequestMapping(value = "/Mapa/Editar/{id}", method = RequestMethod.GET)
	public ModelAndView editarMapaGet(
			@PathVariable("id") int id,
			HttpSession session) {
		ModelAndView mv = null;
		
		if (isAuthenticated(session)) {
			mv = new ModelAndView("Mapa/Editar");
			
			mapaCaracteristicasDTO = mapaInformacoesService.montaDTO(id); 
			mv.addObject("caracteristicas", mapaCaracteristicasDTO);
			
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/**
	 * Metodo para salvar as caracteristicas editadas do mapa
	 * @param int id - ID do mapa editado
	 * @param Mapa mapa - Caracteristicas do mapa editado
	 * @param HttpSession session - Sessao do usuario
	 * @return MapaDTO mapaDTO - Caracteristicas editadas do mapa
	 */
	@RequestMapping(value = "/Mapa/Editar/{id}", method = RequestMethod.POST)
	public @ResponseBody MapaDTO editarDesenhoGet(
			@PathVariable("id") int id,
			Mapa mapa,
			HttpSession session) {
		Date dataCriacao = new Date();
		Usuario usuarioLogado = null;
		int criador =  0;
		String nomeCriador = null;
		
			
		if (isAuthenticated(session)) {
			usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			usuarioLogado = super.getUserSession(session);
			criador =  usuarioLogado.getId();
			nomeCriador = usuarioLogado.getNome();
				
			mapa.setDataDeCriacao(dataCriacao);
			mapa.setNomeCriador(nomeCriador);
			mapa.setDataAlteracao(dataCriacao);
			mapa.setCriadorMapa(criador);
				
			mapaDTO = mapaInformacoesService.salvarCaracteristicasMapa(mapa, "Editar", id);
		}
		
		return mapaDTO;
	}
	
	/** Metodo para redirecionamento para a pagina de listagem de mapas
	 * @param HttpSession session - Sessao do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de listagem dos mapas ou para de login
     * caso o usuario nao esteja logado
     */
	@RequestMapping(value = "/Mapa/Listar", method = RequestMethod.GET)
	public ModelAndView listarGet(
			HttpSession session) {
		ModelAndView mv = null;
		ArrayList<ListarMapaDTO> listaDeMapas = null;
		Usuario usuarioLogado = null;
		int usuarioId = 0;
		
		
		if (isAuthenticated(session)) {
			
			usuarioLogado = super.getUserSession(session);
			usuarioId =  usuarioLogado.getId();
			
			listaDeMapas = listarMapaService.buscaListaDeMapasDoUsuario(usuarioId);
			
			mv = new ModelAndView("Mapa/Listar");
			mv.addObject("lista", listaDeMapas);
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/** Metodo para redirecionamento para a pagina de importacao de mapas
	 * @param HttpSession session - Sessao do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de importacao de mapas ou para de login
     * caso o usuario nao esteja logado
     */
	@RequestMapping(value = "/Mapa/Importar", method = RequestMethod.GET)
	public ModelAndView importarGet(HttpSession session) {
		ModelAndView mv = null;
		ArrayList<ListarMapaDTO> listaDeMapasExportados = null;
		
		if (isAuthenticated(session)) {
			
			listaDeMapasExportados = listarMapaService.buscaListaDeMapasExportados();
			
			mv = new ModelAndView("Mapa/Importar");
			mv.addObject("lista", listaDeMapasExportados);
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/**
	 * Metodo para importar um mapa para o usuario
	 * @param int idMapa - ID do mapa a ser importado
	 * @param HttpSession session - Sessao do usuario
	 * @return ModelAndView mv - Redirecionamento para pagina de importacao de mapas ou para de login
     * caso o usuario nao esteja logado
	 */
	@RequestMapping(value = "/Mapa/Importar/{id}", method = RequestMethod.GET)
	public ModelAndView importarMapaGet(
			@PathVariable("id") int idMapa,
			HttpSession session) {
		boolean mapaImportado = false;
		ModelAndView mv = null;
		ArrayList<ListarMapaDTO> listaDeMapasExportados = null;
		Usuario usuarioLogado = null;
		int idUsuario = 0;
		
		if (isAuthenticated(session)) {
			usuarioLogado = super.getUserSession(session);
			idUsuario =  usuarioLogado.getId();
			
			mapaImportado = listarMapaService.importarMapa(idUsuario, idMapa);
			
			if(mapaImportado) {
				
				listaDeMapasExportados = listarMapaService.buscaListaDeMapasExportados();
				
				mv = new ModelAndView("Mapa/Importar");
				mv.addObject("lista", listaDeMapasExportados);
				mv.addObject("mapaImportado", "importado");
				
			}
			
		} else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/** Metodo para exportar um mapa
	 * @param HttpSession session - Sessao do usuario
	 * @param HttpServletResponse response - Response com o arquivo json a ser exportado
     * @return MapaExportDTO mapaExport - Mapa exportado
	 * @throws IOException 
     */
	@RequestMapping(
		value = "/Mapa/Exportar/{id}", 
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MapaExportDTO exportarMapaGet(
			@PathVariable("id") int id,
			HttpSession session, 
			HttpServletResponse response) throws IOException {
			MapaExportDTO mapaExport = null;
			ModelAndView mv = new ModelAndView();
		
		if (isAuthenticated(session)) {
			mapaExport = mapaDesenhoService.buscaMapaExportDTO(id);
			response.setHeader("Content-Disposition", "attachment;filename="+mapaExport.getNomeMapa()+".json");
			response.flushBuffer();
			
		}
		
		return mapaExport;
	}

	/** Metodo para redirecionamento para a pagina de Desenho dos mapas
	 * @param int id - ID do mapa
     * @return ModelAndView mc - Redireciona para a pagina de desenho do mapa ou para a pagina de login,
     * caso o usuario nao esteja logado
     */
	@RequestMapping(value = "/Mapa/Desenho/{id}", method = RequestMethod.GET)
	public ModelAndView desenhoGet(
			@PathVariable("id") int id,
			HttpSession session) {
		ModelAndView mv = null;
		ArrayList<CategoriaDTO> listaObjetosMenu = new ArrayList<CategoriaDTO>();		
		Mapa mapa;
		
		if (isAuthenticated(session)) {
			//Busca os objetos do menu
			mapa = mapaDesenhoService.buscaMapaPorId(id);
			listaObjetosMenu = mapaMenuDesenhoService.buscaInformacoesInciais(mapa.getTipoMapa());
			
			mv = new ModelAndView("Mapa/Desenho");
			mv.addObject("idMapa", id);
			mv.addObject("listaObjetosMenu", listaObjetosMenu);
			mv.addObject("nomeMapa", mapa.getNomeMapa());
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/**
	 * Metodo para salvar as caracteristicas do mapa
	 * @param Mapa mapa - Caracteristicas do mapa criado
	 * @param HttpSession session - Sessao do usuario
	 * @return MapaDTO mapaDTO - Caracteristicas do mapa criado
	 */
	@RequestMapping(value = "/Mapa/Criar", method = RequestMethod.POST)
	public @ResponseBody MapaDTO criarPost (Mapa mapa, HttpSession session) {
			Date dataCriacao = new Date();
			Usuario usuarioLogado = null;
			int criador =  0;
			String nomeCriador = null;
			
			if (isAuthenticated(session)) {
				usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
					
				usuarioLogado = super.getUserSession(session);
				criador =  usuarioLogado.getId();
				nomeCriador = usuarioLogado.getNome();
					
				mapa.setDataDeCriacao(dataCriacao);
				mapa.setNomeCriador(nomeCriador);
				mapa.setDataAlteracao(dataCriacao);
				mapa.setCriadorMapa(criador);
				mapa.setImportadoPor(0);
					
				mapaDTO = mapaInformacoesService.salvarCaracteristicasMapa(mapa, "Criar", 0);
			}
			
			return mapaDTO;
	}
	
	/** Metodo para redirecionamento para página de formulario da criacao do mapa
     * @param HttpSession session - Sessao do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de criacao do mapa ou para
     * pagina de login caso o usuario nao esteja logado
     */
	@RequestMapping(value = "/Mapa/Criar", method = RequestMethod.GET)
	public ModelAndView criarGet(HttpSession session) {
		ModelAndView mv = null;
		
		if (isAuthenticated(session)) {
			mv = new ModelAndView("Mapa/Criar");
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/** Metodo para excluir um mapa
	 * @param HttpSession session - Sessao do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de listagem de mapas
     */
	@RequestMapping(value = "/Mapa/Excluir/{id}", method = RequestMethod.GET)
	public ModelAndView excluirGet(
			@PathVariable("id") int idMapa,
			HttpSession session) {
		boolean mapaExcluido = false;
		ModelAndView mv = null;
		ArrayList<ListarMapaDTO> listaDeMapas = null;
		Usuario usuarioLogado = null;
		int usuarioId = 0;
		
		if (isAuthenticated(session)) {
			usuarioLogado = super.getUserSession(session);
			usuarioId =  usuarioLogado.getId();
			
			mapaExcluido = mapaExclusaoService.excluirMapa(idMapa, usuarioId);
			
			if(mapaExcluido) {
				
				listaDeMapas = listarMapaService.buscaListaDeMapasDoUsuario(usuarioId);
				
				mv = new ModelAndView("Mapa/Listar");
				mv.addObject("lista", listaDeMapas);
				mv.addObject("mapaExcluido", "excluido");
				
			}
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
	
	/** Metodo para salvar as alterações do desenho do mapa
	 * @param int id - ID do mapa
	 * @param ListObjetoAlteracoesDTO listaDeObjetos - Lista de objetos do desenho do mapa
	 * @param HttpSession session - Sessao do usuario
     * @return boolean atualizacoesSalvas - Retorna true caso as mudancas no desenho foram salvas
     */
	@RequestMapping(
		value = "/Mapa/Desenho/Salvar/{id}", 
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean salvarDesenhoPost(
			@PathVariable("id") int id,
			@RequestBody ListObjetoAlteracoesDTO listaDeObjetos,
			HttpSession session) {
		boolean atualizacoesSalvas = false;
		
		if (isAuthenticated(session)) {
			//Salvando as mudanças no mapa
			atualizacoesSalvas = mapaDesenhoService.salvarMudancas(listaDeObjetos.getDtoList(), id);
		}
		
		return atualizacoesSalvas;
	}
	
	/** Metodo para buscas os objetos do desenho do mapa
	 * @param int id - ID do mapa
	 * @param HttpSession session - Sessao do usuario
     * @return List<ObjetoMapaDTO> listObjeto - Lista de objetos do desenho do mapa
     */
	@RequestMapping(
		value = "/Mapa/Objetos/{id}", 
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ObjetoMapaDTO> desenhoObjetosGet(
			@PathVariable("id") int id,
			HttpSession session) {
		List<ObjetoMapaDTO> listObjeto = null;		
		
		if (isAuthenticated(session)) {
			listObjeto = mapaDesenhoService.buscaTodosOsObjetosDoMapa(id);
		}
		
		return listObjeto;
	}
	
	
}
