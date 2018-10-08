package um.edu.uy.persistance;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import um.edu.uy.interfaz.cliente.ControladorInicioSesion;
import um.edu.uy.persistance.entidades.Usuario;

@Service
public class UsuarioMgr {

	@Autowired
	private UsuarioRepository repository;

	public void save(Usuario usuario) {
		repository.save(usuario);
	}

	public boolean verificarUsuario(Usuario us) {
		boolean verifico = true;
		if (repository.verificarUsuario(us.getNombre(), us.getContrasena()) == null) {
			verifico = false;
		}
		return verifico;
	}
	
	public boolean usuarioYaFueCreado(Usuario us) {
		
	
		boolean creado = true;
		if (repository.verificarNombreUsuario(us.getNombre()) == null) {
			creado = false;
		}
		return creado;
	}
	}


