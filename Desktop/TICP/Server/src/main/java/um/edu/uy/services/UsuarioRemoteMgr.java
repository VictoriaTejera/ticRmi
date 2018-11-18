package um.edu.uy.services;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.UsuarioRemoteMgt;
import um.edu.uy.business.UsuarioMgr;
import um.edu.uy.business.entities.Usuario;

public class UsuarioRemoteMgr implements UsuarioRemoteMgt {

	@Autowired
	private UsuarioMgr usuarioMgr;
	
	
	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verificarUsuario(String nombreUsuario, String contrasena) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean usuarioYaFueCreado(Usuario us) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario find(Integer celular) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario find(String nombre, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
