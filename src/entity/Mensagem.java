package entity;

import java.io.Serializable;

public class Mensagem implements Comparable<Mensagem>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idMensagem;
	private String mensagem;
	private Integer status; //0 para aceita pelo usuário (ativa) e 1 para não aceita(inativa)
	private Grupo grupo;
	private Usuario usuarioDestino;
	
	
	public Mensagem() {
	}

	public Mensagem(Integer idMensagem, String mensagem, Integer status) {
		super();
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.status = status;
	}
	
	public Mensagem(Integer idMensagem, String mensagem, Integer status, Grupo grupo, Usuario usuarioDestino) {
		super();
		this.idMensagem = idMensagem;
		this.mensagem = mensagem;
		this.status = status;
		this.grupo = grupo;
		this.usuarioDestino = usuarioDestino;
	}

	@Override
	public String toString() {
		return "Mensagem [idMensagem=" + idMensagem + ", mensagem=" + mensagem + ", status=" + status + ", grupo="
				+ grupo + ", usuarioDestino=" + usuarioDestino + "]";
	}

	public Integer getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Integer idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

	@Override
	public int compareTo(Mensagem m) {
		return this.idMensagem.compareTo(m.getIdMensagem());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMensagem == null) ? 0 : idMensagem.hashCode());
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
		Mensagem other = (Mensagem) obj;
		if (idMensagem == null) {
			if (other.idMensagem != null)
				return false;
		} else if (!idMensagem.equals(other.idMensagem))
			return false;
		return true;
	}

}
