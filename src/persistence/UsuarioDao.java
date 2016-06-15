package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao{
	
	public void create(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("insert into usuario values(seq_usuario.nextval,?,?,?,?,?)");
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getSenha());
			stmt.setString(4, u.getCelular());
			stmt.setInt(5, 1);
			stmt.execute();
			stmt.close();
		close();
	}
	
	public void update(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("update usuario set nomeUsuario = ?, email = ?, celular = ?"
										+ " where idUsuario = ?");
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getCelular());
			stmt.setInt(4, u.getIdUsuario());
			stmt.executeUpdate();
			stmt.close();
		close();
	}
	
	public void delete(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("update usuario set ativo = 0 where idUsuario = ?");
			stmt.setInt(1, u.getIdUsuario());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public Usuario findByCode(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("select * from usuario where idUsuario = ?");
			stmt.setInt(1, u.getIdUsuario());
			rs = stmt.executeQuery();
			Usuario u2 = null;
			if(rs.next()){
				u2 = new Usuario();
				u2.setIdUsuario(rs.getInt(1));
				u2.setNome(rs.getString(2));
				u2.setEmail(rs.getString(3));
				u2.setSenha(rs.getString(4));
				u2.setCelular(rs.getString(5));
				u2.setAtivo(rs.getInt(6));
			}
			stmt.close();
		close();
		return u2;
	}
	
	public Usuario findById(Integer cod) throws Exception{
		open();
			stmt = con.prepareStatement("select * from usuario where idUsuario = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			Usuario u2 = null;
			if(rs.next()){
				u2 = new Usuario();
				u2.setIdUsuario(rs.getInt(1));
				u2.setNome(rs.getString(2));
				u2.setEmail(rs.getString(3));
				u2.setSenha(rs.getString(4));
				u2.setCelular(rs.getString(5));
				u2.setAtivo(rs.getInt(6));
			}
			stmt.close();
		close();
		return u2;
	}
	
	public Usuario findByEmail(String email) throws Exception{
		open();
			stmt = con.prepareStatement("select * from usuario where email = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			Usuario u = null;
			if(rs.next()){
				u = new Usuario();
				u.setIdUsuario(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setSenha(rs.getString(4));
				u.setCelular(rs.getString(5));
				u.setAtivo(rs.getInt(6));
			}
			stmt.close();
		close();
		return u;
	}
	
	public Usuario findByLogin(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("select * from usuario where email = ? and senha = ? and ativo = 1");
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getSenha());
			rs = stmt.executeQuery();
			Usuario resp = null;
			if(rs.next()){
				resp = new Usuario();
				resp.setIdUsuario(rs.getInt(1));
				resp.setNome(rs.getString(2));
				resp.setEmail(rs.getString(3));
				resp.setSenha(rs.getString(4));
				resp.setCelular(rs.getString(5));
				resp.setAtivo(rs.getInt(6));
			}
			stmt.close();
		close();
		return resp;
	}
	
	public List<Usuario> findAll() throws Exception{
		open();
			stmt = con.prepareStatement("select * from usuario where ativo = 1");
			rs = stmt.executeQuery();
			List<Usuario> lista = new ArrayList<Usuario>();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setIdUsuario(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setSenha(rs.getString(4));
				u.setCelular(rs.getString(5));
				u.setAtivo(rs.getInt(6));
				lista.add(u);
			}
			stmt.close();
		close();
		return lista;
	}

}
