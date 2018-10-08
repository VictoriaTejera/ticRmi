package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Comida;

@Service
public class ComidaMgr {

	@Autowired
	private ComidaRepository repository;
	
	public void save(Comida comida) {
		repository.save(comida);
	}
	
}