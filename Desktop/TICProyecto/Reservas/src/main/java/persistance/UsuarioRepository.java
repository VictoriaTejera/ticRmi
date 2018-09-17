package persistance;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import persistance.entidades.Usuario;

public class UsuarioRepository {

	
	JDBCTemplate template;
	
	
	public UsuarioRepository(JDBCTemplate template) {
		super();
		this.template = template;
	}


	public void Save(Usuario us) throws SQLException {
		
		template.execute(con -> {
			PreparedStatement stmt= con.prepareStatement("insert into Usuario(Nombre, NombreUsuario, Cel, Contrasena) values(?,?,?,?)");
			
			stmt.setString(1,us.getNombre());
			stmt.setString(2,us.getNombreUsuario());
			stmt.setInt(3, us.getCelular());
			stmt.setString(4,us.getContrasena());
			
			return stmt.execute();
			
		});
	}
	
}
