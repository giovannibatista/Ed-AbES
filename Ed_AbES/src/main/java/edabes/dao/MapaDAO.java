package edabes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edabes.dto.ListarMapaDTO;
import edabes.dto.ObjetoAlteracoesDTO;
import edabes.entidades.Categoria;
import edabes.entidades.Mapa;
import edabes.entidades.MapaObjeto;
import edabes.entidades.Objeto;
import edabes.entidades.Subcategoria;

public interface MapaDAO {
	
	public Mapa buscaMapaPorNome(String nome);
	
	public List<Mapa> buscaMapasPorObjetivo(String objetivo);
	
	public Mapa buscaMapaPorDataCriacao(Date dataCriacao);
	
	public boolean salvaCaracteristicasMapa(Mapa caracteristicasMapa);
	
	public int salvarERecuperarCaracteristicasMapaId(Mapa caracteristicasMapa);
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapas();
	
	public ArrayList<Objeto> buscaObjetosPorSubcategoria(int idSubcategoria);
	
	public Mapa buscaMapaPorId(int mapaId);
	
	public HashMap<Integer, Objeto> buscaObjetosDoMapa(int idMapa);
	
	public ArrayList<MapaObjeto> buscaListaDeMapaObjetos(int idMapa);
	
	public ArrayList<Subcategoria> buscaSubcategorias(int idCategoria);
	
	public ArrayList<Categoria> buscaCategorias(int tipoMapa);
	
	public boolean excluirMapa(int idMapa);
	
	public int salvaEdicaoCaracteristicasMapa(Mapa caracteristicasMapa);
	
	public boolean salvarMudancasDoDesenhoMapa(List<ObjetoAlteracoesDTO> listaDeObjetos, int idMapa);
	
	public boolean salvarMapaObjeto(ObjetoAlteracoesDTO mapaObjeto, int idMapa);
	
	public void salvarMapaObjeto(MapaObjeto mapaObjeto);
	
	public ArrayList<Objeto> buscaListaObjetosByMapa(int idMapa);
	
	public void excluirObjetosDoMapa(int idMapa);
	
	public boolean verificaMapaImportado(int idUsuario, String nomeMapa);
	
	public int importarMapa(Mapa mapa);
	
	public int atualizaMapaImportado(Mapa mapaImportado);
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapasCriadosDoUsuario(int idUsuario);
	
	public ArrayList<ListarMapaDTO> buscaListaDeMapasImportadosDoUsuario(int idUsuario);
	
}
