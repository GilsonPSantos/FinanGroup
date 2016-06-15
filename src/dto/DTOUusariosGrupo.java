package dto;

import java.io.Serializable;

public class DTOUusariosGrupo implements Serializable, Comparable<DTOUusariosGrupo> {
	
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String nomeUsuario;
	private String emailusuario;
	private Integer id_Grupo;
	
	@Override
	public String toString() {
		return "DTOUusariosGrupo [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", emailusuario="
				+ emailusuario + ", id_Grupo=" + id_Grupo + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public Integer getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(Integer id_Grupo) {
		this.id_Grupo = id_Grupo;
	}
	
	@Override
	public int compareTo(DTOUusariosGrupo ug){
		return this.nomeUsuario.compareTo(ug.getNomeUsuario());
	}
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())
			return false;
		DTOUusariosGrupo ug = (DTOUusariosGrupo) o;
		return this.nomeUsuario.equals(ug.getNomeUsuario());
	}

}
