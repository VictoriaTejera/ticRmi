package um.edu.uy.persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Integer capacidad;
	private boolean reservada;
	
}
