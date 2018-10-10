package um.edu.uy;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import java.util.LinkedList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.BarrioMgr;
import um.edu.uy.persistance.BarrioRepository;
import um.edu.uy.persistance.ComidaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Restaurante;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestauranteRepository {

	@Autowired
	RestauranteMgr resMgr;

	@Autowired
	BarrioMgr barrioMgr;

	@Autowired
	ComidaMgr comidaMgr;

	// @Test
	// public void testSaveRestaurante() throws SQLException {
	// Comida com1 = new Comida("nombre", "tipo", (float) 13.55);
	// Comida com2 = new Comida("nombre2", "tipo2", (float) 13.56);
	// List<Comida> menu = new LinkedList<>();
	// menu.add(com1);
	// menu.add(com2);
	// Restaurante res = new Restaurante("nombre1", "direccion1", 65765, menu);
	// resMgr.save(res);
	// }

	//@Test
	public void testGetRestaurantes() {
		Restaurante res1 = new Restaurante("nombre1", null, null, null, null, null, null, null);
		resMgr.save(res1);
		Restaurante res2 = new Restaurante("nombre2", null, null, null, null, null, null, null);
		resMgr.save(res2);
		Restaurante res3 = new Restaurante("nombre3", null, null, null, null, null, null, null);
		resMgr.save(res3);
		List<Restaurante> lista = resMgr.getRestaurants();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
	}
	
	//@Test
	public void testGetRestaurantesII() {
		resMgr.getRestaurants();
	}

	// @Test
	public void testSaveRestauranteConBarrio() throws SQLException {
		Barrio b1 = new Barrio("nombre", "barrio1");
		barrioMgr.save(b1);
		Restaurante res = new Restaurante("nombre1", null, null, null, null, null, null, b1);
		resMgr.save(res);
	}


	@Test
	public void testFiltroPorBarrio() {
		Barrio b1 = new Barrio("id", "nombreBarrio1");
		barrioMgr.save(b1);
		Barrio b2 = new Barrio("id2", "nombreBarrio2");
		barrioMgr.save(b2);

		Restaurante res = new Restaurante("nombre1", null, null, null, null, null, null, b1);
		resMgr.save(res);
		Restaurante res2 = new Restaurante("nombre2", null, null, null, null, null, null, b1);
		resMgr.save(res2);
		Restaurante res3 = new Restaurante("nombre3", null, null, null, null, null, null, b1);
		resMgr.save(res3);

		List<Restaurante> lista = resMgr.filtrarPorBarrio(b1.getNombreBarrio());
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("AAAAAA----------------");
			System.out.println(lista.get(i));
		}

		List<Restaurante> lista2 = resMgr.filtrarPorBarrio("nombreNoExistente");
		List<Restaurante> lista3 = resMgr.filtrarPorBarrio(b2.getNombreBarrio());

	}

	//@Test
	public void testFiltroPorComida() {
		Restaurante res1 = new Restaurante("nombreRes1", null, null, null, null, null, null, null);
		resMgr.save(res1);
		Restaurante res2 = new Restaurante("nombreRes2", null, null, null, null, null, null, null);
		resMgr.save(res2);

		Comida c1 = new Comida("nombre1", "tipo1", (float) 123.4, res1);
		comidaMgr.save(c1);
		Comida c2 = new Comida("nombre2", "tipo2", (float) 221.7, res1);
		comidaMgr.save(c2);
		Comida c3 = new Comida("nombre3", "tipo1", (float) 4.7, res2);
		comidaMgr.save(c3);
		Comida c4 = new Comida("nombre4", "tipo4", (float) 800.1, res2);
		comidaMgr.save(c4);

		List<Restaurante> lista = resMgr.filtrarPorComida("tipo1");

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("AAAAAA----------------");
			System.out.println(lista.get(i));
		}

		assertEquals(lista.get(0).getNombre(), "nombreRes1");
		assertEquals(lista.get(1).getNombre(), "nombreRes2");

	}
<<<<<<< HEAD
	@Test
	public void testFiltroPorPrecio() {
		
		Restaurante res1 = new Restaurante("nombreRes1", null, null, null, null, null, null, null);
		resMgr.save(res1);
		Restaurante res2 = new Restaurante("nombreRes2", null, null, null, null, null, null, null);
		resMgr.save(res2);
		
		Comida c1 = new Comida("nombre1", "tipo1", (float)123.4, res1);
		comidaMgr.save(c1);
		Comida c2 = new Comida("nombre2", "tipo2", (float)223.4, res2);
		comidaMgr.save(c2);
		Comida c3 = new Comida("nombre3", "tipo1", (float)233.4, res1);
		comidaMgr.save(c3);
		Comida c4 = new Comida("nombre4", "tipo4", (float)234.4, res2);	
		comidaMgr.save(c4);
		
		List<Restaurante> lista = resMgr.filtrarPorPrecio((float)122.4);
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("");
			System.out.println(lista.get(i));
		}
		System.out.println(lista.size());
//		assertEquals(lista.get(0).getNombre(), "nombreRes1");
//		assertEquals(lista.get(1).getNombre(), "nombreRes2");
//		assertEquals(lista.size(),2);
		
		
	}

//	@Test
//	public void testFiltroPorPrecio() {
//		
//		Restaurante res1 = new Restaurante("nombreRes1", null, null, null, null, null, null, null);
//		resMgr.save(res1);
//		Restaurante res2 = new Restaurante("nombreRes2", null, null, null, null, null, null, null);
//		resMgr.save(res2);
//		
//		Comida c1 = new Comida("nombre1", "tipo1", (float)123.4, res1);
//		comidaMgr.save(c1);
//		Comida c2 = new Comida("nombre2", "tipo2", (float)223.4, res2);
//		comidaMgr.save(c2);
//		Comida c3 = new Comida("nombre3", "tipo1", (float)233.4, res1);
//		comidaMgr.save(c3);
//		Comida c4 = new Comida("nombre4", "tipo4", (float)234.4, res2);	
//		comidaMgr.save(c4);
//		
//		List<Restaurante> lista = resMgr.filtrarPorPrecio((float)122.4, (float)224.6);
//		
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println("");
//			System.out.println(lista.get(i));
//		}
//		
//		assertEquals(lista.get(0).getNombre(), "nombreRes1");
//		assertEquals(lista.get(1).getNombre(), "nombreRes2");
//		assertEquals(lista.size(),2);
//		
//		
//	}


}
