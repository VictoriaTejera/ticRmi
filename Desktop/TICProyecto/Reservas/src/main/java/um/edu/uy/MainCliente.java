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
import um.edu.uy.interfaz.cliente.ControladorRegistro;

@SpringBootApplication
public class MainCliente extends Application {
	Button btnRegistrarse, btnIniciarSesion, btnConfirmarInicioSesion, btnListarRestaurantes, btnConfirmarRegistro;
	Scene scene, scene2, scene1, scene3, scene4, scene5;
	Stage thestage;
	private static ConfigurableApplicationContext context;
	private FXMLLoader fxmlLoader, fxmlLoader1, fxmlLoader2, fxmlLoader3, fxmlLoader4;;
	private Parent root, root1, root2, root3, root4;

	@Override
	public void init() throws Exception {
		MainCliente.context = SpringApplication.run(MainCliente.class);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		thestage = primaryStage;
		btnRegistrarse = new Button();
		btnIniciarSesion = new Button();
		btnConfirmarInicioSesion = new Button();
		btnConfirmarRegistro = new Button();
		btnListarRestaurantes = new Button();

		btnRegistrarse.setOnAction(e -> ButtonClicked(e));
		btnIniciarSesion.setOnAction(e -> ButtonClicked(e));
		btnConfirmarInicioSesion.setOnAction(e -> ButtonClicked(e));
		btnConfirmarRegistro.setOnAction(e -> ButtonClicked(e));
		btnListarRestaurantes.setOnAction(e -> ButtonClicked(e));

		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(MainCliente.getContext()::getBean);

		root = fxmlLoader.load(ControladorRegistro.class.getResourceAsStream("inicio.fxml"));
		scene = new Scene(root);
		
		fxmlLoader1 = new FXMLLoader();
		fxmlLoader1.setControllerFactory(MainCliente.getContext()::getBean);

		root1 = fxmlLoader1.load(ControladorRegistro.class.getResourceAsStream("registrarse.fxml"));
		scene1 = new Scene(root1);
		
		fxmlLoader2 = new FXMLLoader();
		fxmlLoader2.setControllerFactory(MainCliente.getContext()::getBean);

		root2 = fxmlLoader2.load(ControladorRegistro.class.getResourceAsStream("iniciarSesion.fxml"));
		scene2 = new Scene(root2);

		fxmlLoader3 = new FXMLLoader();
		fxmlLoader3.setControllerFactory(MainCliente.getContext()::getBean);

		root3 = fxmlLoader3.load(ControladorRegistro.class.getResourceAsStream("MenuPrincipal.fxml"));
		scene3 = new Scene(root3);
		
		fxmlLoader4 = new FXMLLoader();
		fxmlLoader4.setControllerFactory(MainCliente.getContext()::getBean);
		
		root4 = fxmlLoader4.load(ControladorRegistro.class.getResourceAsStream("ListarRestaurantes.fxml"));
		scene4 = new Scene(root4);

		scene.getStylesheets().add(ControladorInicio.class.getResource("style.css").toExternalForm());
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
			thestage.setScene(scene3);
		if (e.getSource() == btnListarRestaurantes)
			thestage.setScene(scene4);
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