package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SUBCATEGORIA")
public class Subcategoria {

	@Id
    @Column(name="ID_SUBCATEGORIA")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUBCATEGORIA_SEQ")
    @SequenceGenerator(name = "SUBCATEGORIA_SEQ", sequenceName = "SUBCATEGORIA_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="ID_CATEGORIA")
	private int idCategoria;
	
	@Column(name="TITULO")
	private String titulo;

	public Subcategoria() {
		
	}
	
	public Subcategoria(int id, int idCategoria, String titulo) {
		this.id = id;
		this.idCategoria = idCategoria;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
