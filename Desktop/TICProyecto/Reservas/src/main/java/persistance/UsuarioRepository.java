package persistance;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import persistance.entidades.Usuario;

@Repository
public class UsuarioRepository {

	@Autowired
	JDBCTemplate template;

	public void Save(Usuario us) throws SQLException {
		
		template.execute(con -> {
			PreparedStatement stmt= con.prepareStatement("insert into Usuario(Nombre, NombreUsuario, Celular, Contrasena) values(?,?,?,?)");
			
			stmt.setString(1,us.getNombre());
			stmt.setString(2,us.getNombreUsuario());
			stmt.setLong(3, us.getCelular());
			stmt.setString(4,us.getContrasena());
			
			return stmt.execute();
			
		});
	}
	
}
