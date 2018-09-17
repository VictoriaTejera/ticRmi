package persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	@Id
	private Integer celular;
	private String Id;
	private String Nombre;
	private String contrasena;
	private Float rating;
	private Integer cantRatings;
	
}
