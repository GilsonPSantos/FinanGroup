package persistence;

import java.util.ArrayList;
import java.util.List;

import dto.DTOMensagemConsulta;
import entity.Grupo;
import entity.Mensagem;
import entity.Usuario;

public class MensagemDao extends Dao{
	
	public void create(Usuario UsuarioDest, Grupo grupo, Mensagem msg) throws Exception{
		open();
			stmt = con.prepareStatement("insert into mensagem values(seq_mensagem.nextval,?,?,?,?)");
			stmt.setString(1, msg.getMensagem());
			stmt.setInt(2, 1);
			stmt.setInt(3, grupo.getIdGrupo());
			stmt.setInt(4, UsuarioDest.getIdUsuario());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public void aceitarMensagemGrupo(Usuario u, Grupo g) throws Exception{
		open();
			call = con.prepareCall("call aceitarGrupo(?,?)");
			call.setInt(1, u.getIdUsuario());
			call.setInt(2, g.getIdGrupo());
			call.execute();
			call.close();
		close();
	}
	
	public List<DTOMensagemConsulta> findByUsuario(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("select nomeUsuario as UsuarioOrigem, idGrupo, nomeGrupo as Grupo, mensagem, "
					+ "idMensagem from usuario u inner join grupo g on u.idUsuario = g.id_usuario inner join mensagem m "
					+ "on m.id_grupo = g.idGrupo where m.id_usuarioDestino = ? and m.status = 1");
		stmt.setInt(1, u.getIdUsuario());
		rs = stmt.executeQuery();
		List<DTOMensagemConsulta> lista = new ArrayList<DTOMensagemConsulta>();
		while(rs.next()){
			DTOMensagemConsulta dto = new DTOMensagemConsulta();
			dto.setNomeUsuarioOrigem(rs.getString(1));
			dto.setIdGrupo(rs.getInt(2));
			dto.setNomeGrupo(rs.getString(3));
			dto.setMensagem(rs.getString(4));
			dto.setIdMensagem(rs.getInt(5));
			lista.add(dto);
		}
		stmt.close();
		close();
		return lista;
	}
	
	public void delete (Integer cod) throws Exception{
		open();
			stmt = con.prepareStatement("update mensagem set status = 0 where idMensagem = ?");
			stmt.setInt(1, cod);
			stmt.execute();
			stmt.close();
		close();
	}

}
