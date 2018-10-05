package um.edu.uy;

import java.sql.SQLException;

import java.util.LinkedList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Restaurante;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestauranteRepository {

	@Autowired
	RestauranteMgr resMgr;

	@Test
	public void testSaveRestaurante() throws SQLException {
		Comida com1=new Comida("nombre", "tipo", (float)13.55);
		Comida com2=new Comida("nombre2", "tipo2", (float)13.56);
		List<Comida> menu=new LinkedList<>();
		menu.add(com1);
		menu.add(com2);
		Restaurante res=new Restaurante("nombre1", "direccion1", 65765, menu);
		resMgr.save(res);
	}
	
	@Test
	public void testSaveRestauranteConBarrio() throws SQLException {
		Barrio b1=new Barrio("nombre", "barrio1");
		Restaurante res=new Restaurante("nombre1", b1);
		resMgr.save(res);
	}
	
	
	
//	@Test
//	public void testFiltrarPorBarrio() {
//		
//	}

	// @Test
	// public void testGetRestaurantesInterno() throws SQLException {
	//
	// List<Restaurante> lista = resMgr.getRestaurants();
	// for (int i = 0; i < lista.size(); i++) {
	// System.out.println(lista.get(i).getNombre());
	// }
	// }

	// @Test
	// public void testGetRestaurantes() throws SQLException {
	// ApplicationContext ctx = new
	// AnnotationConfigApplicationContext(DBConfiguration.class);
	// RestauranteRepository repo = new RestauranteRepository(ctx);
	// List<Restaurante> lista = repo.getRestaurants();
	// for (int i = 0; i < lista.size(); i++) {
	// System.out.println(lista.get(i).getNombre());
	// }
	// System.exit(0);
	// }
}
