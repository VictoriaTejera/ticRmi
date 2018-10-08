package um.edu.uy.persistance.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.JoinColumn;

@Entity
@Table
public class Restaurante implements Serializable{

	@Id
	private String nombre;
	private String horario;
	private String direccion;
	private Integer telefono;
	private Float rating;
	private Integer cantRatings;
	private String descripcion;

	@ManyToOne
	private Barrio barrio;

//	@OneToMany
//	@JoinTable(name="RESTAURANTE_COMIDA", joinColumns = @JoinColumn(name="nombre"))
//	@Cascade(CascadeType.ALL)
//	private List<Comida> menu;
	
	//foto que tipo de datos es??
	
	public Restaurante(String nombre, String horario, String direccion, Integer telefono, Float rating, Integer cantRatings,
		String descripcion, Barrio barrio) {
	super();
	this.nombre = nombre;
	this.horario = horario;
	this.direccion = direccion;
	this.telefono = telefono;
	this.rating = rating;
	this.cantRatings = cantRatings;
	this.descripcion = descripcion;
	this.barrio = barrio;
}

	public Restaurante() {}

	public String getNombre() {
		return nombre;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public String getHorario() {
		return horario;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public Float getRating() {
		return rating;
	}

	public Integer getCantRatings() {
		return cantRatings;
	}

	public String getDescripcion() {
		return descripcion;
	}

//	public List<Comida> getMenu() {
//		return menu;
//	}
//
//	public void setMenu(List<Comida> menu) {
//		this.menu = menu;
//	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", horario=" + horario + ", direccion=" + direccion + ", telefono="
				+ telefono + ", rating=" + rating + ", cantRatings=" + cantRatings + ", descripcion=" + descripcion
				+ ", barrio=" + barrio + "]";
	}
	
	
	
	
}
