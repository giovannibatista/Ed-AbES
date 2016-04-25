package br.com.edabes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

    public UsuarioController() {
    }

    @RequestMapping(value="/Usuario/Editar", method=RequestMethod.GET)
    public String iniciarEditarUsuario(){
	System.out.println("Executando a lógica com Spring MVC para outra view");
	return "/Usuario/Editar";
    }

}
