package edabes.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class SubcategoriaDTO {
	
	private int idSubcategoria;
	private String titulo;
	private ArrayList<ObjetoDTO> listaObjetos;
	
	public SubcategoriaDTO() {
	}

	public int getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(int idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<ObjetoDTO> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(ArrayList<ObjetoDTO> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	
}



