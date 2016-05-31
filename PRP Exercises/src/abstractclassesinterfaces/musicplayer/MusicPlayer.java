package abstractclassesinterfaces.musicplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class MusicPlayer {
	
	private ArrayList<Track> tracks;
	
	private HashMap<Track, Integer> tracksToLength;
	
	private TreeMap<Track, Artists> trackToArtists;
	
	public MusicPlayer() {
		
		tracks = new ArrayList<Track>();
		
		tracksToLength = new HashMap<Track, Integer>();
	
	}
	
	public void addTrackWithArtist(Track track, Artists artists) {
		
		trackToArtists.put(track, artists);
		
	}
	
	public Set<Artists> artists() {
		
		return (Set<Artists>) trackToArtists.values();
		
	}
	
	public void addTrack(String name, int length) {
		
		Track newTrack = new Track(name);
		
		// newTrack.setTrackLength(length);
		
		tracksToLength.put( newTrack, length );
		
	}
	
	public int getTrackLength(Track track) {
		
		return tracksToLength.get(track);
		
	}
	
	public void addExistingTrack( Track track ) {
		
		tracks.add(track);
		
	}
	
	public void addPlaylist( ArrayList<Track> trackList) {
		
		tracks.addAll(trackList);
		
	}
	
	public ArrayList<Track> getMyTracks() {
		
		return tracks;
		
	}
	
}
