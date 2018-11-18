package um.edu.uy.services;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.ComidaRemoteMgt;
import javafx.collections.ObservableList;
import um.edu.uy.business.ComidaMgr;
import um.edu.uy.business.entities.Comida;

public class ComidaRemoteMgr implements ComidaRemoteMgt {

	@Autowired
	private ComidaMgr comidaMgr;
	
	@Override
	public void save(Comida comida) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<String> getComidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long find(String tipoComida) {
		// TODO Auto-generated method stub
		return null;
	}

}
