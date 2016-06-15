package control;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dto.DTODespesasGrupo;
import dto.DTOReceitasGrupo;
import dto.DTOUusariosGrupo;
import entity.Grupo;
import entity.Lancamento;
import entity.Usuario;
import io.ArquivoCSV;
import io.GerarRelatorioPDF;
import io.GerarRelatorioPDFJasper;
import persistence.DTODao;
import persistence.GrupoDao;
import persistence.LancamentoDao;

public class LancamentoAction extends ActionSupport implements ModelDriven<Lancamento> {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession sessao;
	
	private Lancamento lancamento;

	public LancamentoAction() {
		lancamento = new Lancamento();
	}
	
	public void init(){
		
			request = (HttpServletRequest) ActionContext.getContext().
					get(ServletActionContext.HTTP_REQUEST);
			response = (HttpServletResponse) ActionContext.getContext().
					get(ServletActionContext.HTTP_RESPONSE);
	}
	
	@Override
	public Lancamento getModel() {
		return lancamento;
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

	public HttpSession getSessao() {
		return sessao;
	}

	public void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String cadastrar(){
		init();
		try {
			sessao = request.getSession(true);
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			String nomeGrupo = request.getParameter("nomeGrupo");
			Integer idGrupo = new Integer(request.getParameter("idGrupo"));
			
			Grupo g = new GrupoDao().findById(idGrupo);
			Double valorLancamento = new Double(request.getParameter("valorLancamento"));
			
			lancamento.setValorLancamento(valorLancamento);
			new LancamentoDao().create(usuario, g, lancamento);
			//lancamento = new Lancamento();
			request.setAttribute("lancamento", lancamento);
			request.setAttribute("idGrupo", idGrupo);
			request.setAttribute("nomeGrupo", nomeGrupo);
			
			DTODao dto = new DTODao();
			List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
			List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
					
			//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
				ControleDespesasReceitas cdr = new ControleDespesasReceitas();
				receitasGrupos = cdr.listaReceitasMes(new DTODao().findByReceitas(idGrupo));
				Double totalReceitas = cdr.totalReceitas(receitasGrupos);
				request.setAttribute("receitasGrupos", receitasGrupos);
				request.setAttribute("totalReceitas", totalReceitas);
				
			//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
				despesasGrupos = cdr.listaDespesasMes(new DTODao().findByDespesas(idGrupo));
				Double totalDespesas =cdr.totalDespesas(despesasGrupos);
				request.setAttribute("despesasGrupos", despesasGrupos);
				request.setAttribute("totalDespesas", totalDespesas);
				
				//Achar o percentual de comprometimento da renda e envia
				Double percRenda = (totalDespesas * 100)/totalReceitas;
				request.setAttribute("percRenda", percRenda.intValue());
				
				//Após cadastrar um lançamento retorna a lista de usuarios do grupo
				List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
				request.setAttribute("usuariosGrupo", usuariosGrupo);
				
			return SUCCESS;

		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
	
		}
	}
	
	
	public String delete(){
		init();
		
		try {
			
			Integer idLancamento = new Integer(request.getParameter("idLancamento"));
			new LancamentoDao().delete(idLancamento);
			
			Integer idGrupo = new Integer(request.getParameter("idGrupo"));
			Grupo g = new GrupoDao().findById(idGrupo);
			
			DTODao dto = new DTODao();
			List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
			List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
			
			request.setAttribute("lancamento", lancamento);
			request.setAttribute("idGrupo", idGrupo);
			request.setAttribute("nomeGrupo", g.getNome());
			
			//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
			ControleDespesasReceitas cdr = new ControleDespesasReceitas();
			receitasGrupos = cdr.listaReceitasMes(new DTODao().findByReceitas(idGrupo));
			Double totalReceitas = cdr.totalReceitas(receitasGrupos);
			request.setAttribute("receitasGrupos", receitasGrupos);
			request.setAttribute("totalReceitas", totalReceitas);
			
		//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
			despesasGrupos = cdr.listaDespesasMes(new DTODao().findByDespesas(idGrupo));
			Double totalDespesas =cdr.totalDespesas(despesasGrupos);
			request.setAttribute("despesasGrupos", despesasGrupos);
			request.setAttribute("totalDespesas", totalDespesas);	
			
		//Achar o percentual de comprometimento da renda e envia
			Double percRenda = (totalDespesas * 100)/totalReceitas;
			request.setAttribute("percRenda", percRenda.intValue());
			
		//Após cadastrar um lançamento retorna a lista de usuarios do grupo
			List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
			request.setAttribute("usuariosGrupo", usuariosGrupo);

			return SUCCESS;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
			
		}
	}
	
	
	public String alterar(){
		init();
		try {
			//lancamento.setDataLancamento(request.getParameter("data"));
			lancamento.setValorLancamento(new Double(request.getParameter("valorLancamento")));
			new LancamentoDao().update(lancamento);
			request.setAttribute("msgLancamento", "Lancamento alterado com sucesso");
			System.out.println(lancamento);
			return SUCCESS;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("msgLancamento", "Error : " + ex.getMessage());
			return ERROR;
		}
	}
	
	
	public String linkAlterar(){
		init();
		try{
		Integer idLancamento = new Integer(request.getParameter("idLancamento"));
		lancamento = new LancamentoDao().findById(idLancamento);
		getLancamento();
		request.setAttribute("lancamento", getLancamento());
		
		return SUCCESS;
		
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
			
	}
	
	
	
	public String relatorioPdf(){
		
		init();
		try {
			sessao = request.getSession(true);
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			String nomeGrupo = request.getParameter("nomeGrupo");
			Integer idGrupo = new Integer(request.getParameter("idGrupo"));
			
			request.setAttribute("lancamento", lancamento);
			request.setAttribute("idGrupo", idGrupo);
			request.setAttribute("nomeGrupo", nomeGrupo);
			
			DTODao dto = new DTODao();
			List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
			List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
					
			//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
				ControleDespesasReceitas cdr = new ControleDespesasReceitas();
				receitasGrupos = cdr.listaReceitasMes(receitasGrupos);
				Double totalReceitas = cdr.totalReceitas(receitasGrupos);
				request.setAttribute("receitasGrupos", receitasGrupos);
				request.setAttribute("totalReceitas", totalReceitas);
				
			//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
				despesasGrupos = cdr.listaDespesasMes(despesasGrupos);
				Double totalDespesas =cdr.totalDespesas(despesasGrupos);
				request.setAttribute("despesasGrupos", despesasGrupos);
				request.setAttribute("totalDespesas", totalDespesas);	
				
				//Após cadastrar um lançamento retorna a lista de usuarios do grupo
				Grupo g = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
				List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
				request.setAttribute("usuariosGrupo", usuariosGrupo);
				
				//Gerar o relatório
				GerarRelatorioPDF pdf = new GerarRelatorioPDF();
				pdf.gerarPDF(receitasGrupos, despesasGrupos);
				
				//Achar o percentual de comprometimento da renda e envia
				Double percRenda = (totalDespesas * 100)/totalReceitas;
				request.setAttribute("percRenda", percRenda.intValue());
				
				
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
	
		}
		
		
	}
	
	public String relatorioPdfIreportDespesas(){
		
		init();
		try {
			sessao = request.getSession(true);
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			String nomeGrupo = request.getParameter("nomeGrupo");
			Integer idGrupo = new Integer(request.getParameter("idGrupo"));
			
			request.setAttribute("lancamento", lancamento);
			request.setAttribute("idGrupo", idGrupo);
			request.setAttribute("nomeGrupo", nomeGrupo);
			
			DTODao dto = new DTODao();
			List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
			List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
					
			//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
				ControleDespesasReceitas cdr = new ControleDespesasReceitas();
				receitasGrupos = cdr.listaReceitasMes(receitasGrupos);
				Double totalReceitas = cdr.totalReceitas(receitasGrupos);
				request.setAttribute("receitasGrupos", receitasGrupos);
				request.setAttribute("totalReceitas", totalReceitas);
				
			//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
				despesasGrupos = cdr.listaDespesasMes(despesasGrupos);
				Double totalDespesas =cdr.totalDespesas(despesasGrupos);
				request.setAttribute("despesasGrupos", despesasGrupos);
				request.setAttribute("totalDespesas", totalDespesas);	
				
				//Após cadastrar um lançamento retorna a lista de usuarios do grupo
				Grupo g = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
				List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
				request.setAttribute("usuariosGrupo", usuariosGrupo);
				
				//Gerar o relatório
				GerarRelatorioPDFJasper pdf = new GerarRelatorioPDFJasper();
				pdf.createPdfDespesas(idGrupo);
				
				//Achar o percentual de comprometimento da renda e envia
				Double percRenda = (totalDespesas * 100)/totalReceitas;
				request.setAttribute("percRenda", percRenda.intValue());
				
				
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
	
		}
		
		
	}
	

public String relatorioPdfIreportReceitas(){
	
	init();
	try {
		sessao = request.getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		String nomeGrupo = request.getParameter("nomeGrupo");
		Integer idGrupo = new Integer(request.getParameter("idGrupo"));
		
		request.setAttribute("lancamento", lancamento);
		request.setAttribute("idGrupo", idGrupo);
		request.setAttribute("nomeGrupo", nomeGrupo);
		
		DTODao dto = new DTODao();
		List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
		List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
				
		//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
			ControleDespesasReceitas cdr = new ControleDespesasReceitas();
			receitasGrupos = cdr.listaReceitasMes(receitasGrupos);
			Double totalReceitas = cdr.totalReceitas(receitasGrupos);
			request.setAttribute("receitasGrupos", receitasGrupos);
			request.setAttribute("totalReceitas", totalReceitas);
			
		//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
			despesasGrupos = cdr.listaDespesasMes(despesasGrupos);
			Double totalDespesas =cdr.totalDespesas(despesasGrupos);
			request.setAttribute("despesasGrupos", despesasGrupos);
			request.setAttribute("totalDespesas", totalDespesas);	
			
			//Após cadastrar um lançamento retorna a lista de usuarios do grupo
			Grupo g = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
			List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
			request.setAttribute("usuariosGrupo", usuariosGrupo);
			
			//Gerar o relatório
			GerarRelatorioPDFJasper pdf = new GerarRelatorioPDFJasper();
			pdf.createPdfReceitas(idGrupo);
			
			//Achar o percentual de comprometimento da renda e envia
			Double percRenda = (totalDespesas * 100)/totalReceitas;
			request.setAttribute("percRenda", percRenda.intValue());
			
			
		return SUCCESS;
	} catch (Exception ex) {
		ex.printStackTrace();
		return ERROR;

	}
	
	
}
	
public String relatorioCsv(){
		
		init();
		try {
			sessao = request.getSession(true);
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			String nomeGrupo = request.getParameter("nomeGrupo");
			Integer idGrupo = new Integer(request.getParameter("idGrupo"));
			
			request.setAttribute("lancamento", lancamento);
			request.setAttribute("idGrupo", idGrupo);
			request.setAttribute("nomeGrupo", nomeGrupo);
			
			DTODao dto = new DTODao();
			List<DTODespesasGrupo>	despesasGrupos = dto.findByDespesas(idGrupo);
			List<DTOReceitasGrupo>	receitasGrupos = dto.findByReceitas(idGrupo);
					
			//Pega a lista de receitas do banco, usa o controle para só listar as receitas do mês corrente e pega o total
				ControleDespesasReceitas cdr = new ControleDespesasReceitas();
				receitasGrupos = cdr.listaReceitasMes(receitasGrupos);
				Double totalReceitas = cdr.totalReceitas(receitasGrupos);
				request.setAttribute("receitasGrupos", receitasGrupos);
				request.setAttribute("totalReceitas", totalReceitas);
				
			//Pega a lista de despesas do banco, usa o controle para só listar as despesas do mês corrente e pega o total
				despesasGrupos = cdr.listaDespesasMes(despesasGrupos);
				Double totalDespesas =cdr.totalDespesas(despesasGrupos);
				request.setAttribute("despesasGrupos", despesasGrupos);
				request.setAttribute("totalDespesas", totalDespesas);	
				
				//Após cadastrar um lançamento retorna a lista de usuarios do grupo
				Grupo g = new GrupoDao().findById(new Integer(request.getParameter("idGrupo")));
				List <DTOUusariosGrupo> usuariosGrupo = new DTODao().findByUsuariosGrupo(g);
				request.setAttribute("usuariosGrupo", usuariosGrupo);
				
				//Achar o percentual de comprometimento da renda e envia
				Double percRenda = (totalDespesas * 100)/totalReceitas;
				request.setAttribute("percRenda", percRenda.intValue());
				
				//Gerar o relatório
				ArquivoCSV csv = new ArquivoCSV();
				csv.open();
				csv.writerDespesas(despesasGrupos);
				csv.writerReceitas(receitasGrupos);
				csv.close();
				csv.execute();
				
				
			return SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
	
		}
		
		
	}
	
	
	

}
