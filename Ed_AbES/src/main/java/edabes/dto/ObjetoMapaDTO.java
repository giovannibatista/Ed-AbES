package edabes.dto;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class ObjetoMapaDTO {

	private int profundidade;
	private int coordenadaX;
	private int coordenadaY;
	private int altura;
	private int largura;
	private String imagemMapa;
	private String nome;
	private String audioDescricao;
	private int idMapaObjeto;
	private int angulo;
	private int idObjeto;
	private File arquivoAudio;
	
	public ObjetoMapaDTO() {
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemMapa() {
		return imagemMapa;
	}

	public void setImagemMapa(String imagemMapa) {
		this.imagemMapa = imagemMapa;
	}

	public int getIdMapaObjeto() {
		return idMapaObjeto;
	}

	public void setIdMapaObjeto(int idMapaObjeto) {
		this.idMapaObjeto = idMapaObjeto;
	}

	public String getAudioDescricao() {
		return audioDescricao;
	}

	public void setAudioDescricao(String audioDescricao) {
		this.audioDescricao = audioDescricao;
	}
	
	public int getAngulo() {
		return angulo;
	}
	
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	
	public int getIdObjeto() {
		return idObjeto;
	}
	
	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public File getArquivoAudio() {
		return arquivoAudio;
	}

	public void setArquivoAudio(File arquivoAudio) {
		this.arquivoAudio = arquivoAudio;
	}
}
