package um.edu.uy.interfaz.administrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

@Component
public class AdminControladorFinal {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnRegresar;

	@FXML
	private Button btnSalir;

	private ApplicationContext applicationContext;

	@FXML
	void handleSubmitButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		stage = new Stage();

		if (event.getSource() == btnRegresar) {
			
			stage = (Stage) btnRegresar.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
			
		} else if (event.getSource() == btnSalir) {
			stage = (Stage) btnSalir.getScene().getWindow();
	        stage.close();
		}

		stage.setScene(new Scene(root));
		stage.show();
	}

	@FXML
	void initialize() {
		assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'final.fxml'.";
		assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'final.fxml'.";
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

}
=======
package um.edu.uy.interfaz.administrador;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class AdminControladorFinal {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSalir;


    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnRegresar != null : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'final.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'final.fxml'.";


    }

}
