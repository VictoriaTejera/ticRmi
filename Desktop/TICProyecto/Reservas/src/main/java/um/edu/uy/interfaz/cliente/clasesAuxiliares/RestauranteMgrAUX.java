package um.edu.uy.interfaz.cliente.clasesAuxiliares;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

public class RestauranteMgrAUX {
	@Autowired
	RestauranteMgr resMgr;

	public ObservableList<RestauranteAUX> getRestaurantes() {
		ObservableList<Restaurante> o1 = resMgr.getRestaurants();
		ObservableList<RestauranteAUX> o2 = FXCollections.observableArrayList();
		for (int i = 0; i < o1.size(); i++) {
			o2.add(new RestauranteAUX(o1.get(i)));
		}
		return o2;
	}

}
