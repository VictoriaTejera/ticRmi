package um.edu.uy.presistence;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import um.edu.uy.business.entities.Mesa;
import um.edu.uy.business.entities.Usuario;

public interface MesaRepository extends CrudRepository<Mesa, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE Mesa m SET m.reservada= true WHERE m.id= :id")
	void marcarMesaComoReservada(@Param("id") Long id);
	
	@Modifying
	@Query(value="INSERT INTO Mesa (capacidad, restaurante_id)  VALUES (:capacidad, :rut)", nativeQuery=true)
	@Transactional
	public void insertarMesa(@Param("capacidad") Integer capacidad, @Param("rut") String rut);
	
//	@Query("SELECT m.reservada FROM Mesa m WHERE id= :id")
//	public boolean isReservada(@Param("id") Long id);
	
}
