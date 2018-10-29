package um.edu.uy.persistance.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("unused")
public class Comida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;

//	@ManyToMany
//	private List<Restaurante> restaurante;
	


	public Comida() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comida(String tipo) {
		super();
		
		this.tipo = tipo;
		
	}

	
		
		
//		if(restaurante!=null) {
//		Float precioMayor = restaurante.getPrecioMayor();
//		Float precioMenor=restaurante.getPrecioMenor();
//	
//		if(precio<precioMenor) {
//			restaurante.setPrecioMenor(precio);
//		}
//		if(precio>precioMayor) {
//			restaurante.setPrecioMayor(precio);
//		}
//		}
		
			
		
	
	

	



//	public List<Restaurante> getRestaurante() {
//		return restaurante;
//	}
//
//	public void setRestaurante(List<Restaurante> restaurante) {
//		this.restaurante = restaurante;
//	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
	
}
