package um.edu.uy.presistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import um.edu.uy.business.entities.Barrio;


public interface BarrioRepository extends CrudRepository<Barrio, Integer>{
	@Query("SELECT b FROM Barrio b WHERE b.nombreBarrio= :nombre")
	public List<Barrio> getBarrioByNombre(@Param("nombre") String nombreBarrio);
}
