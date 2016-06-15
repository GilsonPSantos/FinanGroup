package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Usuario implements Comparable<Usuario>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String celular;
	private Integer ativo;//0 - Inativo e 1 - Ativo
	private List<Grupo> grupos;
	private List<Usuario_Grupo> usuariosGrupos;
		
	public Usuario() {
	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, String celular, Integer ativo) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", celular=" + celular
				+ ", ativo=" + ativo + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isOkNome(){
		if(this.nome == null)
			return false;
		Pattern p = Pattern.compile("[a-z A-Z]{2,30}");
		Matcher m = p.matcher(this.nome);
		return m.matches();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isOkEmail(){
		if(this.email == null)
			return false;
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(this.email);
		return m.matches();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isOkSenha(){
		if(this.senha == null)
			return false;
		Pattern p = Pattern.compile("[a-zA-Z0-9]{4,10}");
		Matcher m = p.matcher(this.senha);
		return m.matches();
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public boolean isOkCelular(){
		if(this.celular == null)
			return false;
		Pattern p = Pattern.compile("[0-9]{8,11}");
		Matcher m = p.matcher(this.celular);
		return m.matches();
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	public boolean isOkAtivo(){
		if(this.ativo == null)
			return false;
		if(this.ativo != 0 | this.ativo != 1)
			return false;
		return true;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public List<Usuario_Grupo> getUsuariosGrupos() {
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(List<Usuario_Grupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return String.valueOf(this.idUsuario).length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario u = (Usuario) obj;
		if (idUsuario == null) {
			if (u.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(u.idUsuario))
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario u){
		return this.idUsuario.compareTo(u.getIdUsuario());
	}
	
	public void adicionarGrupo(Grupo g){
		if(grupos == null)
			grupos = new ArrayList<Grupo>();
		if(usuariosGrupos == null)
			usuariosGrupos = new ArrayList<Usuario_Grupo>();
		grupos.add(g);
		usuariosGrupos.add(new Usuario_Grupo(this,g));
	}
	
	

}
