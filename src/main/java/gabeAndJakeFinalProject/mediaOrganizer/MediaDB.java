package gabeAndJakeFinalProject.mediaOrganizer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

public class MediaDB {
//	public static void main(String[] args) throws SQLException, UnsupportedTagException, InvalidDataException, IOException{
//		
//		createDatabase();
//	}
	
	public static void createDatabase(String filepath) throws SQLException, UnsupportedTagException, InvalidDataException, IOException{
		Connection conn = DriverManager.getConnection(Environment.DB_URL);
	
		System.out.println("Connected to database!");
		//REQ #7
		Statement stmt = conn.createStatement();
		String dropTable = "drop table Media";
		stmt.execute(dropTable);
		System.out.println("Media table dropped.");
		String createTable = "create table Media("
				+ "id int not null primary key, " 
				+ "name varchar(255), "
				+ "length double, " 
				+ "genre varchar(90), "
				+ "artist varchar(90), "
				+ "album varchar(90), "
				+ "filename varchar(255) "
				+ ")";
		
		stmt.execute(createTable);
		System.out.println("Media table created.");
		MediaUtility m = new MediaUtility();
		
		m.pullTags(m.pullMediaFromFolder(filepath));
		ArrayList<MediaFile> mediafiles = m.getMediafiles();
		for(int i = 0 ; i < mediafiles.size() ; i ++){
			MediaFile media = (MediaFile) mediafiles.get(i);
			addMediaStmt(conn, i, media.getName(), media.getLength(), media.getGenre(), media.getArtist(),
					((Mp3media) media).getAlbum(), media.getFilename());
			
		}
	}
	public static void addMediaStmt(Connection conn, int id, String name, double length, 
		String genre, String artist, String album, String filename) throws SQLException{
		Statement stmt = conn.createStatement();
		String insert = String.format("insert into Media (id, name, length, genre, artist, album, filename) "
				+ "values (%d, '%s', %f, '%s', '%s', '%s', '%s')", id, name, length, genre, artist, album, filename);
		stmt.executeUpdate(insert);
		System.out.println("Mp3: "+id+ " added!");
		
	}
	public static ArrayList<String> getMedia(){

		ArrayList<String> mediaInfo = new ArrayList<String>();
		
		try {
			Connection conn = DriverManager.getConnection(Environment.DB_URL);
			
			Statement stmt = conn.createStatement();
			
			ResultSet results = stmt.executeQuery("select id, name, length, genre, artist, album from Media");
			
			
			while(results.next()){
				 mediaInfo.add(String.format("%d \t| \t%s \t\t| \t%.0f Seconds \t| \t%s \t| \t%s \t| \t%s\t", 
						 results.getInt("id"), results.getString("name"),results.getDouble("length"),results.getString("genre"),
						 results.getString("artist"),results.getString("album")));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mediaInfo;
	}
}
