package um.edu.uy.persistance.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Table
@Entity
@SuppressWarnings("unused")

public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Integer cantPersonas;

	private boolean confirmada;
	private boolean rechazada;
	private boolean terminada;
	
	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Usuario usuario;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Restaurante restaurante;

	public Reserva() {
	}


	public Reserva(Usuario usuario, Restaurante restaurante, Integer cantPersonas) {
		super();
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.cantPersonas = cantPersonas;
		confirmada=false;
		terminada=false;
		rechazada=false;
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
		return confirmada;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmada = confirmado;
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

	@Override
	public String toString() {
		return "Reserva [Id=" + Id + ", cantPersonas=" + cantPersonas + ", confirmada=" + confirmada + ", terminada="
				+ terminada + ", usuario=" + usuario + ", restaurante=" + restaurante + "]";
	}
	
	
}
