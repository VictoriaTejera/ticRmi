package um.edu.uy.ui.cliente;

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
import javafx.stage.Stage;
import um.edu.uy.interfaz.cliente.ControladorRegistro;
import um.edu.uy.interfaz.restaurante.ControladorMenuRest;

@Component
public class ControladorMenuPrincipal implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnListarRestaurantes;
    
    @FXML
    private Button btnReservasRealizadas;


    @FXML
    private Button btnPuntuarRest;
    
    @FXML
    private Button btnCloseButton;
    
    ApplicationContext applicationContext;
    
    @Autowired
    ControladorListarRestaurantes listar;

    @FXML
    void ListarRestaurantes(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();

		if (event.getSource() == btnListarRestaurantes) {
			root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("ListarRestaurantes.fxml"));
			stage = (Stage) btnListarRestaurantes.getScene().getWindow();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
}
    
    @FXML
    void reservasRealizadas(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
    	if (event.getSource() == btnReservasRealizadas) {
    		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("MisReservas.fxml"));
    		stage = (Stage) btnReservasRealizadas.getScene().getWindow();
		}
    	Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();


    }
    
    @FXML
    void PuntuarRestaurantes(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
    	if (event.getSource() == btnPuntuarRest) {
    		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("PuntuarRestaurantes.fxml"));
    		stage = (Stage)  btnPuntuarRest.getScene().getWindow();
		}
    	Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
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
        assert btnPuntuarRest != null : "fx:id=\"btnPuntuarRest\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
