package edabes.dto;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class AudioDTO {

	private int id;
	private File arquivo;
	private String descricao;
	
	public AudioDTO(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
