package um.edu.uy.persistance;

import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer>{
	
	@Query("SELECT r FROM Restaurante r WHERE r.Barrio= :barrio")
	List<Restaurante> filtrarPorBarrio(@Param("barrio") String barrio);

	@Query("SELECT r FROM Restaurante r JOIN Comida c WHERE c.tipo= :tipoComida")
	List<Restaurante> filtrarPorComida(@Param("tipoComida") String tipoComida);

	
	
}
