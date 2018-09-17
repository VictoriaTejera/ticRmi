package interfaz.administrador;

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


public class ControladorInicio {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarRestaurante;


    @FXML
    void handleSubmitButtonAction(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		if (event.getSource() == btnRegistrarRestaurante) {
			stage = (Stage) btnRegistrarRestaurante.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("registrarRestaurante.fxml"));
		}
    }

    @FXML
    void initialize() {
        assert btnRegistrarRestaurante != null : "fx:id=\"btnRegistrarRestaurante\" was not injected: check your FXML file 'inicio.fxml'.";


    }

}