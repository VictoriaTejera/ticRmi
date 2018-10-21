package um.edu.uy.interfaz.restaurante;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.persistance.BarrioMgr;
import um.edu.uy.persistance.ComidaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Barrio;

@Component
public class ControladorActualizarDatosRest implements ApplicationContextAware{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGuardarDatos;

    @FXML
    private ComboBox<String> cboxBarrio;

    @FXML
    private ComboBox<String> cboxTiposComida;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtHorarioApertura;

    @FXML
    private TextField txtHorarioCierre;

    @FXML
    private TextField txtPrecioPromedio;

	ApplicationContext applicationContext;
	
	@Autowired 
	private BarrioMgr barrioMgr;
	
	@Autowired
	private ComidaMgr comidaMgr;
	
	@Autowired 
	private RestauranteMgr resMgr;

    @FXML
    void handleBarrioCbox(ActionEvent event) {
    	cboxBarrio.setItems(barrioMgr.getBarrios());
    }
    
    @FXML
    void handleTipoComidaCbox(ActionEvent event) {
    	cboxTiposComida.setItems(comidaMgr.getComidas());
    }
    
    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		
		if (event.getSource() == btnGuardarDatos) {
			String barrio = null;
			if(cboxBarrio.getValue()!=null) {
    			barrio=cboxBarrio.getValue();
    		}
			String tipoComida = null;
			if(cboxTiposComida.getValue()!=null) {
    			tipoComida=cboxTiposComida.getValue();
    		}
			resMgr.cargarDatosRes(rut, descripcion, direccion, horario, precio_promedio, telefono);
			
		}
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void initialize() {
        assert btnGuardarDatos != null : "fx:id=\"btnGuardarDatos\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert cboxBarrio != null : "fx:id=\"cboxBarrio\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert cboxTiposComida != null : "fx:id=\"cboxTiposComida\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert txtHorarioApertura != null : "fx:id=\"txtHorarioApertura\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert txtHorarioCierre != null : "fx:id=\"txtHorarioCierre\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
        assert txtPrecioPromedio != null : "fx:id=\"txtPrecioPromedio\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
