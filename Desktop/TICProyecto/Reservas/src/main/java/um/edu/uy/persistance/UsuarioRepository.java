package um.edu.uy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import um.edu.uy.persistance.entidades.Usuario;

@Repository
public class UsuarioRepository {


	@Autowired
	JDBCTemplate template;

	public UsuarioRepository(JDBCTemplate template) {
		super();
		this.template = template;
	}

	public void Save(Usuario us) throws SQLException {

		template.execute(con -> {
			PreparedStatement stmt = con.prepareStatement(
					"insert into Usuario(Nombre, NombreUsuario, Celular, Contrasena) values(?,?,?,?)");

			stmt.setString(1, us.getNombre());
			stmt.setString(2, us.getNombreUsuario());
			stmt.setLong(3, us.getCelular());
			stmt.setString(4, us.getContrasena());

			return stmt.execute();

		});
	}

	public boolean VerificUsuario(Usuario us) {
		boolean correcto = false;
		try {
			correcto= (boolean)template.execute(con -> {
				PreparedStatement preparedStatement = con.prepareStatement(
						"SELECT * FROM usuarios WHERE Nombre=us.getNombre() Contrasena=us.getContrasena()");
				ResultSet resultSet = preparedStatement.executeQuery();
				boolean correcto1=false;
				if (resultSet.getString("nombre") == us.getNombre()
						&& resultSet.getString("contrasena") == us.getContrasena()) {
					correcto1 = true;
				}

				return correcto1;
			});
		} catch (SQLException e) {
			System.out.println("ERROR");
		}
		return correcto;

	}

}
