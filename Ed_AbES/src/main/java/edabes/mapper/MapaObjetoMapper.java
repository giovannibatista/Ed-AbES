package edabes.mapper;

import edabes.dto.ObjetoAlteracoesDTO;
import edabes.entidades.MapaObjeto;

public interface MapaObjetoMapper {
	MapaObjeto toEntity(ObjetoAlteracoesDTO dto, int idMapa);
}