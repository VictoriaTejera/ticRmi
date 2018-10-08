package um.edu.uy.interfaz.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import um.edu.uy.persistance.BarrioMgr;

@Component
public class ComboBoxBarrio {
	  @Autowired
	  BarrioMgr barrioMgr;
	  
	  ComboBox<String> cbx;
   
	  public Scene getScene(){
    	ObservableList<String> items = FXCollections.observableArrayList();
    	items.addAll(barrioMgr.getBarrios());
    	cbx = new ComboBox<>(items);
    	StackPane pane = new StackPane(cbx);
    	Scene scene = new Scene(pane, 250, 150);
    	return scene;
    }
	  
	public String getBarrio() {
		String barrio = cbx.getValue();
		return barrio;
	}
}
