package um.edu.uy.interfaz.administrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import um.edu.uy.interfaz.cliente.clasesAuxiliares.RestauranteAUX;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class AdminControladorVerPagosPendientes implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnVolverAlMenu;

	@FXML
	private TableColumn<Restaurante, String> columnaNombre;

	@FXML
	private TableColumn<Restaurante, String> columnaTelefono;

	@FXML
	private TableColumn<Restaurante, String> columnaCantidad;

	@FXML
	private TableView<Restaurante> tabla;
	
	private StringProperty prop = new SimpleStringProperty();
	
	@Autowired
	AdminControladorPagosPendientes controller;

	private static ApplicationContext applicationContext;

	public void llenarTabla() {
		columnaNombre.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Restaurante, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Restaurante, String> r) {
						prop.setValue(r.getValue().getNombre());
						return prop;
					}
				});
		columnaTelefono.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Restaurante, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Restaurante, String> r) {
						prop.setValue(Integer.toString(r.getValue().getTelefono()));
						return prop;
					}
				});
//		columnaCantidad.setCellValueFactory(
//				new Callback<TableColumn.CellDataFeatures<Restaurante, String>, ObservableValue<String>>() {
//					public ObservableValue<String> call(TableColumn.CellDataFeatures<Restaurante, String> r) {
//						prop.setValue(Integer.toString(r.getValue().getTelefono()));
//						return prop;
//					}
//				});
		
		controller.getFechaInicio();
		controller.getFechaFin();
		ObservableList<Restaurante> restaurantes=null; //operacion get restaurantes
		
		tabla.setItems(restaurantes);
	}

//	@FXML
//	void initialize(MouseEvent event) {
//	}

	@FXML
	void volverAlMenu(ActionEvent event) throws IOException {
		Stage stage;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
		if (event.getSource() == btnVolverAlMenu) {
			stage = (Stage) btnVolverAlMenu.getScene().getWindow();
			root = fxmlLoader.load(AdminControladorRegistro.class.getResourceAsStream("inicio.fxml"));
		}
		stage.setScene(new Scene(root));
		stage.show();
	}

	@FXML
	void initialize() {
		assert btnVolverAlMenu != null : "fx:id=\"btnVolverAlMenu\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
		assert columnaCantidad != null : "fx:id=\"columnaCantidad\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
		assert columnaNombre != null : "fx:id=\"columnaNombre\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
		assert columnaTelefono != null : "fx:id=\"columnaTelefono\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";
		assert tabla != null : "fx:id=\"tabla\" was not injected: check your FXML file 'verPagosPendientes.fxml'.";

		llenarTabla();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
