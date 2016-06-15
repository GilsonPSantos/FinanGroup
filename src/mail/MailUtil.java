package mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import entity.Mensagem;
import entity.Usuario;

public class MailUtil {
	
	private static final String HOSTNAME="smtp.gmail.com";
	private static final String USERNAME = "cotiexemplo@gmail.com";
	private static final String PASSWORD = "@coticoti@";
	
	public static Email conectaEmail() throws Exception{
		
		Email email = new SimpleEmail();
		email.setHostName(HOSTNAME);
		email.setSmtpPort(465);
		email.setAuthentication(USERNAME, PASSWORD);
		email.setTLS(true);
		email.setSSL(true);
		email.setFrom(USERNAME,USERNAME);
		return email;
	}
	
	public static void enviarEmail(Usuario u, Mensagem m) throws Exception{
		Email mail = new SimpleEmail();
		mail = conectaEmail();
		mail.setSubject("FinanGroup - Você recebeu um pedido para ser adicionado a um grupo.");
		mail.addTo(u.getEmail());
		mail.setMsg("Olá, " + u.getNome() + " você foi adicionado ao grupo " + m.getGrupo().getNome() + 
				" e para aceitar acesse seu FinanGroup. Obrigado pela atenção!");
		mail.send();
		
	}

}
