package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.management.model.Student;

public class testHibernate {
			
	private Session session;
	
	public static void main(String[] args) {
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("management");
		EntityManager entityManager = entityManagerFactory.createEntityManager();*/
	}

	
	@Test
	public void TestsHibernate() {
		 try {
			 SessionFactory  factory = new Configuration().configure("tests/hibernate.cfg.xml").buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	@Test
	public void getStudent() {
		test();
		System.out.println("Test6");
		Student p = new Student(1, "Raphael", "Baudry", 31, "efd@ere");
		System.out.println("Test7");
		session.beginTransaction();
		System.out.println("Test8");
		try {
		session.save(p);
		} catch(Exception ex) {
			System.out.println(ex);
		}
		System.out.println("Test9");
		session.getTransaction().commit();
		System.out.println("Test10");
	}
	
	@Test
	public void testAnnotations() {
		System.out.println("Test");
		Configuration configuration = new Configuration().configure("tests/hibernate.cfg.xml");
		System.out.println("Test1");
	    // ICI ON AJOUTE LES CLASSES JPA
	    configuration.addAnnotatedClass(com.management.model.Student.class);
	    // FIN DE L'AJOUT DES CLASSES JPA
	    System.out.println("Test2");
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	            .applySettings(configuration.getProperties()).build();
	    System.out.println("Test3");
	    SessionFactory sessionFactory = configuration
	            .buildSessionFactory(serviceRegistry);
	    System.out.println("Test4");
	    session = sessionFactory.openSession();
	    System.out.println("Test5");
	}
	
	@Test
	public void test() {
		System.out.println("Test");
		Configuration configuration = new Configuration().configure("tests/hibernate.cfg.xml");
		System.out.println("Test1");
	    // ICI ON AJOUTE LES CLASSES JPA
	    configuration.addAnnotatedClass(com.management.model.Student.class);
	    // FIN DE L'AJOUT DES CLASSES JPA
	    System.out.println("Test2");
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	            .applySettings(configuration.getProperties()).build();
	    System.out.println("Test3");
	    SessionFactory sessionFactory = configuration
	            .buildSessionFactory(serviceRegistry);
	    System.out.println("Test4");
	    session = sessionFactory.openSession();
	    System.out.println("Test5");
	}
	
	@Test
	public void test2() {
		// SessionFactory in Hibernate 5 example
		  Configuration config = new Configuration();
		  config.configure("tests/hibernate.cfg.xml");
		  // local SessionFactory bean created
		  SessionFactory sessionFactory = config.buildSessionFactory();
		  session = sessionFactory.getCurrentSession();
	}
	
}
