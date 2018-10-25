package um.edu.uy.persistance;

import org.springframework.data.repository.CrudRepository;

import um.edu.uy.persistance.entidades.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, String> {

}
