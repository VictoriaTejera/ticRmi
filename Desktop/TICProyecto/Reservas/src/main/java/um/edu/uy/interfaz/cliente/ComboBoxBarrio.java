package um.edu.uy.interfaz.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import um.edu.uy.persistance.BarrioMgr;

@Component
public class ComboBoxBarrio extends Application {
	  @Autowired
	  BarrioMgr barrioMgr;
	  
	  ComboBox<String> cbx;
	  
	  Button button;
	  
	  @Autowired
	  private TablaPorBarrio tablaPorBarrio;
	  
	  Stage thestage;
	 
	public void buttonClicked(ActionEvent event) {
		if (event.getSource() == button) {
			thestage.setScene(tablaPorBarrio.getSceneTable());
		} 
	}

	public String getBarrio() {
		String barrio = cbx.getValue();
		return barrio;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<String> items = FXCollections.observableArrayList();
    	items.addAll(barrioMgr.getBarrios());
    	
    	cbx = new ComboBox<>(items);
    	button = new Button ("Aceptar");
    	button.setOnAction(e -> buttonClicked(e));
    	
    	GridPane pane = new GridPane();
    	pane.add(cbx, 3, 0);
    	pane.add(button, 0, 3);
    	
    	Scene scene = new Scene(pane, 250, 150);
    	primaryStage.setScene(scene);
        primaryStage.show();
		
	}
}
