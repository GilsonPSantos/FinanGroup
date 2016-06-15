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

import dto.DTOMensagemConsulta;
import entity.Grupo;
import entity.Usuario;
import persistence.GrupoDao;
import persistence.MensagemDao;

public class MensagemAction extends ActionSupport implements ModelDriven<DTOMensagemConsulta>{

	private static final long serialVersionUID = 1L;
	private DTOMensagemConsulta dtoMensagem;
	private List<DTOMensagemConsulta> mensagens;
	
	
	HttpServletRequest request;
	HttpServletResponse response;
	ServletContext context;
	HttpSession session;

	public MensagemAction() {
		dtoMensagem = new DTOMensagemConsulta();
	}
	
	@Override
	public DTOMensagemConsulta getModel() {
		return dtoMensagem;
	}
	
	public void init(){
		request = (HttpServletRequest) ActionContext.getContext().
				get(ServletActionContext.HTTP_REQUEST);
		response = (HttpServletResponse) ActionContext.getContext().
				get(ServletActionContext.HTTP_RESPONSE);
	}

	public DTOMensagemConsulta getDtoMensagem() {
		return dtoMensagem;
	}

	public void setDtoMensagem(DTOMensagemConsulta dtoMensagem) {
		this.dtoMensagem = dtoMensagem;
	}

	public List<DTOMensagemConsulta> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<DTOMensagemConsulta> mensagens) {
		this.mensagens = mensagens;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DTOMensagemConsulta> getMensagens(Usuario u) {
		try {
			mensagens = new MensagemDao().findByUsuario(u);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mensagens;
	}
	
	public String aceitarMensagem(){
		init();
		try{
		session = request.getSession(true);
		Grupo g = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		new MensagemDao().aceitarMensagemGrupo(usuario, g);
		
		session.setAttribute("usuario", usuario);
		GrupoAction ga = new GrupoAction();
		MensagemAction ma = new MensagemAction();
		request.setAttribute("usuariosGrupos", ga.getUsuariosGrupos());
		request.setAttribute("mensagens", ma.getMensagens(usuario));
		
		return SUCCESS;
		
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
			
		}
	}
	
	public String deletarMensagem(){
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		new MensagemDao().delete(new Integer(request.getParameter("idMensagem")));
		session.setAttribute("usuario", usuario);
		GrupoAction ga = new GrupoAction();
		MensagemAction ma = new MensagemAction();
		request.setAttribute("usuariosGrupos", ga.getUsuariosGrupos());
		request.setAttribute("mensagens", ma.getMensagens(usuario));
		
		return SUCCESS;
		
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
			
		}
	}

	
	
}
