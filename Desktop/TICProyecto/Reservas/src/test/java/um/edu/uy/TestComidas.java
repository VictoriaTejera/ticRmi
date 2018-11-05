package um.edu.uy;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javafx.collections.ObservableList;
import um.edu.uy.persistance.ComidaMgr;
import um.edu.uy.persistance.entidades.Comida;

@SpringBootTest(classes = MainRestaurante.class)
@RunWith(SpringRunner.class)
public class TestComidas {

	@Autowired
	ComidaMgr comidaMgr;

	@Test
	public void testGetComidas() {
		Comida comida = new Comida("tipo");
		comidaMgr.save(comida);
		ObservableList<String> lista = comidaMgr.getComidas();
		System.out.println("Empiezo a imprimir test ---------------------------------------------------");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("Termino de imprimir test ---------------------------------------------------");
		
		
	}

}
