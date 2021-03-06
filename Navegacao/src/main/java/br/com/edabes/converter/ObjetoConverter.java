package br.com.edabes.converter;

import br.com.edabes.dto.ObjetoDTO;
import br.com.edabes.dto.SubcategoriaDTO;
import br.com.edabes.model.Objeto;
import br.com.edabes.model.Subcategoria;

public class ObjetoConverter implements Converter<Objeto, ObjetoDTO> {

    private Converter<Subcategoria, SubcategoriaDTO> subcategoriaConverter = new SubcategoriaConverter();

    @Override
    public ObjetoDTO converteModelParaDTO(Objeto model) {
	ObjetoDTO objetoDTO = new ObjetoDTO();
	objetoDTO.setId(model.getId());
	objetoDTO.setDescricao(model.getDescricao());
	objetoDTO.setNome(model.getNome());
	objetoDTO.setAltura(model.getAltura());
	objetoDTO.setLargura(model.getLargura());
	objetoDTO.setImagemMapa(model.getImagemMapa());
	objetoDTO.setNivel(model.getNivel());
	objetoDTO.setSubcategoria(subcategoriaConverter.converteModelParaDTO(model.getSubcategoria()));
	return objetoDTO;
    }

    @Override
    public Objeto converteDTOParaModel(ObjetoDTO dto) {
	Objeto objeto = new Objeto();
	objeto.setId(dto.getId());
	objeto.setDescricao(dto.getDescricao());
	objeto.setNome(dto.getNome());
	objeto.setAltura(dto.getAltura());
	objeto.setLargura(dto.getLargura());
	objeto.setImagemMapa(dto.getImagemMapa());
	objeto.setNivel(dto.getNivel());
	objeto.setSubcategoria(subcategoriaConverter.converteDTOParaModel(dto.getSubcategoria()));
	return objeto;
    }

}
