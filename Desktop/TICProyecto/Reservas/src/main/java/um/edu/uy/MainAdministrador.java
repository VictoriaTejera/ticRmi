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
import um.edu.uy.interfaz.administrador.AdminControladorRegistro;
import um.edu.uy.interfaz.cliente.ControladorInicio;

@SpringBootApplication
public class MainAdministrador extends Application {
	Button btnRegistrarRestaurante, btnRegistrar;
	Scene scene, scene1, scene2;
	Stage thestage;
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader, fxmlLoader1, fxmlLoader2;
	private Parent root, root1, root2;

	@Override
	public void init() throws Exception {
		MainAdministrador.context = SpringApplication.run(MainAdministrador.class);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		thestage = primaryStage;
		btnRegistrarRestaurante = new Button();
		btnRegistrar = new Button();

		btnRegistrarRestaurante.setOnAction(e -> ButtonClicked(e));
		btnRegistrar.setOnAction(e -> ButtonClicked(e));
		
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainAdministrador.getContext()::getBean);

		root = fxmlLoader.load(AdminControladorRegistro.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		fxmlLoader1 = new FXMLLoader();
		fxmlLoader1.setControllerFactory(MainAdministrador.getContext()::getBean);

		root1 = fxmlLoader1.load(AdminControladorRegistro.class.getResourceAsStream("RegistrarRestaurante.fxml"));
		scene1 = new Scene(root1);
		scene1.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		
		fxmlLoader2 = new FXMLLoader();
		fxmlLoader2.setControllerFactory(MainAdministrador.getContext()::getBean);

		root2 = fxmlLoader2.load(AdminControladorRegistro.class.getResourceAsStream("final.fxml"));
		scene2 = new Scene(root2);
		scene2.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
		scene.getStylesheets().add(AdminControladorRegistro.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnRegistrarRestaurante)
			thestage.setScene(scene1);
		if (e.getSource() == btnRegistrar)
			thestage.setScene(scene2);
		
	}

	public void stop() {
		context.close();
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}