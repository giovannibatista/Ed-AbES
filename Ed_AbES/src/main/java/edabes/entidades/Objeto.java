package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OBJETO")
public class Objeto {
	
	@Id
    @Column(name="ID_OBJETO")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBJETO_SEQ")
    @SequenceGenerator(name = "OBJETO_SEQ", sequenceName = "OBJETO_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="ALTURA")
	private int altura;
	
	@Column(name="LARGURA")
	private int largura;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="SUBCATEGORIA")
	private int subcategoria;
	
	@Column(name="IMAGEM_MENU")
	private String imagemMenu;
	
	@Column(name="IMAGEM_MAPA")
	private String imagemMapa;
	
	@Column(name="NOME")
	private String nome;

	public Objeto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(int tipo) {
		this.subcategoria = tipo;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Objeto [id=" + id + ", altura=" + altura + ", largura="
				+ largura + ", descricao=" + descricao + ", subcategoria=" + subcategoria
				+ ", imagemMenu=" + imagemMenu + ", imagemMapa=" + imagemMapa
				+ ", nome=" + nome + "]";
	}
	
	
	
}
