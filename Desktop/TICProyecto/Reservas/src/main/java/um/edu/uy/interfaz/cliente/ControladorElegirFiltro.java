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

@Component
public class ControladorElegirFiltro implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBarrio;

    @FXML
    private Button btnComida;
    
    @FXML
	TextField txtComida;
    
    @FXML 
    TextField txtBarrio;
    
    ApplicationContext applicationContext;
    
    @Autowired
    private TablaPorComida tablaPorComida;
    
    @Autowired
    private TablaPorBarrio tablaPorBarrio;

    @FXML
    void filtrarRestaurantes(ActionEvent event) throws IOException {
    	Stage stage = null;
    	Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
    	
    	if (event.getSource() == btnComida) {
			stage = (Stage) btnComida.getScene().getWindow();
			stage.setScene(tablaPorComida.getSceneTable());
		}
    	if (event.getSource() == btnBarrio) {
    		stage = (Stage) btnBarrio.getScene().getWindow();
			stage.setScene(tablaPorBarrio.getSceneTable());	
    	}
    	stage.setScene(new Scene(root));
    	stage.show();
    }

    @FXML
    void initialize() {
        assert btnBarrio != null : "fx:id=\"btnBarrio\" was not injected: check your FXML file 'ElegirFiltro.fxml'.";
        assert btnComida != null : "fx:id=\"btnComida\" was not injected: check your FXML file 'ElegirFiltro.fxml'.";
    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
