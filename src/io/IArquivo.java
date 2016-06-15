package io;

import java.util.List;

import dto.DTODespesasGrupo;
import dto.DTOReceitasGrupo;


public interface IArquivo <Classe> {
	
	public void open() throws Exception;
	
	public void close() throws Exception;
	
	public void writerDespesas(List<DTODespesasGrupo> despesas) throws Exception;
	
	public void writerReceitas(List<DTOReceitasGrupo> receitas) throws Exception;
}
