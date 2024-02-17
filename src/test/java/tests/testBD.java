package tests;

import org.junit.Test;

import com.management.utils.MySQLDatabase;

public class testBD {
	@Test
	public void testBD() {
		MySQLDatabase.listDatabases();
		
		System.out.println("List databases : " + MySQLDatabase.databases);
	}
}
