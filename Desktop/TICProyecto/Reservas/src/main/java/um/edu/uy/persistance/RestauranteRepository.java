package um.edu.uy.persistance;

import um.edu.uy.persistance.entidades.Restaurante;

import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer>{
	
}
