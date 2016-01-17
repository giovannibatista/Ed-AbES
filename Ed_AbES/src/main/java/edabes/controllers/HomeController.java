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
import edabes.services.MapaInformacoesService;
import edabes.services.EmailService;
import edabes.services.LoginService;
import edabes.services.UsuarioService;

@Controller
public class HomeController extends EdController {
	
	/** Metodo para redirecionar o usuario para pagina de login caso ele nao esteja logado. 
	 * Caso esteja, sera redirecionado para a pagina de login
     * @param  String verificacao - Parametro de verificacao da página
     * @return ModelAndView mv - Redirecionamento para pagina
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView paginaInicialSemURL(HttpSession session) {
		ModelAndView mv = null;
		
		if (isAuthenticated(session)) {
			mv = redirectToHome();
		}
		else {
			mv = redirectToLogin();
		}
		
		return mv;
	}
}