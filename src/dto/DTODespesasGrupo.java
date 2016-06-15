package dto;

import java.io.Serializable;
import java.util.Date;

public class DTODespesasGrupo implements Serializable, Comparable<DTODespesasGrupo> {
	
	private static final long serialVersionUID = 1L;
	private Integer idLancamento;
	private String nomeLancamento;
	private Date dataVencimento;
	private Double valorLancamento;
	private String usuarioLancador;
		
	{
		valorLancamento = 0.;
	}
	
	@Override
	public String toString() {
		return idLancamento + ";" + nomeLancamento+ ";" + dataVencimento + ";" + valorLancamento + ";"
				+ usuarioLancador;
	}

	public Integer getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(Integer idLancamento) {
		this.idLancamento = idLancamento;
	}

	public String getNomeLancamento() {
		return nomeLancamento;
	}

	public void setNomeLancamento(String nomeLancamento) {
		this.nomeLancamento = nomeLancamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getUsuarioLancador() {
		return usuarioLancador;
	}

	public void setUsuarioLancador(String usuarioLancador) {
		this.usuarioLancador = usuarioLancador;
	}
		
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())
			return false;
		DTODespesasGrupo dto = (DTODespesasGrupo) o;
		return dto.equals(this.dataVencimento);
	}
	
	@Override
	public int compareTo(DTODespesasGrupo dto){
		return this.dataVencimento.compareTo(dto.getDataVencimento());
	}
	
	
}
