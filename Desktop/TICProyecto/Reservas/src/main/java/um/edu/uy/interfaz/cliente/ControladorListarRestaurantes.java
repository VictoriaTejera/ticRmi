package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import um.edu.uy.persistance.BarrioMgr;
import um.edu.uy.persistance.ComidaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class ControladorListarRestaurantes implements ApplicationContextAware {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<String> cboxBarrio;

    @FXML
    private ComboBox<String> cboxComida;

    @FXML
    private ComboBox<String> cboxPrecio;

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
    
    @Autowired
 	private BarrioMgr barrioMgr;
    
    @Autowired
 	private ComidaMgr comidaMgr;
    
    ApplicationContext applicationContext;
    
    

    public void llenarTabla() {
    	columnaNombre.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("nombre"));
    	columnaDireccion.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("direccion"));
    	columnaTelefono.setCellValueFactory(new PropertyValueFactory<Restaurante,Integer>("telefono"));
    	tabla.setItems(restaurante.getRestaurants());
    }
    
    @FXML
    void filtroBarrio(ActionEvent event) {
    	cboxBarrio.setItems(barrioMgr.getBarrios());
    }

    @FXML
    void filtroComida(ActionEvent event) {
    	cboxComida.setItems(comidaMgr.getComidas());
    }

    @FXML
    void filtroPrecio(ActionEvent event) {
    }

    @FXML
    void ListarRestaurantes(ActionEvent event) {
    	if (event.getSource() == btnBuscar) {
    		if(cboxBarrio.getValue()!=null) {
    			tabla.setItems(restaurante.filtrarPorBarrio(cboxBarrio.getValue()));
    		}
    	}
    }

    @FXML
    void initialize() {
    	assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert cboxBarrio != null : "fx:id=\"cboxBarrio\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert cboxComida != null : "fx:id=\"cboxComida\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert cboxPrecio != null : "fx:id=\"cboxPrecio\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert columnaDireccion != null : "fx:id=\"columnaDireccion\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert columnaNombre != null : "fx:id=\"columnaNombre\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert columnaTelefono != null : "fx:id=\"columnaTelefono\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";
        assert tabla != null : "fx:id=\"tabla\" was not injected: check your FXML file 'ListarRestaurantes.fxml'.";

    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
