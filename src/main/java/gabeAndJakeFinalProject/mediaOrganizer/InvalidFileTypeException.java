package gabeAndJakeFinalProject.mediaOrganizer;

import java.util.StringTokenizer;

public class InvalidFileTypeException extends Exception{
	
	public InvalidFileTypeException(String fileExtension){
		
		super(" is not a valid file type for the Media Organizer, skipping");
	}
	public String getExtension(String filename){
		StringTokenizer st = new StringTokenizer(filename, ".");
		st.nextToken();
		String fileExtension = st.nextToken();
		return fileExtension;
	}
}
