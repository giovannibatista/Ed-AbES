package br.com.edabes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavegacaoController {

	public NavegacaoController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/Navegacao/MapasSalvos", method=RequestMethod.GET)
	public String abrirMapasSalvos(){
		System.out.println("Iniciando a Navegação. Abrindo lista de mapas salvos...");
		return "/Navegacao/MapasSalvos";
	}

	@RequestMapping(value="/Navegacao/Resumo/{id}", method=RequestMethod.GET)
	public String abrirResumo(@PathVariable("id") Integer id) {
		System.out.println("Abrindo o Resumo do Mapa, Id: " + id);
		return "/Navegacao/Resumo";
	}
	
	@RequestMapping(value="/Navegacao/Mapa/{id}", method=RequestMethod.GET)
	public String iniciarNavegacao(@PathVariable("id") Integer id,
			HttpSession session) {
		System.out.println("Iniciando a Navegação do Id: " + id);
		return "/Navegacao/Mapa";
	}

	@RequestMapping(value="/Navegacao/Treinamento", method=RequestMethod.GET)
	public String iniciarTreinamento(){
		System.out.println("Iniciando o treinamento");
		return "/Navegacao/Resumo";
	}
	
	@RequestMapping(value="/Navegacao/Historico", method=RequestMethod.GET)
	public String iniciarHistorico(){
		System.out.println("Iniciando o historico");
		return "/Navegacao/Historico";
	}

}
