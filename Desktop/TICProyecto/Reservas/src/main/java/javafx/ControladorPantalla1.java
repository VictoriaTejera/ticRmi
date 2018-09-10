package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControladorPantalla1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarse;


    @FXML
    void initialize() {
        assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'pantalla1.fxml'.";
        assert btnRegistrarse != null : "fx:id=\"btnRegistrarse\" was not injected: check your FXML file 'pantalla1.fxml'.";


    }
    
    @FXML
    void handleButtonAction(ActionEvent event) {
    	Stage stage; 
        Parent root = null;
        if(event.getSource()==btnRegistrarse){
           //Obtener referencia a la Escena del botón         
           stage=(Stage) btnRegistrarse.getScene().getWindow();
           //cargar el otro documento, en este caso la segundo pantalla
     try {
		root = FXMLLoader.load(getClass().getResource("pantalla2.fxml"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         }
        else{
          stage=(Stage) btnIniciarSesion.getScene().getWindow();
     try {
		root = FXMLLoader.load(getClass().getResource("pantalla3.fxml"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         }
        //Crear una nueva escena con raíz y establecer el escenario
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

}
