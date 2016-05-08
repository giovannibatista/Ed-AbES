package br.com.edabes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OBJETO")
public class Objeto {

    @Id
    @Column(name = "ID_OBJETO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBJETO_SEQ")
    @SequenceGenerator(name = "OBJETO_SEQ", sequenceName = "OBJETO_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "ALTURA")
    private Integer altura;

    @Column(name = "LARGURA")
    private Integer largura;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "SUBCATEGORIA")
    private Subcategoria subcategoria;

    @Column(name = "IMAGEM_MAPA")
    private String imagemMapa;
    
    @Column(name = "nivel")
    private Integer nivel;

    public Objeto() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
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

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Subcategoria getSubcategoria() {
	return subcategoria;
    }

    public void setSubcategoria(Subcategoria tipo) {
	this.subcategoria = tipo;
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
    
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
	return "Objeto [id=" + id + ", altura=" + altura + ", largura=" + largura + ", nome=" + nome + ", descricao="
		+ descricao + ", subcategoria=" + subcategoria + ", imagemMapa=" + imagemMapa + "]";
    }

}
