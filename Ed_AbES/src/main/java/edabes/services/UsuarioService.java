package edabes.services;

import edabes.entidades.Usuario;

public interface UsuarioService {
	
	public String trocaSenha(String email);
	
	public boolean alterarDadosUsuario(Usuario usuario);
	
}
