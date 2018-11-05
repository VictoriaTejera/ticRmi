package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Mesa;

@Service
public class MesaMgr {
	
	@Autowired
	private MesaRepository repository;
	
	public void save(Mesa mesa) {
		repository.save(mesa);
	}
	

}
