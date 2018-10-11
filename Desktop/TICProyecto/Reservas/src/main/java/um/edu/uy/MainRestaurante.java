package um.edu.uy;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import um.edu.uy.interfaz.cliente.ControladorRegistro;
import um.edu.uy.interfaz.restaurante.ControladorInicioSesionRest;

@SpringBootApplication
public class MainRestaurante extends Application{
	Button btnIniciarSesion;
	Scene scene, scene1;
	Stage thestage;
	
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader;
	private Parent root;
	
	
	@Override
	public void init() throws IOException  {
		MainRestaurante.context = SpringApplication.run(Main.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		thestage = primaryStage;
		btnIniciarSesion = new Button();
		btnIniciarSesion.setOnAction(e -> ButtonClicked(e));
		
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(Main.getContext()::getBean);
		
		root = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		scene.getStylesheets().add(ControladorRegistro.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion)
			thestage.setScene(scene1);
	}
	
	public void stop() {
		context.close();
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}
