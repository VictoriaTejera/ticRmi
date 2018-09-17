package interfaz.administrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ControladorInicio {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarRestaurante;


    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnRegistrarRestaurante != null : "fx:id=\"btnRegistrarRestaurante\" was not injected: check your FXML file 'inicio.fxml'.";


    }

}