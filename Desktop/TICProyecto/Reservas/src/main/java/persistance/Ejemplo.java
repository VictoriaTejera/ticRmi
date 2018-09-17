package persistance;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import persistance.entidades.Usuario;

public class Ejemplo {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(DBConfiguration.class);
		
		
		Usuario us=new Usuario("Victoria", "hola", 8);
		
		UsuarioRepository usR= ctx.getBean(UsuarioRepository.class);
		
		usR.Save(us);
		

	}

}
