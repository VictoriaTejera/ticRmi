package Mgt;
import java.rmi.Remote;

public interface MesaRemoteMgt extends Remote {

	void save(String RUT, Integer capacidad);
	
	void marcarMesaComoReservada(Long id);
	
	void delete(Long id);
	
	
}
