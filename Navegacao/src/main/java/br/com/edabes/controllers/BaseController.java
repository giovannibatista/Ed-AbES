package br.com.edabes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String execute() {
		System.out.println("Executando a l�gica com Spring MVC");
		return "Index";
	}



}
