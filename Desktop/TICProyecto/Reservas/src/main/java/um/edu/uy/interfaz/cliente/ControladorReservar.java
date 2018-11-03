package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;

@Component
public class ControladorReservar {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReservar;
    
    @FXML
    private TextField cantPersonas;
        
    @Autowired
    ControladorInicioSesion controladorInicioSesion;    
    
    @Autowired
    ControladorListarRestaurantes controlador;
    
    @Autowired
    ReservaMgr reservaMgr;

    @FXML
    void handleButtonAction(ActionEvent event) {
    	if (event.getSource() == btnReservar) {
			Reserva reserva = new Reserva(controladorInicioSesion.getUsuario(), controlador.restSeleccionado(), Integer.parseInt(cantPersonas.getText()));
			reservaMgr.save(reserva);
		}
    }

    @FXML
    void initialize() {
        assert btnReservar != null : "fx:id=\"btnReservar\" was not injected: check your FXML file 'Reservar.fxml'.";
        assert cantPersonas != null : "fx:id=\"cantPersonas\" was not injected: check your FXML file 'Reservar.fxml'.";
    }
    
}


