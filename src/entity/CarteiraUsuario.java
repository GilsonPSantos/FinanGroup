package entity;

import java.io.Serializable;
import java.util.List;

public class CarteiraUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Lancamento> lancamentos;
	
	public CarteiraUsuario() {
	}

	public CarteiraUsuario(Usuario usuario, List<Lancamento> lancamentos) {
		super();
		this.usuario = usuario;
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "CarteiraUsuario [usuario=" + usuario + ", lancamentos=" + lancamentos + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
