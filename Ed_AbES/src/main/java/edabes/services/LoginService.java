package edabes.services;

import edabes.entidades.Usuario;

public interface LoginService {

	public boolean login(String nome, String senha);
	
	public Usuario buscaUsuarioByEmail(String email);
	
}
