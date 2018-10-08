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
	List<Restaurante> filtrarPorBarrio(@Param("barrio") String nombreBarrio);

	@Query("SELECT r FROM Comida c, Restaurante r WHERE r=c.restaurante and c.tipo= :tipoComida")
	List<Restaurante> filtrarPorComida(@Param("tipoComida") String tipoComida);

//	@Query ("SELECT r FROM Restaurante r WHERE r.precioMayor<= :precioMayor and rprecioMenor>= :precioMayor")
//	List<Restaurante> filtrarPorPrecio(@Param ("precioMenor") Float precioMenor, @Param ("precioMayor") Float precioMayor);
	
}
