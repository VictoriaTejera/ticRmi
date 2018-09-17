package persistance.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("unused")
public class Restaurante {

	@Id
	private String nombre;
	private String barrio;
	private String horario;
	private String direccion;
	private Integer telefono;
	private Float rating;
	private Integer cantRatings;
	private String descripcion;
	private List<Comida> menu;
	
	//foto que tipo de datos es??
	
	public Restaurante(String nombre, String direccion, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	
	
}
