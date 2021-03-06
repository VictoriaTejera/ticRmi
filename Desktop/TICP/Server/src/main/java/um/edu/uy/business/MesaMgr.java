package um.edu.uy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.presistence.MesaRepository;



@Service
public class MesaMgr {
	
	@Autowired
	private MesaRepository repository;
	
	public void save(String RUT, Integer capacidad) {
		repository.insertarMesa(capacidad, RUT);
	}
	
	
	public void marcarMesaComoReservada(Long id) {
		repository.marcarMesaComoReservada(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
//	public boolean isReservada(Long id) {
//		return repository.isReservada(id);
//	}

	
}
