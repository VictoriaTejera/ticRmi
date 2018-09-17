package test.persistance;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import persistance.DBConfiguration;
import persistance.RestauranteRepository;
import persistance.entidades.Restaurante;

@SuppressWarnings("unused")
public class TestRestauranteRepository {

	@Test
	public void testGetRestaurantes() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);
	
		RestauranteRepository repo = ctx.getBean(RestauranteRepository.class);
		List<Restaurante> lista=null;
		try {
			lista = repo.getRestaurants();
		} catch (SQLException e) {
			fail();
		}
		
		for(int i=0; i<lista.size();i++) {
			System.out.println(lista.get(i).getNombre());
		}
		System.exit(0);
	}
}
