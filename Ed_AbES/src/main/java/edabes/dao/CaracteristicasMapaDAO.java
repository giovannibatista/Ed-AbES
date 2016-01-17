package edabes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edabes.entidades.Mapa;

public interface CaracteristicasMapaDAO {
	
	public Mapa buscaMapaPorNome(String nome);
	
	public List<Mapa> buscaMapasPorObjetivo(String objetivo);
	
	public boolean salvaCaracteristicasMapa(Mapa caracteristicasMapa);
	
	public ArrayList<Mapa> buscaListaDeMapas();
	
}
