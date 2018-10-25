package um.edu.uy.interfaz.cliente.clasesAuxiliares;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Restaurante;

public class RestauranteAUX {
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
	private byte[] imagen;
	private List<Comida> comidas;
	private Barrio barrio;
	
	private Button button;
	
	public ObservableList<Restaurante> getRestaurants(){
		return null;
	}
	
	public RestauranteAUX(Restaurante res) {
		this.rut=res.getRUT();
		this.nombre=res.getNombre();
		this.horarioApertura=res.getHorarioAperura();
		this.horarioCierre=res.getHorarioCierre();
		this.direccion=res.getDireccion();
		this.telefono=res.getTelefono();
		this.rating=res.getRating();
		this.cantRatings=res.getCantRatings();
		this.descripcion=res.getDescripcion();
		this.precio_promedio=res.getPrecio_promedio();
		this.email=res.getEmail();
		this.password=res.getPassword();
		this.imagen=res.getImagen();
		this.comidas=res.getComidas();
		this.barrio=res.getBarrio();
		this.button=null;
	}

}
