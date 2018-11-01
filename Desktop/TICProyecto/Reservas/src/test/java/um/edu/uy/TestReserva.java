package um.edu.uy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestReserva {

	
	@Autowired 
	RestauranteMgr resMgr; 
	
	@Autowired
	UsuarioMgr usuarioMgr;
	
	@Test
	public void obtenerReservasNoTerminadas() {
		Usuario u1=new Usuario("nombre2", "con2", 1234);
		usuarioMgr.save(u1);
		Restaurante r1=new Restaurante("Mc", "123");
		resMgr.save(r1);
		Reserva rr= new Reserva(u1, r1, 3);
		
		
		
	}

}
