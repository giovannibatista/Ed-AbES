package edabes.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edabes.dto.AudioDTO;
import edabes.dto.ListarMapaDTO;
import edabes.entidades.Usuario;
import edabes.services.AudioService;

@Controller
public class AudioController extends EdController {

	@Autowired
	private AudioService audioService;

	/**
	 * Metodo para redirecionamento para página de upload dos arquivos de audio
	 * 
	 * @param HttpSession
	 *            session - Sessao do usuario
	 * @return ModelAndView mv - Redirecionamento para pagina de upload dos
	 *         arquivos de audio pagina de login caso o usuario nao esteja
	 *         logado
	 */
	@RequestMapping(value = "/Audio/Importar", method = RequestMethod.GET)
	public ModelAndView audioGet(HttpSession session) {
		ModelAndView mv = null;

		if (isAuthenticated(session)) {
			mv = new ModelAndView("/Audio/Importar");
		} else {
			mv = redirectToLogin();
		}

		return mv;
	}

	@RequestMapping(value = "/Audio/Importar/", method = RequestMethod.POST)
	public @ResponseBody boolean importarArquivo(@RequestParam("descricaoAudio") String descricaoAudio,
			@RequestParam("arquivo") MultipartFile arquivo, HttpSession session)
					throws IllegalStateException, IOException {
		boolean retorno = false;

		if (isAuthenticated(session)) {
			retorno = audioService.importarArquivo(criaAudioDTO(arquivo, descricaoAudio));
		} else {
			retorno = false;
		}

		return retorno;
	}

	@RequestMapping(value = "/Audio/Listar", method = RequestMethod.GET)
	public ArrayList<AudioDTO> listarGet(HttpSession session) {
		ModelAndView mv = null;
		ArrayList<AudioDTO> listaAudioDTOs = null;

		if (isAuthenticated(session)) {

			listaAudioDTOs = audioService.listaAudios();

			mv = new ModelAndView("/Audio/Listar");
			mv.addObject("listaAudios", listaAudioDTOs);
		} else {
			mv = redirectToLogin();
		}

		return listaAudioDTOs;
	}

	private AudioDTO criaAudioDTO(MultipartFile arquivo, String descricaoAudio)
			throws IllegalStateException, IOException {
		AudioDTO audioDTO = new AudioDTO();

		audioDTO.setArquivo(multipartFileParaFile(arquivo));
		audioDTO.setDescricao(descricaoAudio);

		return audioDTO;
	}

	private File multipartFileParaFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File arquivo = new File(multipart.getOriginalFilename());
		multipart.transferTo(arquivo);
		return arquivo;
	}

}
