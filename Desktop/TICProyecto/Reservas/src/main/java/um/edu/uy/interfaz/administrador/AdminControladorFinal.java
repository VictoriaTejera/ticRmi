package um.edu.uy.interfaz.administrador;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class AdminControladorFinal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSalir;


    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'final.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'final.fxml'.";


    }

}
