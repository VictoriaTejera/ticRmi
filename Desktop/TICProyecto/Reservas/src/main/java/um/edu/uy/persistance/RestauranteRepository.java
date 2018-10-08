package um.edu.uy.persistance;

import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javafx.collections.ObservableList;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer>{
	
	@Query("SELECT r FROM Restaurante r WHERE r.barrio.nombreBarrio= :barrio")
	ObservableList<Restaurante> filtrarPorBarrio(@Param("barrio") String nombreBarrio);

	@Query("SELECT r FROM Comida c, Restaurante r WHERE r=c.restaurante and c.tipo= :tipoComida")
	ObservableList<Restaurante> filtrarPorComida(@Param("tipoComida") String tipoComida);

	
}
