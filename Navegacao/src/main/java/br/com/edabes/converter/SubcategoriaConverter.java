package br.com.edabes.converter;

import br.com.edabes.dto.SubcategoriaDTO;
import br.com.edabes.model.Subcategoria;

public class SubcategoriaConverter implements Converter<Subcategoria, SubcategoriaDTO> {

    @Override
    public SubcategoriaDTO converteModelParaDTO(Subcategoria model) {
	SubcategoriaDTO subcategoriaDTO = new SubcategoriaDTO();
	subcategoriaDTO.setId(model.getId());
	subcategoriaDTO.setIdCategoria(model.getIdCategoria());
	subcategoriaDTO.setTitulo(model.getTitulo());
	return subcategoriaDTO;
    }

    @Override
    public Subcategoria converteDTOParaModel(SubcategoriaDTO dto) {
	Subcategoria subcategoria = new Subcategoria();
	subcategoria.setId(dto.getId());
	subcategoria.setIdCategoria(dto.getIdCategoria());
	subcategoria.setTitulo(dto.getTitulo());
	return subcategoria;
    }

}
