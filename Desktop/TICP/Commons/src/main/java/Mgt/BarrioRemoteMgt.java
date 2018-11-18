package Mgt;
import java.rmi.Remote;

import javafx.collections.ObservableList;
import um.edu.uy.business.entities.Barrio;

public interface BarrioRemoteMgt extends Remote {
	
	void save(Barrio barrio);
	
	ObservableList<String> getBarrios();
	
	Barrio find(String nombreBarrio);
	
	

}
