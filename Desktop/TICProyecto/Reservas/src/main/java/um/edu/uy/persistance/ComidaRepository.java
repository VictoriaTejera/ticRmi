package um.edu.uy.persistance;

import org.springframework.data.repository.CrudRepository;

import um.edu.uy.persistance.entidades.Comida;

public interface ComidaRepository extends CrudRepository<Comida, String>{

}
