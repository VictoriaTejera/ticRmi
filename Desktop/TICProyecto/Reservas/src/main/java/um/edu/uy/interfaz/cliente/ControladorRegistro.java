package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
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
import um.edu.uy.Main;
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.entidades.Usuario;
@Component
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
	
	@Autowired
	UsuarioMgr usuMgr;
	
	public ControladorRegistro() {
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws Exception {
		Usuario user = new Usuario(txtNombre.getText(), txtContrasena.getText(), Integer.parseInt(txtCelular.getText()));
		usuMgr.save(user);
	}

	@FXML
	void initialize() {
		assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtCelular != null : "fx:id=\"txtCelular\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'registrarse.fxml'.";
		assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'registrarse.fxml'.";

	}

}