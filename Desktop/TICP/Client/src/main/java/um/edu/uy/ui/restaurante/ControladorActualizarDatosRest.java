package um.edu.uy.ui.restaurante;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import um.edu.uy.business.BarrioMgr;
import um.edu.uy.business.ComidaMgr;
import um.edu.uy.business.RestauranteMgr;
import um.edu.uy.business.entities.Barrio;
import um.edu.uy.interfaz.restaurante.ControladorAgregarTiposComidaRest;
import um.edu.uy.interfaz.restaurante.ControladorInicioSesionRest;
import um.edu.uy.ui.cliente.ControladorInicio;

@Component
public class ControladorActualizarDatosRest implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnGuardarDatos;

	@FXML
	private Button btnCargarImagen;

	@FXML
	private ImageView imgView;

	@FXML
	private ComboBox<String> cboxBarrio;

	@FXML
	private TextField txtDescripcion;

	@FXML
	private TextField txtHorarioApertura;

	@FXML
	private TextField txtHorarioCierre;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtPrecioPromedio;

	@FXML
	private TextField txtMail;

	@FXML
	private TextField txtCantMesas;

	@FXML
	private TextField txtLugares;

	ApplicationContext applicationContext;

	@Autowired
	private BarrioMgr barrioMgr;

	@Autowired
	private RestauranteMgr resMgr;

	byte[] imagenAGuardar = null;

	private Stage stage;

	@Autowired
	ControladorInicioSesionRest controller;

	@Autowired
	ControladorAgregarTiposComidaRest controllerTiposComida;

	@FXML
	void handleBarrioCbox(ActionEvent event) {
		cboxBarrio.setItems(barrioMgr.getBarrios());
	}

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnGuardarDatos) {
			String rut = controller.getRutRestaurante();
			String descripcion = txtDescripcion.getText();
			String direccion = txtDireccion.getText();
			String horarioApertura = txtHorarioApertura.getText();
			String horarioCierre = txtHorarioCierre.getText();
			String mail = txtMail.getText();
			String barrio = null;
			Float precioPromedio = null;
			Integer cantMesas = null;
			Integer lugaresPorMesa = null;

			if (cboxBarrio.getValue() != null) {
				barrio = cboxBarrio.getValue();
			}
			try {
				precioPromedio = Float.parseFloat(txtPrecioPromedio.getText());
			} catch (NumberFormatException e) {
			}
			try {

				cantMesas = Integer.parseInt(txtCantMesas.getText());
			} catch (NumberFormatException e) {
				if (resMgr.getCantMesas(rut) == 0) {
					showAlert("Cantidad de mesas", "Ingrese la cantidad de mesas para habilitar las reservas.");
				}	
			}
			try {
				lugaresPorMesa = Integer.parseInt(txtLugares.getText());
			} catch (NumberFormatException e) {
				if (resMgr.getCantLugarPorMesa(rut) == 0) {
					showAlert("Lugares por mesa", "Ingrese la cantidad de lugares por mesa para habilitar las reservas.");
				}
				
			}

			resMgr.cargarDatosRes(rut, descripcion, direccion, horarioApertura, horarioCierre, precioPromedio, mail,
					barrio, imagenAGuardar, cantMesas, lugaresPorMesa);

			stage = (Stage) btnGuardarDatos.getScene().getWindow();
			root = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("AgregarTiposComida.fxml"));
			controllerTiposComida.handleTipoComidaCbox1(event);
			controllerTiposComida.handleTipoComidaCbox2(event);
			controllerTiposComida.handleTipoComidaCbox3(event);

		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void cargarImagen() throws IOException {
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*.PNG");
		fc.getExtensionFilters().addAll(ext1, ext2);
		File file = fc.showOpenDialog(stage);

		BufferedImage bf;
		bf = ImageIO.read(file);
		Image image = SwingFXUtils.toFXImage(bf, null);
		imgView.setImage(image);

		byte[] fileContent = Files.readAllBytes(file.toPath());
		imagenAGuardar = fileContent;
	}

	// @FXML
	// void volverAMenu(ActionEvent event) throws IOException {
	// Stage stage = new Stage();
	// Parent root = null;
	// FXMLLoader fxmlLoader = new FXMLLoader();
	// fxmlLoader.setControllerFactory(applicationContext::getBean);
	// if(event.getSource()==btnVolverAMenu) {
	// stage = (Stage) btnGuardarDatos.getScene().getWindow();
	// root = fxmlLoader.load(
	// ControladorActualizarDatosRest.class.getResourceAsStream("MenuPrincipal.fxml"));
	// }
	// Scene scene = new Scene(root);
	// stage.setScene(scene);
	// stage.show();
	// }

	@FXML
	void initialize() {
		assert btnGuardarDatos != null : "fx:id=\"btnGuardarDatos\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert cboxBarrio != null : "fx:id=\"cboxBarrio\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert txtHorarioApertura != null : "fx:id=\"txtHorarioApertura\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert txtHorarioCierre != null : "fx:id=\"txtHorarioCierre\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert txtPrecioPromedio != null : "fx:id=\"txtPrecioPromedio\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
		assert txtLugares != null : "fx:id=\"txtLugares\" was not injected: check your FXML file 'ActualizarDatosRest.fxml'.";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	public static void showAlert(String title, String contextText) {
		javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
				javafx.scene.control.Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(contextText);
		alert.showAndWait();
	}

}
