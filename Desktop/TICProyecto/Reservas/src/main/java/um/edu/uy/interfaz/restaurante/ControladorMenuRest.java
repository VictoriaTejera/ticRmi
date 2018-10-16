package um.edu.uy.interfaz.restaurante;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class ControladorMenuRest {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDatos;

    @FXML
    private Button btnReservas;


    @FXML
    void initialize() {
        assert btnDatos != null : "fx:id=\"btnDatos\" was not injected: check your FXML file 'MenuPrincipalRest.fxml'.";
        assert btnReservas != null : "fx:id=\"btnReservas\" was not injected: check your FXML file 'MenuPrincipalRest.fxml'.";


    }

}
