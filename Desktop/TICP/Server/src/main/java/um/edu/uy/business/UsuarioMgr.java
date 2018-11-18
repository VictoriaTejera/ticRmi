package um.edu.uy.business;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import um.edu.uy.business.entities.Usuario;
import um.edu.uy.presistence.UsuarioRepository;


@Service
public class UsuarioMgr {

	@Autowired
	private UsuarioRepository repository;

	public void save(Usuario usuario) {
		repository.save(usuario);
	}

	public boolean verificarUsuario(String nombreUsuario, String contrasenaUsuario) {
		boolean verifico = true;
		if (repository.verificarUsuario(nombreUsuario, contrasenaUsuario) == null) {
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
	
	public Usuario find(String nombre, String contrasena) {
		return repository.verificarUsuario(nombre, contrasena);
	}
}
