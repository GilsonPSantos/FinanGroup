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

import dto.DTODespesasGrupo;
import dto.DTOGruposUsuario;
import dto.DTOReceitasGrupo;
import dto.DTOUusariosGrupo;
import entity.Grupo;
import entity.Usuario;
import persistence.DTODao;
import persistence.GrupoDao;

public class GrupoAction extends ActionSupport implements ModelDriven<Grupo> {

	private static final long serialVersionUID = 1L;
	private Grupo grupo;
	private List<DTOGruposUsuario> usuariosGrupos;
	private List<DTODespesasGrupo> despesasGrupos;
	private List<DTOReceitasGrupo> receitasGrupos;
	HttpServletRequest request;
	HttpServletResponse response;
	ServletContext context;
	HttpSession session;
	
	public GrupoAction() {
		grupo = new Grupo();
	}
	
	public void init(){
		request = (HttpServletRequest) ActionContext.getContext().
				get(ServletActionContext.HTTP_REQUEST);
		response = (HttpServletResponse) ActionContext.getContext().
				get(ServletActionContext.HTTP_RESPONSE);
	}

	@Override
	public Grupo getModel() {
		return grupo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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
		
	public List<DTOGruposUsuario> getUsuariosGrupos() {
		
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuariosGrupos = new DTODao().findByUsuario(usuario);
		
		if(!usuariosGrupos.isEmpty()){
			
		//session.setAttribute("dtoGrupos", usuariosGrupos);
		
		}else{
			request.setAttribute("msgListaGrupo", "Você não possui grupos..");
			
		}
		}catch(Exception ex){
			request.setAttribute("msgListaGrupo", "Error : " + ex.getMessage());
			
		}
		
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(List<DTOGruposUsuario> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public List<DTOReceitasGrupo> getReceitasGrupos() {
		
		return receitasGrupos;
	}

	public void setReceitasGrupos(List<DTOReceitasGrupo> receitasGrupos) {
		this.receitasGrupos = receitasGrupos;
	}

	public List<DTODespesasGrupo> getDespesasGrupos() {
		return despesasGrupos;
	}

	public void setDespesasGrupos(List<DTODespesasGrupo> despesasGrupos) {
		this.despesasGrupos = despesasGrupos;
	}

	public String cadastrar(){
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(grupo.getNome()!=null){
		new GrupoDao().create(usuario, grupo);
		grupo = new Grupo();
		getUsuariosGrupos();
		request.setAttribute("msgGrupo", "Grupo criado com sucesso...");
		MensagemAction ma = new MensagemAction();
		request.setAttribute("mensagens", ma.getMensagens(usuario));
		return SUCCESS;
		}else{
			return ERROR;
		}
		}catch(Exception ex){
			request.setAttribute("msgGrupo", "Error : " + ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String linkAlterar(){
		init();
		try{
		//session = request.getSession(true);
		//Usuario usuario = (Usuario) session.getAttribute("usuario");
		grupo = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
		getGrupo();
		return SUCCESS;
		}catch(Exception ex){
			request.setAttribute("msgAlterar", "Error : " + ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String alterar(){
		init();
		try{
		//session = request.getSession(true);
		//Usuario usuario = (Usuario) session.getAttribute("usuario");
		new GrupoDao().update(grupo);
		request.setAttribute("msgAlterar", "Alteração efetuada com sucesso! Clique em Home para voltar a tela inicial");
		return SUCCESS;
		}catch(Exception ex){
			request.setAttribute("msgAlterar", "Error : " + ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String deletar(){
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		grupo = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));	
		new GrupoDao().delete(grupo);
		
		session.setAttribute("usuario", usuario);
		MensagemAction ma = new MensagemAction();
		request.setAttribute("usuariosGrupos", getUsuariosGrupos());
		request.setAttribute("mensagens", ma.getMensagens(usuario));
		
		return SUCCESS;
		}catch(Exception ex){
			request.setAttribute("msgAlterar", "Error : " + ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	public String listaGrupo(){
		init();
		try{
		session = request.getSession(true);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuariosGrupos = new DTODao().findByUsuario(usuario);
		if(!usuariosGrupos.isEmpty()){
		session.setAttribute("dtoGrupos", usuariosGrupos);
		return SUCCESS;
		}else{
			request.setAttribute("msgListaGrupo", "Você não possui grupos..");
			return ERROR;
		}
		}catch(Exception ex){
			request.setAttribute("msgListaGrupo", "Error : " + ex.getMessage());
			return ERROR;
		}
	}
	
	public String linkTelaGrupo(){
		init();
		
		try{
			session = request.getSession(true);
		Integer idGrupo = new Integer(request.getParameter("idGrupo"));
		
		//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
			ControleDespesasReceitas cdr = new ControleDespesasReceitas();
			receitasGrupos = cdr.listaReceitasMes(new DTODao().findByReceitas(idGrupo));
			Double totalReceitas = cdr.totalReceitas(receitasGrupos);
			request.setAttribute("totalReceitas", totalReceitas);
			
		//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
			despesasGrupos = cdr.listaDespesasMes(new DTODao().findByDespesas(idGrupo));
			Double totalDespesas =cdr.totalDespesas(despesasGrupos);
			request.setAttribute("despesasGrupos", despesasGrupos);
			request.setAttribute("totalDespesas", totalDespesas);
			
		//Achar o percentual de comprometimento da renda e envia
			Double percRenda = (totalDespesas * 100)/totalReceitas;
			request.setAttribute("percRenda", percRenda.intValue());
			
		GrupoDao gd = new GrupoDao();
		Grupo grupologado = gd.findById(idGrupo);
		session.setAttribute("grupologado", grupologado);
		
		session.setAttribute("usuarioCriador", gd.findByIdUsuarioCriador(grupologado));
		
		
		List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(grupologado);
		request.setAttribute("usuariosGrupo", usuariosGrupo);
		
					
		return SUCCESS;
		}catch(Exception ex){
			return ERROR;
		}
		
	}

}
