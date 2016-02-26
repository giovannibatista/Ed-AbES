package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MAPA_OBJETO")
public class MapaObjeto {

	@Id
    @Column(name="ID_MAPA_OBJETO")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPA_OBJETO_SEQ")
    @SequenceGenerator(name = "MAPA_OBJETO_SEQ", sequenceName = "MAPA_OBJETO_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="ID_MAPA")
	private int idMapa;
	
	@Column(name="ID_OBJETO")
	private int idObjeto;
	
	@Column(name="PROFUNDIDADE")
	private int profundidade;
	
	@Column(name="AUDIO_DESCRICAO")
	private String audioDescricao;
	
	@Column(name="COORDENADA_X")
	private int coordenadaX;
	
	@Column(name="COORDENADA_Y")
	private int coordenadaY;
	
	@Column(name="ALTURA")
	private int altura;
	
	@Column(name="LARGURA")
	private int largura;
	
	@Column(name="ANGULO")
	private int angulo;
	
	@Column(name="ID_ARQUIVO_AUDIO")
	private Integer idArquivoAudio;

	public MapaObjeto() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public String getAudioDescricao() {
		return audioDescricao;
	}

	public void setAudioDescricao(String audioDescricao) {
		this.audioDescricao = audioDescricao;
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
	
	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}
	
	public int getAngulo() {
		return angulo;
	}

	public Integer getIdArquivoAudio() {
		return idArquivoAudio;
	}

	public void setIdArquivoAudio(Integer idArquivoAudio) {
		this.idArquivoAudio = idArquivoAudio;
	}

}
