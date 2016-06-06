package br.com.edabes.converter;

import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.model.Usuario;

public class UsuarioConverter implements Converter<Usuario, UsuarioDTO> {

    public UsuarioConverter() {
	super();
    }

    @Override
    public UsuarioDTO converteModelParaDTO(Usuario model) {
	UsuarioDTO dto = new UsuarioDTO();
	dto.setId(model.getId());
	dto.setNome(model.getNome());
	dto.setSobrenome(model.getSobrenome());
	dto.setGenero(model.getGenero());
	dto.setEmail(model.getEmail());
	dto.setCidade(model.getCidade());
	dto.setAnoNascimento(model.getAnoNascimento());
	dto.setCidade(model.getCidade());
	dto.setPais(model.getPais());
	dto.setSenha(model.getSenha());

	return dto;
    }

    @Override
    public Usuario converteDTOParaModel(UsuarioDTO dto) {
	Usuario model = new Usuario();
	model.setId(dto.getId());
	model.setNome(dto.getNome());
	model.setSobrenome(dto.getSobrenome());
	model.setGenero(dto.getGenero());
	model.setEmail(dto.getEmail());
	model.setCidade(dto.getCidade());
	model.setAnoNascimento(dto.getAnoNascimento());
	model.setCidade(dto.getCidade());
	model.setPais(dto.getPais());
	model.setSenha(dto.getSenha());

	return model;
    }

}
