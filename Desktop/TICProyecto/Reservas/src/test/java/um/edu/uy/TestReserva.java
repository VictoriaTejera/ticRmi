package um.edu.uy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestReserva {

	
	@Autowired
	ReservaMgr reserMgr;
	
	@Autowired 
	RestauranteMgr resMgr; 
	
	@Autowired
	UsuarioMgr usuarioMgr;
	
	//@Test
	public void obtenerReservasNoTerminadas() {
		Usuario u1=new Usuario("nombre2", "con2", 1234);
		usuarioMgr.save(u1);
		Restaurante r1=new Restaurante("Mc", "123");
		resMgr.save(r1);
		Reserva rr= new Reserva(u1, r1, 3);
		
		
		
	}
	
	@Test
	public void testConfirmarReserva() {
		Usuario u5=new Usuario("nombre2", "con2", 1234);
		usuarioMgr.save(u5);
		Restaurante r5=new Restaurante("Ruffi", "1233");
		resMgr.save(r5);

		Reserva r1= new Reserva(u5, r5, 7);
		reserMgr.save(r1);
	}
	
	
	

}
