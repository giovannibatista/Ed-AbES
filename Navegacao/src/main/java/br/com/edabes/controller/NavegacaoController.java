package br.com.edabes.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.service.MapaService;

@Controller
public class NavegacaoController {

    @Autowired
    private MapaService mapaService;
    
    private ArrayList<MapaDTO> mapas;

    public NavegacaoController() {
	super();
	mapas = new ArrayList<MapaDTO>();
    }

    @RequestMapping(value = "/Navegacao/Listar", method = RequestMethod.GET)
    public ModelAndView abrirMapasSalvos() {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Navegacao/Listar");
	    mapas = mapaService.listarMapas();
	    //mapas = new ArrayList<>(); PARA TESTE
	    model.addObject("mapas", mapas);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Resumo/{id}", method = RequestMethod.GET)
    public ModelAndView abrirResumo(@PathVariable("id") Integer id) {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Navegacao/Resumo");
	    MapaDTO mapaConsulta = new MapaDTO();
	    mapaConsulta.setId(id);
	    MapaDTO mapaDTO = mapaService.consultaMapa(mapaConsulta);
	    model.addObject("mapa", mapaDTO);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Mapa/{id}", method = RequestMethod.GET)
    public ModelAndView iniciarNavegacao(@PathVariable("id") Integer id, HttpSession session) {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Navegacao/Mapa");
	    model.addObject("idMapa", id);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }
    
    @RequestMapping(value = "/Navegacao/Mapa/Objetos/{id}", method = RequestMethod.GET)
    public ModelAndView carregarObjetosMapa (@PathVariable("id") Integer id, HttpSession session) {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Navegacao/Mapa");
	    model.addObject("idMapa", id);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }


    @RequestMapping(value = "/Navegacao/Treinamento", method = RequestMethod.GET)
    public String iniciarTreinamento() {
	System.out.println("Iniciando o treinamento");
	return "/Navegacao/Resumo";
    }

    @RequestMapping(value = "/Navegacao/Historico", method = RequestMethod.GET)
    public String iniciarHistorico() {
	System.out.println("Iniciando o historico");
	return "/Navegacao/Historico";
    }

    public ArrayList<MapaDTO> getMapas() {
        return mapas;
    }

    public void setMapas(ArrayList<MapaDTO> mapas) {
        this.mapas = mapas;
    }
    
    


}
