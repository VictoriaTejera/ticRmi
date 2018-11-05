package um.edu.uy.persistance;

import java.io.IOException;
import java.util.Optional;

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
	
	public Usuario encontrarPorMail(String mail) {
		return repository.encontrarPorMail(mail);
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
	
	public Usuario find(Integer celular) {
		Optional<Usuario> optional=repository.findById(celular);
		Usuario usuario=null;
		if(optional.isPresent()) {
			usuario=optional.get();
		}
		return usuario; 
	}
}
