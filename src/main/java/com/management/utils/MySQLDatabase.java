package com.management.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.management.model.Database;

public class MySQLDatabase {
		public static List<Database> databases;
		
		public static void listDatabases() {
			databases = new ArrayList<Database>();
			getConnection();
			databases = executeMySQLQuery();
		}
	 
	    static Connection conn = null;
	    static String username = "root"; // replace with your MySQL client username
	    static String password = "pass"; // replace with your MySQL client password
	 
	    public static List<Database> executeMySQLQuery() {
	    	List<Database> listSQL = new ArrayList<Database>();
	    	
	        Statement stmt = null;
	        ResultSet resultset = null;
	 
	        try {
	            stmt = conn.createStatement();
	            resultset = stmt.executeQuery("SHOW DATABASES;");
	 
	            if (stmt.execute("SHOW DATABASES;")) {
	                resultset = stmt.getResultSet();
	            }
	 
	            while (resultset.next()) {
	            	//System.out.println("name : " + resultset.getString("Database"));
	            	listSQL.add(new Database(resultset.getString("Database")));
	            }
	        }
	        catch (SQLException ex){
	            // handle any errors
	            ex.printStackTrace();
	        }
	        finally {
	            // release resources
	            if (resultset != null) {
	                try {
	                    resultset.close();
	                } catch (SQLException sqlEx) { }
	                resultset = null;
	            }
	 
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException sqlEx) { }
	                stmt = null;
	            }
	 
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException sqlEx) { }
	                conn = null;
	            }
	            return listSQL;
	        }
	    }
	 
	    /**
	     * This method makes a connection to MySQL Server
	     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
	     *  at the standard port 3306
	     */
	    public static void getConnection(){
	        Properties connectionProps = new Properties();
	        connectionProps.put("user", username);
	        connectionProps.put("password", password);
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            conn = DriverManager.getConnection(
	                    "jdbc:" + "mysql" + "://" +
	                            "127.0.0.1" +
	                            ":" + "3306" + "/"+
	                            "",
	                    connectionProps);
	        } catch (SQLException ex) {
	            // handle any errors
	            ex.printStackTrace();
	        } catch (Exception ex) {
	            // handle any errors
	            ex.printStackTrace();
	        }
	    }
	}

