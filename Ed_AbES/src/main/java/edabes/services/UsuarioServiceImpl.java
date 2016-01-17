package edabes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edabes.dao.UsuarioDAO;
import edabes.entidades.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
    private UsuarioDAO usuarioDAO;
	
	public UsuarioServiceImpl(){
	}
	
	/** Metodo para trocar a senha do usuario
     * @param  String email - email do usuario
     * @return String senhaAlterada - retorna a nova senha do usuario
     */
	public String trocaSenha(String email) {
		String senhaAlterada = "";
		
		senhaAlterada = usuarioDAO.trocaSenha(email);
		
		return senhaAlterada;
	}
	
	/**
	 * Metodo para alterar os dados do usuario
	 * @param Usuario usuario - Usuario logado
	 * @return boolean dadosAlterados - True caso os dados tenham sido alterados
	 * com sucesso
	 */
	public boolean alterarDadosUsuario(Usuario usuario) {
		boolean dadosAlterados = false;
		
		dadosAlterados = usuarioDAO.alterarDadosUsuario(usuario);
		
		return dadosAlterados;
		
	}
	
}
