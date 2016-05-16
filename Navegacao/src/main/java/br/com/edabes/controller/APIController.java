package br.com.edabes.controller;

import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.edabes.utils.Synthesiser;

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
		Synthesiser synthesiser = null;
		
		try {
		    
		    	text =  URLDecoder.decode(text, "UTF-8");
			//Initiate the Speech object
			synthesiser = new Synthesiser(Synthesiser.LANG_PT_BRAZILIAN);
			
			//Get input stream from Google
			//inputStream = speech.getMP3Data(text);
			inputStream = synthesiser.getMP3Data(text);
			
			//Copy the stream
			IOUtils.copy(inputStream, response.getOutputStream());
			
			//flush buffer
			response.flushBuffer();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
