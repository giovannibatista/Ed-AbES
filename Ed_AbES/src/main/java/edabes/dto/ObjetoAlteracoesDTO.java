package edabes.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjetoAlteracoesDTO {

	private int idMapaObjeto;
	private int coordenadaX;
	private int coordenadaY;
	private int profundidade;
	private int idObjeto;
	private int altura;
	private int largura;
	private String audioDescricao;
	private int operacao;
	private int angulo;
	private int idArquivoAudio;
	//private AudioDTO arquivoAudio;

	public ObjetoAlteracoesDTO() {
	}

	public String getAudioDescricao() {
		return audioDescricao;
	}

	public void setAudioDescricao(String audioDescricao) {
		this.audioDescricao = audioDescricao;
	}

	public int getIdMapaObjeto() {
		return idMapaObjeto;
	}

	public void setIdMapaObjeto(int idMapaObjeto) {
		this.idMapaObjeto = idMapaObjeto;
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

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
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

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getIdArquivoAudio() {
		return idArquivoAudio;
	}

	public void setIdArquivoAudio(int idArquivoAudio) {
		this.idArquivoAudio = idArquivoAudio;
	}
 	
}
