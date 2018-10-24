package um.edu.uy.persistance.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

  @Entity
  @Table
//@SuppressWarnings("unused")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;
	private Usuario usuario;
	private Restaurante restaurante;
	private Integer cantPersonas;
	private boolean confirmado;
	
}
