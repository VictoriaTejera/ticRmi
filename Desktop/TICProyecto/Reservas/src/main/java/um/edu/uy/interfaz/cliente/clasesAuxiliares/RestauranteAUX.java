package um.edu.uy.interfaz.cliente.clasesAuxiliares;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import um.edu.uy.MainCliente;
import um.edu.uy.interfaz.cliente.ControladorInicio;
import um.edu.uy.interfaz.cliente.ControladorListarRestaurantes;
import um.edu.uy.interfaz.cliente.ControladorRegistro;
import um.edu.uy.interfaz.cliente.ControladorReservarDirecto;
import um.edu.uy.persistance.entidades.Barrio;
import um.edu.uy.persistance.entidades.Comida;
import um.edu.uy.persistance.entidades.Restaurante;

//@Entity
public class RestauranteAUX {
	@Id
	private Integer id;
	private Restaurante restaurante;
	private Button button;
	
	@Autowired 
	ControladorReservarDirecto controller;
	
	public ObservableList<Restaurante> getRestaurants(){
		return null;
	}
	
	public RestauranteAUX(Restaurante restaurante) {
		this.restaurante = restaurante;
		this.button= new Button("Reservar");
		button.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	@Override
	    	public void handle(MouseEvent event){
	    		FXMLLoader fxmlLoader = new FXMLLoader();
	    		fxmlLoader.setLocation(ControladorInicio.class.getResource("Reservar2.fxml"));
	    		try {
	    			fxmlLoader.load();
	    		}catch(IOException ex){
	    			Logger.getLogger(ControladorListarRestaurantes.class.getName()).log(null, ex);
	    		}
	    		controller=(ControladorReservarDirecto)MainCliente.getContext().getBean("ControladorReservarDirecto");
	    		controller.setRestaurante(restaurante);
	    		Parent root = fxmlLoader.getRoot();
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(root));
	    		stage.show();
	    	}
	    });
	}
	
	public Button getButton() {
		return button;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}

}
