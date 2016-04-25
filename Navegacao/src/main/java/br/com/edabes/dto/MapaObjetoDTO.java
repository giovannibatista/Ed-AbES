package br.com.edabes.dto;

public class MapaObjetoDTO {

    private Integer id;
    private Integer idMapa;
    private ObjetoDTO objeto;
    private Integer profundidade;
    private String audioDescricao;
    private Integer coordenadaX;
    private Integer coordenadaY;
    private Integer altura;
    private Integer largura;
    private Integer angulo;
    private Integer idArquivoAudio;
    private boolean pontoInicial;
    private boolean pontoFinal;

    public MapaObjetoDTO() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getIdMapa() {
	return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
	this.idMapa = idMapa;
    }

    public ObjetoDTO getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoDTO objeto) {
        this.objeto = objeto;
    }

    public Integer getProfundidade() {
	return profundidade;
    }

    public void setProfundidade(Integer profundidade) {
	this.profundidade = profundidade;
    }

    public String getAudioDescricao() {
	return audioDescricao;
    }

    public void setAudioDescricao(String audioDescricao) {
	this.audioDescricao = audioDescricao;
    }

    public Integer getCoordenadaX() {
	return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
	this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
	return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
	this.coordenadaY = coordenadaY;
    }

    public Integer getAltura() {
	return altura;
    }

    public void setAltura(Integer altura) {
	this.altura = altura;
    }

    public Integer getLargura() {
	return largura;
    }

    public void setLargura(Integer largura) {
	this.largura = largura;
    }

    public void setAngulo(Integer angulo) {
	this.angulo = angulo;
    }

    public Integer getAngulo() {
	return angulo;
    }

    public Integer getIdArquivoAudio() {
	return idArquivoAudio;
    }

    public void setIdArquivoAudio(Integer idArquivoAudio) {
	this.idArquivoAudio = idArquivoAudio;
    }
    
    public boolean isPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(boolean pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public boolean isPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(boolean pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    @Override
    public String toString() {
	return "MapaObjetoDTO [id=" + id + ", idMapa=" + idMapa + ", objeto=" + objeto.toString() + ", profundidade="
		+ profundidade + ", audioDescricao=" + audioDescricao + ", coordenadaX=" + coordenadaX
		+ ", coordenadaY=" + coordenadaY + ", altura=" + altura + ", largura=" + largura + ", angulo=" + angulo
		+ ", idArquivoAudio=" + idArquivoAudio + "]";
    }

    
    
    

}
