package persistance;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import persistance.entidades.Usuario;

public class Ejemplo {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(DBConfiguration.class);
		
		Long tel=(long) 89879879;
		Usuario us=new Usuario("Victoria", "hola", tel);
		
		UsuarioRepository usR= ctx.getBean(UsuarioRepository.class);
		
		usR.Save(us);
		

	}

}
