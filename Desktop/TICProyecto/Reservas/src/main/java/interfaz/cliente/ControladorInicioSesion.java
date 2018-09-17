package interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControladorInicioSesion {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnConfirmarInicioSesion;

    @FXML
    void handleSubmitButtonAction(ActionEvent event) throws IOException {
    	Stage stage = null;
		if (event.getSource() == btnConfirmarInicioSesion) {
			stage = (Stage) btnConfirmarInicioSesion.getScene().getWindow();
		} 
		
		stage.setScene(Main.getSceneTable());
		stage.show();
    }

    @FXML
    void initialize() {
    }
}
