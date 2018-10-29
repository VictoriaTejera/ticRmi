package um.edu.uy.interfaz.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class ControladorDetallesRestaurante {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReservar;

    @FXML
    private TableColumn<Restaurante, String> colDireccion;

    @FXML
    private TableColumn<Restaurante, String> colHoraApertura;
    
    @FXML
    private TableColumn<Restaurante, String> colHoraCierre;

    @FXML
    private TableColumn<Restaurante, Float> colRating;

    @FXML
    private TableColumn<Restaurante, Integer> colTel;

    @FXML
    private Label descripcion;

    @FXML
    private Label nombreRest;

    @FXML
    private TableView<Restaurante> tabla;
    
    @Autowired
    ControladorListarRestaurantes controlador;


    @FXML
    void RealizarReserva(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert btnReservar != null : "fx:id=\"btnReservar\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert colDireccion != null : "fx:id=\"colDireccion\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert colHoraApertura != null : "fx:id=\"colHoraApertura\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert colHoraCierre != null : "fx:id=\"colHoraCierre\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert colRating != null : "fx:id=\"colRating\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert colTel != null : "fx:id=\"colTel\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert descripcion != null : "fx:id=\"descripcion\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert nombreRest != null : "fx:id=\"nombreRest\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        assert tabla != null : "fx:id=\"tabla\" was not injected: check your FXML file 'DetallesRestaurante.fxml'.";
        
        nombreRest.setText(controlador.restSeleccionado().getNombre());
        
        colDireccion.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("direccion"));
        colHoraApertura.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("horarioApertura"));
        colHoraCierre.setCellValueFactory(new PropertyValueFactory<Restaurante,String>("horarioCierre"));
        colRating.setCellValueFactory(new PropertyValueFactory<Restaurante,Float>("rating"));
        colTel.setCellValueFactory(new PropertyValueFactory<Restaurante,Integer>("telefono"));
        
        ObservableList<Restaurante> lista = FXCollections.observableArrayList();
        lista.add(controlador.restSeleccionado());
        tabla.setItems(lista);
        
        descripcion.setText(controlador.restSeleccionado().getDescripcion());
    }

}
