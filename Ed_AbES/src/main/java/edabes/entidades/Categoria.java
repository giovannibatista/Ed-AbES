package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {

	
	
	@Id
    @Column(name="ID_CATEGORIA")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_SEQ")
    @SequenceGenerator(name = "CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="TITULO")
	private String titulo;

	public Categoria() {
		
	}
		
	public Categoria(int id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
