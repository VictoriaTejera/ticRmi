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
//	private List<Comida> menu;
	
	//foto que tipo de datos es??
	
	public Restaurante(String nombre, String direccion, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Restaurante(String nombre, String barrio, String horario, String direccion, Integer telefono, Float rating,
			Integer cantRatings, String descripcion, List<Comida> menu) {
		super();
		this.nombre = nombre;
		this.barrio = barrio;
		this.horario = horario;
		this.direccion = direccion;
		this.telefono = telefono;
		this.rating = rating;
		this.cantRatings = cantRatings;
		this.descripcion = descripcion;
//		this.menu = menu;
	}
	
	
	
	
}
