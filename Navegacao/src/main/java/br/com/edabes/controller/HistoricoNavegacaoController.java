package br.com.edabes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import br.com.edabes.dto.HistoricoNavegacaoDTO;
import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.service.HistoricoNavegacaoService;

@Controller
public class HistoricoNavegacaoController extends EdController {

    @Autowired
    private HistoricoNavegacaoService historicoNavegacaoService;

    public HistoricoNavegacaoController() {
	super();
    }

    @RequestMapping(value = "/Historico/Listar", method = RequestMethod.GET)
    public ModelAndView listarHistoricoNavegacao(HttpSession session) {
	ModelAndView model = null;
	List<HistoricoNavegacaoDTO> historicoNavegacaoDTOs = new ArrayList<HistoricoNavegacaoDTO>();
	HistoricoNavegacaoDTO historicoNavegacaoDTO = new HistoricoNavegacaoDTO();
	UsuarioDTO usuarioLogado = null;
	try {
	    model = new ModelAndView("/Historico/Listar");
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		historicoNavegacaoDTO.setUsuario(usuarioLogado.getId());
		historicoNavegacaoDTOs = historicoNavegacaoService.listarHistoricoNavegacao(historicoNavegacaoDTO);
	    }
	    model.addObject("historicoNavegacoes", historicoNavegacaoDTOs);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Historico/Consultar/{id}", method = RequestMethod.GET)
    public ModelAndView consultarHistoricoNavegacao(@PathVariable("id") Integer idHistoricoNavegacao,
	    HttpSession session) {
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
    public @ResponseBody Boolean IncluirHistoricoNavegacao(@RequestBody final String historicoNavegacao,
	    HttpSession session) {
	Boolean incluiuHistoricoNavegacao = false;
	UsuarioDTO usuarioLogado = null;
	try {
	    if (isAuthenticated(session)) {
		usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
		Gson gson = new Gson();
		HistoricoNavegacaoDTO historicoNavegacaoDTO = gson.fromJson(historicoNavegacao,
			HistoricoNavegacaoDTO.class);
		historicoNavegacaoDTO.setUsuario(usuarioLogado.getId());
		incluiuHistoricoNavegacao = historicoNavegacaoService.incluirHistoricoNavegacao(historicoNavegacaoDTO);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return incluiuHistoricoNavegacao;
    }

    @RequestMapping(value = "/Navegacao/Historico/Download/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody String downloadHistoricoNavegacao(@PathVariable("id") int id, HttpSession session,
	    HttpServletResponse response) throws IOException {
	HistoricoNavegacaoDTO historicoNavegacaoDTO = new HistoricoNavegacaoDTO();

	if (isAuthenticated(session)) {
	    historicoNavegacaoDTO.setId(id);
	    historicoNavegacaoDTO = historicoNavegacaoService.consultarHistoricoNavegacao(historicoNavegacaoDTO);
	    response.setHeader("Content-Disposition",
		    "attachment;filename=log" + historicoNavegacaoDTO.getMapa().getNome() + ".txt");
	    response.flushBuffer();
	}

	return historicoNavegacaoDTO.getLog();
    }

}
