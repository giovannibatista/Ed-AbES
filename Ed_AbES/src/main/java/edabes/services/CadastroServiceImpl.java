package edabes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.UsuarioDAO;
import edabes.entidades.Usuario;
import edabes.utils.Crypter;

@Service
@Transactional
public class CadastroServiceImpl implements CadastroService {

	@Autowired
    private UsuarioDAO usuarioDAO;
	
	/** Metodo para cadastrar o usuario
     * @param  Usuario usuario - objeto contando as informacoes do usuario
     * @return boolean usuarioCadastrado - retorna true se o usuario foi cadastrado corretamente
     */
	public boolean cadastrarUsuario(Usuario usuario) {
		boolean usuarioCadastrado = false;
		String senhaCript = "";
		try{
			Crypter crypter = new Crypter();
			senhaCript = crypter.crypt(usuario.getSenha()); //encriptando a senha
			usuario.setSenha(senhaCript);
			
			usuarioCadastrado = usuarioDAO.cadastrarUsuario(usuario);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return usuarioCadastrado;
	}

}
