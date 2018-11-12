package um.edu.uy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.MesaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

@SpringBootTest(classes = MainRestaurante.class)
@RunWith(SpringRunner.class)
public class TestMesas {
	
	@Autowired
	RestauranteMgr restauranteMgr;
	
	@Autowired
	MesaMgr mesaMgr;
	
	@Test
	public void test() {
		Restaurante res = new Restaurante("rut2", "nombre2", 543 , "pass2");
		restauranteMgr.save(res);
		mesaMgr.save("rut2", 4);
	}

}
