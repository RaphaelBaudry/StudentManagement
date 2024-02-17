package tests;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.management.model.Student;
import com.management.utils.HibernateUtils;

public class TestHibernateWithOutXML {
	Session session;
	
	@Test
	public void openSession() {
		// Hibernate 5.4 SessionFactory example without XML
		  Map<String, String> settings = new HashMap<String,String>();
		  settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		  settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		  settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/management");
		  settings.put("hibernate.connection.username", "root");
		  settings.put("hibernate.connection.password", "pass");
		  settings.put("connection.pool_size", "3");
		  settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
		  settings.put("org.hibernate.dialect.MySQL8Dialect", "thread");
		  settings.put("show_sql", "true");
		  settings.put("format_sql", "true");
		  settings.put("hibernate.hbm2ddl.auto", "update");

		  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		                                    .applySettings(settings).build();

		  MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		  metadataSources.addAnnotatedClass(Student.class);
		  Metadata metadata = metadataSources.buildMetadata();

		  // here we build the SessionFactory (Hibernate 5.4)
		  SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		  session = sessionFactory.openSession();
	}
	
	@Test
	public void test() {
		openSession();
		Student p = new Student("Aurore", "Baudry", 26, "sss@ere");
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	
	@Test
	public void testList() {
		HibernateUtils.setup("management");
		//System.out.println("Taille : " + HibernateUtil.getAll().length());
	}
		  
}
