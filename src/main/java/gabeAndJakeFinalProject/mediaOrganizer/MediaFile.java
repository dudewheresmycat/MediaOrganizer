package gabeAndJakeFinalProject.mediaOrganizer;

public class MediaFile {
	
	//id, name, length, genre, artist, filename
	private int id;
	private String name;
	private double length;
	private String genre;
	private String artist;
	private String filename;
	
	private int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private double getLength() {
		return length;
	}
	private void setLength(double length) {
		this.length = length;
	}
	private String getGenre() {
		return genre;
	}
	private void setGenre(String genre) {
		this.genre = genre;
	}
	private String getArtist() {
		return artist;
	}
	private void setArtist(String artist) {
		this.artist = artist;
	}
	private String getFilename() {
		return filename;
	}
	private void setFilename(String filename) {
		this.filename = filename;
	}
	
}