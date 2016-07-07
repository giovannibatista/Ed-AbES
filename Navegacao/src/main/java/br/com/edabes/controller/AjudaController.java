package br.com.edabes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjudaController {

    @RequestMapping(value = "/Ajuda/Sobre", method = RequestMethod.GET)
    public String iniciarAjudaSobre() {
	return "/Ajuda/Sobre";
    }

    @RequestMapping(value = "/Ajuda/TeclasAtalho", method = RequestMethod.GET)
    public String iniciarAjudaTeclasAtalho() {
	return "/Ajuda/TeclasAtalho";
    }

}
