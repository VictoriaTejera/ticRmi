package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import um.edu.uy.persistance.entidades.Usuario;

public class ControladorRegistro {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRegistrarse;

	@FXML
	private TextField txtCelular;

	@FXML
	private PasswordField txtContrasena;

	@FXML
	private TextField txtNombre;

	@FXML
	void handleSubmitButtonAction(ActionEvent event) {
		Usuario u1 = new Usuario(txtNombre.getText(), txtContrasena.getText(), Long.parseLong(txtCelular.getText()));
	}

	@FXML
	void initialize() {
		assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtCelular != null : "fx:id=\"txtCelular\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'registrarse.fxml'.";

	}

}