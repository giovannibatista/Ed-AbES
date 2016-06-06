package br.com.edabes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController extends EdController {
	
	/** Metodo para redirecionar o usuario para pagina de login caso ele nao esteja logado. 
	 * Caso esteja, sera redirecionado para a pagina de login
     * @param  String verificacao - Parametro de verificacao da página
     * @return ModelAndView mv - Redirecionamento para pagina
     */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView paginaInicialSemURL(HttpSession session) {
		ModelAndView mv = null;
		
		if (isAuthenticated(session)) {
			mv = redirectToHome();
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}*/
}