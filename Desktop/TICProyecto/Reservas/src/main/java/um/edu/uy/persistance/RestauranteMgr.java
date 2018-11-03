package um.edu.uy.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
public class RestauranteMgr {

	@Autowired
	private RestauranteRepository repository;

	@Autowired
	private BarrioMgr barrioMgr;

	public List<Restaurante> getRestaurants() {
		Iterable<Restaurante> it = repository.findAll();
		List<Restaurante> lista = FXCollections.observableArrayList();
		for (Restaurante r : it) {
			lista.add(r);
		}
		return lista;
	}

	public void save(Restaurante res) {
		repository.save(res);
	}

	public void insertarComida(String rut, Comida comida) {
		repository.insertarComida(rut, comida.getId());
	}

	
//	public List<Restaurante> filtrarPorBarrio(String nombreBarrio) {


	public ObservableList<Restaurante> filtrarPorBarrio(String nombreBarrio) {
		List<Restaurante> restaurantes = repository.filtrarPorBarrio(nombreBarrio);
		return (ObservableList<Restaurante>) restaurantes;
	}


	public List<Restaurante> filtrarPorComida(String tipoComida) {
		List<Restaurante> restaurantes = repository.filtrarPorComida(tipoComida);
		return restaurantes;
	}
		

//	public ObservableList<Restaurante> filtrarPorComida(String tipoComida) {
//		List<Restaurante> restaurantes = repository.filtrarPorComida(repository.obtenerIdComida(tipoComida));
//		ObservableList<Restaurante> observ = FXCollections.observableArrayList();
//		for (int i = 0; i < restaurantes.size(); i++) {
//			observ.add(restaurantes.get(i));
//		}
//		return observ;
//
//	}

	public List<Restaurante> filtrarPorPrecio(Float precioMenor, Float precioMayor) {
		List<Restaurante> restaurantes = repository.filtrarPorPrecio(precioMenor, precioMayor);
		return restaurantes;

	}

	public boolean verificarUsuarioRestaurante(Restaurante res) {
		boolean verifico = true;
		if (repository.verificarRestaurante(res.getNombre(), res.getPassword()) == null) {
			verifico = false;
		}
		return verifico;
	}

	@Transactional
	public void cargarDatosRes(String rut, String descripcion, String direccion, String horarioApertura,
			String horarioCierre, Float precio_promedio, Integer telefono, String barrio, byte[] imagen,
			List<String> tipoComidas) {
		repository.cargarDatosRes(rut, descripcion, direccion, horarioApertura, horarioCierre, precio_promedio,
				telefono, barrioMgr.find(barrio), imagen);
		if (tipoComidas != null) {
			for (int i = 0; i < tipoComidas.size(); i++) {
				repository.insertarComida(rut, repository.obtenerIdComida(tipoComidas.get(i)));
			}
		}

	}

	public boolean restauranteYaFueCreado(Restaurante res) {
		boolean creado = true;
		if (repository.verificarRutRestaurante(res.getRUT()) == null) {
			creado = false;
		}
		return creado;
	}

	public String getRut(String nombre, String password) {
		Restaurante res = repository.verificarRestaurante(nombre, password);
		String rut = null;
		if (res != null) {
			rut = res.getRUT();
		}
		return rut;
	}

	public Restaurante find(String RUT) {
		Optional<Restaurante> optional = repository.findById(RUT);
		Restaurante restaurante = null;
		if (optional.isPresent()) {
			restaurante = optional.get();
		}
		return restaurante;
	}

}
