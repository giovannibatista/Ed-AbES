package br.com.edabes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
  /*  @RequestMapping(value = "/Navegacao/Historico", method = RequestMethod.GET)
    public String iniciarHistorico() {
	System.out.println("Iniciando o historico");
	return "/Navegacao/Historico";
    }
*/    
    @RequestMapping(value = "/Navegacao/Historico", method = RequestMethod.GET)
    public ModelAndView listarHistoricoNavegacao(/*@PathVariable("id") Integer idUsuario,*/ HttpSession session) {
	ModelAndView model = null;
	List<HistoricoNavegacaoDTO> historicoNavegacaoDTOs = new ArrayList<HistoricoNavegacaoDTO>();
	HistoricoNavegacaoDTO historicoNavegacaoDTO = new HistoricoNavegacaoDTO(); 
	try {
	    model = new ModelAndView("/Navegacao/Historico");
	    //historicoNavegacaoDTO.setUsuario(idUsuario);
	    historicoNavegacaoDTOs = historicoNavegacaoService.listarHistoricoNavegacao(historicoNavegacaoDTO);
	    model.addObject("historicoNavegacoes", historicoNavegacaoDTOs);
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
   /* 
    @RequestMapping(value = "/Salvar/Perfil", method = RequestMethod.POST)
	public @ResponseBody boolean salvarPerfilPostt(Usuario usuario, HttpSession session) {
		boolean dadosSalvos = false;
		Usuario usuarioLogado = null;
		
		if (isAuthenticated(session)) {
			usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
			usuarioLogado = super.getUserSession(session);
			usuario.setId(usuarioLogado.getId());
			dadosSalvos = usuarioService.alterarDadosUsuario(usuario);
			
			if(dadosSalvos) {
				session.setAttribute("usuarioLogado", usuario);
			}
		}
		
		return dadosSalvos;
	}*/
    
    
    
    

}
