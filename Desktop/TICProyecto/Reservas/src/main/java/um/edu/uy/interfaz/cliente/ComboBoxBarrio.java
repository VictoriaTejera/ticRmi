package um.edu.uy.interfaz.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import um.edu.uy.persistance.BarrioMgr;

@Component
public class ComboBoxBarrio {
	  @Autowired
	  BarrioMgr barrioMgr;
	  
	  ComboBox<String> cbx;
	  
	  Button button;
   
	  public Scene getScene(){
    	ObservableList<String> items = FXCollections.observableArrayList();
    	items.addAll(barrioMgr.getBarrios());
    	cbx = new ComboBox<>(items);
    	button = new Button ("Aceptar");
    	
    	GridPane pane = new GridPane();
    	pane.add(cbx, 3, 0);
    	pane.add(button, 0, 3);
    	
    	Scene scene = new Scene(pane, 250, 150);
    	return scene;
    }
	
	public boolean getEventButton(ActionEvent event) {
		boolean result = false;
		if (event.getSource() == button) {
    		result = true;
		} 
		
		return result;
	}
	  
	public String getBarrio() {
		String barrio = cbx.getValue();
		return barrio;
	}
}
