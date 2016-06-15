package control;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dto.DTOGruposUsuario;
import entity.Grupo;
import entity.Mensagem;
import entity.Usuario;
import persistence.DTODao;
import persistence.MensagemDao;
import persistence.UsuarioDao;

public class UsuarioAction extends ActionSupport implements ModelDriven<Usuario>{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	ServletContext context;
	HttpSession session;
	private Usuario usuario;
	private List<DTOGruposUsuario> usuariosGrupos;
	
	
	public UsuarioAction() {
		usuario = new Usuario();
	}
	
	public void init(){
		request = (HttpServletRequest) ActionContext.getContext().
										get(ServletActionContext.HTTP_REQUEST);
		response = (HttpServletResponse) ActionContext.getContext().
										get(ServletActionContext.HTTP_RESPONSE);
	}
	
	@Override
	public Usuario getModel() {
		return usuario;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	

	public List<DTOGruposUsuario> getUsuariosGrupos() {
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuariosGrupos = new DTODao().findByUsuario(usuario);
		
		
		}catch(Exception ex){
			request.setAttribute("msgListaGrupo", "Error : " + ex.getMessage());
		}
		return usuariosGrupos;
	}
	

	public void setUsuariosGrupos(List<DTOGruposUsuario> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public String cadastrar(){
		init();
		try {
			UsuarioDao ud = new UsuarioDao();
			ValidaUsuario.validaDadosUsuario(usuario);
			new Criptografia().criptografaSenha(usuario);			
			ud.create(usuario);
			usuario = new Usuario();
			request.setAttribute("resp", "Usuário cadastrado com sucesso!");
			return SUCCESS;
		} catch (Exception ex) {
			request.setAttribute("resp", "Error : " + ex.getMessage());
			
			return ERROR;			
		}
	}
	
	public String login(){
		init();
		try {
			UsuarioDao ud = new UsuarioDao();
			new Criptografia().criptografaSenha(usuario);
			Usuario resp = ud.findByLogin(usuario);
	
			if(resp != null){
				usuario = resp;
				session = request.getSession(true);
				session.setAttribute("usuario", usuario);
				GrupoAction ga = new GrupoAction();
				MensagemAction ma = new MensagemAction();
				request.setAttribute("usuariosGrupos", ga.getUsuariosGrupos());
				request.setAttribute("mensagens", ma.getMensagens(usuario));
				return LOGIN;
			}else{
				request.setAttribute("resp", "Login Inválido..Tente novamente ou faça seu cadastro..");
				return ERROR;
			}
		} catch (Exception ex) {
			request.setAttribute("msgLogin", "Error : " + ex.getMessage());
			return ERROR;
		}
	}
	
	public String logout(){
		init();
		HttpSession session = request.getSession(true);
		
		session.setAttribute("usuario", null);
		
		return SUCCESS;
	}
	
	public String alterar(){
		init();
		HttpSession session = request.getSession(true);
		try {
			new UsuarioDao().update(usuario);
			usuario = new UsuarioDao().findByCode(usuario);
			request.setAttribute("msgAlterar", "Dados alterados com sucesso!");
			session.setAttribute("usuario", usuario);
			return SUCCESS;
	
		} catch (Exception ex) {

			request.setAttribute("msgAlterar", "Error : " + ex.getMessage());
			return ERROR;
		}
	}
	
	public String linkAlterarUsuario(){
		init();
		session = request.getSession(true);
		usuario = (Usuario) session.getAttribute("usuario");
		getUsuario();
		

		return SUCCESS;
	}
	
	public String linkHome(){
		init();
		session = request.getSession(true);
		usuario = (Usuario) session.getAttribute("usuario");
		session.setAttribute("usuario", usuario);
		GrupoAction ga = new GrupoAction();
		MensagemAction ma = new MensagemAction();
		request.setAttribute("usuariosGrupos", ga.getUsuariosGrupos());
		request.setAttribute("mensagens", ma.getMensagens(usuario));
		
		
		
		return SUCCESS;
	}
	
	public String delete(){
		init();
		try {
			session = request.getSession(true);
			usuario = (Usuario) session.getAttribute("usuario");
			new UsuarioDao().delete(usuario);
			request.setAttribute("resp", "Cadastro Excluído com Sucesso..");
			logout();
			
		} catch (Exception ex) {
			request.setAttribute("msgDelete", "Error : " + ex.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String linkConsultaUsuario(){
		init();
		session = request.getSession(true);
		usuario = (Usuario) session.getAttribute("usuario");
		session.setAttribute("usuario", usuario);
		return SUCCESS;		
	}
	
	public String consultaUsuario(){
		init();
		try {
			session = request.getSession(true);
			usuario = (Usuario) session.getAttribute("usuario");
			session.setAttribute("usuario", usuario);
			
			String email = request.getParameter("email");
			Usuario usuarioResp = new UsuarioDao().findByEmail(email);
			if(usuarioResp != null){
				
				request.setAttribute("usuarioResp", usuarioResp);
				return SUCCESS;
			}else{
				request.setAttribute("msgUsu", "Usuário não Localizado, tente novamente!");
				return ERROR;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;			
		}
		
	}
	
	
	public String enviarMensagem(){
		init();
		
		try{
			session = request.getSession(true);
		Grupo grupo = (Grupo) session.getAttribute("grupologado");
		Usuario usuario = new UsuarioDao().findById(new Integer(request.getParameter("idUsuarioResp")));
		Usuario usuarioEmitente = (Usuario) session.getAttribute("usuario");
		
		Mensagem m = new Mensagem();
		m.setMensagem("Olá " + usuario.getNome() + ", " + usuarioEmitente.getNome() + " lhe convidou para fazer parte "
						+ "do grupo " + grupo.getNome());
		new MensagemDao().create(usuario, grupo, m);
		request.setAttribute("msgMsg", "Solicitação enviada com sucesso! Aguarde a confirmação do usuário.");
		return SUCCESS;
		}catch(Exception ex){
			request.setAttribute("msgMsg", "Error : " + ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
		
		
		
	
	

}
