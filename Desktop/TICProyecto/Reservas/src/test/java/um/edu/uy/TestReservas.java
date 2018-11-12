package um.edu.uy;

import java.util.List;

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

@SpringBootTest(classes = MainRestaurante.class)
@RunWith(SpringRunner.class)
public class TestReservas {

	@Autowired
	ReservaMgr reservaMgr;
	
	@Autowired 
	RestauranteMgr restauranteMgr;
	
	@Autowired 
	UsuarioMgr usuarioMgr;
	
	@Test
	public void testSaveReserva() {
		Restaurante res=new Restaurante("rut", "nombre", "email", "pass");
		Usuario u= new Usuario("nombre", "contrasena", 123);
		Reserva reserva=new Reserva(u, res, 123);
		
		//reservaMgr.save(reserva);
	}

	@Test
	public void testSaveReserva2() {
		Restaurante res = new Restaurante("rut", "nombre", "email", "pass");
		Restaurante res2 = new Restaurante("rut2", "nombre2", "email2", "pass2");
		restauranteMgr.save(res);
		restauranteMgr.save(res2);
		Usuario u = new Usuario("nombre", "contrasena", 123);
		Usuario u2 = new Usuario("nombre2", "contrasena2", 111);
		usuarioMgr.save(u);
		usuarioMgr.save(u2);
		
		Reserva reserva = new Reserva(u, res, 5);
		//reservaMgr.save(reserva);
		//reservaMgr.save(123, "rut2", 4);

		List<Reserva> lista = reservaMgr.verEstadoReservasUsuario(123);
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
	
}
