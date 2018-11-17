package um.edu.uy.interfaz.administrador;

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
import um.edu.uy.interfaz.cliente.ControladorInicio;

@Component
public class AdminControladorInicio  implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarRestaurante;
    
    @FXML
    private Button btnPagosPendientes;

    ApplicationContext applicationContext;

    @FXML
    void handleSubmitButtonAction(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
		if (event.getSource() == btnRegistrarRestaurante) {
			stage = (Stage) btnRegistrarRestaurante.getScene().getWindow();
			root = fxmlLoader.load(AdminControladorRegistro.class.getResourceAsStream("RegistrarRestaurante.fxml"));
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void pagosPendientes(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
		if (event.getSource() == btnPagosPendientes) {
			stage = (Stage) btnRegistrarRestaurante.getScene().getWindow();
			root = fxmlLoader.load(AdminControladorRegistro.class.getResourceAsStream("recibirFechasParaPagosPendientes.fxml"));
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void initialize() {
    	assert btnRegistrarRestaurante != null : "fx:id=\"btnRegistrarRestaurante\" was not injected: check your FXML file 'inicio.fxml'.";

    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}