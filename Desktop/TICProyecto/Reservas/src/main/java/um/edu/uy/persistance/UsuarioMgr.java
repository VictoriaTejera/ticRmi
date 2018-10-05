package um.edu.uy.persistance;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.edu.uy.persistance.entidades.Usuario;

@Service
public class UsuarioMgr {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
	public boolean VerificarUsuario(Usuario us) {
		boolean verifico=true;
		if(repository.verificarUsuario(us.getNombre())==null) {
			verifico=false;
		}
		return verifico;
	}

}
