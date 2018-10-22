package um.edu.uy.persistance;

import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javafx.collections.ObservableList;

public interface RestauranteRepository extends CrudRepository<Restaurante, Integer>{
	
	@Query("SELECT r FROM Restaurante r WHERE r.barrio.nombreBarrio= :barrio")
	List<Restaurante> filtrarPorBarrio(@Param("barrio") String nombreBarrio);

	@Query("SELECT r FROM Comida c, Restaurante r WHERE r=c.restaurante and c.tipo= :tipoComida")
	List<Restaurante> filtrarPorComida(@Param("tipoComida") String tipoComida);
	
	@Query("SELECT r FROM Restaurante r WHERE r.precio_promedio BETWEEN :precioMenor and :precioMayor")
	List<Restaurante> filtrarPorPrecio(@Param("precioMenor") Float precioMenor, @Param ("precioMayor") Float precioMayor);

	@Query("SELECT r FROM Restaurante r WHERE r.nombre= :nombre and r.password= :password")
	Restaurante verificarRestaurante(@Param("nombre") String nombre, @Param("password") String password);

	@Transactional
	@Modifying
<<<<<<< HEAD
	@Query("UPDATE Restaurante r SET r.descripcion= :descripcion, r.direccion= :direccion, r.horarioApertura= :horarioApertura,r.horarioCierre= :horarioCiere, r.precio_promedio= :precio_promedio, r.telefono= :telefono WHERE r.rut= :rut")
	public void cargarDatosRes(@Param("rut") String rut, @Param("descripcion")String descripcion, @Param("direccion")String direccion, @Param("horarioApertura") String horarioApertura, @Param("horarioCierre") String horarioCierre, @Param("precio_promedio") Float precio_promedio, @Param("telefono")Integer telefono);

=======
	@Query("UPDATE Restaurante r SET r.descripcion= :descripcion, r.direccion= :direccion, r.horario= :horario, r.precio_promedio= :precio_promedio, r.telefono= :telefono WHERE r.rut= :rut")
	public void cargarDatosRes(@Param("rut") String rut, @Param("descripcion")String descripcion, @Param("direccion")String direccion, @Param("horario") String horario, @Param("precio_promedio") Float precio_promedio, @Param("telefono")Integer telefono);
>>>>>>> branch 'master' of https://github.com/VictoriaTejera/TIC.git

	@Query("SELECT res FROM Restaurante res WHERE res.rut= :rut")
	Restaurante verificarRutRestaurante(@Param("rut") String rut);
}
