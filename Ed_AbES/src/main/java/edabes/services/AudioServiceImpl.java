package edabes.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.AudioDAO;
import edabes.dto.AudioDTO;
import edabes.entidades.Audio;
import edabes.utils.DateUtils;

@Service
@Transactional
public class AudioServiceImpl implements AudioService {

	@Autowired
	private AudioDAO audioDAO;

	private final String FILESYSTEM = "C:\\dev\\tcc\\audio_files\\";

	public AudioServiceImpl() {

	}

	public boolean importarArquivo(AudioDTO audioDTO) {

		boolean audioCadastrado = false;
		try {
			audioDTO.setArquivo(salvarArquivoFileSystem(audioDTO.getArquivo()));

			Audio audio = converteDTOParaEntidade(audioDTO);
			audioCadastrado = audioDAO.salvarAudio(audio);
			
		} catch (IOException e) {
			e.printStackTrace();

		}

		return audioCadastrado;
	}

	public Audio converteDTOParaEntidade(AudioDTO audioDTO) {
		Audio audio = new Audio();

		audio.setId(audioDTO.getId());
		audio.setArquivo(FILESYSTEM + audioDTO.getArquivo().getName());
		audio.setDescricao(audioDTO.getDescricao());

		return audio;
	}

	public AudioDTO converteEntidadeParaDTO(Audio audio) {
		AudioDTO audioDTO = new AudioDTO();

		File arquivo = new File(audio.getArquivo());

		audioDTO.setId(audio.getId());
		audioDTO.setArquivo(arquivo);
		audioDTO.setDescricao(audio.getDescricao());

		return audioDTO;
	}

	public File salvarArquivoFileSystem(File arquivoUpload) throws IOException {

		File arquivoDestino = new File(FILESYSTEM + arquivoUpload.getName());

		if (arquivoDestino.exists()) {
			arquivoDestino = new File(FILESYSTEM + getNomeArquivoComDataAtual(arquivoUpload));
		}
		@SuppressWarnings("resource")
		FileInputStream fileInputStream = new FileInputStream(arquivoUpload);
		FileChannel origem = fileInputStream.getChannel();
		@SuppressWarnings("resource")
		FileOutputStream fileOutputStream = new FileOutputStream(arquivoDestino);
		FileChannel destino = fileOutputStream.getChannel();
		destino.transferFrom(origem, 0, origem.size());

		return arquivoDestino;
	}

	public String getNomeArquivoComDataAtual(File arquivo) {
		String nomeArquivoSemExtensao = FilenameUtils.removeExtension(arquivo.getName());
		String extensao = FilenameUtils.getExtension(arquivo.getName());

		String nomeArquivo = nomeArquivoSemExtensao + "_" + (DateUtils.getDateFormatString()) + "." + extensao;
		System.out.println(nomeArquivo);
		return nomeArquivo;

	}

	public ArrayList<AudioDTO> listaAudios() {
		
		ArrayList<Audio> listaAudios = new ArrayList<Audio>();
		ArrayList<AudioDTO> listaAudioDTOs = new ArrayList<AudioDTO>();
		
		listaAudios = audioDAO.listaAudios();
		
		for (Audio audio : listaAudios) {
			listaAudioDTOs.add(converteEntidadeParaDTO(audio));
		}
		
		return listaAudioDTOs;
	}

	public AudioDTO buscarAudio(Integer idArquivoAudio) {
		
		if(idArquivoAudio == null){
			return new AudioDTO();
		}
		
		Audio audio = audioDAO.buscarAudio(idArquivoAudio);
		
		AudioDTO audioDTO = converteEntidadeParaDTO(audio);
		
		return audioDTO;
	}

}
