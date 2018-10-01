package um.edu.uy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import um.edu.uy.persistance.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u WHERE u.Nombre= :nombre")
	boolean verificarUsuario(@Param("nombre") String nombre);
	
	
//	@Query("SELECT u FROM usuario u WHERE u.nombre= :nombre and u.contrasena= :contrasena")
//	boolean verificarUsuario(@Param("nombre") String nombre, @Param("contrasena") String contrasena);
////
//	@Autowired
//	JDBCTemplate template;
//
//	public UsuarioRepository(JDBCTemplate template) {
//		super();
//		this.template = template;
//	}
//
//	public void Save(Usuario us) throws SQLException {
//
//		template.execute(con -> {
//			PreparedStatement stmt = con.prepareStatement(
//					"insert into Usuario(Nombre, NombreUsuario, Celular, Contrasena) values(?,?,?,?)");
//
//			stmt.setString(1, us.getNombre());
//			stmt.setString(2, us.getNombreUsuario());
//			stmt.setLong(3, us.getCelular());
//			stmt.setString(4, us.getContrasena());
//
//			return stmt.execute();
//
//		});
//	}
//
	

}
