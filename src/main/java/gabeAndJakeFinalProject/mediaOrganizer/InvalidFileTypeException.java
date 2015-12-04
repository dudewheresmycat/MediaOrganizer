package gabeAndJakeFinalProject.mediaOrganizer;

public class InvalidFileTypeException extends Exception{
	public InvalidFileTypeException(String filename){
		super(String.format("%s is not a valid file type for the Media Organizer, skipping", filename));
	}
}
