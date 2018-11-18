package um.edu.uy.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Mgt.RestauranteRemoteMgt;
import um.edu.uy.business.RestauranteMgr;
import um.edu.uy.business.entities.Comida;
import um.edu.uy.business.entities.Mesa;
import um.edu.uy.business.entities.Reserva;
import um.edu.uy.business.entities.Restaurante;

public class RestauranteRemoteMgr implements RestauranteRemoteMgt {

	@Autowired
	private RestauranteMgr restauranteMgr;
	
	@Override
	public List<Restaurante> getRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Restaurante res) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertarComida(String rut, Comida comida) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertarComida(String rut, String tipoComida) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Restaurante> filtrarPorBarrio(String nombreBarrio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurante> filtrarPorComida(String tipoComida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurante> filtrarPorPrecio(Float precioMenor, Float precioMayor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verificarUsuarioRestaurante(String nombre, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cargarDatosRes(String rut, String descripcion, String direccion, String horarioApertura,
			String horarioCierre, Float precio_promedio, String mail, String barrio, byte[] imagen, Integer cantMesas,
			Integer lugaresPorMesa) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean restauranteYaFueCreado(Restaurante res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRut(String nombre, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurante find(String RUT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mesa> obtenerMesasNoReservadas(String RUT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> obtenerReservasTerminadas(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long cantidadAPagar(String rut, LocalDate fecha1, LocalDate fecha2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getCantMesas(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCantLugarPorMesa(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mesa> obtenerMesas(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage obtenerImagen(String rut) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
