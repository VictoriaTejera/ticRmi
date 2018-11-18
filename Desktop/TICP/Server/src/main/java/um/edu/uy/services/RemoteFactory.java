package um.edu.uy.services;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.annotation.PostConstruct;

import org.apache.tomcat.jni.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Mgt.BarrioRemoteMgt;
import Mgt.ComidaRemoteMgt;
import Mgt.MesaRemoteMgt;
import Mgt.RemoteConstants;
import Mgt.ReservaRemoteMgt;
import Mgt.RestauranteRemoteMgt;
import Mgt.UsuarioRemoteMgt;

@Service
public class RemoteFactory {

	
	

	    @Autowired
	    private UsuarioRemoteMgr usuarioRemoteMgr;
	    
	    @Autowired
	    private RestauranteRemoteMgr restauranteRemoteMgr;

	    @Autowired
	    private ReservaRemoteMgr reservaRemoteMgr;
	    
	    @Autowired
	    private MesaRemoteMgr mesaRemoteMgr;
	    
	    @Autowired
	    private ComidaRemoteMgr comidaRemoteMgr;
	    
	    @Autowired
	    private BarrioRemoteMgr barrioRemoteMgr;
	    
	    @Value("${server.rmi.port}")
	    private int remotePort;

	    @PostConstruct
	    public void init() throws RemoteException {

	        // Create Registry an register remote

	        Registry oRegistry = (Registry) LocateRegistry.createRegistry(remotePort);

	        // Export all remote objects
	        UsuarioRemoteMgt oStub = (UsuarioRemoteMgt) UnicastRemoteObject.exportObject(usuarioRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.USUARIO_REMOTE_NAME, oStub);

	        
	        RestauranteRemoteMgt oStub1 = (RestauranteRemoteMgt) UnicastRemoteObject.exportObject(restauranteRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.RESTAURANTE_REMOTE_NAME, oStub);
	        
	        ReservaRemoteMgt oStub2 = (ReservaRemoteMgt) UnicastRemoteObject.exportObject(reservaRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.RESERVA_REMOTE_NAME, oStub);
	        
	        MesaRemoteMgt oStub3 = (MesaRemoteMgt) UnicastRemoteObject.exportObject(mesaRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.MESA_REMOTE_NAME, oStub);
	        
	        ComidaRemoteMgt oStub4 = (ComidaRemoteMgt) UnicastRemoteObject.exportObject(comidaRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.COMIDA_REMOTE_NAME, oStub);
	        
	        BarrioRemoteMgt oStub5= (BarrioRemoteMgt) UnicastRemoteObject.exportObject(barrioRemoteMgr, 0);
	        ((java.rmi.registry.Registry) oRegistry).rebind(RemoteConstants.BARRIO_REMOTE_NAME, oStub);
	    }
	    
	    
}
