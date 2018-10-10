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
import um.edu.uy.interfaz.administrador.ControladorRegistro;

@SpringBootApplication
public class MainAdministrador extends Application {
	Button btnRegistrarse, btnConfirmarRegistro;
	Scene scene, scene1;
	Stage thestage;
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader, fxmlLoader1, fxmlLoader2, fxmlLoader3;
	private Parent root, root1, root2, root3;

	@Override
	public void init() throws Exception {
		MainAdministrador.context = SpringApplication.run(MainAdministrador.class);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		thestage = primaryStage;
		btnRegistrarse = new Button();
		btnConfirmarRegistro = new Button();

		btnRegistrarse.setOnAction(e -> ButtonClicked(e));
		btnConfirmarRegistro.setOnAction(e -> ButtonClicked(e));

		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainAdministrador.getContext()::getBean);

		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		fxmlLoader1 = new FXMLLoader();
		fxmlLoader1.setControllerFactory(MainAdministrador.getContext()::getBean);

		root1 = fxmlLoader1.load(ControladorRegistro.class.getResourceAsStream("RegistrarRestaurante.fxml"));
		scene1 = new Scene(root1);
		
		fxmlLoader2 = new FXMLLoader();
		fxmlLoader2.setControllerFactory(MainAdministrador.getContext()::getBean);

		scene.getStylesheets().add(ControladorRegistro.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void ButtonClicked(ActionEvent e) {
		if (e.getSource() == btnRegistrarse)
			thestage.setScene(scene1);
	}

	public void stop() {
		context.close();
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}