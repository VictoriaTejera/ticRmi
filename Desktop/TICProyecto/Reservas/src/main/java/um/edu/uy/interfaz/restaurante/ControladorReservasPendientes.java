package um.edu.uy.interfaz.restaurante;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import um.edu.uy.interfaz.cliente.clasesAuxiliares.RestauranteAUX;
import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;
import um.edu.uy.persistance.entidades.Restaurante;

@Component
public class ControladorReservasPendientes {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private TableColumn<Reserva, String> columnaCantPersonas;

    @FXML
    private TableColumn<Reserva, String> columnaUsuario;

    @FXML
    private TableView<Reserva> reservasPendientes;

    @Autowired
    private ReservaMgr resMgr;
    
    private Restaurante restaurante;
    private final StringProperty prop = new SimpleStringProperty();
    @Autowired
    private ControladorInicioSesionRest controlador;
    

    @FXML
    void initialize() {
    	
    	
    	List<Reserva> listaDePendientes =  resMgr.obtenerReservasNoConfirmadas(controlador.getRestaurante().getRUT());
    	
       	columnaUsuario.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
   	     public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {
   	    	 prop.setValue(r.getValue().getUsuario().getNombre());
   	    	 return prop;
   	     }
   	  });
    	columnaCantPersonas.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
      	     public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {
      	    	 prop.setValue(Integer.toString(r.getValue().getCantPersonas()));
      	    	 return prop;
      	     }
      	  });
    	
    	ObservableList<Reserva> reservas = FXCollections.observableArrayList();
    	Reserva reserva;
		reservas.addAll(listaDePendientes);
    	reservasPendientes.setItems(reservas);
    }


	public void setRestaurante(Restaurante restaurante2) {
		restaurante = restaurante2;
		
	}

}

