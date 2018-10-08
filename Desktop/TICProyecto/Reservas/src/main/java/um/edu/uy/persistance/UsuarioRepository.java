package um.edu.uy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import um.edu.uy.persistance.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u WHERE u.Nombre= :nombre and u.contrasena= :contrasena")
	Usuario verificarUsuario(@Param("nombre") String nombre, @Param("contrasena") String contrasena);
	
	@Query("SELECT u FROM Usuario u WHERE u.Nombre= :nombre")
	Usuario verificarNombreUsuario(@Param("nombre") String nombre);
	
	


	

}
