package um.edu.uy.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;

@Service
public class ComidaMgr {

	@Autowired
	private ComidaRepository repository;
	
	public void save(Comida comida) {
		repository.save(comida);
	}
	
	public ObservableList<Comida> getComidas() {
		Iterable<Comida> it = repository.findAll();
		ObservableList<Comida> lista = FXCollections.observableArrayList();
		for (Comida c : it) {
			lista.add(c);
		}
		return lista;
	}
	
	
}