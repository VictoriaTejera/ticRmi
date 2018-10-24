package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Reserva;

@Service
public class ReservaMgr {
	
	@Autowired
	ReservaRepository repository;
	
	@Autowired 
	RestauranteMgr resMgr;
	
	@Autowired
	UsuarioMgr usuarioMgr;
	
	public void save(Reserva reserva) {
		repository.save(reserva);
	}
	
	public void save(Integer usuarioCelular, String restauranteRUT, Integer cantPersonas) {
		Reserva reserva=new Reserva(usuarioMgr.)
	}

}
