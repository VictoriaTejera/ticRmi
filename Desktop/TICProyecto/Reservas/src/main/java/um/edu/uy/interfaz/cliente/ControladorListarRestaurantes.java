package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.jboss.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    private TableColumn<Restaurante, String> columnaInfo;

    @FXML
    private TableView<Restaurante> tabla;
    
    @FXML
    private Button btnVolverAlMenu;
    
    @Autowired
	private RestauranteMgr restaurante;
    
    @Autowired
 	private BarrioMgr barrioMgr;
    
    @Autowired
 	private ComidaMgr comidaMgr;
    
    ApplicationContext applicationContext;
    
    @FXML
    private TableColumn<Restaurante, String> colDireccion;

    @FXML
    private TableColumn<Restaurante, String> colHorario;

    @FXML
    private TableColumn<Restaurante, Float> colRating;

    @FXML
    private TableColumn<Restaurante, Integer> colTel;

    @FXML
    private Label descripciónRest;

    @FXML
    private Label nombreRest;
    
    

    public void llenarTabla() {
    	columnaNombre.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("nombre"));
    	columnaDireccion.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("direccion"));
    	columnaTelefono.setCellValueFactory(new PropertyValueFactory<Restaurante,Integer>("telefono"));
//    	columnaInfo.setCellValueFactory(new PropertyValueFactory<Restaurante, String>("button"));
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
    		if(cboxComida.getValue()!=null) {
    			tabla.setItems(restaurante.filtrarPorComida(cboxComida.getValue()));
    		}
    	}
    }
    
//    @FXML
//    void seleccionarRestaurante(){
//    	tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//    	    if (newSelection != null) {
//    	        Restaurante res = tabla.getSelectionModel().getSelectedItem();
//    	    }
//    	});
//    }
    
    @FXML
    Restaurante restSeleccionado() {
    	Restaurante res = tabla.getSelectionModel().getSelectedItem();
    	return res;
    }
    
    @FXML
    void mostrarRestaurante(ActionEvent event) throws IOException {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		root = fxmlLoader.load(ControladorListarRestaurantes.class.getResourceAsStream("DetallesRestaurante.fxml"));
		stage.setScene(new Scene(root));
    }
    	  
    @FXML
    void volverAlMenu(ActionEvent event) throws IOException {
    	Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
    	if (event.getSource() == btnVolverAlMenu) {
    		root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
			stage = (Stage) btnVolverAlMenu.getScene().getWindow();
    	}
    	Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
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
        
        tabla.setOnMousePressed(new EventHandler<MouseEvent>(){
        	@Override
	    	public void handle(MouseEvent event){
	    		FXMLLoader fxmlLoader = new FXMLLoader();
	    		fxmlLoader.setControllerFactory(applicationContext::getBean);
	    		fxmlLoader.setLocation(getClass().getResource("DetallesRestaurante.fxml"));
	    		try {
	    			//fxmlLoader.load(ControladorListarRestaurantes.class.getResourceAsStream("DetallesRestaurante.fxml"));
	    			fxmlLoader.load();
	    		}catch(IOException ex){
	    			Logger.getLogger(ControladorListarRestaurantes.class.getName()).log(null, ex);
	    		}
	    		Parent root = fxmlLoader.getRoot();
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(root));
	    		stage.show();
	    	}
	    });

    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
