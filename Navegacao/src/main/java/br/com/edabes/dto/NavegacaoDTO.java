package br.com.edabes.dto;

import java.util.ArrayList;

public class NavegacaoDTO {

    private ArrayList<MapaObjetoDTO> objetosNivelSolo;
    private ArrayList<MapaObjetoDTO> objetos;
    private ArrayList<MapaObjetoDTO> todosObjetos;

    public NavegacaoDTO() {
	objetosNivelSolo = new ArrayList<MapaObjetoDTO>();
	objetos = new ArrayList<MapaObjetoDTO>();
	todosObjetos = new ArrayList<MapaObjetoDTO>();
    }

    public NavegacaoDTO(ArrayList<MapaObjetoDTO> objetosNivelSolo, ArrayList<MapaObjetoDTO> objetos,
	    ArrayList<MapaObjetoDTO> todosObjetos) {
	super();
	this.objetosNivelSolo = objetosNivelSolo;
	this.objetos = objetos;
	this.todosObjetos = todosObjetos;
    }

    public ArrayList<MapaObjetoDTO> getObjetosNivelSolo() {
	return objetosNivelSolo;
    }

    public void setObjetosNivelSolo(ArrayList<MapaObjetoDTO> objetosNivelSolo) {
	this.objetosNivelSolo = objetosNivelSolo;
    }

    public ArrayList<MapaObjetoDTO> getObjetos() {
	return objetos;
    }

    public void setObjetos(ArrayList<MapaObjetoDTO> objetos) {
	this.objetos = objetos;
    }

    public ArrayList<MapaObjetoDTO> getTodosObjetos() {
	return todosObjetos;
    }

    public void setTodosObjetos(ArrayList<MapaObjetoDTO> todosObjetos) {
	this.todosObjetos = todosObjetos;
    }

}
