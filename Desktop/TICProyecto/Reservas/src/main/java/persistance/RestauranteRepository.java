package persistance;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import persistance.entidades.Restaurante;

public class RestauranteRepository {
	@Autowired
	private RestauranteRepositoryInterno interno;
	
	public RestauranteRepository(ApplicationContext ctx) {
		interno= ctx.getBean(RestauranteRepositoryInterno.class);
	}
	
	public List<Restaurante> getRestaurants() throws SQLException {
		return interno.getRestaurants();
	}

}
