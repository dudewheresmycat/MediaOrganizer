package gabeAndJakeFinalProject.mediaOrganizer;

public class Mp3media extends MediaFile{
	private String album;
	public Mp3media(String name, double length, String genre,
			String artist, String album, String filename) {
		super(name, length, genre, artist, filename);
		this.setAlbum(album);
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}

}
