package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@Component
public class ControladorInicio implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnIniciarSesion;

	@FXML
	private Button btnRegistrarse;
	
	ApplicationContext applicationContext;

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
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();

		if (event.getSource() == btnRegistrarse) {
			root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("registrarse.fxml"));
			stage = (Stage) btnRegistrarse.getScene().getWindow();
		} else {
			root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("iniciarSesion.fxml"));
			stage = (Stage) btnIniciarSesion.getScene().getWindow();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
