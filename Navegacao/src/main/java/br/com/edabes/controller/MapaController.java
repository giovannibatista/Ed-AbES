package br.com.edabes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.service.MapaService;

@Controller
public class MapaController {

    @Autowired
    private MapaService mapaService;

    private ArrayList<MapaDTO> mapas;

    public MapaController() {
	super();
	mapas = new ArrayList<MapaDTO>();
    }

    @RequestMapping(value = "/Mapa/Listar", method = RequestMethod.GET)
    public ModelAndView iniciarListaMapas() {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Mapa/Listar");
	    mapas = mapaService.listarMapasPublicos();
	    // mapas = new ArrayList<>(); PARA TESTE
	    model.addObject("mapas", mapas);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

}
