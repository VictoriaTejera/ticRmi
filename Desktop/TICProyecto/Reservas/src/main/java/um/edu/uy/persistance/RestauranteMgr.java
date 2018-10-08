package um.edu.uy.persistance;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

@Service
public class RestauranteMgr{
	
	@Autowired
	private RestauranteRepository repository;
	
	public List<Restaurante> getRestaurants(){
		Iterable<Restaurante> it=repository.findAll();
		List<Restaurante> lista=new LinkedList<>();
		for(Restaurante r:it) {
			lista.add(r);
		}
		return lista;
	}
	
	public void save(Restaurante res) {
		repository.save(res);
	}
	
	public List<Restaurante> filtrarPorBarrio(String nombreBarrio) {
		List<Restaurante> restaurantes = repository.filtrarPorBarrio(nombreBarrio);
		return restaurantes;
	}
	
	public List<Restaurante> filtrarPorComida(String tipoComida){
		List<Restaurante> restaurantes = repository.filtrarPorComida(tipoComida);
		return restaurantes;
	}
	
	public List<Restaurante> filtrarPorPrecio(Float precioMenor, Float precioMayor){
		List<Restaurante> restaurantes= repository.filtrarPorPrecio(precioMenor, precioMayor);
		return restaurantes;
		
	}

}
