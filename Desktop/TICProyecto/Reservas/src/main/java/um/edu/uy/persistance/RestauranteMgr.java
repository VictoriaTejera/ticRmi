package um.edu.uy.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
public class RestauranteMgr {

	@Autowired
	private RestauranteRepository repository;

	public ObservableList<Restaurante> getRestaurants() {
		Iterable<Restaurante> it = repository.findAll();
		ObservableList<Restaurante> lista = FXCollections.observableArrayList();
		for (Restaurante r : it) {
			lista.add(r);
		}
		return lista;
	}

	public void save(Restaurante res) {
		repository.save(res);
	}

	public ObservableList<Restaurante> filtrarPorBarrio(String nombreBarrio) {
		List<Restaurante> restaurantes = repository.filtrarPorBarrio(nombreBarrio);
		ObservableList<Restaurante> observ = FXCollections.observableArrayList();
		for (int i = 0; i < restaurantes.size(); i++) {
			observ.add(restaurantes.get(i));
		}
		return observ;
	}

	public ObservableList<Restaurante> filtrarPorComida(String tipoComida) {
		List<Restaurante> restaurantes = repository.filtrarPorComida(tipoComida);
		ObservableList<Restaurante> observ = FXCollections.observableArrayList();
		for (int i = 0; i < restaurantes.size(); i++) {
			observ.add(restaurantes.get(i));
		}
		return observ;
	}
	
	public List<Restaurante> filtrarPorPrecio(Float precioMenor, Float precioMayor){
		List<Restaurante> restaurantes= repository.filtrarPorPrecio(precioMenor, precioMayor);
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
	public void cargarDatosRes(String rut, String descripcion, String direccion, String horarioApertura, String horarioCierre, Float precio_promedio, Integer telefono) {
		repository.cargarDatosRes(rut, descripcion, direccion, horarioApertura, horarioCierre, precio_promedio, telefono);
	}
	public boolean restauranteYaFueCreado(Restaurante res) {
		boolean creado = true;
		if (repository.verificarRutRestaurante(res.getRUT()) == null) {
			creado = false;
		}
		return creado;
	}
	
	public String getRut(String nombre, String password) {
		Restaurante res=repository.verificarRestaurante(nombre, password);
		return res.getRUT();
	}

}
