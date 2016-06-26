package br.com.edabes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.service.UsuarioService;

@Controller
public class UsuarioController extends EdController {

    @Autowired
    private UsuarioService usuarioService;

    private String email;

    public UsuarioController() {
    }

    @RequestMapping(value = "/Usuario/Login", method = RequestMethod.GET)
    public ModelAndView efetuarLoginUsuario(HttpSession session) {
	ModelAndView model = null;
	UsuarioDTO usuarioLogado = null;
	try{
	    model = new ModelAndView("/Usuario/Login");
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		model.addObject("usuario", usuarioLogado);
	    }
	}catch(Exception e){
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Usuario/Editar", method = RequestMethod.GET)
    public ModelAndView abrirEdicaoUsuario() {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Usuario/Editar");
	    UsuarioDTO usuario = new UsuarioDTO();
	    usuario.setEmail(getEmail());
	    model.addObject("usuario", usuario);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Usuario/ConsultarEmail", method = RequestMethod.POST)
    public @ResponseBody String consultarEmail(@RequestBody final String email, HttpSession session) {
	String mensagemRetorno = "";
	UsuarioDTO usuarioDTO = null;
	try {
	    usuarioDTO = new UsuarioDTO();

	    usuarioDTO.setEmail(email);

	    setEmail(email);

	    usuarioDTO = usuarioService.buscaUsuario(usuarioDTO);

	    if (usuarioDTO.getId() != null) {
		mensagemRetorno = "Já existe um usuário cadastrado com o email informado!";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mensagemRetorno;
    }

    @RequestMapping(value = "/Usuario/Novo", method = RequestMethod.POST)
    public ModelAndView novoUsuario(UsuarioDTO usuario) {
	ModelAndView model = null;
	try {

	    usuario = usuarioService.incluirUsuario(usuario);

	    if (usuario.getId() != null) {
		model = new ModelAndView("/Usuario/Login");
		model.addObject("cadastro", "true");
		model.addObject("verificacaoCadastro", "true");
	    } else {
		model = new ModelAndView("/Usuario/Editar");
		model.addObject("cadastro", "false");
		model.addObject("usuario", usuario);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    model = new ModelAndView("/Usuario/Editar");
	    model.addObject("cadastro", "false");
	    usuario.setSenha("");
	    model.addObject("usuario", usuario);

	}
	return model;
    }

    @RequestMapping(value = "/Usuario/EfetuarLogin", method = RequestMethod.POST)
    public ModelAndView loginPost(@RequestParam(value = "email", required = false) String email,
	    @RequestParam(value = "senha", required = false) String senha, HttpSession session) {
	boolean flag = false;
	ModelAndView mv = null;
	try {
	    UsuarioDTO usuarioLogado = new UsuarioDTO();
	    flag = (boolean) usuarioService.login(email, senha);
	    if (flag) {
		usuarioLogado.setEmail(email);
		usuarioLogado = usuarioService.buscaUsuario(usuarioLogado);
		super.loginUser(session, usuarioLogado);

		mv = redirectToHome();
	    } else {
		mv = new ModelAndView("/Usuario/Login");
		mv.addObject("erroLogin", true);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return mv;
    }

    @RequestMapping(value = "/Usuario/Logout", method = RequestMethod.GET)
    public ModelAndView logoutGet(HttpSession session) {
	ModelAndView mv = redirectToLogin();

	if (isAuthenticated(session)) {
	    super.logoutUser(session);
	}

	return mv;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
