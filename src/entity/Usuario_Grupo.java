package entity;

import java.io.Serializable;


public class Usuario_Grupo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Grupo grupo;
	
	public Usuario_Grupo() {
	}

	public Usuario_Grupo(Usuario usuario, Grupo grupo) {
		super();
		this.usuario = usuario;
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Usuario_Grupo [usuario=" + usuario + ", grupo=" + grupo + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
