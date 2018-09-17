package persistance;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import persistance.entidades.Usuario;

@Configuration
@ComponentScan
public class DBConfiguration {

	@Bean(name="pool")
	DataSource pool() {
		BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/ticdb?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("1997");
        ds.setDefaultAutoCommit(true);
        return ds;
	}
	
	@Bean
	SessionFactory sessionFactory(@Autowired @Qualifier("pool") DataSource ds) {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        configuration.addAnnotatedClass(Usuario.class);
        configuration.setProperty("hibernate.schema_update", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        
    	return configuration.buildSessionFactory(
    		        new StandardServiceRegistryBuilder()
    		            .applySettings(configuration.getProperties())
    		            .applySetting(Environment.DATASOURCE, ds)
    		            .build());
		
	}
	
	@Bean
	JDBCTemplate template(@Autowired @Qualifier("pool") DataSource ds) {
		return new JDBCTemplate(ds);
	}
	
	@Bean
	UsuarioRepository interaccion(@Autowired @Qualifier("template") JDBCTemplate template) {
		return new UsuarioRepository(template);
	}
	
		
}
