package br.com.edabes.controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.edabes.utils.MakeSound;

@Controller
public class MapaController {

    public MapaController() {
	super();
    }

    @RequestMapping(value = "/Mapa/Listar", method = RequestMethod.GET)
    public ModelAndView iniciarListaMapas() {
	ModelAndView model = null;
	try {
	    model = new ModelAndView("/Mapa/Listar");
	    //mapas = mapaService.listarMapas();
	    //model.addObject("mapas", mapas);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return model;
    }

    @RequestMapping(value = "/Mapa/Testar", method = RequestMethod.GET)
    public String testarSom() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
	System.out.println("entrou");
	MakeSound makeSound = new MakeSound();

	makeSound.playSound("C:\\dev\\tcc\\ed_abes\\audio_files\\grass1.wav");
	System.out.println("fim");
	return "rodou";
    }

}
