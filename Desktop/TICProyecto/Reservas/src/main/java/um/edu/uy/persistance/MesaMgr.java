package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Mesa;

@Service
public class MesaMgr {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public void save(Mesa mesa) {
		mesaRepository.save(mesa);
	}
	
	
	public void marcarMesaComoReservada(Long id) {
		mesaRepository.marcarMesaComoReservada(id);
	}

}
