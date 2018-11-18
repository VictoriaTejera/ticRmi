package Mgt;
import java.rmi.Remote;
import java.util.List;

import um.edu.uy.business.entities.Reserva;

public interface ReservaRemoteMgt extends Remote {

	void save(Integer usuarioCelular, String restauranteRUT, Integer cantPersonas);
	
	List<Reserva> obtenerReservasNoTerminadas(String rut);
	
	List<Reserva> obtenerReservasNoConfirmadas(String rut);
	
	public List<Reserva> verEstadoReservasUsuario(Integer usuarioCelular);
	
	boolean confirmarReserva(Long idReserva);
	
	void rechazarReserva(Long idReserva);
}
