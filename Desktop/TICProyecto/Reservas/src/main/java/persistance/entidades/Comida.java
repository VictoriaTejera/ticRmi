package persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("unused")
public class Comida {
	@Id
	private String nombre;
	private String tipo;
	private Float precio;
	
}
