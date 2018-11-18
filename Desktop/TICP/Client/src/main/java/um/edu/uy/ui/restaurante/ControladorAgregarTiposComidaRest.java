package um.edu.uy.ui.restaurante;

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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import um.edu.uy.business.ComidaMgr;
import um.edu.uy.business.RestauranteMgr;
import um.edu.uy.interfaz.restaurante.ControladorInicioSesionRest;
import um.edu.uy.ui.cliente.ControladorInicio;

@Component
public class ControladorAgregarTiposComidaRest implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarMasTiposComida;

    @FXML
    private ComboBox<String> btnTipoComida1;

    @FXML
    private ComboBox<String> btnTipoComida2;

    @FXML
    private ComboBox<String> btnTipoComida3;

    @FXML
    private Button btnVolverAAgregarDatos;
    
    ApplicationContext applicationContext;
    
    @Autowired 
    private ComidaMgr comidaMgr;
    
    @Autowired
    private RestauranteMgr restauranteMgr;
    
    @Autowired
	ControladorInicioSesionRest controller;
    
    @Autowired 
    ControladorActualizarDatosRest controllerActualizarDatos;
    
    @Autowired
    ControladorAgregarTiposComidaRest controllerAgregarTiposComida;
   
    @FXML
    void handleTipoComidaCbox1(ActionEvent event) {
    	btnTipoComida1.setItems(comidaMgr.getComidas());
    }
    
    @FXML
    void handleTipoComidaCbox2(ActionEvent event) {
    	btnTipoComida2.setItems(comidaMgr.getComidas());
    }
    
    @FXML
    void handleTipoComidaCbox3(ActionEvent event) {
    	btnTipoComida3.setItems(comidaMgr.getComidas());
    }
    
    @FXML
    void agregarMasTiposComida(ActionEvent event) throws IOException {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnAgregarMasTiposComida) {
			if (btnTipoComida1.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida1.getValue());
			}
			if (btnTipoComida2.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida2.getValue());
			}
			if (btnTipoComida3.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida3.getValue());
			}
			stage = (Stage) btnAgregarMasTiposComida.getScene().getWindow();
			root = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("AgregarTiposComida.fxml"));
			controllerAgregarTiposComida.handleTipoComidaCbox1(event);
			controllerAgregarTiposComida.handleTipoComidaCbox2(event);
			controllerAgregarTiposComida.handleTipoComidaCbox3(event);
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
}

    @FXML
    void volverAAgregarDatos(ActionEvent event) throws IOException {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnVolverAAgregarDatos) {
			if (btnTipoComida1.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida1.getValue());
			}
			if (btnTipoComida2.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida2.getValue());
			}
			if (btnTipoComida3.getValue() != null) {
				restauranteMgr.insertarComida(controller.getRutRestaurante(), btnTipoComida3.getValue());
			}
			stage = (Stage) btnVolverAAgregarDatos.getScene().getWindow();
			root = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("MenuPrincipalRest.fxml"));
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void initialize() {
        assert btnAgregarMasTiposComida != null : "fx:id=\"btnAgregarMasTiposComida\" was not injected: check your FXML file 'AgregarTiposComida.fxml'.";
        assert btnTipoComida1 != null : "fx:id=\"btnTipoComida1\" was not injected: check your FXML file 'AgregarTiposComida.fxml'.";
        assert btnTipoComida2 != null : "fx:id=\"btnTipoComida2\" was not injected: check your FXML file 'AgregarTiposComida.fxml'.";
        assert btnTipoComida3 != null : "fx:id=\"btnTipoComida3\" was not injected: check your FXML file 'AgregarTiposComida.fxml'.";
        assert btnVolverAAgregarDatos != null : "fx:id=\"btnVolverAAgregarDatos\" was not injected: check your FXML file 'AgregarTiposComida.fxml'.";


    }

    @Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}

