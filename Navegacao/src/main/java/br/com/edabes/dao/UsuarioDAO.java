package br.com.edabes.dao;

import br.com.edabes.model.Usuario;

/*
 * 
 * Classe importada do projeto Ed-AbES - Módulo de Construção
 * Desenvolvido por Daniel Pinto e Muriel Pereira.
 */
public interface UsuarioDAO {

    public boolean buscaUsuarioByEmailESenha(String email, String senha);

    public Usuario incluirUsuario(Usuario usuario);

    public Usuario buscaUsuario(Usuario usuario);

    public String trocaSenha(String email);

    public Usuario alterarUsuario(Usuario usuario);

}
