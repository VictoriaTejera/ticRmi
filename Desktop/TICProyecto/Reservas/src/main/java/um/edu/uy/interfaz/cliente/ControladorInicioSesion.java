package um.edu.uy.interfaz.cliente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.entidades.Usuario;
@Component
public class ControladorInicioSesion {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnConfirmarInicioSesion;
	
	@FXML
	private PasswordField txtContrasena;

	@FXML
	private TextField txtNombre;

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		Usuario user = new Usuario(txtNombre.getText(), txtContrasena.getText());
		if (event.getSource() == btnConfirmarInicioSesion && UsuarioMgr.verificarUsuario(user)==true) {
			stage = (Stage) btnConfirmarInicioSesion.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void initialize() {
	}
}
