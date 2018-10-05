package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import um.edu.uy.Main;

@Component
public class ControladorInicio {

	@Autowired
	private Main main;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnIniciarSesion;

	@FXML
	private Button btnRegistrarse;

	@FXML
	void initialize() {
		assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'pantalla1.fxml'.";
		assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'pantalla1.fxml'.";

	}

	@FXML
	void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();

		if (event.getSource() == btnRegistrarse) {
			fxmlLoader.setControllerFactory(Main.getContext()::getBean);
			root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("registrarse.fxml"));
			stage = (Stage) btnRegistrarse.getScene().getWindow();
		} else {
			root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("iniciarSesion.fxml"));
			stage = (Stage) btnIniciarSesion.getScene().getWindow();
		}
		stage.setScene(new Scene(root));
		stage.show();
	}

}
