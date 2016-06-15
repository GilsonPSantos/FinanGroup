package control;

import entity.Usuario;

public class ValidaUsuario {
	
	public static void validaDadosUsuario(Usuario u) throws Exception{
		int erro = 0;
		StringBuffer sb = new StringBuffer();
		
		if(!u.isOkNome()){
			erro = 1;
			sb.append("Digite um nome válido! <br/>");
		}
		if(!u.isOkSenha()){
			erro = 1;
			sb.append("Digite uma senha válida, mínimo de 4 e máximo de 10 caracteres! <br/>");
		}
		if(!u.isOkEmail()){
			erro = 1;
			sb.append("Digite um email válido! <br/>");
		}
		
		if(!u.isOkCelular()){
			erro = 1;
			sb.append("Digite um número de celular válido, mínimo de 8 dígitos e apenas números! <br/>");
		}
		
		if(erro == 1){
			throw new Exception(sb.toString());
		}
		
		
		
	}

}
