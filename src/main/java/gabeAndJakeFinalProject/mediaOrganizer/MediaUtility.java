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
	
	
	
	public File[] pullMediaFromFolder(){
		File file = new File("G:/MediaUnsort");
		 File[] a = file.listFiles();
		 for(int i = 0; i < a.length; i++){
			 System.out.println("added file:"+i);
		 }
		 
		return a;
	}
	
	public void pullTags(File[] filepaths) throws UnsupportedTagException, InvalidDataException, IOException{
		for(int i = 0 ; i < filepaths.length;i++){
			String filename = filepaths[i].getPath();
			Mp3File mp3file = new Mp3File(filename);
			System.out.println("added: "+ i + ": "+filename);
			String name = mp3file.getId3v2Tag().getTitle();
			double length = mp3file.getId3v2Tag().getLength();
			String genre = mp3file.getId3v2Tag().getGenreDescription();
			String artist = mp3file.getId3v2Tag().getArtist();
			String album = mp3file.getId3v2Tag().getAlbum();
			
			
			if(filename.endsWith(".mp3")){
				Mp3media media = new Mp3media(name,length,genre,artist,album,filename);
				mediafiles.add(media);
			}else if(filename.endsWith(".m4a")){
				M4Amedia media = new M4Amedia(name,length,genre,artist,filename);
				mediafiles.add(media);
			}
		}
		
	}

	public ArrayList<MediaFile> getMediafiles() {
		return mediafiles;
	}

	public void setMediafiles(ArrayList<MediaFile> mediafiles) {
		this.mediafiles = mediafiles;
	}

}
