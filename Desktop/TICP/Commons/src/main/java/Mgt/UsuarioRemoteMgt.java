package Mgt;
import java.rmi.Remote;

import um.edu.uy.business.entities.Usuario;

public interface UsuarioRemoteMgt extends Remote {

	void save(Usuario usuario);
	
	boolean verificarUsuario( String nombreUsuario, String contrasena);
	
	boolean usuarioYaFueCreado(Usuario us);
	
	Usuario find(Integer celular);
	
	Usuario find(String nombre, String contrasena);
}
