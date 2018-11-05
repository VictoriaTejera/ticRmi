package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import um.edu.uy.interfaz.cliente.clasesAuxiliares.RestauranteAUX;
import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class ControladorReservarDirecto implements ApplicationContextAware {

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
    
    private ApplicationContext applicationContext;

    @FXML
    void handleButtonAction(ActionEvent event) {
    	if (event.getSource() == btnReservar) {
			Reserva reserva = new Reserva(controladorInicioSesion.getUsuario(), controlador.getRestaurante(), Integer.parseInt(cantPersonas.getText()));
			reservaMgr.save(reserva);
		}
    }

    @FXML
    void initialize() {
        assert btnReservar != null : "fx:id=\"btnReservar\" was not injected: check your FXML file 'Reservar.fxml'.";
        assert cantPersonas != null : "fx:id=\"cantPersonas\" was not injected: check your FXML file 'Reservar.fxml'.";
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
    
    
}
