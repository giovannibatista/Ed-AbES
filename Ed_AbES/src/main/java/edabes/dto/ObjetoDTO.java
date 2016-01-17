package edabes.dto;

import org.springframework.stereotype.Component;

@Component
public class ObjetoDTO {

	private int idObjeto;
	private int altura;
	private int largura;
	private String nome;
	private String imagemMenu;
	private String imagemMapa;
	
	public ObjetoDTO() {
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemMenu() {
		return imagemMenu;
	}
	public void setImagemMenu(String imagemMenu) {
		this.imagemMenu = imagemMenu;
	}
	public String getImagemMapa() {
		return imagemMapa;
	}
	public void setImagemMapa(String imagemMapa) {
		this.imagemMapa = imagemMapa;
	}
	
	
	
}
