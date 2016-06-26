package br.com.edabes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.dto.MapaObjetoDTO;
import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.service.MapaObjetoService;
import br.com.edabes.service.MapaService;

@Controller
@Scope(value = "session")
public class NavegacaoController extends EdController {

    @Autowired
    private MapaService mapaService;

    @Autowired
    private MapaObjetoService mapaObjetoService;

    private ArrayList<MapaDTO> mapas;
    
    private boolean estavaLogado = false;

    public NavegacaoController() {
	super();
	mapas = new ArrayList<MapaDTO>();
    }

    @RequestMapping(value = "/Navegacao/Listar", method = RequestMethod.GET)
    public ModelAndView abrirMapasSalvos(HttpSession session) {
	ModelAndView model = null;
	UsuarioDTO usuarioLogado = null;
	try {
	    model = new ModelAndView("/Navegacao/Listar");
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		MapaDTO mapaDTO = new MapaDTO();
		mapaDTO.setCriador(usuarioLogado.getId());
		mapaDTO.setImportadoPor(usuarioLogado.getId());
		mapas = mapaService.listarMapas(mapaDTO);
		model.addObject("mapas", mapas);
		estavaLogado = true;
	    } else {
		if(estavaLogado){
		    mapas = new ArrayList<>();
		    estavaLogado = false;
		}
		model.addObject("mapas", mapas);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Resumo/{id}", method = RequestMethod.GET)
    public ModelAndView abrirResumo(@PathVariable("id") Integer id, HttpSession session) {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Navegacao/Resumo");
	    MapaDTO mapaConsulta = new MapaDTO();
	    mapaConsulta.setId(id);
	    MapaDTO mapaDTO = mapaService.consultarMapa(mapaConsulta);
	    model.addObject("mapa", mapaDTO);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Mapa/{id}", method = RequestMethod.GET)
    public ModelAndView iniciarNavegacao(@PathVariable("id") Integer id, HttpSession session) {
	ModelAndView model = null;
	UsuarioDTO usuarioLogado = null;
	try {
	    model = new ModelAndView("/Navegacao/Mapa");
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		model.addObject("usuario", usuarioLogado);
	    }
	    MapaDTO mapaConsulta = new MapaDTO();
	    mapaConsulta.setId(id);
	    MapaDTO mapaDTO = mapaService.consultarMapa(mapaConsulta);
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
    public ModelAndView iniciarTreinamento(HttpSession session) {
	ModelAndView model = null;
	UsuarioDTO usuarioLogado = null;
	try {
	    model = new ModelAndView("/Navegacao/Treinamento");
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		model.addObject("usuario", usuarioLogado);
	    }
	    MapaDTO mapaTreinamento = mapaService.consultarMapaTreinamento();
	    model.addObject("mapa", mapaTreinamento);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Navegacao/Mapa/Treinamento/Objetos", method = RequestMethod.GET)
    @ResponseBody
    public String carregarObjetosMapaTreinamento(HttpSession session) {
	String mapaObjetos = "";
	try {
	    mapaObjetos = mapaObjetoService.carregaObjetosMapaTreinamento();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return mapaObjetos;
    }

    @RequestMapping(value = "/Navegacao/MapaPublico/Salvar/{id}", method = RequestMethod.GET)

    public @ResponseBody boolean salvarMapaPublico(@PathVariable("id") Integer idMapa, HttpSession session) {
	Boolean incluiuMapa = false;
	UsuarioDTO usuarioLogado = null;
	try {

	    MapaDTO mapaDTO = new MapaDTO();
	    mapaDTO.setId(idMapa);
	    mapaDTO = mapaService.consultarMapaPublico(mapaDTO);
	    if (mapaDTO != null) {
		if (isAuthenticated(session)) {
		    usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		    mapaDTO.setImportadoPor(usuarioLogado.getId());
		    mapaDTO.setCriador(usuarioLogado.getId());
		    mapaService.importarMapa(mapaDTO);

		} else {
		    MapaDTO mapaSalvo = new MapaDTO();
		    mapaSalvo.setNome(mapaDTO.getNome());
		    mapaSalvo = mapaService.consultarMapa(mapaSalvo);
		    if (mapaSalvo.getId() != null) {
			mapas.add(mapaSalvo);
		    }
		}
		incluiuMapa = true;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return incluiuMapa;
    }

    public ArrayList<MapaDTO> getMapas() {
	return mapas;
    }

    public void setMapas(ArrayList<MapaDTO> mapas) {
	this.mapas = mapas;
    }

}
