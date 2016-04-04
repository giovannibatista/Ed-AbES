package br.com.edabes.controllers;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.edabes.auxiliares.MakeSound;

@Controller
public class MapaController {

    public MapaController() {
	// TODO Auto-generated constructor stub
    }

    @RequestMapping(value="/Mapa/Listar", method=RequestMethod.GET)
    public String iniciarListarMapas(){
	System.out.println("Executando a lógica com Spring MVC para outra view");
	return "/Mapa/Listar";
    }

    @RequestMapping(value="/Mapa/Testar", method=RequestMethod.GET)
    public String testarSom() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
	System.out.println("entrou");
	MakeSound makeSound = new MakeSound();

	makeSound.playSound("C:\\dev\\tcc\\ed_abes\\audio_files\\grass1.wav");
	System.out.println("fim");
	return "rodou";
    }

}
