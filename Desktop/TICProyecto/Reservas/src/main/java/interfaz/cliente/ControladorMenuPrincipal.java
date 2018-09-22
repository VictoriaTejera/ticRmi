package interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControladorMenuPrincipal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnListarRestaurantes;

    @FXML
    private Button btnSalir;


    @FXML
    void ListarRestaurantes(ActionEvent event) {
    	Stage stage = null;
    	if (event.getSource() == btnListarRestaurantes) {
			stage = (Stage) btnListarRestaurantes.getScene().getWindow();
		} 
		
		stage.setScene(Tabla.getSceneTable());
		stage.show();
    	
    }

    @FXML
    void initialize() {
        assert btnListarRestaurantes != null : "fx:id=\"btnListarRestaurantes\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";


    }

}
