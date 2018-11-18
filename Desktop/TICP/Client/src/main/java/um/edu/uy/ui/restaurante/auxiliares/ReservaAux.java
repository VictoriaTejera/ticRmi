package um.edu.uy.ui.restaurante.auxiliares;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import um.edu.uy.business.entities.Reserva;

public class ReservaAux {
	private Reserva reserva;
	private Button aceptar;
	private Button rechazar;

	public ReservaAux(Reserva reserva) {
		this.reserva = reserva;
		this.aceptar = new Button("Aceptar");
		this.rechazar = new Button("Rechazar");

		aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				reserva.setConfirmado(true);
				showAlert("Confirmaci�n de reserva","Reserva confirmada con �xito");
			}
		});
		
		rechazar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				reserva.setRechazada(true);
				showAlert("Rechazo de reserva","Reserva rechazada con �xito");
			}
		});
	
	}

	public static void showAlert(String title, String contextText) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

	public Reserva getReserva() {
		return reserva;
	}

	public Button getAceptar() {
		return aceptar;
	}

	public Button getRechazar() {
		return rechazar;
	}

}