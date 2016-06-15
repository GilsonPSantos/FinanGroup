package entity;

import java.io.Serializable;
import java.util.Date;

public class Lancamento implements Serializable, Comparable<Lancamento> {
	
	private static final long serialVersionUID = 1L;
	private Integer idLancamento;
	private String nomeLancamento;
	private Integer tipoLancamento; // 0 para receita e 1 para despesa.
	private Date dataLancamento; //Se for receita a data é a atual e se for despesa essa data é a de vencimento
	private Double valorLancamento;
	private Integer status; //1 para Ativo e 0 para inativo
	
	public Lancamento() {
	}

	public Lancamento(Integer idLancamento, String nomeLancamento, Integer tipoLancamento, Date dataLancamento,
			Double valorLancamento, Integer status) {
		super();
		this.idLancamento = idLancamento;
		this.nomeLancamento = nomeLancamento;
		this.tipoLancamento = tipoLancamento;
		this.dataLancamento = dataLancamento;
		this.valorLancamento = valorLancamento;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Lancamento [idLancamento=" + idLancamento + ", nomeLancamento=" + nomeLancamento + ", tipoLancamento="
				+ tipoLancamento + ", dataLancamento=" + dataLancamento + ", valorLancamento=" + valorLancamento
				+ ", status=" + status + "]";
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

	public Integer getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(Integer tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int compareTo(Lancamento l) {
		return this.idLancamento.compareTo(l.getIdLancamento());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLancamento == null) ? 0 : idLancamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (idLancamento == null) {
			if (other.idLancamento != null)
				return false;
		} else if (!idLancamento.equals(other.idLancamento))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
