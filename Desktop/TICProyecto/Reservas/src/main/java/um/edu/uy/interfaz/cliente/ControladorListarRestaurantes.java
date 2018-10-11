package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class ControladorListarRestaurantes implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Restaurante, String> columnaDireccion;

    @FXML
    private TableColumn<Restaurante, String> columnaNombre;

    @FXML
    private TableColumn<Restaurante, Integer> columnaTelefono;

    @FXML
    private TableView<Restaurante> tabla;
    
    @Autowired
	private RestauranteMgr restaurante;
    
    ApplicationContext applicationContext;
    
    public void llenarTabla() {
    	columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    	columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    	tabla.setItems(restaurante.getRestaurants());
    }


    @FXML
    void initialize() {
        assert columnaDireccion != null : "fx:id=\"columnaDireccion\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert columnaNombre != null : "fx:id=\"columnaNombre\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert columnaTelefono != null : "fx:id=\"columnaTelefono\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert tabla != null : "fx:id=\"tabla\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";

    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
