package Mgt;
import java.rmi.Remote;

import javafx.collections.ObservableList;
import um.edu.uy.business.entities.Comida;

public interface ComidaRemoteMgt extends Remote {
	
	void save(Comida comida);
	
	ObservableList<String> getComidas();
	
	Long find(String tipoComida);
	
	

}
