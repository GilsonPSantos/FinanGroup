package dto;

import java.io.Serializable;

public class DTOMensagemConsulta implements Serializable, Comparable<DTOMensagemConsulta> {

	private static final long serialVersionUID = 1L;
	private String nomeUsuarioOrigem;
	private Integer idGrupo;
	private String nomeGrupo;
	private String mensagem;
	private Integer idMensagem;
	
	@Override
	public String toString() {
		return "DTOMensagemConsulta [nomeUsuarioOrigem=" + nomeUsuarioOrigem + ", idGrupo=" + idGrupo + ", nomeGrupo="
				+ nomeGrupo + ", mensagem=" + mensagem + ", idMensagem=" + idMensagem + "]";
	}

	public String getNomeUsuarioOrigem() {
		return nomeUsuarioOrigem;
	}

	public void setNomeUsuarioOrigem(String nomeUsuarioOrigem) {
		this.nomeUsuarioOrigem = nomeUsuarioOrigem;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())
			return false;
		DTOMensagemConsulta dto = (DTOMensagemConsulta) o;
		return this.nomeUsuarioOrigem.equals(dto.getNomeUsuarioOrigem());
	}
	
	@Override
	public int compareTo(DTOMensagemConsulta dto){
		return this.nomeUsuarioOrigem.compareTo(dto.getNomeUsuarioOrigem());
	}
		
	
	
	
}
