package abstractclassesinterfaces.decoderstrategypatternwithtracks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicPlayer {

	private StreamDecoder musicEngine;
	
	private List<Track> tracks;
	
	public MusicPlayer( StreamDecoder musicEngine ) {
		
		this.musicEngine = musicEngine;
		
		tracks = new ArrayList<Track>();
		
	}
	
	public List<Track> getPlayedTracks() {
		
		return tracks;
		
	}
	
	public void playStream ( MusicStream stream ) {
		
		tracks.add(new Track(stream));
		
		Collections.sort(tracks);
		
		musicEngine.play(stream);
		
	}
	
	public static void main( String[] args ) {
		
		MusicPlayer MP3Player = new MusicPlayer(new MP3Engine());
		
		MP3Player.playStream(new MP3("TrackB"));
		
		MP3Player.playStream(new MP3("TrackA"));
		
		System.out.println(MP3Player.getPlayedTracks());
		
		MusicPlayer WAVPlayer = new MusicPlayer(new WAVEngine());
		
		WAVPlayer.playStream(new WAV("TrackC"));
		
		MusicPlayer AACPlayer = new MusicPlayer(new AACEngine());
		
		AACPlayer.playStream(new AAC("TrackB"));
		
		
	}

}
