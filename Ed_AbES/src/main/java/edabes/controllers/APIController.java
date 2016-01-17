package edabes.controllers;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edabes.utils.SpeechUtil;

@Controller
public class APIController {	
	
	/**
	 * Metodo para executar a audioDescricao
	 * @param String text - Mensagem a ser lida  
	 * @param HttpServletResponse response - Retorno do arquivo mp3
	 */
	@RequestMapping(
		value = "/API/getTraducao", 
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void getTraducao (
		@RequestParam(value = "text", required = true) String text,
		HttpServletResponse response) {
		
		InputStream inputStream = null;
		SpeechUtil speech = null;
		
		try {
			//Initiate the Speech object
			speech = new SpeechUtil(SpeechUtil.LANG_PT_BRAZILIAN);
			
			//Get input stream from Google
			inputStream = speech.getMP3Data(text);
			
			//Copy the stream
			IOUtils.copy(inputStream, response.getOutputStream());
			
			//flush buffer
			response.flushBuffer();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
