package edabes.mapper;

import org.springframework.stereotype.Component;

import edabes.dto.ObjetoAlteracoesDTO;
import edabes.entidades.MapaObjeto;

@Component
public class MapaObjetoMapperImpl implements MapaObjetoMapper {
	
	/**
	 * Metodo para transformar o dto ObjetoAlteracoesDTO em uma entidade MapaObjeto
	 * @param ObjetoAlteracoesDTO dto - Objeto com informacoes do objeto do mapa
	 * @param int idMapa - Identificador do mapa
	 * @return MapaObjeto obj - Entidade MapaObjeto
	 */
	public MapaObjeto toEntity(ObjetoAlteracoesDTO dto, int idMapa) {
		MapaObjeto obj = new MapaObjeto();
		
		obj.setIdMapa(idMapa);
		obj.setAudioDescricao(dto.getAudioDescricao());
		obj.setCoordenadaX(dto.getCoordenadaX());
		obj.setCoordenadaY(dto.getCoordenadaY());
		obj.setId(dto.getIdMapaObjeto());
		obj.setIdObjeto(dto.getIdObjeto());
		obj.setProfundidade(dto.getProfundidade());
		obj.setAltura(dto.getAltura());
		obj.setLargura(dto.getLargura());
		obj.setAngulo(dto.getAngulo());
		obj.setIdArquivoAudio(dto.getIdArquivoAudio() == 0 ? null : dto.getIdArquivoAudio());
		
		return (obj);
	}
	
}