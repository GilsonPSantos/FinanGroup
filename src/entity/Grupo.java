package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Comparable<Grupo>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idGrupo;
	private String nome;
	private Integer status; //0 para inativo e 1 para ativo
	private Usuario usuario;
	
	
	public Grupo() {
	}

	public Grupo(Integer idGrupo, String nome, Integer status) {
		super();
		this.idGrupo = idGrupo;
		this.nome = nome;
		this.status = status;
	}

	public Grupo(Integer idGrupo, String nome, Integer status, Usuario usuario) {
		super();
		this.idGrupo = idGrupo;
		this.nome = nome;
		this.status = status;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nome=" + nome + "]";
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public int compareTo(Grupo g) {
		return this.idGrupo.compareTo(g.getIdGrupo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGrupo == null) ? 0 : idGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (idGrupo == null) {
			if (other.idGrupo != null)
				return false;
		} else if (!idGrupo.equals(other.idGrupo))
			return false;
		return true;
	}
	
	

}
