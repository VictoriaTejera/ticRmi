package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControladorProbandoFoto {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label myLabel;
    

    Image image = new Image(getClass().getResourceAsStream("pizza.jpeg")); 
	
    public void insertarImagen() {
	myLabel.setGraphic(new ImageView(image));
    }

    @FXML
    void initialize() {
        assert myLabel != null : "fx:id=\"myLabel\" was not injected: check your FXML file 'ProbandoFoto.fxml'.";


    }

}

	
	

