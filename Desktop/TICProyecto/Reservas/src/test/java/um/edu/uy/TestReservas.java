package um.edu.uy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

@SpringBootTest(classes = MainRestaurante.class)
@RunWith(SpringRunner.class)
public class TestReservas {

	@Autowired
	ReservaMgr reservaMgr;
	
	@Test
	public void testSaveReserva() {
		Restaurante res=new Restaurante("rut", "nombre", "email", "pass");
		Usuario u= new Usuario("nombre", "contrasena", 123);
		Reserva reserva=new Reserva(u, res, 123);
		
		reservaMgr.save(reserva);
	}

}
