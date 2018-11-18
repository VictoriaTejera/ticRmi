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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.ui.cliente.ControladorInicio;


@Component
public class AdminControladorPagosPendientes implements ApplicationContextAware  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVerPagosPendientes;

    @FXML
    private TextField txtFechaFin;

    @FXML
    private TextField txtFechaInicio;

    ApplicationContext applicationContext;
    
    private String fechaInicio;
    private String fechaFin;

	@FXML
    void verPagosPendientes(ActionEvent event) throws IOException {
    	Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
		if (event.getSource() == btnVerPagosPendientes) {
			if(txtFechaInicio.getText()!="" && txtFechaFin.getText()!="") {
				fechaInicio=txtFechaInicio.getText();
				fechaFin=txtFechaFin.getText();
			}else {
				showAlert("Lo sentimos, ", "Ingrese una fecha de inicio y de finalizacion.");
			}
			
			stage = (Stage) btnVerPagosPendientes.getScene().getWindow();
			root = fxmlLoader.load(AdminControladorRegistro.class.getResourceAsStream("verPagosPendientes.fxml"));
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void initialize() {
        assert btnVerPagosPendientes != null : "fx:id=\"btnVerPagosPendientes\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
        assert txtFechaFin != null : "fx:id=\"txtFechaFin\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
        assert txtFechaInicio != null : "fx:id=\"txtFechaInicio\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";


    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static void showAlert(String title, String contextText) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}
}
