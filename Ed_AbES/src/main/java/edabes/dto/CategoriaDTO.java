package edabes.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CategoriaDTO {

	private int idCategoria;
	private String titulo;
	private ArrayList<SubcategoriaDTO> listaDeSubcategoria;
	
	public CategoriaDTO() {
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

	public ArrayList<SubcategoriaDTO> getListaDeSubcategoria() {
		return listaDeSubcategoria;
	}

	public void setListaDeSubcategoria(
			ArrayList<SubcategoriaDTO> listaDeSubcategoria) {
		this.listaDeSubcategoria = listaDeSubcategoria;
	}
	
}
