package um.edu.uy.interfaz.restaurante.clasesAuxiliares;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import um.edu.uy.persistance.entidades.Reserva;

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
			}
		});
		
//		rechazar.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				reserva.setConfirmado(false); //hay que hacer un setRechazado
//			}
//		});
	}

	public Reserva getReserva() {
		return reserva;
	}

}