package persistence;

import entity.Grupo;
import entity.Usuario;

public class Usuario_GrupoDao extends Dao {
	
	public void delete (Usuario u, Grupo g) throws Exception{
		open();
		stmt = con.prepareStatement("delete from adicionaUsuario where id_Usuario = ? and id_Grupo = ?");
		stmt.setInt(1, u.getIdUsuario());
		stmt.setInt(2, g.getIdGrupo());
		stmt.execute();
		stmt.close();
		close();		
	}
	
	
	
	
	
	
	

}
