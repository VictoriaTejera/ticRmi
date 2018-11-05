package um.edu.uy.persistance;

import org.springframework.data.repository.CrudRepository;

import um.edu.uy.persistance.entidades.Mesa;
import um.edu.uy.persistance.entidades.Usuario;

public interface MesaRepository extends CrudRepository<Mesa, Long>{

}
