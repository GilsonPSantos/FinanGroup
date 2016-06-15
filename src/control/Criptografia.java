package control;

import org.jcommon.encryption.SimpleMD5;

import entity.Usuario;

public class Criptografia {
	
	public void criptografaSenha(Usuario u){
		SimpleMD5 md5 = new SimpleMD5(u.getSenha(), "g!i@l#s$o%n&@123");
		u.setSenha(md5.toHexString());
	}
	
	

}
