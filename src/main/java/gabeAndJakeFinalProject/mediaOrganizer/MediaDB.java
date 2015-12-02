package gabeAndJakeFinalProject.mediaOrganizer;

import java.io.*;
import java.sql.*;
import java.util.StringTokenizer;

public class MediaDB {
	
	public static void CreateDatabase() throws SQLException{
		Connection conn = DriverManager.getConnection(Environment.DB_URL);
	
		System.out.println("Connected to database!");

		Statement stmt = conn.createStatement();
		String dropTable = "drop table Media";
		stmt.execute(dropTable);
		System.out.println("Media table dropped.");
		String createTable = "create table Media("
				+ "id int not null primary key, " 
				+ "name varchar(75), "
				+ "length double, " 
				+ "genre varchar(30), "
				+ "artist varchar(30), "
				+ "filename varchar(255), "
				+ ")";
		
		stmt.execute(createTable);
		System.out.println("Media table created.");
		
	}
	public static void addMediaStmt(Connection conn, int id, String name, double length, 
		String genre, String artist, String filename) throws SQLException{
		Statement stmt = conn.createStatement();
		String insertMedia = String.format("insert into Media (id, name, length, genre, artist, filename)"
				+ " values (%d, '%s', %,.2f, '%s', '%s', '%s')", id, name, length, genre, artist, filename);
		stmt.executeUpdate(insertMedia);
		System.out.println("Mp3 added!");
		
	}
	
	
}
