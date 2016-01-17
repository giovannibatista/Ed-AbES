package edabes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MAPA_NIVEL")
public class MapaNivel {

	@Id
    @Column(name="ID_MAPA_NIVEL")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPA_NIVEL_SEQ")
    @SequenceGenerator(name = "MAPA_NIVEL_SEQ", sequenceName = "MAPA_NIVEL_SEQ", allocationSize = 1)
	private int id;
	
	@Column(name="ID_MAPA")
	private int idMapa;
	
	@Column(name="ANDAR")
	private int andar;

	public MapaNivel(int id, int idMapa, int andar) {
		this.id = id;
		this.idMapa = idMapa;
		this.andar = andar;
	}

	public MapaNivel(int idMapa, int andar) {
		this.idMapa = idMapa;
		this.andar = andar;
	}

	public MapaNivel(int andar) {
		this.andar = andar;
	}

	public MapaNivel() {
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

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	@Override
	public String toString() {
		return "MapaNivel [id=" + id + ", idMapa=" + idMapa + ", andar="
				+ andar + "]";
	}
	
	
}
