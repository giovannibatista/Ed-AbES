package br.com.edabes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "index";
	}
	
	@RequestMapping("/OtherView")
	public String executeOtherView() {
		System.out.println("Executando a lógica com Spring MVC para outra view");
		return "OtherView";
	}

}
