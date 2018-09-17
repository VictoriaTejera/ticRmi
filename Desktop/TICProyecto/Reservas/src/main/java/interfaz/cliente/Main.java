package interfaz.cliente;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Main extends Application {
	Button btnRegistrarse, btnIniciarSesion; // botones que mandaran a llamar a la ventana que deseamos abrir
	Scene scene, scene2, scene1;// con esto cargaremos el contenido de cada ventana un scene por cada una
	Stage thestage;// este Stage se utiliza para cargar la ventana se puede utilizar con todas las
					// ventanas

	@Override
	public void start(Stage primaryStage) {
		try {
			thestage = primaryStage;
			btnRegistrarse = new Button();
			btnIniciarSesion = new Button();
			btnRegistrarse.setOnAction(e -> ButtonClicked(e));// Indicamos que hará una acción cuando se dé clic en el botón
			btnIniciarSesion.setOnAction(e -> ButtonClicked(e));

			Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
			Parent root1 = FXMLLoader.load(getClass().getResource("registrarse.fxml"));
			Parent root2 = FXMLLoader.load(getClass().getResource("iniciarSesion.fxml"));
			Scene scene = new Scene(root, 400, 400);
			Scene scene1 = new Scene(root1, 400, 400);
			Scene scene2 = new Scene(root2, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void ButtonClicked(ActionEvent e) {
	    //aquí en caso de presionar algún boton se declara qué escena deseamos ejecutar
	  
	    if (e.getSource()==btnRegistrarse)
	        thestage.setScene(scene1);
	    else
	        thestage.setScene(scene2);
	}
}
