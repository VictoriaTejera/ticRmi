package um.edu.uy.persistance;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import um.edu.uy.persistance.entidades.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, String> {
	

	@Query("SELECT r FROM Reserva r WHERE r.terminada=false AND r.restaurante.rut= :rut")
	List<Reserva> obtenerReservasNoTerminadas(@Param("rut") String rut);
	
	

	@Query("SELECT r FROM Reserva r WHERE r.usuario.celular= :usuarioCelular and r.terminada=false")
	public List<Reserva> verEstadoReservasUsuario(@Param("usuarioCelular") Integer usuarioCelular);


}
