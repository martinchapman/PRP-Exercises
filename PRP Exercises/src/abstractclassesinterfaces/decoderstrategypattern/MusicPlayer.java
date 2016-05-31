package abstractclassesinterfaces.decoderstrategypattern;

public class MusicPlayer {

	private StreamDecoder musicEngine;
	
	public MusicPlayer( StreamDecoder musicEngine ) {
		
		this.musicEngine = musicEngine;
		
	}
	
	public void playStream ( MusicStream stream ) {
		
		musicEngine.play(stream);
		
	}
	
	public static void main( String[] args ) {
		
		MusicPlayer MP3Player = new MusicPlayer(new MP3Engine());
		
		MP3Player.playStream(new MP3());
		
		MusicPlayer WAVPlayer = new MusicPlayer(new WAVEngine());
		
		WAVPlayer.playStream(new WAV());
		
		MusicPlayer AACPlayer = new MusicPlayer(new AACEngine());
		
		AACPlayer.playStream(new AAC());
		
	}

}
