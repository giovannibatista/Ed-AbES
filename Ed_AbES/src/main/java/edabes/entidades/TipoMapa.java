package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_MAPA")
public class TipoMapa {

	@Id
    @Column(name="ID_TIPO")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_MAPA_SEQ")
    @SequenceGenerator(name = "TIPO_MAPA_SEQ", sequenceName = "TIPO_MAPA_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="NOME_TIPO")
	private String nome;

	public TipoMapa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public TipoMapa(String nome) {
		this.nome = nome;
	}
	
	public TipoMapa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoMapa [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
