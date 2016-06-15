package persistence;

import entity.Grupo;
import entity.Lancamento;
import entity.Usuario;

public class LancamentoDao extends Dao {
	
	public void create (Usuario u,Grupo g, Lancamento l) throws Exception{
		open();
			call = con.prepareCall("call adicionaLancamentoGrupo (?,?,?,?,?,?,?)");
			call.setInt(1, u.getIdUsuario());
			call.setInt(2, g.getIdGrupo());
			call.setString(3, l.getNomeLancamento());
			call.setInt(4, l.getTipoLancamento());
			java.sql.Date data = new java.sql.Date(l.getDataLancamento().getTime());
			call.setDate(5, data);
			call.setDouble(6, l.getValorLancamento());
			call.setInt(7, 1);
			call.execute();
			call.close();
		close();	
	}
	
	public void update (Lancamento l) throws Exception{
		open();
			stmt = con.prepareStatement("update lancamento set nomeLancamento = ?,"
						+ " dataLancamento = ?, valorLancamento = ? where idLancamento = ?");
			stmt.setString(1, l.getNomeLancamento());
			java.sql.Date data = new java.sql.Date(l.getDataLancamento().getTime());
			stmt.setDate(2, data);
			stmt.setDouble(3, l.getValorLancamento());
			stmt.setInt(4, l.getIdLancamento());
			stmt.executeUpdate();
			stmt.close();
		close();	
	}
	
	public void delete (Integer cod) throws Exception{
		open();
			stmt = con.prepareStatement("update lancamento set status = 0 where idLancamento = ?");
			stmt.setInt(1, cod);
			stmt.execute();
			stmt.close();
		close();	
	}
	
	public Integer findByUsuarioLancamento(Integer cod) throws Exception{
		open();
		Integer idUsuario=0;
			stmt = con.prepareStatement("select idUsuario from usuario u inner join carteiraGrupo cg on "
					+ "u.idUsuario = cg.id_usuario where id_lancamento = ?");
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();
			if(rs.next()){
				idUsuario = rs.getInt(1);
			}
		stmt.close();
		close();
		return idUsuario;		
	}
	
	
	public Lancamento findById(Integer idLancamento) throws Exception{
		open();
			stmt = con.prepareStatement("select * from lancamento where idLancamento = ?");
			stmt.setInt(1, idLancamento);
			rs = stmt.executeQuery();
			Lancamento lancamento = null;
			if(rs.next()){
				lancamento = new Lancamento();
				lancamento.setIdLancamento(rs.getInt(1));
				lancamento.setNomeLancamento(rs.getString(2));
				lancamento.setTipoLancamento(rs.getInt(3));
				lancamento.setDataLancamento(rs.getDate(4));
				lancamento.setValorLancamento(rs.getDouble(5));
				lancamento.setStatus(rs.getInt(6));
			}
		stmt.close();
		close();
		return lancamento;
	}
	
	

}
