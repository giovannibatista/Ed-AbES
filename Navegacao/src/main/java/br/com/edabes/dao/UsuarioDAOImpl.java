package br.com.edabes.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.edabes.model.Usuario;
import br.com.edabes.utils.Crypter;
import br.com.edabes.utils.UtilsGenerator;

/*
 * 
 * Classe importada do projeto Ed-AbES - Módulo de Construção
 * Desenvolvido por Daniel Pinto e Muriel Pereira.
 */
@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UsuarioDAOImpl() {
    }

    /**
     * Metodo para fazer a pesquisa do usuario pelo email e senha
     * 
     * @param String
     *            email - email do usuario
     * @param String
     *            senha - senha do usuario
     * @return boolean usuarioEncontrado - retorna o objeto usuario caso a senha
     *         e o email estejam no banco
     */
    public boolean buscaUsuarioByEmailESenha(String email, String senha) {
	boolean usuarioEncontrado = false;
	Session session;

	try {
	    session = sessionFactory.getCurrentSession();
	    Query query = session.createQuery("from Usuario where EMAIL = :email and SENHA = :senha");
	    query.setParameter("email", email);
	    query.setParameter("senha", senha);
	    @SuppressWarnings("unchecked")
	    List<Usuario> list = query.list();

	    if (!list.isEmpty() && list != null) {
		usuarioEncontrado = true;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usuarioEncontrado;
    }

    
    public Usuario incluirUsuario(Usuario usuario) {
	Session session;
	Usuario usuarioJaExistente = null;
	try {
	    session = sessionFactory.getCurrentSession();

	    usuarioJaExistente = (Usuario) buscaUsuario(usuario);

	    if (usuarioJaExistente == null) {
		// Inserindo o usuario
		usuario.setId((Integer) session.save(usuario));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usuario;
    }

    /**
     * Metodo para fazer a busca do usuario pelo email
     * 
     * @param String
     *            email - email do usuario
     * @return Usuario usuario - retorna o objeto usuario caso ele tenha sido
     *         encontrado no banco, se nao encontrar retorna null
     */
    public Usuario buscaUsuario(Usuario usuario) {
	Session session;
	try {
	   
	    session = sessionFactory.getCurrentSession();
	    
	    Example example = Example.create(usuario);
	    
	    usuario =  (Usuario) session.createCriteria(Usuario.class).add(example).uniqueResult();

	       

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return usuario;
    }

    /**
     * Metodo para fazer a troca de senha do usuario Gera uma senha aleatoria,
     * criptografa e atualiza o banco de dados
     * 
     * @param String
     *            email - email do usuario
     * @return String novaSenha - retorna a nova senha do usuario
     */
    public String trocaSenha(String email) {
	Session session;
	String novaSenha = "";
	String novaSenhaCriptografada = "";
	Crypter crypter = new Crypter();
	Query query = null;

	try {

	    UtilsGenerator utilsGenerator = new UtilsGenerator();
	    novaSenha = utilsGenerator.gerarSenha(8);

	    novaSenhaCriptografada = crypter.crypt(novaSenha);

	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("update Usuario set senha = :senha where email = :email");
	    query.setParameter("senha", novaSenhaCriptografada);
	    query.setParameter("email", email);
	    query.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return novaSenha;
    }

    /**
     * Metodo para alterar os dados do usuario
     * 
     * @param UsuarioDTO
     *            usuario - Objeto com informacoes do usuario
     * @return boolean dadosAlterados - True caso as informacoes tenham sido
     *         alteradas com sucesso
     */
    public Usuario alterarUsuario(Usuario usuario) {
	Session session;
	session = sessionFactory.getCurrentSession();
	Query query = null;
	boolean verificaAlterada = false;
	Crypter crypter = new Crypter();
	String novaSenhaCriptografada;

	try {

	    verificaAlterada = verificaSenhaAlterada(usuario.getSenha(), usuario.getEmail());

	    if (verificaAlterada) {
		novaSenhaCriptografada = crypter.crypt(usuario.getSenha());
		usuario.setSenha(novaSenhaCriptografada);
	    }

	    query = session.createQuery(
		    "update Usuario set nome = :nome, sobrenome = :sobrenome, anoNascimento = :anoNascimento, cidade = :cidade, pais = :pais, genero = :genero, senha = :senha where id = :idUsuario");
	    query.setParameter("nome", usuario.getNome());
	    query.setParameter("sobrenome", usuario.getSobrenome());
	    query.setParameter("anoNascimento", usuario.getAnoNascimento());
	    query.setParameter("cidade", usuario.getCidade());
	    query.setParameter("pais", usuario.getPais());
	    query.setParameter("genero", usuario.getGenero());
	    query.setParameter("senha", usuario.getSenha());
	    query.setParameter("idUsuario", usuario.getId());

	    query.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usuario;
    }

    /**
     * Metodo para verificar se a senha do usuario esta correta
     * 
     * @param String
     *            senha - Senha do usuario
     * @param String
     *            email - email do usuario
     * @return boolean senhaDiferente - True se a senha estiver incorreta
     */
    @SuppressWarnings("unchecked")
    public boolean verificaSenhaAlterada(String senha, String email) {
	boolean senhaDiferente = false;
	Session session;
	Query query = null;

	try {
	    session = sessionFactory.getCurrentSession();
	    query = session.createQuery("from Usuario where EMAIL = :email and SENHA = :senha");
	    query.setParameter("email", email);
	    query.setParameter("senha", senha);
	    List<Usuario> list = query.list();

	    if (list.isEmpty()) {
		senhaDiferente = true;
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return senhaDiferente;
    }

}
