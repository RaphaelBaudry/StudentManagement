package com.management.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	public Database(String name) {
		super();
		this.name = name;
		listDatabasesKnown.add(this);
	}

	private static List<Database> listDatabasesKnown = new ArrayList<Database>();
	
	public static List<Database> getListDatabasesKnown() {
		return listDatabasesKnown;
	}

	public static void setListDatabasesKnown(List<Database> listDatabasesKnown) {
		Database.listDatabasesKnown = listDatabasesKnown;
	}
	
	public static void removeFromDatabasesKnown(Database database) {
		if (listDatabasesKnown.contains(database))
			listDatabasesKnown.remove(database);
	}
	
	public static void addFromDatabasesKnown(Database database) {
		if (listDatabasesKnown.contains(database))
			listDatabasesKnown.add(database);
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
