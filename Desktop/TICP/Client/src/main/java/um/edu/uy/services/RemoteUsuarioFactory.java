package um.edu.uy.services;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Mgt.RemoteConstants;
import Mgt.UsuarioRemoteMgt;

@Service
public class RemoteUsuarioFactory {
	
	@Value("${client.rmi.port}")
    private int remotePort;
	
	 public UsuarioRemoteMgt getUsuarioRemoteMgt() throws RemoteException {
	        UsuarioRemoteMgt usuarioRemoteMgt = null;
	        Registry oRegistry = LocateRegistry.getRegistry(remotePort);

	        try {

	            usuarioRemoteMgt = (UsuarioRemoteMgt) oRegistry.lookup(RemoteConstants.USUARIO_REMOTE_NAME);

	        } catch (NotBoundException e) {
	            throw new RuntimeException("No se encuentra uno de los objetos remotos con el nombre indicado");
	        }

	        return usuarioRemoteMgt;
	    }
	

}
