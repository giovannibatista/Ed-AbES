package br.com.edabes.service;

import br.com.edabes.dto.UsuarioDTO;

/*
 * 
 * Classe importada do projeto Ed-AbES - Módulo de Construção
 * Desenvolvido por Daniel Pinto e Muriel Pereira.
 */
public interface UsuarioService {

    public String trocaSenha(String email);
    
    public boolean login(String nome, String senha);

    public boolean alterarDadosUsuario(UsuarioDTO usuarioDTO);
    
    public UsuarioDTO buscaUsuario(UsuarioDTO usuarioDTO);

    public UsuarioDTO incluirUsuario(UsuarioDTO usuario);

}
