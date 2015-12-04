package gabeAndJakeFinalProject.mediaOrganizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

public class MediaUtility {
	
	
	private ArrayList<MediaFile> mediafiles = new ArrayList<>();
	private ArrayList<File> filepath = new ArrayList<>();
	
	public void fillMediaFiles(){
		mediafiles.add(new MediaFile(1,"",2,"","",""));
	}
	
	public static File[] pullMediaFromFolder(){
		File file = new File("G:/MediaUnsort");
		 File[] a = file.listFiles();
		return a;
	}
	public static int pullMediaTags(String filename) throws UnsupportedTagException, InvalidDataException, IOException{
		
			Mp3File mp3file = new Mp3File(filename);
			mp3file.getId3v2Tag().getLength();
			return mp3file.getId3v2Tag().getLength();
	}

	public ArrayList<MediaFile> getMediafiles() {
		return mediafiles;
	}

	public void setMediafiles(ArrayList<MediaFile> mediafiles) {
		this.mediafiles = mediafiles;
	}

	public ArrayList<File> getFilepath() {
		return filepath;
	}

	public void setFilepath(ArrayList<File> filepath) {
		this.filepath = filepath;
	}
}
