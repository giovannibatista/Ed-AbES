package edabes.dao;

import edabes.entidades.Usuario;

public interface UsuarioDAO {

	public boolean buscaUsuarioByEmailESenha(String email, String senha);
	
	public boolean cadastrarUsuario(Usuario usuario);
	
	public Usuario buscaNomeUsuarioByEmail(String email);
	
	public String trocaSenha(String email);
	
	public boolean alterarDadosUsuario(Usuario usuario);
	
}
