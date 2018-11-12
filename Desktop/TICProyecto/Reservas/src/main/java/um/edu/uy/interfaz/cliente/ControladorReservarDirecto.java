package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.interfaz.cliente.clasesAuxiliares.RestauranteAUX;
import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;
import um.edu.uy.persistance.entidades.Usuario;

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
	void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		
		if (event.getSource() == btnReservar) {
			try {
				reservaMgr.save(controladorInicioSesion.getUsuario().getCelular(), controladorListarRestaurantes.getRestaurante().getRUT(),
						Integer.parseInt(cantPersonas.getText()));
				stage = (Stage) btnReservar.getScene().getWindow();
				root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
			}catch(NumberFormatException e) {
				showAlert("Ingrese una cantidad de personas.");
			}

	    	Scene scene = new Scene(root);
			scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
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
