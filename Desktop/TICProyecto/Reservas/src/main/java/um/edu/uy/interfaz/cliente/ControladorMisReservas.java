package um.edu.uy.interfaz.cliente;

import java.net.URL;
import um.edu.uy.persistance.ReservaMgr;
import um.edu.uy.persistance.entidades.Reserva;

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

@Component
public class ControladorMisReservas {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Reserva, String> confirmadas;

    @FXML
    private TableView<Reserva> misReservas;

    @FXML
    private TableColumn<Reserva, String> pendientes;

    @Autowired
    private ReservaMgr resMgr;
    
    private final StringProperty prop = new SimpleStringProperty();
    
    private int usuarioCelular;
    
    
    public void setUsuarioCelular (int uC) {
    	usuarioCelular = uC;
    }
    
    @FXML
    void initialize() {
    	
    	confirmadas.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
     	     public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {
     	    
				prop.setValue(r.getValue().getRestaurante().getNombre());
     	    	 return prop;
     	     }
     	  });
    	
    	pendientes.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reserva, String>, ObservableValue<String>>() {
    	     public ObservableValue<String> call(TableColumn.CellDataFeatures<Reserva, String> r) {
    	    	 prop.setValue(r.getValue().getRestaurante().getNombre());
    	    	 return prop;
    	     }
    	  });

    	List<Reserva> todasLasReservas =   resMgr.obtenerReservasDe(usuarioCelular); //TODO HAGAN FUNCION DE OBTENER TODAS LAS RESERVAS DE UN USUARIO
    	
    	for(Reserva r : todasLasReservas) {
    		if(r.isConfirmado()) {
    			tablaPend.add(r);
    		}else {
    			tablaConf.add(r);
    		}
    	}

    }

}
