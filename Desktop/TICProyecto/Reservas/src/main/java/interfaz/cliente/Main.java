package interfaz.cliente;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import persistance.entidades.Restaurante;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Main extends Application {
	Button btnRegistrarse, btnIniciarSesion, btnConfirmarInicioSesion; // botones que mandaran a llamar a la ventana que deseamos abrir
	Scene scene, scene2, scene1, scene3;// con esto cargaremos el contenido de cada ventana un scene por cada una
	Stage thestage;// este Stage se utiliza para cargar la ventana se puede utilizar con todas las
					// ventanas
	

	@Override
	public void start(Stage primaryStage) throws IOException {
		thestage = primaryStage;
		btnRegistrarse = new Button();
		btnIniciarSesion = new Button();
		btnConfirmarInicioSesion = new Button();
		btnRegistrarse.setOnAction(e -> ButtonClicked(e));// Indicamos que hará una acción cuando se dé clic en el botón
		btnIniciarSesion.setOnAction(e -> ButtonClicked(e));
		btnConfirmarInicioSesion.setOnAction(e -> ButtonClicked(e));
				
	    Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
		Parent root1 = FXMLLoader.load(getClass().getResource("registrarse.fxml"));
		Parent root2 = FXMLLoader.load(getClass().getResource("iniciarSesion.fxml"));
		Scene scene = new Scene(root, 400, 400);
		Scene scene1 = new Scene(root1, 400, 400);
		Scene scene2 = new Scene(root2, 400, 400);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		
		thestage.setTitle("reservas - JavaFX");

        //thestage.setScene(scene3);
        //thestage.show();
	}
	
	public static Scene getSceneTable() {
		TableView<Restaurante> table;
		// Columna Nombre
		TableColumn<Restaurante, String> columnaNombre = new TableColumn<>("Nombre");
		columnaNombre.setMinWidth(200);
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

		// Columna Direccion
		TableColumn<Restaurante, String> columnaDireccion = new TableColumn<>("Direccion");
		columnaDireccion.setMinWidth(100);
		columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		// Columna Telefono
		TableColumn<Restaurante, Integer> columnaTelefono = new TableColumn<>("Telefono");
		columnaTelefono.setMinWidth(100);
		columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
		table = new TableView<>();
        table.setItems(getRestaurante());
        table.getColumns().addAll(columnaNombre, columnaDireccion, columnaTelefono);
		VBox vBox = new VBox();

        vBox.getChildren().addAll(table);
		Scene scene3 = new Scene(vBox);
		
		return scene3;
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void ButtonClicked(ActionEvent e) {
		// aquí en caso de presionar algún boton se declara qué escena deseamos ejecutar

		if (e.getSource() == btnRegistrarse)
			thestage.setScene(scene1);
		if (e.getSource() == btnIniciarSesion)
			thestage.setScene(scene2);
		if (e.getSource() == btnConfirmarInicioSesion)
			thestage.setScene(scene3);
	}
	
	//Get all of the products
    public static ObservableList<Restaurante> getRestaurante(){
        ObservableList<Restaurante> restaurantes = FXCollections.observableArrayList();
        restaurantes.add(new Restaurante("Burger King", "calle1, 102", 23445678));
        restaurantes.add(new Restaurante("One Love", "calle2, 200", 23446655));
        return restaurantes;
    }
}
