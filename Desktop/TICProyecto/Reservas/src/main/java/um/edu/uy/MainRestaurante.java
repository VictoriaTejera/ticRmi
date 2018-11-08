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
import um.edu.uy.interfaz.cliente.ControladorInicio;
import um.edu.uy.interfaz.restaurante.ControladorInicioSesionRest;

@SpringBootApplication
public class MainRestaurante extends Application{
	Button btnIniciarSesion, btnDatos, btnGuardarDatos, btnCargarImagen, btnVolverAMenu;
	Scene scene, scene1, scene2, scene3;
	Stage thestage;
	
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader;
	private Parent root, root1, root2, root3;
	
	@Override
	public void init() throws IOException  {
		MainRestaurante.context = SpringApplication.run(MainRestaurante.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		thestage = primaryStage;
		btnIniciarSesion = new Button();
		btnDatos = new Button();
		btnGuardarDatos = new Button();
		btnCargarImagen = new Button();
//		btnVolverAMenu = new Button();
		
		btnIniciarSesion.setOnAction(e -> ButtonClicked(e));
		btnDatos.setOnAction(e -> ButtonClicked(e));
		btnGuardarDatos.setOnAction(e -> ButtonClicked(e));
		btnCargarImagen.setOnAction(e -> ButtonClicked(e));
		
		
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainRestaurante.getContext()::getBean);
		
		root = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainRestaurante.getContext()::getBean);
		
		root1 = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("MenuPrincipalRest.fxml"));
		scene1 = new Scene(root1);
		
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainRestaurante.getContext()::getBean);
		
		root2 = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("ActualizarDatosRest.fxml"));
		scene2 = new Scene(root2);
		
//		fxmlLoader = new FXMLLoader();
//		fxmlLoader.setControllerFactory(MainRestaurante.getContext()::getBean);
//		
//		root3 = fxmlLoader.load(ControladorInicioSesionRest.class.getResourceAsStream("WarningDatosGuardadosExitosamente.fxml"));
//		scene3 = new Scene(root3);		
		
		scene.getStylesheets().add(ControladorInicio.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion)
			thestage.setScene(scene1);
		if (e.getSource() == btnDatos)
			thestage.setScene(scene2);
		if (e.getSource() == btnGuardarDatos)
			thestage.setScene(scene1);	
//		if (e.getSource() == btnVolverAMenu)
//			thestage.setScene(scene1);
	}
	
	public void stop() {
		context.close();
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}
