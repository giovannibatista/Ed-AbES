package br.com.edabes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import br.com.edabes.dto.HistoricoNavegacaoDTO;
import br.com.edabes.service.HistoricoNavegacaoService;

@Controller
public class HistoricoNavegacaoController {
    
    @Autowired
    private HistoricoNavegacaoService historicoNavegacaoService; 

    public HistoricoNavegacaoController() {
	super();
	// TODO Auto-generated constructor stub
    }
    
    @RequestMapping(value = "/Historico/Listar", method = RequestMethod.GET)
    public ModelAndView listarHistoricoNavegacao(/*@PathVariable("id") Integer idUsuario,*/ HttpSession session) {
	ModelAndView model = null;
	List<HistoricoNavegacaoDTO> historicoNavegacaoDTOs = new ArrayList<HistoricoNavegacaoDTO>();
	HistoricoNavegacaoDTO historicoNavegacaoDTO = new HistoricoNavegacaoDTO(); 
	try {
	    model = new ModelAndView("/Historico/Listar");
	    //historicoNavegacaoDTO.setUsuario(idUsuario);
	    historicoNavegacaoDTOs = historicoNavegacaoService.listarHistoricoNavegacao(historicoNavegacaoDTO);
	    model.addObject("historicoNavegacoes", historicoNavegacaoDTOs);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }
    
    @RequestMapping(value = "/Historico/Consultar/{id}", method = RequestMethod.GET)
    public ModelAndView consultarHistoricoNavegacao(@PathVariable("id") Integer idHistoricoNavegacao, HttpSession session) {
	ModelAndView model = null;
	HistoricoNavegacaoDTO historicoNavegacaoDTO = new HistoricoNavegacaoDTO(); 
	try {
	    model = new ModelAndView("/Historico/Consultar");
	    historicoNavegacaoDTO.setId(idHistoricoNavegacao);
	    historicoNavegacaoDTO = historicoNavegacaoService.consultarHistoricoNavegacao(historicoNavegacaoDTO);
	    model.addObject("historicoNavegacao", historicoNavegacaoDTO);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }
    
    @RequestMapping(value = "/Navegacao/Historico/Incluir", method = RequestMethod.POST)
    public @ResponseBody Boolean IncluirHistoricoNavegacao(@RequestBody final String historicoNavegacao, HttpSession session) {
	Boolean incluiuHistoricoNavegacao = false;
	try {
	    Gson gson = new Gson();
	    HistoricoNavegacaoDTO historicoNavegacaoDTO = gson.fromJson(historicoNavegacao, HistoricoNavegacaoDTO.class);
	    incluiuHistoricoNavegacao = historicoNavegacaoService.incluirHistoricoNavegacao(historicoNavegacaoDTO);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return incluiuHistoricoNavegacao;
    }
   
}
