package edabes.services;

import java.util.ArrayList;

import edabes.dto.AudioDTO;

public interface AudioService {

	boolean importarArquivo(AudioDTO audioDTO);
	
	ArrayList<AudioDTO> listaAudios();
	
	AudioDTO buscarAudio(Integer idArquivoAudio);

}
