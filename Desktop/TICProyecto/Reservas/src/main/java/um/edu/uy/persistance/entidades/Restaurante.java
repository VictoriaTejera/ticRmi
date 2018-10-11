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
public class Restaurante implements Serializable {

	@Id
	private String RUT;
	private String nombre;
	private String contrasena;
	private String horario;
	private String direccion;
	private Integer telefono;
	private Float rating;
	private Integer cantRatings;
	private String descripcion;
	private Float precioPromedio;
	private String email;
	private String password;
//	private Float precioMenor=(float)1000000.0;
//	private Float precioMayor=(float)0.0;

	@ManyToOne
	private Barrio barrio;

	// @OneToMany
	// @JoinTable(name="RESTAURANTE_COMIDA", joinColumns =
	// @JoinColumn(name="nombre"))
	// @Cascade(CascadeType.ALL)
	// private List<Comida> menu;

	// foto que tipo de datos es??

	public Restaurante(String nombre, String horario, String direccion, Integer telefono, Float rating,
			Integer cantRatings, String descripcion, Barrio barrio) {
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

	public Restaurante(String RUT, String nombre, String email, String password) {
		super();
		this.RUT = RUT;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public Restaurante() {
	}

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
	
//	public void setPrecioMenor(Float precioMenor) {
//		this.precioMenor = precioMenor;
//	}
//
//	public Float getPrecioMayor() {
//		return precioMayor;
//	}
//	public Float getPrecioMenor() {
//		return precioMenor;
//	}
//	
//	public void setPrecioMayor(Float precioMayor) {
//		this.precioMayor = precioMayor;
//	}
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
