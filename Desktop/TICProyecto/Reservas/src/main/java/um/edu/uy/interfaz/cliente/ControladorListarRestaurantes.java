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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import um.edu.uy.Main;
import um.edu.uy.interfaz.cliente.clasesAuxiliares.RestauranteAUX;
import um.edu.uy.interfaz.restaurante.ControladorMenuRest;
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
	private TableColumn<RestauranteAUX, String> columnaDireccion;

	@FXML
	private TableColumn<RestauranteAUX, String> columnaNombre;

	@FXML
	private TableColumn<RestauranteAUX, String> columnaTelefono;

	@FXML
	private TableColumn<RestauranteAUX, String> columnaReservar;

	@FXML
	private TableView<RestauranteAUX> tabla;

	@FXML
	private Button btnVolverAlMenu;

	@Autowired
	private RestauranteMgr restaurante;
	
    @Autowired
 	private BarrioMgr barrioMgr;
    
    @Autowired
 	private ComidaMgr comidaMgr;
    
    private ApplicationContext applicationContext;
    
    @FXML
    private TableColumn<RestauranteAUX, String> colDireccion;

    @FXML
    private TableColumn<RestauranteAUX, String> colHorario;

    @FXML
    private TableColumn<RestauranteAUX, Float> colRating;

    @FXML
    private TableColumn<RestauranteAUX, Integer> colTel;

    @FXML
    private Label descripciónRest;

    @FXML
    private Label nombreRest;
    
    private final StringProperty prop = new SimpleStringProperty();
<<<<<<< HEAD
    private int usuarioCelular;
    
    public void setUsuarioCelular (int uC) {
    	usuarioCelular=uC;
    }
    public void llenarTabla() {
    	columnaNombre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
    	     public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
    	    	 prop.setValue(r.getValue().getRestaurante().getNombre());
    	    	 return prop;
    	     }
    	  });
    	 
    	columnaDireccion.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
   	     public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
	    	 prop.setValue(r.getValue().getRestaurante().getDireccion());
	    	 return prop;
	     }
	  });
    	
    	columnaTelefono.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
   	     public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
	    	 prop.setValue(Integer.toString(r.getValue().getRestaurante().getTelefono()));
	    	 return prop;
	     }
	  });
    	
    	columnaReservar.setCellValueFactory(new PropertyValueFactory<RestauranteAUX, String>("button"));
    	
    	ObservableList<RestauranteAUX> restaurantes = FXCollections.observableArrayList();
    	RestauranteAUX restAux;
=======

	public void llenarTabla() {
		columnaNombre.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
						prop.setValue(r.getValue().getRestaurante().getNombre());
						return prop;
					}
				});

		columnaDireccion.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
						prop.setValue(r.getValue().getRestaurante().getDireccion());
						return prop;
					}
				});

		columnaTelefono.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<RestauranteAUX, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<RestauranteAUX, String> r) {
						prop.setValue(Integer.toString(r.getValue().getRestaurante().getTelefono()));
						return prop;
					}
				});

		columnaReservar.setCellValueFactory(new PropertyValueFactory<RestauranteAUX, String>("button"));

		ObservableList<RestauranteAUX> restaurantes = FXCollections.observableArrayList();
		RestauranteAUX restAux;
>>>>>>> 4f58b1446972e11d699f10e937d829c06f1a2c5c
		for (int i = 0; i < restaurante.getRestaurants().size(); i++) {
			restAux = new RestauranteAUX(restaurante.getRestaurants().get(i));
			restaurantes.add(restAux);
		}

		tabla.setItems(restaurantes);
	}

	@FXML
	void filtroBarrio() {
		cboxBarrio.setItems(barrioMgr.getBarrios());
	}

	@FXML
	void filtroComida() {
		cboxComida.setItems(comidaMgr.getComidas());
	}

	@FXML
	void filtroPrecio() {
	}

	@FXML
	void ListarRestaurantes(ActionEvent event) {
		if (event.getSource() == btnBuscar) {
			ObservableList<RestauranteAUX> rest = FXCollections.observableArrayList();
			RestauranteAUX restAux;
			if (cboxBarrio.getValue() != null) {
				for (int i = 0; i < restaurante.filtrarPorBarrio(cboxBarrio.getValue()).size(); i++) {
					restAux = new RestauranteAUX(restaurante.filtrarPorBarrio(cboxBarrio.getValue()).get(i));
					rest.add(restAux);
				}
				tabla.setItems(rest);
			}
			if (cboxComida.getValue() != null) {
				for (int i = 0; i < restaurante.filtrarPorComida(cboxComida.getValue()).size(); i++) {
					restAux = new RestauranteAUX(restaurante.filtrarPorComida(cboxComida.getValue()).get(i));
					rest.add(restAux);
				}
				tabla.setItems(rest);
			}
		}
	}

	@FXML
	Restaurante restSeleccionado() {
		Restaurante res = tabla.getSelectionModel().getSelectedItem().getRestaurante();
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
		//stage = (Stage) event.getSource().getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
    }

	@FXML
	void volverAlMenu(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
<<<<<<< HEAD
    	if (event.getSource() == btnVolverAlMenu) {
    		ControladorMenuPrincipal controller = Main.getContext().getBean(ControladorMenuPrincipal.class);
			controller.setUsuarioCelular(usuarioCelular);
			
    		root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
=======
		if (event.getSource() == btnVolverAlMenu) {
			root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
>>>>>>> 4f58b1446972e11d699f10e937d829c06f1a2c5c
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

		llenarTabla();
		filtroBarrio();
		filtroComida();
		filtroPrecio();

		tabla.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setControllerFactory(applicationContext::getBean);
				fxmlLoader.setLocation(getClass().getResource("DetallesRestaurante.fxml"));
				try {
					fxmlLoader.load();
				} catch (IOException ex) {
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
