package br.com.edabes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.service.MapaObjetoService;
import br.com.edabes.service.MapaService;

@Controller
public class NavegacaoController {

    @Autowired
    private MapaService mapaService;

    @Autowired
    private MapaObjetoService mapaObjetoService;

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
	    // mapas = new ArrayList<>(); PARA TESTE
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
	    MapaDTO mapaConsulta = new MapaDTO();
	    mapaConsulta.setId(id);
	    MapaDTO mapaDTO = mapaService.consultaMapa(mapaConsulta);
	    model.addObject("mapa", mapaDTO);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Mapa/Objetos/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String carregarObjetosMapa(@PathVariable("id") Integer idMapa, HttpSession session) {
	List<MapaObjetoDTO> mapaObjetoDTOs = null;
	String mapaObjetos = "";
	try {
	    mapaObjetoDTOs = new ArrayList<MapaObjetoDTO>();

	    MapaObjetoDTO mapaObjetoDTO = new MapaObjetoDTO();
	    mapaObjetoDTO.setIdMapa(idMapa);

	    mapaObjetoDTOs = mapaObjetoService.carregaObjetosMapa(mapaObjetoDTO);

	    JSONArray array = new JSONArray(mapaObjetoDTOs);
	    mapaObjetos = array.toString();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mapaObjetos;
    }

    @RequestMapping(value = "/Navegacao/Treinamento", method = RequestMethod.GET)
    public String iniciarTreinamento() {
	System.out.println("Iniciando o treinamento");
	return "/Navegacao/Resumo";
    }

    public ArrayList<MapaDTO> getMapas() {
	return mapas;
    }

    public void setMapas(ArrayList<MapaDTO> mapas) {
	this.mapas = mapas;
    }

}
