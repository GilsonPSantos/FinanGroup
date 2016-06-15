package io;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.DTODao;

public class GerarRelatorioPDFJasper {
	
	private static final long serialVersionUID = 1L;
	//ServletContext context;
	HttpServletResponse response;
	
	
	public void createPdfReceitas (Integer idGrupo) throws Exception{

		Map<String,Object> parametro = new HashMap<String, Object>();
		parametro.put("idGrupo", idGrupo);
		
		DTODao d = new DTODao();
		JRResultSetDataSource jrrs = new JRResultSetDataSource(d.findByReceitasRelatorio(idGrupo));
		
		byte arquivo[] = JasperRunManager.runReportToPdf("C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\receitas2.jasper", parametro, jrrs);
		
		FileOutputStream fileOuputStream = 
				new FileOutputStream("C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\receitas.pdf"); 
               
	    fileOuputStream.write(arquivo);
	    fileOuputStream.close();

	    try{	
			String arg[]=
		{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
	     "C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\receitas.pdf"};
			 Runtime rt = Runtime.getRuntime();
			 Process p = rt.exec(arg);

		}catch(Exception ex){
			System.out.println("Error :" + ex.getMessage());
		}
		
	}
	
	
	public void createPdfDespesas (Integer idGrupo) throws Exception{

		Map<String,Object> parametro = new HashMap<String, Object>();
		parametro.put("idGrupo", idGrupo);
		
		
		DTODao d = new DTODao();
		JRResultSetDataSource jrrs = new JRResultSetDataSource(d.findByDespesasRelatorio(idGrupo));
		
		byte arquivo[] = JasperRunManager.runReportToPdf("C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\despesas.jasper", parametro, jrrs);
		
		FileOutputStream fileOuputStream = 
				new FileOutputStream("C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\despesas.pdf"); 
               
	    fileOuputStream.write(arquivo);
	    fileOuputStream.close();

	    try{	
			String arg[]=
		{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
	     "C:\\MyWork_New_Brq\\projetoFinalBrq_14\\WebContent\\relatorios\\despesas.pdf"};
			 Runtime rt = Runtime.getRuntime();
			 Process p = rt.exec(arg);

		}catch(Exception ex){
			System.out.println("Error :" + ex.getMessage());
		}
		
	}
	
	

}
