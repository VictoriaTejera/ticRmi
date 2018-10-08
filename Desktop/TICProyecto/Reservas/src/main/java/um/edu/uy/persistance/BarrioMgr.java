package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Restaurante;

@Service
public class BarrioMgr {

	@Autowired
	private BarrioRepository repository;
	
	public void save(Barrio barrio) {
		repository.save(barrio);
	}
	
	public ObservableList<String> getBarrios() {
		Iterable<Barrio> it = repository.findAll();
		ObservableList<String> lista = FXCollections.observableArrayList();
		for (Barrio r : it) {
			lista.add(r.getNombreBarrio());
		}
		return lista;
	}
	
	
}
