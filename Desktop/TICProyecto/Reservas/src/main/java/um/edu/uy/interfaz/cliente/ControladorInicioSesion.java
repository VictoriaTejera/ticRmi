package um.edu.uy.interfaz.cliente;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.persistance.UsuarioMgr;
import um.edu.uy.persistance.entidades.Usuario;

@Component
public class ControladorInicioSesion implements ApplicationContextAware {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnConfirmarInicioSesion;

	@FXML
	private PasswordField txtContrasena;

	@FXML
	private TextField txtUsuario;
	
	@Autowired
	private UsuarioMgr usuarioMgr;
	
	private ApplicationContext applicationContext;

	public ControladorInicioSesion() {
		super();
	}

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		stage = new Stage();
		fxmlLoader.setControllerFactory(applicationContext::getBean);

		if (event.getSource() == btnConfirmarInicioSesion) {
			Usuario user = new Usuario(txtUsuario.getText(), txtContrasena.getText());
			System.out.println(user.getNombre());
			
			if (usuarioMgr.verificarUsuario(user) == true) {
				stage = (Stage) btnConfirmarInicioSesion.getScene().getWindow();
				root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("MenuPrincipal.fxml"));
			} else {
				stage = (Stage) btnConfirmarInicioSesion.getScene().getWindow();
				root = fxmlLoader.load(ControladorInicioSesion.class.getResourceAsStream("Warning.fxml"));
			}
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void initialize() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
