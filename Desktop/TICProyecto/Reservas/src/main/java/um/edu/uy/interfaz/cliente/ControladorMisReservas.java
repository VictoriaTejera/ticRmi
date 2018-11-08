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
    private TableColumn<Reserva, String> pendientes;

    @FXML
    private TableView<Reserva> tablaConfirmadas;

    @FXML
    private TableView<Reserva> tablaPendientes;

    @Autowired
    private ReservaMgr resMgr;
    
    @Autowired
    private ControladorInicioSesion controladorInicio;
    
    private final StringProperty prop = new SimpleStringProperty();
    
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

    	List<Reserva> todasLasReservas =   resMgr.verEstadoReservasUsuario(controladorInicio.getUsuario().getCelular()); 
    	
    	for(Reserva r : todasLasReservas) {
    		if(r.isConfirmado()) {
    			((List<Reserva>) tablaPendientes).add(r);
    		}else {
    			((List<Reserva>) tablaConfirmadas).add(r);
    		}
    	}

    }

}
