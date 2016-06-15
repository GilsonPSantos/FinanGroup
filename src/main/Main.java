package main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.ControleDespesasReceitas;
import control.Criptografia;
import entity.Grupo;
import entity.Lancamento;
import entity.Mensagem;
import entity.Usuario;
import io.ArquivoCSV;
import io.GerarRelatorioPDF;
import io.GerarRelatorioPDFJasper;
import persistence.DTODao;
import persistence.GrupoDao;
import persistence.LancamentoDao;
import persistence.MensagemDao;
import persistence.UsuarioDao;

public class Main {
	
	public static void main(String[] args) {
		
		Usuario u = new Usuario(1,"Pedro","pedro@gmail.com", "1234", null,null);
		
		Grupo g = new Grupo(7, "MARIO PEDRO",1);
		Mensagem msg = new Mensagem(null, "aceita?", 1, g,u);
		Lancamento l = new Lancamento(null, "luz", 1, new Date(), 150., 1);
		
		try {
			//new UsuarioDao().create(u);
			//new GrupoDao().create(u, g);
			//new MensagemDao().create(u, g, msg);
			//new MensagemDao().aceitarMensagemGrupo(u, g);
			//new LancamentoDao().create(u,g, l);
			//new LancamentoDao().delete(1);
			//new Criptografia().criptografaSenha(u);
			//System.out.println(new UsuarioDao().findByLogin(u));
			//new UsuarioDao().update(u);
			
			//System.out.println("Gravado..." + new UsuarioDao().findByCode(u));
			
			//System.out.println(new DTOUsuarioGrupoDao().findByUsuario(u));
			//Grupo g3 = new GrupoDao().findById(7);
			//System.out.println(g3 + " Usuario que criou : " + g3.getUsuario());
			
			//System.out.println("Gravado");
			
			//System.out.println(new DTODao().findByDespesas(1));
			
			//System.out.println(new MensagemDao().findByUsuario(u));
			
			//new GrupoDao().update(g);
			//ControleDespesasReceitas ct = new ControleDespesasReceitas();
			//System.out.println(ct.totalReceitas(new DTODao().findByReceitas(26)) );
			
			//System.out.println("gravado");
			
			/*ArquivoCSV csv = new ArquivoCSV();
			csv.open();
			csv.writerDespesas(new DTODao().findByDespesas(1));
			csv.writerReceitas(new DTODao().findByReceitas(1));
			csv.close();*/
//			GerarRelatorioPDF pdf = new GerarRelatorioPDF();
//			pdf.gerarPDF(new DTODao().findByReceitas(1), new DTODao().findByDespesas(1));
//			System.out.println("ok");
			
			//new GerarRelatorioPDFJasper().createPdfReceitas(1);
			//new GerarRelatorioPDFJasper().createPdfDespesas(1 );
			
//			Double n = 1123.0;
//			DecimalFormat df = new DecimalFormat("0.00");
//			String n1 = df.format(n);
//			System.out.println(n1);
			
			
//			Date data = new Date();
//			System.out.println(data);
//			String data2 = new SimpleDateFormat("dd/MM/yyyy").format(data);
//			System.out.println(data2);
			
			
			//System.out.println(new LancamentoDao().findById(10));
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		
		
	}

}
