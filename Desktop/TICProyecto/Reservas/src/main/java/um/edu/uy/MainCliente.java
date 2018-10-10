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

@SpringBootApplication
public class Main extends Application {
	Button btnRegistrarse, btnIniciarSesion, btnConfirmarInicioSesion, btnListarRestaurantes, btnConfirmarRegistro;
	Scene scene, scene2, scene1, scene3, scene4;
	Stage thestage;
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader, fxmlLoader1, fxmlLoader2, fxmlLoader3;
	private Parent root, root1, root2, root3;

	@Override
	public void init() throws Exception {
		Main.context = SpringApplication.run(Main.class);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		thestage = primaryStage;
		btnRegistrarse = new Button();
		btnIniciarSesion = new Button();
		btnConfirmarInicioSesion = new Button();
		btnConfirmarRegistro = new Button();

		btnRegistrarse.setOnAction(e -> ButtonClicked(e));
		btnIniciarSesion.setOnAction(e -> ButtonClicked(e));
		btnConfirmarInicioSesion.setOnAction(e -> ButtonClicked(e));
		btnConfirmarRegistro.setOnAction(e -> ButtonClicked(e));

		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(Main.getContext()::getBean);

		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		fxmlLoader1 = new FXMLLoader();
		fxmlLoader1.setControllerFactory(Main.getContext()::getBean);

		root1 = fxmlLoader1.load(ControladorRegistro.class.getResourceAsStream("registrarse.fxml"));
		scene1 = new Scene(root1);
		
		fxmlLoader2 = new FXMLLoader();
		fxmlLoader2.setControllerFactory(Main.getContext()::getBean);

		root2 = fxmlLoader2.load(ControladorRegistro.class.getResourceAsStream("iniciarSesion.fxml"));
		scene2 = new Scene(root2);

		fxmlLoader3 = new FXMLLoader();
		fxmlLoader3.setControllerFactory(Main.getContext()::getBean);

		root3 = fxmlLoader3.load(ControladorRegistro.class.getResourceAsStream("MenuPrincipal.fxml"));
		scene3 = new Scene(root3);

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
		if (e.getSource() == btnIniciarSesion)
			thestage.setScene(scene2);
		if (e.getSource() == btnConfirmarInicioSesion)
			thestage.setScene(scene4);
		if (e.getSource() == btnListarRestaurantes)
			thestage.setScene(scene3);
		if (e.getSource() == btnConfirmarRegistro)
			thestage.setScene(scene2);
	}

	public void stop() {
		context.close();
	}

	public static ConfigurableApplicationContext getContext() {
		return context;
	}

}