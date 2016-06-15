package io;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import dto.DTODespesasGrupo;
import dto.DTOReceitasGrupo;

public class ArquivoCSV implements IArquivo<Object> {

	FileWriter fwReceitas;
	FileWriter fwDespesas;
	
	@Override
	public void open() throws Exception {
		File f1 = new File("c:/relatoriosCSV/relatorioDespesas.csv");
		File f2 = new File("c:/relatoriosCSV/relatorioReceitas.csv");
		f1.mkdirs();
		f2.mkdir();
		f1.delete();
		f2.delete();
		fwDespesas = new FileWriter(f1,false);
		fwReceitas = new FileWriter(f2,false);

	}

	@Override
	public void close() throws Exception {
		fwReceitas.close();
		fwDespesas.close();
	}

	@Override
	public void writerDespesas(List<DTODespesasGrupo> despesas) throws Exception {
		for(DTODespesasGrupo dto : despesas){
			fwDespesas.write(dto + "\n");
			fwDespesas.flush();
		}
		
	}

	@Override
	public void writerReceitas(List<DTOReceitasGrupo> receitas) throws Exception {
		for(DTOReceitasGrupo dto : receitas){
			fwReceitas.write(dto + "\n");
			fwReceitas.flush();
		}
	}
	
	public void execute() throws Exception{
		try{	
			String arg[]=
		{"C:\\Program Files (x86)\\Microsoft Office\\Office15\\excel.exe",
	     "c:\\relatoriosCSV\\relatorioDespesas.csv", "c:\\relatoriosCSV\\relatorioReceitas.csv"};
			 Runtime rt = Runtime.getRuntime();
			 Process p = rt.exec(arg);

		}catch(Exception ex){
			System.out.println("Error :" + ex.getMessage());
		}
	}


}
