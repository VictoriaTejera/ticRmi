package persistance.entidades;

import java.util.List;

public class Restaurante {

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
