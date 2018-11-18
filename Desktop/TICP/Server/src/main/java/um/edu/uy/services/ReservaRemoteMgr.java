package um.edu.uy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.ReservaRemoteMgt;
import um.edu.uy.business.ReservaMgr;
import um.edu.uy.business.entities.Reserva;

public class ReservaRemoteMgr implements ReservaRemoteMgt {

	
	@Autowired
	private ReservaMgr reservaMgr;
	
	@Override
	public void save(Integer usuarioCelular, String restauranteRUT, Integer cantPersonas) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reserva> obtenerReservasNoTerminadas(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> obtenerReservasNoConfirmadas(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> verEstadoReservasUsuario(Integer usuarioCelular) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirmarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rechazarReserva(Long idReserva) {
		// TODO Auto-generated method stub

	}

}
