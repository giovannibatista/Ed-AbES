package br.com.edabes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavegacaoController {

	public NavegacaoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="Navegacao/Iniciar", method=RequestMethod.GET)
	public String iniciarNavegacao(){
		System.out.println("Executando a lógica com Spring MVC para outra view");
		return "/Navegacao/Iniciar";
	}

}
