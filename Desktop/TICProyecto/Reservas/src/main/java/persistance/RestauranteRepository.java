package persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import persistance.entidades.Restaurante;

@Repository
@SuppressWarnings("unchecked")
public class RestauranteRepository {
	
	@Autowired
	JDBCTemplate template;
	
	public List<Restaurante> getRestaurants() throws SQLException {
		
		List<Restaurante> lista= (List<Restaurante>) template.execute(con -> {
			List<Restaurante> listaInterna= new LinkedList<>();
			PreparedStatement stmt = con.prepareStatement("select * from Restaurante");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
				listaInterna.add(new Restaurante(rs.getString("nombre"), rs.getString("direccion"), rs.getInt("telefono")));
			return listaInterna;
		});
		return lista;
	}
	
	
//	@Override
//	public void printPersonas() throws SQLException {
//		template.execute(callback -> {
//			PreparedStatement stmt = callback.prepareStatement(
//					"select * from persona");
//			ResultSet rs=stmt.executeQuery(); 
//			while(rs.next())  
//				System.out.println(new Persona(rs.getInt("ci"), rs.getString("nombre")));  
//			return null;
//		});
//		
//	}


}
