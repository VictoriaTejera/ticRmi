package um.edu.uy.persistance;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Restaurante;

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

}
