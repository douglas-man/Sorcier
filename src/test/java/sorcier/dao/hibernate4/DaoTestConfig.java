package sorcier.dao.hibernate4;

import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class DaoTestConfig implements TransactionManagementConfigurer {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
		edb.setType(EmbeddedDatabaseType.H2);
		edb.addScript("sorcier/dao/hibernate/schema.sql");
		edb.addScript("sorcier/dao/hibernate4/test-data.sql");
		EmbeddedDatabase embeddedDatabase = edb.build();
		
		return embeddedDatabase;
	}
	
	@Bean
	public SessionFactory sessionFactoryBean() {
		try {
			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			lsfb.setPackagesToScan("sorcier.domain");
			Properties props = new Properties();
			props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
			lsfb.setHibernateProperties(props);
			lsfb.afterPropertiesSet();
			SessionFactory object = lsfb.getObject();
			
			return object;
		} catch (IOException e) {
			return null;
		}
	}
	
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}	
}