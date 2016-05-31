package abstractclassesinterfaces.musicplayer;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		MusicPlayer myPlayer = new MusicPlayer();
		
		myPlayer.addTrack("TrackA", 10);
		
		myPlayer.addTrack("TrackD", 5);
		
		myPlayer.addTrack("TrackC", 3);
		
		System.out.println(myPlayer.getMyTracks());
		
		ArrayList<Track> tracks = myPlayer.getMyTracks();
		
		Collections.sort(tracks);
		
		System.out.println(tracks);
		
	}

}
