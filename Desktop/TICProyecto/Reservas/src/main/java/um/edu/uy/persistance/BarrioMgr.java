package um.edu.uy.persistance;

import java.util.List;

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
	
	public Barrio find(String nombreBarrio) {
		List<Barrio> lista=repository.getBarrioByNombre(nombreBarrio);
		Barrio barrio=null;
		if(lista.size()==1) {
			barrio=lista.get(0);
		}
		return barrio;
	}
	
	
}
