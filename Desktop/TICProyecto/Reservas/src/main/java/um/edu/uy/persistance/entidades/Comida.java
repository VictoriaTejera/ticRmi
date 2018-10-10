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
	
	@ManyToOne
	private Restaurante restaurante;
	
	public Comida() {}

	public Comida(String nombre, String tipo, Float precio) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}

	public Comida(String nombre, String tipo, Float precio, Restaurante restaurante) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.restaurante = restaurante;
		
		if(restaurante!=null) {
		Float precioMayor = restaurante.getPrecioMayor();
		Float precioMenor=restaurante.getPrecioMenor();
	
		if(precio<precioMenor) {
			restaurante.setPrecioMenor(precio);
		}
		if(precio>precioMayor) {
			restaurante.setPrecioMayor(precio);
		}
		}
		
			
		
	}
	

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	
}
