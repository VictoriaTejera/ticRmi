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

@Component("ControladorReservarDirecto")
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
	ControladorListarRestaurantes controladorListarRestaurantes;

	@Autowired
	ReservaMgr reservaMgr;

	private ApplicationContext applicationContext;

//	private Restaurante restaurante;

	@FXML
	void handleButtonAction(ActionEvent event) {
		if (event.getSource() == btnReservar) {
			if (cantPersonas.getText() != "") {
				Reserva reserva = new Reserva(controladorInicioSesion.getUsuario(), controladorListarRestaurantes.getRestaurante(),
						Integer.parseInt(cantPersonas.getText()));
				reservaMgr.save(controladorInicioSesion.getUsuario().getCelular(), controladorListarRestaurantes.getRestaurante().getRUT(),
						Integer.parseInt(cantPersonas.getText()));
			} else {
				showAlert("Ingrese una cantidad de personas.");
			}
		}
	}

	@FXML
	void initialize() {
		assert btnReservar != null : "fx:id=\"btnReservar\" was not injected: check your FXML file 'Reservar.fxml'.";
		assert cantPersonas != null : "fx:id=\"cantPersonas\" was not injected: check your FXML file 'Reservar.fxml'.";
	}

	

//	public void setRestaurante(Restaurante restaurante) {
//		this.restaurante = restaurante;
//	}
	
	public static void showAlert(String title) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(null);
        alert.showAndWait();
    }
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
