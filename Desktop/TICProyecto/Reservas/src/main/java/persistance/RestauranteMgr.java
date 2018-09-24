package persistance;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import persistance.entidades.Restaurante;

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
