package um.edu.uy.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

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
		Usuario usu=usuarioMgr.find(usuarioCelular);
		Restaurante res = resMgr.find(restauranteRUT);
		Reserva reserva=new Reserva(usu, res, cantPersonas);
		repository.save(reserva);
	}

	public List<Reserva>obtenerReservasNoTerminadas(String rut) {
		List<Reserva> reservasNoTerminadas= repository.obtenerReservasNoTerminadas(rut);
		return reservasNoTerminadas;
	}
	
	public List<Reserva> obtenerReservasNoConfirmadas(String rut) {
		List<Reserva> reservasNoConfirmadas= repository.obtenerReservasNoConfirmadas(rut);
		return reservasNoConfirmadas;
	}


	public List<Reserva> verEstadoReservasUsuario(Integer usuarioCelular){
		return repository.verEstadoReservasUsuario(usuarioCelular);
	}
	
<<<<<<< HEAD
	//public boolean confirmarReserva
=======
//	public boolean confirmarReserva() {}
>>>>>>> 4f58b1446972e11d699f10e937d829c06f1a2c5c

}
