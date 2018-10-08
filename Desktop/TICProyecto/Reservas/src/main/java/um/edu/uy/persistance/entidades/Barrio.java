package um.edu.uy.persistance.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table
public class Barrio {
	@Id
	private String idBarrio;
	private String nombreBarrio;
	
//	@OneToMany
//	@JoinTable(name="BARRIO_RESTAURANTE", joinColumns = @JoinColumn(name="nombre"))
//	@Cascade(CascadeType.ALL)
//	private List<Restaurante> restaurantes;
//
	public Barrio(String idBarrio, String nombreBarrio) {
		super();
		this.idBarrio = idBarrio;
		this.nombreBarrio = nombreBarrio;
	}
	
	public Barrio() {}

	public String getNombreBarrio() {
		return nombreBarrio;
	}

	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	
}
