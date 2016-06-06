package br.com.edabes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.UsuarioDTO;

public abstract class EdController {
	private static String SESSION_KEY = "usuarioLogado";
	
	/**
	 * Metodo para verificar se o usuario esta logado.
	 * @param HttpSession session - Sessao do usuario
	 * @return boolean - true se o usuario esta logado
	 */
	protected boolean isAuthenticated(HttpSession session) {
		Object objUser = null;
		UsuarioDTO user = null;
		
		//get object from Session
		objUser = session.getAttribute(SESSION_KEY);
		
		if (objUser != null && objUser instanceof UsuarioDTO) {
			user = (UsuarioDTO) objUser;
		}
			
		return (user != null && user.getId() > 0);
	}
	
	/**
	 * Metodo para buscar o Usuario logado
	 * @param HttpSession session - Sessao
	 * @return Usuario - Usuario logado
	 */
	protected UsuarioDTO getUserSession(HttpSession session) {
		return ((UsuarioDTO) session.getAttribute(SESSION_KEY));
	}
	
	/**
	 * Metodo para realizar o logout do usuario
	 * @param HttpSession session - Sessao
	 */
	protected void logoutUser(HttpSession session) {
		session.removeAttribute(SESSION_KEY);
	}
	
	/**
	 * Metodo para realizar o login do usuario
	 * @param HttpSession session - Sessao
	 * @param Usuario usuario - Usuario que esta sendo logado
	 */
	protected void loginUser(HttpSession session, UsuarioDTO usuario) {
		session.setAttribute(SESSION_KEY, usuario);
	}
	
	/**
	 * Metodo para redirecionar para pagina de login
	 * @return ModelAndView - Redirecionamento para pagina home
	 */
	protected ModelAndView redirectToLogin() {
		return (new ModelAndView("redirect:/Usuario/Login"));
	}
	
	/**
	 * Metodo para redirecionar para pagina home
	 * @return ModelAndView - Redirecionamento para pagina home
	 */
	protected ModelAndView redirectToHome() {
		return (new ModelAndView("redirect:/"));
	}
}
