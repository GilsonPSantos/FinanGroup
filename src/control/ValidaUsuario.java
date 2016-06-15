package control;

import entity.Usuario;

public class ValidaUsuario {
	
	public static void validaDadosUsuario(Usuario u) throws Exception{
		int erro = 0;
		StringBuffer sb = new StringBuffer();
		
		if(!u.isOkNome()){
			erro = 1;
			sb.append("Digite um nome v�lido! <br/>");
		}
		if(!u.isOkSenha()){
			erro = 1;
			sb.append("Digite uma senha v�lida, m�nimo de 4 e m�ximo de 10 caracteres! <br/>");
		}
		if(!u.isOkEmail()){
			erro = 1;
			sb.append("Digite um email v�lido! <br/>");
		}
		
		if(!u.isOkCelular()){
			erro = 1;
			sb.append("Digite um n�mero de celular v�lido, m�nimo de 8 d�gitos e apenas n�meros! <br/>");
		}
		
		if(erro == 1){
			throw new Exception(sb.toString());
		}
		
		
		
	}

}
