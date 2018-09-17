package test.persistance;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import persistance.DBConfiguration;
import persistance.RestauranteRepository;
import persistance.UsuarioRepository;
import persistance.entidades.Restaurante;
import persistance.entidades.Usuario;

public class TestUsuarioRepository {

	@Test
	public void testGetUsuartio() throws SQLException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);
		
		UsuarioRepository repo = ctx.getBean(UsuarioRepository.class);
		
			assertEquals(repo.VerificUsuario(new Usuario("Victoria", "tej", 9)), true );
		
		
	
	}

}
