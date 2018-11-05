package um.edu.uy.interfaz.restaurante;

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
public class ControladorDatosActualizadosExitosamenteRest implements ApplicationContextAware  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVolverAMenu;

    private ApplicationContext applicationContext;

    @FXML
	void volverAMenu(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		if(event.getSource()==btnVolverAMenu) {
			stage = (Stage) btnVolverAMenu.getScene().getWindow();
			root = fxmlLoader.load(
					ControladorActualizarDatosRest.class.getResourceAsStream("MenuPrincipal.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

    @FXML
    void initialize() {
        assert btnVolverAMenu != null : "fx:id=\"btnVolverAMenu\" was not injected: check your FXML file 'WarningDatosGuardadosExitosamente.fxml'.";
    }

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
	


}
