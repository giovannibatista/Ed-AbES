package br.com.edabes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapaController {

	public MapaController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/Mapa/Listar", method=RequestMethod.GET)
	public String iniciarListarMapas(){
		System.out.println("Executando a lógica com Spring MVC para outra view");
		return "/Mapa/Listar";
	}

}
