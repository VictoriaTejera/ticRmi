package um.edu.uy.interfaz.cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import um.edu.uy.persistance.entidades.Restaurante;

public class Tabla {
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
        table.setItems(getRestaurante()); //le paso la lista de restaurantes
        table.getColumns().addAll(columnaNombre, columnaDireccion, columnaTelefono);
		VBox vBox = new VBox();

        vBox.getChildren().addAll(table);
		Scene scene3 = new Scene(vBox);
		
		return scene3;
	}
	
	//Obtener todos los restaurantes
    public static ObservableList<Restaurante> getRestaurante(){
        ObservableList<Restaurante> restaurantes = FXCollections.observableArrayList();
        restaurantes.add(new Restaurante("Burger King", "calle1, 100", 11111));
        restaurantes.add(new Restaurante("One Love", "calle2, 200", 22222));
        restaurantes.add(new Restaurante("Magnum", "calle3, 300", 33333));
        restaurantes.add(new Restaurante("Rudy", "calle4, 400", 44444));
        restaurantes.add(new Restaurante("Tandory", "calle5, 500", 55555));	
        
        return restaurantes;
    }
}
