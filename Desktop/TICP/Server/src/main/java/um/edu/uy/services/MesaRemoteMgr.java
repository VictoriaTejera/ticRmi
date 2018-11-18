package um.edu.uy.services;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.MesaRemoteMgt;
import um.edu.uy.business.MesaMgr;

public class MesaRemoteMgr implements MesaRemoteMgt {

	@Autowired
	private MesaMgr mesaMgr;
	
	
	@Override
	public void save(String RUT, Integer capacidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void marcarMesaComoReservada(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
