package edabes.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edabes.entidades.Usuario;
import edabes.services.CadastroService;
import edabes.services.EmailService;
import edabes.services.LoginService;
import edabes.services.UsuarioService;

@Controller
public class UserController extends EdController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CadastroService cadastroService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private EmailService emailService;
	
	@RequestMapping(value = "/User/Login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpSession session) {
		ModelAndView mv = null;
		
		if (!isAuthenticated(session)) {
			mv = new ModelAndView("Home/Login");
		}
		else {
			mv = redirectToHome();
		}
		
		return mv;
	}
	
	/**
	 * Metodo para realizar o redirecionamento para página de edicao de perfil
	 * @param Usuairo usuario - Objeto com informacoes do usuario
	 * @param HttpSession session - Sessao
	 * @return ModelAndView mv - Redirecionamento para a pagina de edicao de perfil
	 */
	@RequestMapping(value = "/Editar/Perfil", method = RequestMethod.GET)
	public @ResponseBody ModelAndView editarPerfilGet(Usuario usuario, HttpSession session) {
		ModelAndView mv = null;
		Usuario usuarioLogado = null;
		
		if (!isAuthenticated(session)) {
			mv = new ModelAndView("Home/Login");
		}
		else {
			
			usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			usuarioLogado = super.getUserSession(session);
			
			mv = new ModelAndView("/EditarPerfil");
			mv.addObject("usuario", usuarioLogado);
			
		}
		
		return mv;
	}
	
	/**
	 * Metodo para salvar as alteracoes no perfil do usuario utilizando o metodo POST
	 * @param Usuairo usuario - Objeto com informacoes do usuario
	 * @param HttpSession session - Sessao
	 * @return boolean dadosSalvos - True caso os dados tenham sido salvos com sucesso
	 */
	@RequestMapping(value = "/Salvar/Perfil", method = RequestMethod.POST)
	public @ResponseBody boolean salvarPerfilPostt(Usuario usuario, HttpSession session) {
		boolean dadosSalvos = false;
		Usuario usuarioLogado = null;
		
		if (isAuthenticated(session)) {
			usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			usuarioLogado = super.getUserSession(session);
			usuario.setId(usuarioLogado.getId());
			dadosSalvos = usuarioService.alterarDadosUsuario(usuario);
			
			if(dadosSalvos) {
				session.setAttribute("usuarioLogado", usuario);
			}
		}
		
		return dadosSalvos;
	}
	
	/**
	 * Metodo para salvar as alteracoes no perfil do usuario utilizando o metodo GET
	 * @param Usuairo usuario - Objeto com informacoes do usuario
	 * @param HttpSession session - Sessao
	 * @return boolean dadosSalvos - True caso os dados tenham sido salvos com sucesso
	 */
	@RequestMapping(value = "/Salvar/Perfil", method = RequestMethod.GET)
	public @ResponseBody boolean salvarPerfilGet(Usuario usuario, HttpSession session) {
		boolean dadosSalvos = false;
		
		if (isAuthenticated(session)) {
			dadosSalvos = usuarioService.alterarDadosUsuario(usuario);
		}
		return dadosSalvos;
	}
	
	@RequestMapping(value = "/User/Logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(HttpSession session) {
		ModelAndView mv = redirectToLogin();
		
		if (isAuthenticated(session)) {
			super.logoutUser(session);
		}
		
		return mv;
	}
	
	/** Metodo para redirecionamento para a pagina de login do usuario
	 * @author Muriel Garrido
	 * @param String email - Email digitado pelo usuario
	 * @param String senha - Senha digitada pelo usuario
	 * @param HttpSession session - Sessao do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de login caso 
     * tenha ocorrido alguma falha, caso tenha ocorrido com sucesso
     * sera redirecionado para pagina de home
     */
	@RequestMapping(value = "/User/Login", method = RequestMethod.POST)
	public ModelAndView loginPost(
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "senha", required = false) String senha,
			HttpSession session) {
		boolean flag = false; 
		ModelAndView mv = null;
		Usuario usuarioLogado;
		
		flag = (boolean) loginService.login(email, senha);
		
		if(flag) {
			usuarioLogado = (Usuario) loginService.buscaUsuarioByEmail(email);
			super.loginUser(session, usuarioLogado);
			
			mv = redirectToHome();
		} 
		else {
			mv = redirectToLogin();
			mv.addObject("verificacao", "erro");
		}
		
		return mv;
	}
	
	/** Metodo para redirecionamento para a pagina de esqueceu sua senha
	 * @param String email - Email do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de login
     */
	@RequestMapping(value = "/User/EsqueceuSuaSenha", method = RequestMethod.POST)
	public ModelAndView esqueceSuaSenhaPost(@RequestParam(value = "email", required = false) String email) {
		
		boolean emailEnviado = false;
		Usuario usuario = null;
		String novaSenha = "";
		String mensagem = "";
		
		novaSenha = usuarioService.trocaSenha(email);
		mensagem = "Olá, \n\n"
				+ "A sua nova senha é: " + novaSenha
				+ "\nPara trocar de senha, logue na aplicação e utilize a opção Editar Perfil do menu."
				+ "\n\nAtt,"
				+ "\nEquipe Ed_AbES";
		
		
		usuario = (Usuario) loginService.buscaUsuarioByEmail(email);
		if(usuario != null) {
			emailEnviado = emailService.sendMail(email, "Esquecimento de senha - Ed_AbES", mensagem);	
		}
		
		ModelAndView mv = new ModelAndView("Home/Login");
		mv.addObject("esqueceuSuaSenha", "true");
		mv.addObject("verificacaoEsqueceuSuaSenha", emailEnviado);
		
		return mv;
	}
	
	/** Metodo para redirecionamento para a pagina de cadastro do usuario
	 * @param Usuario usuario - Objeto com as informacoes do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de cadastro
     */
	@RequestMapping(value = "/User/Cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarPost(
			Usuario usuario) {
		boolean usuarioCadastrado = false;
		ModelAndView mv = new ModelAndView("Home/Login");
		
		usuarioCadastrado = cadastroService.cadastrarUsuario(usuario);
		mv.addObject("cadastro", "true");
		mv.addObject("verificacaoCadastro", usuarioCadastrado);
		//mv = redirectToLogin();
		
		return mv;
	}
}
