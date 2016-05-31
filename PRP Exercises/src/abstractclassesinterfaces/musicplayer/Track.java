package abstractclassesinterfaces.musicplayer;

import java.io.Serializable;

public class Track extends MusicPlayer implements Comparable<Track>, Serializable {

	private String name;
	
	private int trackLength;
	
	public Track(String name) {
		
		this.name = name;
		
	}
	
	public String toString() {
		
		return name;
		
	}

	@Override
	public int compareTo(Track otherTrack) {
		
		return Integer.compare(this.trackLength, otherTrack.trackLength);
		
		/*if ( this.trackLength < otherTrack.trackLength ) {
			
			return -1;
			
		} else if ( otherTrack.trackLength < this.trackLength ) {
			
			return 1;
			
		} else {
			
			return 0;
			
		}*/
		
	}

}
