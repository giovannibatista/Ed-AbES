package br.com.edabes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.edabes.dto.MapaDTO;
import br.com.edabes.service.MapaService;
import br.com.edabes.utils.MakeSound;

@Controller
public class MapaController {
    
    @Autowired
    private MapaService mapaService;
    
    private ArrayList<MapaDTO> mapas;

    public MapaController() {
	super();
	mapas = new ArrayList<MapaDTO>();
    }

    @RequestMapping(value="/Mapa/Listar", method=RequestMethod.GET)
    public String iniciarListaMapas(){
	
	mapas = mapaService.listarMapas();
	
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
    

    public ArrayList<MapaDTO> getMapas() {
        return mapas;
    }

    public void setMapas(ArrayList<MapaDTO> mapas) {
        this.mapas = mapas;
    }

}
