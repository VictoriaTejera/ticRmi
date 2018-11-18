package um.edu.uy.ui.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import um.edu.uy.business.ReservaMgr;

@Component("ControladorReservarDirecto")
public class ControladorReservarDirecto {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnReservar;

	@FXML
	private TextField cantPersonas;

	@Autowired
	ControladorInicioSesion controladorInicioSesion;

	@Autowired
	ControladorListarRestaurantes controladorListarRestaurantes;

	@Autowired
	ReservaMgr reservaMgr;

	@FXML
	void handleButtonAction(ActionEvent event){
		Stage stage = null;
		if (event.getSource() == btnReservar) {
			try {
				reservaMgr.save(controladorInicioSesion.getUsuario().getCelular(), controladorListarRestaurantes.getRestaurante().getRUT(),
						Integer.parseInt(cantPersonas.getText()));
				stage = (Stage) btnReservar.getScene().getWindow();
				stage.close();
			}catch(NumberFormatException e) {
				showAlert("Ingrese una cantidad de personas.");
			}
		}
		 Parent root = null;
			Scene scene = new Scene(root);
			scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
			stage.setScene(scene);
	    	stage.show();
			
	}

	@FXML
	void initialize() {
		assert btnReservar != null : "fx:id=\"btnReservar\" was not injected: check your FXML file 'Reservar.fxml'.";
		assert cantPersonas != null : "fx:id=\"cantPersonas\" was not injected: check your FXML file 'Reservar.fxml'.";
	}
	
	public static void showAlert(String title) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(null);
        alert.showAndWait();
    }
	

}
