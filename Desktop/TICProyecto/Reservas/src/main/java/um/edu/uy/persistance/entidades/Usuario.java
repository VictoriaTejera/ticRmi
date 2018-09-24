package um.edu.uy.persistance.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class Usuario {

	@Id
	private Integer celular;
	private String Nombre;
	
	@Column(unique=true)
	private String NombreUsuario;
	private String contrasena;
	private Float rating;
	private Integer cantRatings;

	public Usuario(String nombre, String contrasena, Integer tel) {
		Nombre = nombre;
		this.contrasena = contrasena;
		this.celular = tel;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Integer getCantRatings() {
		return cantRatings;
	}

	public void setCantRatings(Integer cantRatings) {
		this.cantRatings = cantRatings;
	}
	
	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

}
