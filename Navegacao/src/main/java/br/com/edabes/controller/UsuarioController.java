package br.com.edabes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.service.UsuarioService;

@Controller
public class UsuarioController extends EdController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController() {
    }

    @RequestMapping(value = "/Usuario/Login", method = RequestMethod.GET)
    public String efetuarLoginUsuario() {
	System.out.println("Executando a lógica com Spring MVC para outra view");
	return "/Usuario/Login";
    }

    @RequestMapping(value = "/Usuario/Editar", method = RequestMethod.GET)
    public String abrirEdicaoUsuario() {
	return "/Usuario/Editar";
    }

    @RequestMapping(value = "/Usuario/ConsultarEmail", method = RequestMethod.POST)
    public @ResponseBody String consultarEmail(@RequestBody final String email, HttpSession session) {
	String mensagemRetorno = "";
	UsuarioDTO usuarioDTO = null;
	try {
	    usuarioDTO = new UsuarioDTO();

	    usuarioDTO.setEmail(email);

	    usuarioDTO = usuarioService.buscaUsuario(usuarioDTO);

	    if (usuarioDTO.getId() != null) {
		mensagemRetorno = "Já existe um usuário cadastrado com o email informado!";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mensagemRetorno;
    }

    /**
     * Metodo para redirecionamento para a pagina de cadastro do usuario
     * 
     * @param Usuario
     *            usuario - Objeto com as informacoes do usuario
     * @return ModelAndView mv - Redirecionamento para pagina de cadastro
     */
    @RequestMapping(value = "/Usuario/Novo", method = RequestMethod.POST)
    public ModelAndView novoUsuario(UsuarioDTO usuario) {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Usuario/Login");

	    usuario = usuarioService.incluirUsuario(usuario);

	    if (usuario.getId() != null) {
		model.addObject("cadastro", "true");
		model.addObject("verificacaoCadastro", "true");
	    } else {
		model = new ModelAndView("/Usuario/Editar");
		model.addObject("cadastro", "false");
		model.addObject("usuadio", usuario);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

}
