package um.edu.uy.persistance.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javax.persistence.JoinColumn;

@Entity
@Table
public class Restaurante implements Serializable {

	@Id
	private String rut;
	private String nombre;
	private String horarioApertura;
	private String horarioCierre;
	private String direccion;
	private Integer telefono;
	private Float rating;
	private Integer cantRatings;
	private String descripcion;
	private Float precio_promedio;
	private String email;
	private String password;

	@Lob
	private byte[] imagen;

	@ManyToMany
	private List<Comida> comidas;
	
	
	
	@ManyToOne
	private Barrio barrio;
	
	@OneToMany
	@JoinTable(name="Restaurante_Mesa", joinColumns = @JoinColumn(name="Restaurante_RUT"))
	@Cascade(CascadeType.ALL)
	private List<Mesa> mesas;

	public Restaurante(String nombre, String horarioApertura, String horarioCierre, String direccion, Integer telefono,
			Float rating, Integer cantRatings, String descripcion, Barrio barrio) {
		super();
		this.nombre = nombre;
		this.horarioCierre = horarioCierre;
		this.horarioApertura = horarioApertura;
		this.direccion = direccion;
		this.telefono = telefono;
		this.rating = rating;
		this.cantRatings = cantRatings;
		this.descripcion = descripcion;
		this.barrio = barrio;
	}

	public Restaurante(String rut, String nombre, String email, String password) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}
	
	public List<Comida> getComidas() {
		return comidas;
	}

	public void setComida(List<Comida> comida) {
		this.comidas = comida;
	}

	public void agregarComida(Comida comida) {
		comidas.add(comida);
	}
	
	public Restaurante(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getRUT() {

		return rut;
	}

	public void setRut(String rut) {
		rut = rut;

	}

	public Restaurante() {
	}

	public String getNombre() {
		return nombre;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public String getHorarioAperura() {
		return horarioApertura;
	}

	public String getHorarioCierre() {
		return horarioCierre;
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

	// public void setPrecioMenor(Float precioMenor) {
	// this.precioMenor = precioMenor;
	// }
	//
	// public Float getPrecioMayor() {
	// return precioMayor;
	// }
	// public Float getPrecioMenor() {
	// return precioMenor;
	// }
	//
	// public void setPrecioMayor(Float precioMayor) {
	// this.precioMayor = precioMayor;
	// }
	// public List<Comida> getMenu() {
	// return menu;
	// }
	//
	// public void setMenu(List<Comida> menu) {
	// this.menu = menu;
	// }

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", horarioApertura=" + horarioApertura + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", rating=" + rating + ", cantRatings=" + cantRatings + ", descripcion="
				+ descripcion + ", barrio=" + barrio + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getPrecio_promedio() {
		return precio_promedio;
	}

	public String getEmail() {
		return email;
	}
	
	

}
