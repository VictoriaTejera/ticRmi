package um.edu.uy.interfaz.restaurante;

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
import um.edu.uy.persistance.BarrioMgr;
import um.edu.uy.persistance.ComidaMgr;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Barrio;

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

//	@FXML
//	private Button btnVolverAMenu;

	@FXML
	private ImageView imgView;

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
	private TextField txtDireccion;

	@FXML
	private TextField txtPrecioPromedio;

	@FXML
	private TextField txtTelefono;

	ApplicationContext applicationContext;

	@Autowired
	private BarrioMgr barrioMgr;

	@Autowired
	private ComidaMgr comidaMgr;

	@Autowired
	private RestauranteMgr resMgr;

	byte[] imagenAGuardar = null;

	@Autowired
	ControladorInicioSesionRest controller;

	@FXML
	void handleBarrioCbox(ActionEvent event) {
		cboxBarrio.setItems(barrioMgr.getBarrios());
	}

	@FXML
	void handleTipoComidaCbox(ActionEvent event) {
		cboxTiposComida.setItems(comidaMgr.getComidas());
	}

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnGuardarDatos) {
			String barrio = null;
			if (cboxBarrio.getValue() != null) {
				barrio = cboxBarrio.getValue();
			}
			String tipoComida = null;
			if (cboxTiposComida.getValue() != null) {
				tipoComida = cboxTiposComida.getValue();
			}
			resMgr.cargarDatosRes(controller.getRutRest(), txtDescripcion.getText(), txtDireccion.getText(),
					txtHorarioApertura.getText(), txtHorarioCierre.getText(),
					Float.parseFloat(txtPrecioPromedio.getText()), Integer.parseInt(txtTelefono.getText()), barrio,
					imagenAGuardar);
			stage = (Stage) btnGuardarDatos.getScene().getWindow();
			root = fxmlLoader.load(
					ControladorActualizarDatosRest.class.getResourceAsStream("MenuPrincipal.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void cargarImagen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		Stage stage = (Stage) btnCargarImagen.getScene().getWindow();
		Parent root = fxmlLoader
				.load(ControladorActualizarDatosRest.class.getResourceAsStream("ActualizarDatosRest.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);

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

//	@FXML
//	void volverAMenu(ActionEvent event) throws IOException {
//		Stage stage = new Stage();
//		Parent root = null;
//		FXMLLoader fxmlLoader = new FXMLLoader();
//		fxmlLoader.setControllerFactory(applicationContext::getBean);
//		if(event.getSource()==btnVolverAMenu) {
//			stage = (Stage) btnGuardarDatos.getScene().getWindow();
//			root = fxmlLoader.load(
//					ControladorActualizarDatosRest.class.getResourceAsStream("MenuPrincipal.fxml"));
//		}
//		Scene scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}

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