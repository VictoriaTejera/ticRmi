package um.edu.uy.persistance;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import um.edu.uy.persistance.entidades.Mesa;
import um.edu.uy.persistance.entidades.Usuario;

public interface MesaRepository extends CrudRepository<Mesa, Long>{

	
	@Transactional
	@Modifying
	@Query("UPDATE Mesa m SET m.reservada= true WHERE m.id= :id")
	void marcarMesaComoReservada(@Param("id") Long id);
	
}
