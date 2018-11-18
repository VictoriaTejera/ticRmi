package um.edu.uy.services;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.BarrioRemoteMgt;
import javafx.collections.ObservableList;
import um.edu.uy.business.BarrioMgr;
import um.edu.uy.business.entities.Barrio;

public class BarrioRemoteMgr implements BarrioRemoteMgt {

	@Autowired
	private BarrioMgr barrioMgr;
	
	
	@Override
	public void save(Barrio barrio) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<String> getBarrios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barrio find(String nombreBarrio) {
		// TODO Auto-generated method stub
		return null;
	}

}
