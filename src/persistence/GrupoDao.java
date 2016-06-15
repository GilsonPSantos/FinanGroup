package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Grupo;
import entity.Usuario;

public class GrupoDao extends Dao {
	
	public void create(Usuario u, Grupo g) throws Exception{
		open();
			call = con.prepareCall("call criarGrupo (?,?,?)");
			call.setInt(1, u.getIdUsuario());
			call.setString(2, g.getNome());
			call.setInt(3, 1);
			call.execute();
			call.close();
		close();
	}
	
	public void update(Grupo g) throws Exception{
		open();
			stmt = con.prepareStatement("update grupo set nomeGrupo = ? where idGrupo = ?");
			stmt.setString(1, g.getNome());
			stmt.setInt(2, g.getIdGrupo());
			stmt.executeUpdate();
			stmt.close();
		close();
	}
	
	public void delete(Grupo g) throws Exception{
		open();
			stmt = con.prepareStatement("update grupo set status = 0 where idGrupo = ?");
			stmt.setInt(1, g.getIdGrupo());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public List<Grupo> findByUsuario(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("select * from grupo where id_usuario = ? and status = 1");
			stmt.setInt(1, u.getIdUsuario());
			rs = stmt.executeQuery();
			List<Grupo> lista = new ArrayList<Grupo>();
			while(rs.next()){
				Grupo g = new Grupo();
				g.setIdGrupo(rs.getInt(1));
				g.setNome(rs.getString(2));
				g.setStatus(rs.getInt(3));
				lista.add(g);
			}
			stmt.close();
		close();
		return lista;
	}
	public Grupo findById(Integer cod) throws Exception{
		open();
			stmt = con.prepareStatement("select * from grupo where idGrupo = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			Grupo g = null;
			if(rs.next()){
				g = new Grupo();
				g.setIdGrupo(rs.getInt(1));
				g.setNome(rs.getString(2));
				g.setStatus(rs.getInt(3));
				g.setUsuario(new UsuarioDao().findById(rs.getInt(4)));
			}
			stmt.close();
		close();
		return g;
	}
	
		public Integer findByIdUsuarioCriador(Grupo g) throws Exception{
			Integer cod = null;
		open();
			stmt = con.prepareStatement("select idUsuario from usuario u inner join grupo g on "
										+ "u.idUsuario = g.id_usuario where g.idGrupo = ?");
			stmt.setInt(1, g.getIdGrupo());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				cod = rs.getInt(1);
			}
			stmt.close();
		close();
		return cod;
	}
	
	
	

}
