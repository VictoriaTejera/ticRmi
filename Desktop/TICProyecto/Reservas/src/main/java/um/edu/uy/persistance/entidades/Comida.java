package um.edu.uy.persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("unused")
public class Comida {
	@Id
	private String nombre;
	private String tipo;
	private Float precio;
	
	public Comida() {}

	public Comida(String nombre, String tipo, Float precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}
	
	
}
