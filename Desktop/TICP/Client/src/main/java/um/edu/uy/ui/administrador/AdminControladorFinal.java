package um.edu.uy.ui.administrador;

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
import um.edu.uy.ui.cliente.ControladorInicio;

@Component
public class AdminControladorFinal implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRegresar;

	@FXML
	private Button btnSalir;

	private ApplicationContext applicationContext;

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();

		if (event.getSource() == btnRegresar) {
			stage = (Stage) btnRegresar.getScene().getWindow();
			root = fxmlLoader.load(getClass().getResourceAsStream("inicio.fxml"));
			
		} else if (event.getSource() == btnSalir) {
			stage = (Stage) btnSalir.getScene().getWindow();
	        stage.close();
		}

		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
}

	@FXML
	void initialize() {
		assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'final.fxml'.";
		assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'final.fxml'.";
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
}