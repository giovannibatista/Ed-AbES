package br.com.edabes.service;

import java.util.ArrayList;
import br.com.edabes.dto.MapaDTO;

public interface MapaService {

    public ArrayList<MapaDTO> listarMapas(MapaDTO mapaDTO) throws Exception;

    public ArrayList<MapaDTO> listarMapasPublicos() throws Exception;

    public MapaDTO consultarMapa(MapaDTO consulta);

    public MapaDTO consultarMapaPublico(MapaDTO consulta);

    public MapaDTO consultarMapaTreinamento() throws Exception;

    public void importarMapa(MapaDTO mapaDTO);

}
