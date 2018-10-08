package um.edu.uy.persistance;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Service
public class RestauranteMgr{
	
	@Autowired
	private RestauranteRepository repository;
	
	public ObservableList<Restaurante> getRestaurants(){
		Iterable<Restaurante> it=repository.findAll();
		ObservableList<Restaurante> lista=FXCollections.observableArrayList();
		for(Restaurante r:it) {
			lista.add(r);
		}
		return lista;
	}
	
	public void save(Restaurante res) {
		repository.save(res);
	}
	
	public ObservableList<Restaurante> filtrarPorBarrio(String nombreBarrio) {
		ObservableList<Restaurante> restaurantes = repository.filtrarPorBarrio(nombreBarrio);
		return restaurantes;
	}
	
	public ObservableList<Restaurante> filtrarPorComida(String tipoComida){
		ObservableList<Restaurante> restaurantes = repository.filtrarPorComida(tipoComida);
		return restaurantes;
	}

}
