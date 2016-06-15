package dto;

import java.io.Serializable;

public class DTOGruposUsuario implements Serializable, Comparable<DTOGruposUsuario> {
	
	private static final long serialVersionUID = 1L;
	private Integer idGrupo;
	private String nomeGrupo;
	private Integer idUsuario;
	private String nomeUsuarioCriador;
	

	@Override
	public String toString() {
		return "DTOUsuarioGrupo [idGrupo=" + idGrupo + ", nomeGrupo=" + nomeGrupo + ", idUsuario=" + idUsuario
				+ ", nomeUsuarioCriador=" + nomeUsuarioCriador + "]";
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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuarioCriador() {
		return nomeUsuarioCriador;
	}
	public void setNomeUsuarioCriador(String nomeUsuarioCriador) {
		this.nomeUsuarioCriador = nomeUsuarioCriador;
	}
	
	@Override
	public int compareTo(DTOGruposUsuario ug){
		return this.nomeGrupo.compareTo(ug.getNomeGrupo());
	}
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())
			return false;
		DTOGruposUsuario ug = (DTOGruposUsuario) o;
		return this.nomeGrupo.equals(ug.getNomeGrupo());
	}
	
	

}
