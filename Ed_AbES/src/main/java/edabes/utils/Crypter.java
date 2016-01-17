package edabes.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Crypter {

	private static MessageDigest md;
	
	public Crypter() {
	}
	
	/** Metodo para criptografar a senha utilizando MD5
     * @param  String senha - senha do usuario
     * @return String senha - retorna a senha criptografada do usuário
     */
	public String crypt(String senha){
		    try {
		        md = MessageDigest.getInstance("MD5");
		        byte[] passBytes = senha.getBytes();
		        md.reset();
		        byte[] digested = md.digest(passBytes);
		        StringBuffer sb = new StringBuffer();
		        for(int i=0;i<digested.length;i++){
		            sb.append(Integer.toHexString(0xff & digested[i]));
		        }
		        return sb.toString();
		    } catch (NoSuchAlgorithmException ex) {
		        Logger.getLogger(Crypter.class.getName()).log(Level.SEVERE, null, ex);
		    }
		        return null;

		   }
	
}
