package um.edu.uy.interfaz.cliente;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import um.edu.uy.persistance.RestauranteMgr;
import um.edu.uy.persistance.entidades.Restaurante;

public class TablaPorComida {
	@Autowired
	private RestauranteMgr restaurante;

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
		table.setItems((ObservableList<Restaurante>) restaurante
				.filtrarPorBarrio(ControladorElegirFiltro.txtComida.getText())); // le paso la lista de restaurantes
		table.getColumns().addAll(columnaNombre, columnaDireccion, columnaTelefono);
		VBox vBox = new VBox();

		vBox.getChildren().addAll(table);
		Scene scene3 = new Scene(vBox);

		return scene3;
	}
}
