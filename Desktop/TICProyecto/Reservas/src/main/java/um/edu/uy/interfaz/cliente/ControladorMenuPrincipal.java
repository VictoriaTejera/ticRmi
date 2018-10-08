package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@Component
public class ControladorMenuPrincipal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnListarRestaurantes;

    @FXML
    private Button btnCloseButton;
    
    @FXML
    private Button btnFiltrarRestaurantes;
    
    ApplicationContext applicationContext;

    @FXML
    void ListarRestaurantes(ActionEvent event) throws IOException {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
    	
    	if (event.getSource() == btnListarRestaurantes) {
			stage = (Stage) btnListarRestaurantes.getScene().getWindow();
			stage.setScene(Tabla.getSceneTable());
		}
    	if (event.getSource() == btnFiltrarRestaurantes) {
    		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("ElegirFiltro.fxml"));
			stage = (Stage) btnFiltrarRestaurantes.getScene().getWindow();
		} 
	
		stage.show();
    }
    
    @FXML
    void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnCloseButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert btnListarRestaurantes != null : "fx:id=\"btnListarRestaurantes\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnCloseButton != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";

    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
