package um.edu.uy.persistance;
import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCTemplateCallback {
	Object execute(Connection con) throws SQLException;
}
