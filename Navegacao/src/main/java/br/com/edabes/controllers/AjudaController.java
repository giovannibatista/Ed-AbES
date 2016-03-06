package br.com.edabes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjudaController {

	@RequestMapping(value="/Ajuda/Sobre", method=RequestMethod.GET)
	public String iniciarAjudaSobre(){
		System.out.println("Executando a lógica com Spring MVC para outra view");
		return "/Ajuda/Sobre";
	}
	
	@RequestMapping(value="/Ajuda/TeclasAtalho", method=RequestMethod.GET)
	public String iniciarAjudaTeclasAtalho(){
		System.out.println("Executando a lógica com Spring MVC para outra view");
		return "/Ajuda/TeclasAtalho";
	}



}
