package edabes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.UsuarioDAO;
import edabes.entidades.Usuario;
import edabes.utils.Crypter;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
    private UsuarioDAO usuarioDAO;
	
	public LoginServiceImpl() {
	}
	
	/** Metodo para fazer o login
     * @param  String email - email do usuario
     * @param  String senha - senha do usuario
     * @return boolean flag - retorna true se o email e a senha forem encontrados
     */
    public boolean login(String email, String senha) {
    	boolean flag = false;
    	String senhaCript = "";
    	
    	//Criptografando a senha digitada
    	Crypter crypter = new Crypter();
		senhaCript = crypter.crypt(senha);
    	
    	flag = usuarioDAO.buscaUsuarioByEmailESenha(email, senhaCript);

    	return flag;
    }
	
    /** Metodo para buscar o usuario por email
     * @param  String email - email do usuario
     * @return Usuario usuario - retorna o objeto com as informacoes do usuario
     */
    public Usuario buscaUsuarioByEmail(String email) {
    	Usuario usuario;
    	
    	usuario = usuarioDAO.buscaNomeUsuarioByEmail(email);
    	
    	return usuario;
    }

	
	
}
