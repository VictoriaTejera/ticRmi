package um.edu.uy.ui.cliente;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.business.UsuarioMgr;
import um.edu.uy.business.entities.Usuario;

@Component
public class ControladorRegistro implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnConfirmarRegistro;

	@FXML
	private Button btnVolver;

	@FXML
	private TextField txtCelular;

	@FXML
	private PasswordField txtContrasena;

	@FXML
	private TextField txtNombre;

	@Autowired
	UsuarioMgr usuMgr;

	private ApplicationContext applicationContext;

	public ControladorRegistro() {
	}

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws Exception {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();

		if (event.getSource() == btnConfirmarRegistro) {
			Usuario user = new Usuario(txtNombre.getText(), txtContrasena.getText(),
					Integer.parseInt(txtCelular.getText()));
			if (usuMgr.usuarioYaFueCreado(user) == false) {
				usuMgr.save(user);
				root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("iniciarSesion.fxml"));
				stage = (Stage) btnConfirmarRegistro.getScene().getWindow();
			} else {
				showAlert("No se ha podido registrar al usuario: " , "Ya existe.");
			}
		}
		if (event.getSource() == btnVolver) {
			root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("inicio.fxml"));
			stage = (Stage) btnVolver.getScene().getWindow();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		stage.setScene(scene);
    	stage.show();
}

	@FXML
	void initialize() {
		assert btnConfirmarRegistro != null : "fx:id=\"btnConfirmarRegistro\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtCelular != null : "fx:id=\"txtCelular\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'registrarse.fxml'.";
		
		 
			
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
	public static void showAlert(String title, String contextText) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

}