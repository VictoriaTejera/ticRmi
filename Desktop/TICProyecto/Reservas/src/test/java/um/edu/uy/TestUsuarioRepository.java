package um.edu.uy;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.RestauranteRepository;
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.UsuarioRepository;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUsuarioRepository {
	
	@Autowired
	UsuarioMgr usuMgr;

	@Test
	public void testGetUsuario() throws SQLException {
		Usuario usuario=new Usuario("nombre1", "contrasena1", 65765);
		usuMgr.save(usuario);
	
	}

}
