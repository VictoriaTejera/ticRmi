package um.edu.uy;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

@SpringBootTest
@RunWith(SpringRunner.class)
@SuppressWarnings("unused")
public class TestRestauranteRepository {
	
	@Autowired
	RestauranteMgr resMgr;

	@Test
	public void testGetRestaurantesInterno() throws SQLException {
		
		List<Restaurante> lista = resMgr.getRestaurants();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
	}

//	@Test
//	public void testGetRestaurantes() throws SQLException {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfiguration.class);
//		RestauranteRepository repo = new RestauranteRepository(ctx);
//		List<Restaurante> lista = repo.getRestaurants();
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getNombre());
//		}
//		System.exit(0);
//	}
}
