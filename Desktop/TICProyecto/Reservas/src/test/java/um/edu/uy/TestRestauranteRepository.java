package um.edu.uy;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import um.edu.uy.persistance.DBConfiguration;
import um.edu.uy.persistance.RestauranteRepository;
import um.edu.uy.persistance.RestauranteRepositoryInterno;
import um.edu.uy.persistance.entidades.Restaurante;

@SuppressWarnings("unused")
public class TestRestauranteRepository {

	@Test
	public void testGetRestaurantesInterno() throws SQLException {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);

		RestauranteRepositoryInterno repo = ctx.getBean(RestauranteRepositoryInterno.class);
		List<Restaurante> lista = repo.getRestaurants();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
		System.exit(0);
	}

	@Test
	public void testGetRestaurantes() throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);
		RestauranteRepository repo = new RestauranteRepository(ctx);
		List<Restaurante> lista = repo.getRestaurants();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
		System.exit(0);
	}
}
