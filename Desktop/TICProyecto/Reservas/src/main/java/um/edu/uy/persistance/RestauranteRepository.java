package um.edu.uy.persistance;

import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javafx.collections.ObservableList;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer>{
	
	@Query("SELECT r FROM Restaurante r WHERE r.barrio.nombreBarrio= :barrio")
	List<Restaurante> filtrarPorBarrio(@Param("barrio") String nombreBarrio);

	@Query("SELECT r FROM Comida c, Restaurante r WHERE r=c.restaurante and c.tipo= :tipoComida")
	List<Restaurante> filtrarPorComida(@Param("tipoComida") String tipoComida);
	
	@Query("SELECT r FROM Restaurante r WHERE r.precioPromedio BETWEEN :precioMenor and :precioMayor")
	List<Restaurante> filtrarPorPrecio(@Param("precioMenor") Float precioMenor, @Param ("precioMayor") Float precioMayor);

	@Query("SELECT u FROM Usuario u WHERE u.Nombre= :nombre and u.contrasena= :contrasena")
	Usuario verificarUsuario(@Param("nombre") String nombre, @Param("contrasena") String contrasena);
	
	@Modifying
	@Query("update Restaurante r set r.descripcion=?1, r.direccion=?2, r.horario=?3, r.precio_romedio=?4, r.telefono=?5 where r.rut= :rut")
	public void cargarDatosRes(@Param("rut") String rut ,String descripcion, String direccion, Float precio_promedio, Integer telefono, String rut2);
//	@Query ("SELECT r FROM Restaurante r WHERE r.precioMayor<= :precioMayor and r.precioMenor>= :precioMenor")
//
//	List<Restaurante> filtrarPorPrecio(@Param ("precioMenor") Float precioMenor, @Param ("precioMayor") Float precioMayor);
	
	
}
