package br.com.edabes.service;

import java.util.ArrayList;
import br.com.edabes.dto.MapaDTO;

public interface MapaService {
    
    public ArrayList<MapaDTO> listarMapas() throws Exception;

    public MapaDTO consultaMapa(MapaDTO consulta);

    public MapaDTO consultaMapaTreinamento() throws Exception;
  

}
