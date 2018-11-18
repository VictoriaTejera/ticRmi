package um.edu.uy.ui.cliente;

import java.io.IOException;
import java.net.URL;

import um.edu.uy.business.ReservaMgr;
import um.edu.uy.business.entities.Reserva;

import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.ActionEvent;

@Component
public class ControladorMisReservas implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<Reserva, String> confirmadas;

	@FXML
	private TableColumn<Reserva, String> pendientes;

	@FXML
	private TableView<Reserva> tablaConfirmadas;

	@FXML
	private TableView<Reserva> tablaPendientes;

	@FXML
	private Button btnVolver;

	@Autowired
	private ReservaMgr resMgr;

	@Autowired
	private ControladorInicioSesion controladorInicio;

	private ApplicationContext applicationContext;

	private final StringProperty prop = new SimpleStringProperty();
	
    @FXML
    void volverAlMenu(ActionEvent event) throws IOException {

        Parent root = null;
        Stage stage = null;
        
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();
		if (event.getSource() == btnVolver) {
			root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
			stage = (Stage) btnVolver.getScene().getWindow();
		}
		Scene scene = new Scene(root );
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
    }

	@FXML
	void initialize() {
		assert confirmadas != null : "fx:id=\"confirmadas\" was not injected: check your FXML file 'MisReservas.fxml'.";
		assert pendientes != null : "fx:id=\"pendientes\" was not injected: check your FXML file 'MisReservas.fxml'.";
		assert tablaConfirmadas != null : "fx:id=\"tablaConfirmadas\" was not injected: check your FXML file 'MisReservas.fxml'.";
		assert tablaPendientes != null : "fx:id=\"tablaPendientes\" was not injected: check your FXML file 'MisReservas.fxml'.";
		assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'MisReservas.fxml'.";

		confirmadas.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {

						prop.setValue(r.getValue().getRestaurante().getNombre());
						return prop;
					}
				});

		pendientes.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {
						prop.setValue(r.getValue().getRestaurante().getNombre());
						return prop;
					}
				});

//		List<Reserva> todasLasReservas = resMgr.verEstadoReservasUsuario(controladorInicio.getUsuario().getCelular());
//
//		for (Reserva r : todasLasReservas) {
//			if (r.isConfirmado() == true) {
//				((List<Reserva>) tablaPendientes).add(r);
//			} else {
//				((List<Reserva>) tablaConfirmadas).add(r);
//			}
//		}

	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
