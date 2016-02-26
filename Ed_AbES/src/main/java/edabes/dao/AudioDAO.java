package edabes.dao;

import java.util.ArrayList;

import edabes.entidades.Audio;

public interface AudioDAO {

	boolean salvarAudio(Audio audio);
	
	ArrayList<Audio> listaAudios();
	
	Audio buscarAudio(Integer idArquivoAudio);


}
