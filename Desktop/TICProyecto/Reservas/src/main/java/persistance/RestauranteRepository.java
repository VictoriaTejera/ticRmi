package persistance;

import org.springframework.data.repository.CrudRepository;

import persistance.entidades.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante, String>{

}
