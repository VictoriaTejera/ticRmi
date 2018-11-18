package Mgt;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.rmi.Remote;
import java.time.LocalDate;
import java.util.List;

import um.edu.uy.business.entities.Comida;
import um.edu.uy.business.entities.Mesa;
import um.edu.uy.business.entities.Reserva;
import um.edu.uy.business.entities.Restaurante;

public interface RestauranteRemoteMgt extends Remote {

	List<Restaurante> getRestaurants();
	
	void save(Restaurante res);
	
	void insertarComida(String rut, Comida comida);
	
	void insertarComida(String rut, String tipoComida);
	
	List<Restaurante> filtrarPorBarrio(String nombreBarrio);
	
	List<Restaurante> filtrarPorComida(String tipoComida);
	
	List<Restaurante> filtrarPorPrecio(Float precioMenor, Float precioMayor);
	
	boolean verificarUsuarioRestaurante(String nombre, String password);
	
	void cargarDatosRes(String rut, String descripcion, String direccion, String horarioApertura,
			String horarioCierre, Float precio_promedio, String mail, String barrio, byte[] imagen, Integer cantMesas, Integer lugaresPorMesa) {
		repository.cargarDatosRes(rut, descripcion, direccion, horarioApertura, horarioCierre, precio_promedio, mail,
				barrioMgr.find(barrio), imagen, lugaresPorMesa);
		
		boolean restauranteYaFueCreado(Restaurante res);
		
		String getRut(String nombre, String password);
		
		Restaurante find(String RUT);
		
		List<Mesa> obtenerMesasNoReservadas(String RUT);
		
		List<Reserva> obtenerReservasTerminadas(String rut);
		
		long cantidadAPagar(String rut, LocalDate fecha1, LocalDate fecha2);
		
		Integer getCantMesas(String rut);
		
		Integer getCantLugarPorMesa(String rut);
		
		List<Mesa> obtenerMesas(String rut);
		
		BufferedImage obtenerImagen(String rut) throws IOException;
		
}
