package um.edu.uy.persistance;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JDBCTemplate {
	// Sirve para tener ahi un DataSource y que a partir de ahi puedas ejecutar algo. Y para no abrir y cerrar las conexiones manualmente
	DataSource ds;
	
	public JDBCTemplate(DataSource ds) {
		this.ds = ds;
	}
	
	Object execute(JDBCTemplateCallback callback) throws SQLException {
		try (Connection con = ds.getConnection()) { 
			return callback.execute(con);
		}		
	}

}