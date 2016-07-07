package br.com.edabes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.converter.Converter;
import br.com.edabes.converter.UsuarioConverter;
import br.com.edabes.dao.UsuarioDAO;
import br.com.edabes.dto.UsuarioDTO;
import br.com.edabes.model.Usuario;
import br.com.edabes.utils.Crypter;

/*
 * 
 * Classe importada do projeto Ed-AbES - Módulo de Construção
 * Desenvolvido por Daniel Pinto(2015) e Muriel Pereira(2015).
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    private Converter<Usuario, UsuarioDTO> converter;

    public UsuarioServiceImpl() {
	converter = new UsuarioConverter();

    }

    /**
     * Metodo para trocar a senha do usuario
     * 
     * @param String
     *            email - email do usuario
     * @return String senhaAlterada - retorna a nova senha do usuario
     */
    public String trocaSenha(String email) {
	String senhaAlterada = "";

	senhaAlterada = usuarioDAO.trocaSenha(email);

	return senhaAlterada;
    }

    public boolean login(String email, String senha) {
	boolean flag = false;
	String senhaCript = "";
	try {

	    // Criptografando a senha digitada
	    Crypter crypter = new Crypter();
	    senhaCript = crypter.crypt(senha);

	    flag = usuarioDAO.buscaUsuarioByEmailESenha(email, senhaCript);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return flag;
    }

    public UsuarioDTO buscaUsuario(UsuarioDTO usuarioDTO) {
	Usuario usuario = null;
	try {
	    usuario = converter.converteDTOParaModel(usuarioDTO);

	    usuario = usuarioDAO.buscaUsuario(usuario);
	    if (usuario != null) {
		usuarioDTO = converter.converteModelParaDTO(usuario);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return usuarioDTO;
    }

    @Override
    public UsuarioDTO incluirUsuario(UsuarioDTO usuarioDTO) {
	String senhaCript = "";
	Usuario usuario = null;
	try {

	    usuario = converter.converteDTOParaModel(usuarioDTO);
	    Crypter crypter = new Crypter();
	    senhaCript = crypter.crypt(usuario.getSenha());
	    usuario.setSenha(senhaCript);

	    usuario = usuarioDAO.incluirUsuario(usuario);
	    usuarioDTO = converter.converteModelParaDTO(usuario);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usuarioDTO;
    }

    @Override
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
	Usuario usuario = null;
	try {

	    usuario = converter.converteDTOParaModel(usuarioDTO);
	    usuario = usuarioDAO.alterarUsuario(usuario);
	    usuarioDTO = converter.converteModelParaDTO(usuario);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usuarioDTO;
    }

}
