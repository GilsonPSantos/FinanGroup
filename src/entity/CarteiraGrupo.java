package entity;

import java.io.Serializable;
import java.util.List;

public class CarteiraGrupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private List<Lancamento> lancamentos;
	private Grupo grupo;
	
	public CarteiraGrupo() {
	}

	public CarteiraGrupo(List<Usuario> usuarios, List<Lancamento> lancamentos, Grupo grupo) {
		super();
		this.usuarios = usuarios;
		this.lancamentos = lancamentos;
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "CarteiraGrupo [usuarios=" + usuarios + ", lancamentos=" + lancamentos + ", grupo=" + grupo + "]";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
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
