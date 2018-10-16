package um.edu.uy.interfaz.administrador;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class AdminControladorRegistro implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRegistrar;

	@FXML
	private TextField txtContrasena;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtRut;
	
	@Autowired
	private RestauranteMgr resMgr;
	
	ApplicationContext applicationContext;

	public AdminControladorRegistro() {
		super();
	}

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnRegistrar) {
			Restaurante restaurante = new Restaurante(txtRut.getText(), txtNombre.getText(), txtEmail.getText(), txtContrasena.getText());
			if(resMgr.restauranteYaFueCreado(restaurante) == false) {
				resMgr.save(restaurante);
				stage = (Stage) btnRegistrar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("final.fxml"));
			}else {
//				stage = (Stage) btnRegistrar.getScene().getWindow();
//				root = FXMLLoader.load(getClass().getResource("final.fxml"));
			}
		}
		stage.setScene(new Scene(root));
		stage.show();
	}

	@FXML
	void initialize() {
		assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistrarRestaurante.fxml'.";
		assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'RegistrarRestaurante.fxml'.";
		assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'RegistrarRestaurante.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'RegistrarRestaurante.fxml'.";
		assert txtRut != null : "fx:id=\"txtRut\" was not injected: check your FXML file 'RegistrarRestaurante.fxml'.";
	
		}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}