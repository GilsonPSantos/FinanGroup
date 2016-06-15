package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.DTODespesasGrupo;
import dto.DTOReceitasGrupo;

public class ControleDespesasReceitas {
	
	
	public Double totalDespesas(List<DTODespesasGrupo> lista){
		Double totalDespesas = 0.;
		for(DTODespesasGrupo dto : lista){
			totalDespesas += dto.getValorLancamento();
		}
		return totalDespesas;
	}
	
	public Double totalReceitas(List<DTOReceitasGrupo> lista){
		Double totalReceitas= 0.;
		for(DTOReceitasGrupo dto : lista){
			totalReceitas += dto.getValorLancamento();
		}
		return totalReceitas;
	}
	
	@SuppressWarnings("deprecation")
	public List<DTODespesasGrupo> listaDespesasMes(List<DTODespesasGrupo> lista){
		
		Date data = new Date();
		new SimpleDateFormat("dd/MM/yyyy").format(data);
		List<DTODespesasGrupo> listaAtual = new ArrayList<DTODespesasGrupo>();
		for(DTODespesasGrupo dto : lista){
			new SimpleDateFormat("dd/MM/yyyy").format(dto.getDataVencimento());
			if(dto.getDataVencimento().getMonth() == data.getMonth() && dto.getDataVencimento().getYear() == data.getYear()){
				listaAtual.add(dto);
			}
		}
		return listaAtual;
		}
	
	@SuppressWarnings("deprecation")
	public List<DTOReceitasGrupo> listaReceitasMes(List<DTOReceitasGrupo> lista){
		
		Date data = new Date();
		new SimpleDateFormat("dd/MM/yyyy").format(data);
		List<DTOReceitasGrupo> listaAtual = new ArrayList<DTOReceitasGrupo>();
		for(DTOReceitasGrupo dto : lista){
			new SimpleDateFormat("dd/MM/yyyy").format(dto.getDataVencimento());
			if(dto.getDataVencimento().getMonth() == data.getMonth() && dto.getDataVencimento().getYear() == data.getYear()){
				listaAtual.add(dto);
			}
		}
		return listaAtual;
		}
	
	

}
