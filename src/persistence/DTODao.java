package persistence;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dto.DTODespesasGrupo;
import dto.DTOGruposUsuario;
import dto.DTOReceitasGrupo;
import dto.DTOUusariosGrupo;
import entity.Grupo;
import entity.Usuario;

public class DTODao extends Dao {

	public List<DTOGruposUsuario> findByUsuario(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("select idGrupo, nomeGrupo,idUsuario, nomeUsuario as usuarioCriador "
										+ "from usuario u inner join grupo g on u.idusuario = g.id_Usuario "
										+ "inner join adicionaUsuario au on au.id_grupo = g.idGrupo where au.id_usuario = ? "
										+ "and g.status = 1");
			stmt.setInt(1, u.getIdUsuario());
			rs = stmt.executeQuery();
			List<DTOGruposUsuario> lista = new ArrayList<DTOGruposUsuario>();
			while(rs.next()){
				DTOGruposUsuario ug = new DTOGruposUsuario();
				ug.setIdGrupo(rs.getInt(1));
				ug.setNomeGrupo(rs.getString(2));
				ug.setIdUsuario(rs.getInt(3));
				ug.setNomeUsuarioCriador(rs.getString(4));
				lista.add(ug);
			}
			stmt.close();
			close();
			Collections.sort(lista);
			return lista;
	}
	
	public List<DTODespesasGrupo> findByDespesas(Integer idGrupo) throws Exception{
		open();
			stmt = con.prepareStatement("select idLancamento, nomeLancamento, dataLancamento, valorlancamento, nomeUsuario as usuarioLancador "
										+ "from lancamento l inner join carteiraGrupo cg on l.idLancamento = cg.id_Lancamento "
										+ "inner join usuario u on cg.id_usuario = u.idUsuario where cg.id_grupo = ?"
										+ "and l.status = 1 and l.tipoLancamento = 1");
			stmt.setInt(1, idGrupo);
			rs = stmt.executeQuery();
			List<DTODespesasGrupo> lista = new ArrayList<DTODespesasGrupo>();
			while(rs.next()){
				DTODespesasGrupo dg = new DTODespesasGrupo();
				dg.setIdLancamento(rs.getInt(1));
				dg.setNomeLancamento(rs.getString(2));
				dg.setDataVencimento(rs.getDate(3));
				dg.setValorLancamento(rs.getDouble(4));
				dg.setUsuarioLancador(rs.getString(5));
				lista.add(dg);
			}
			stmt.close();
			close();
			Collections.sort(lista);
			return lista;
	}
	
	//Find para usar no relatório
	public ResultSet findByDespesasRelatorio(Integer idGrupo) throws Exception{
		open();
			stmt = con.prepareStatement("select idLancamento, nomeLancamento, dataLancamento, valorlancamento, nomeUsuario as usuarioLancador "
										+ "from lancamento l inner join carteiraGrupo cg on l.idLancamento = cg.id_Lancamento "
										+ "inner join usuario u on cg.id_usuario = u.idUsuario where cg.id_grupo = ?"
										+ "and l.status = 1 and l.tipoLancamento = 1");
			stmt.setInt(1, idGrupo);
			rs = stmt.executeQuery();
			return rs;
	}
	
	
	
	
	
	public List<DTOReceitasGrupo> findByReceitas(Integer idGrupo) throws Exception{
		open();
			stmt = con.prepareStatement("select idLancamento, nomeLancamento, dataLancamento, valorlancamento, nomeUsuario as usuarioLancador "
										+ "from lancamento l inner join carteiraGrupo cg on l.idLancamento = cg.id_Lancamento "
										+ "inner join usuario u on cg.id_usuario = u.idUsuario where cg.id_grupo = ?"
										+ "and l.status = 1 and l.tipoLancamento = 0");
			stmt.setInt(1, idGrupo);
			rs = stmt.executeQuery();
			List<DTOReceitasGrupo> lista = new ArrayList<DTOReceitasGrupo>();
			while(rs.next()){
				DTOReceitasGrupo dg = new DTOReceitasGrupo();
				dg.setIdLancamento(rs.getInt(1));
				dg.setNomeLancamento(rs.getString(2));
				dg.setDataVencimento(rs.getDate(3));
				dg.setValorLancamento(rs.getDouble(4));
				dg.setUsuarioLancador(rs.getString(5));
				lista.add(dg);
			}
			stmt.close();
			close();
			Collections.sort(lista);
			return lista;
	}
	
	//Find para usar no relatório
		public ResultSet findByReceitasRelatorio(Integer idGrupo) throws Exception{
			open();
				stmt = con.prepareStatement("select idLancamento, nomeLancamento, dataLancamento, valorlancamento, nomeUsuario as usuarioLancador "
											+ "from lancamento l inner join carteiraGrupo cg on l.idLancamento = cg.id_Lancamento "
											+ "inner join usuario u on cg.id_usuario = u.idUsuario where cg.id_grupo = ?"
											+ "and l.status = 1 and l.tipoLancamento = 0");
				stmt.setInt(1, idGrupo);
				rs = stmt.executeQuery();
				return rs;
		}
	
		public List<DTOUusariosGrupo> findByUsuariosGrupo(Grupo g) throws Exception{
		open();
			stmt = con.prepareStatement("select idUsuario, nomeUsuario, email, id_Grupo  from usuario u inner join adicionaUsuario au "
										+ "on au.id_usuario = u.idUsuario where au.id_grupo = ? and u.ativo = 1");
			stmt.setInt(1, g.getIdGrupo());
			rs = stmt.executeQuery();
			List<DTOUusariosGrupo> lista = new ArrayList<DTOUusariosGrupo>();
			while(rs.next()){
				DTOUusariosGrupo dto = new DTOUusariosGrupo();
				dto.setIdUsuario(rs.getInt(1));
				dto.setNomeUsuario(rs.getString(2));
				dto.setEmailusuario(rs.getString(3));
				dto.setId_Grupo(rs.getInt(4));
				lista.add(dto);				
			}
		stmt.close();
		close();
		return lista;		
	}
	
	
	
	
	
}
