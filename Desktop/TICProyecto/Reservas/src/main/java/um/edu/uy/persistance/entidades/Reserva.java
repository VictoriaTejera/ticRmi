package um.edu.uy.persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("unused")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Integer cantPersonas;
	private boolean confirmado;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Restaurante restaurante;

	public Reserva() {
	}

	public Reserva(Usuario usuario, Restaurante restaurante, Integer cantPersonas) {
		super();
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.cantPersonas = cantPersonas;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(Integer cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	

}
