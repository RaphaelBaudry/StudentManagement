package com.management.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.management.model.Student;

import antlr.collections.List;
import exceptions.SQLIntegrityConstraintViolationException;

public class HibernateUtils {
	private static Session session;
	
	public static void setup(String database) {
		// Hibernate 5.4 SessionFactory example without XML
		  Map<String, String> settings = new HashMap<String,String>();
		  settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		  settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		  settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/"
				  + database);
		  settings.put("hibernate.connection.username", "root");
		  settings.put("hibernate.connection.password", "pass");
		  settings.put("connection.pool_size", "3");
		  settings.put("dialect", "org.hibernate.dialect.MySQL5Dialect");
		  settings.put("org.hibernate.dialect.MySQL8Dialect", "thread");
		  settings.put("show_sql", "true");
		  settings.put("format_sql", "true");
		  settings.put("hibernate.hbm2ddl.auto", "update");

		  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		                                    .applySettings(settings).build();

		  MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		  metadataSources.addAnnotatedClass(Student.class);
		  Metadata metadata = metadataSources.buildMetadata();

		  // here we build the SessionFactory (Hi,bernate 5.4)
		  SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		  session = sessionFactory.openSession();
	}
	
	public static void save(Student s) {
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}
	
	public static void delete(Student s) {
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
	}
	
	public static void deleteAll() {
		session.beginTransaction();
		String hql = String.format("delete from %s","Student");
	    Query query = session.createQuery(hql);
	    query.executeUpdate();
	    session.getTransaction().commit();
	}
	
	public static void getDatabases() {

	}
	
	public static ArrayList<Student> getAll() {
		session.beginTransaction();
		/*@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Student.class);
		List javaBeans = criteria.list();*/
		ArrayList<Student> list =  findAllStudentsWithJpql();
		session.getTransaction().commit();
		return list;
		//return students;
	}
	
	public static List findAllStudentsWithCriteriaQuery() {
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	    Root<Student> rootEntry = cq.from(Student.class);
	    CriteriaQuery<Student> all = cq.select(rootEntry);

	    TypedQuery<Student> allQuery = session.createQuery(all);
	    return (List) allQuery.getResultList();
	}
	
	public static ArrayList<Student> findAllStudentsWithJpql() {
	    return (ArrayList<Student>) session.createQuery("SELECT a FROM Student a", Student.class).getResultList();      
	}
}
