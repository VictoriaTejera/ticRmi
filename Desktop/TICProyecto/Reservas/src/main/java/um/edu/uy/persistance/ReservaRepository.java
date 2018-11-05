package um.edu.uy.persistance;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import um.edu.uy.persistance.entidades.Reserva;

@Component
public interface ReservaRepository extends CrudRepository<Reserva, String> {
	

	@Query("SELECT r FROM Reserva r WHERE r.terminada=false AND r.restaurante.rut= :rut")
	List<Reserva> obtenerReservasNoTerminadas(@Param("rut") String rut);
	
	

	@Query("SELECT r FROM Reserva r WHERE r.usuario.celular= :usuarioCelular and r.terminada=false")
	public List<Reserva> verEstadoReservasUsuario(@Param("usuarioCelular") Integer usuarioCelular);

	
	@Query("SELECT r FROM Reserva r WHERE r.id= :id")
	Reserva otenerReservaPorId(@Param("id") Long id);
	
	@Query("SELECT r.restaurante.rut FROM Reserva r WHERE r.id= :id")
	String otenerRutRestauranteDeReserva(@Param("id") Long id);

	
	//NECESITO AYUDA CON ESTO!!!!!!!!
}
