package um.edu.uy;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import um.edu.uy.persistance.RestauranteRepository;
import um.edu.uy.persistance.UsuarioRepository;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

public class TestUsuarioRepository {

	@Test
	public void testGetUsuartio() throws SQLException {
		
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);
//		
//		UsuarioRepository repo = ctx.getBean(UsuarioRepository.class);
//		
//			assertEquals(repo.VerificUsuario(new Usuario("Victoria", "tej", 9)), true );
//		
		
	
	}

}
