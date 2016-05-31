package abstractclassesinterfaces.decoderstrategypatternwithtracks;

public class Track implements Comparable<Track> {

	private MusicStream stream;
	
	public Track( MusicStream stream ) {
		
		this.stream = stream;
		
	}

	@Override
	public int compareTo(Track o) {
		
		return stream.getName().compareTo(((Track)o).stream.getName());
	
	}
	
	public String toString() {
		
		return stream.getName();
		
	}

}
