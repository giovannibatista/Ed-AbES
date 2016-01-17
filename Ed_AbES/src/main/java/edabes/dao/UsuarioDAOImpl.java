package edabes.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edabes.entidades.Usuario;
import edabes.utils.Crypter;
import edabes.utils.UtilsGenerator;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UsuarioDAOImpl(){
	}
	
	/** Metodo para fazer a pesquisa do usuario pelo email e senha
     * @param  String email - email do usuario
     * @param  String senha - senha do usuario
     * @return boolean usuarioEncontrado - retorna o objeto usuario caso a senha e o email estejam no banco
     */
	public boolean buscaUsuarioByEmailESenha(String email, String senha) {
		boolean usuarioEncontrado = false;                                                        
	    Session session;
	    
	    try {
		    session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Usuario where EMAIL = :email and SENHA = :senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			List<Usuario> list = query.list();
			
			if(!list.isEmpty() && list != null) {
				usuarioEncontrado = true;
				Usuario usu = (Usuario) list.get(0);
				//System.out.println(usu.getNome());
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
			
		return usuarioEncontrado;
	}
	
	/** Metodo para fazer o cadastro do usuario
     * @param  Usuario usuario - objeto usuario com os dados da tela de cadastro
     * @return boolean usuarioCadastrado - retorna true caso o usuario tenha sido cadastrado no banco 
     */
	public boolean cadastrarUsuario(Usuario usuario) {
		boolean usuarioCadastrado = false;                                                        
	    Session session;
		Usuario usuarioJaExistente = null;
	    
	    try{
		    session = sessionFactory.getCurrentSession();
	    	
		    usuarioJaExistente = (Usuario) buscaNomeUsuarioByEmail(usuario.getEmail());
		    
		    if(usuarioJaExistente == null) {
		    	//Inserindo o usuario
		    	session.save(usuario);
		    	usuarioCadastrado = true;
		    }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		return usuarioCadastrado;
	}
	
	/** Metodo para fazer a busca do usuario pelo email
     * @param  String email - email do usuario
     * @return Usuario usuario - retorna o objeto usuario caso ele tenha sido encontrado no banco,
     * se nao encontrar retorna null 
     */
	public Usuario buscaNomeUsuarioByEmail(String email) {
		Usuario usuario = null;
		Session session;
		
		try {
			session = sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Usuario where EMAIL = :email");
			query.setParameter("email", email);
			List<Usuario> list = query.list();
			
			if(!list.isEmpty() && list != null) {
				usuario = (Usuario) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	/** Metodo para fazer a troca de senha do usuario
	 *  Gera uma senha aleatoria, criptografa e atualiza o banco de dados
     * @param  String email - email do usuario
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
	 * @param Usuario usuario - Objeto com informacoes do usuario
	 * @return boolean dadosAlterados - True caso as informacoes tenham
	 * sido alteradas com sucesso
	 */
	public boolean alterarDadosUsuario(Usuario usuario) {
		boolean dadosAlterados = false;
		Session session;
		session = sessionFactory.getCurrentSession();
		Query query = null;
		int result = 0;
		boolean verificaAlterada = false;
		UtilsGenerator utilsGenerator = null;
		Crypter crypter = new Crypter();
		String novaSenhaCriptografada;
		
		try {				
			
			verificaAlterada = verificaSenhaAlterada(usuario.getSenha(), usuario.getEmail());
			
			if(verificaAlterada) {
		    	novaSenhaCriptografada = crypter.crypt(usuario.getSenha());
		    	usuario.setSenha(novaSenhaCriptografada);
			}
			
			query = session.createQuery("update Usuario set nome = :nome, sobrenome = :sobrenome, anoNascimento = :anoNascimento, cidade = :cidade, pais = :pais, genero = :genero, senha = :senha where id = :idUsuario");
			query.setParameter("nome", usuario.getNome());
			query.setParameter("sobrenome", usuario.getSobrenome());
			query.setParameter("anoNascimento", usuario.getAnoNascimento());
			query.setParameter("cidade", usuario.getCidade());
			query.setParameter("pais", usuario.getPais());
			query.setParameter("genero", usuario.getGenero());
			query.setParameter("senha", usuario.getSenha());
			query.setParameter("idUsuario", usuario.getId());
			
			result = query.executeUpdate();
			
			if (result > 0) {
				dadosAlterados = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		return dadosAlterados;
	}
	
	/**
	 * Metodo para verificar se a senha do usuario esta correta
	 * @param String senha - Senha do usuario
	 * @param String email - email do usuario
	 * @return boolean senhaDiferente - True se a senha estiver incorreta
	 */
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
			
			if(list.isEmpty()) {
				senhaDiferente = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return senhaDiferente;
	}
	
}
