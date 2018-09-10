package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Cierre extends Application {
	// Estos son objetos que llamaremos abajo
	Button btn, btn2; // botones que mandaran a llamar a la ventana que deseamos abrir
	Label lbl, lbl2;// Label para colocar texto e identificar las ventanas en este ejemplo
	Scene scene, scene2;// con esto cargaremos el contenido de cada ventana un scene por cada una
	Stage thestage;// este Stage se utiliza para cargar la ventana se puede utilizar con todas las
					// ventanas

	public void start(Stage stage) throws Exception {
	    thestage=stage; 
	    btn=new Button();
	    btn2=new Button();
	    btn.setOnAction(e-> ButtonClicked(e));//Indicamos que hará una acción cuando se dé clic en el botón
	    btn2.setOnAction(e-> ButtonClicked(e));
	   /* lbl=new Label("Scene 1");
	      lbl2=new Label("Scene 2");*/
	}
	    private Object ButtonClicked(ActionEvent e) {
			// TODO Auto-generated method stub
			return null;
		}

}
