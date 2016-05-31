package abstractclassesinterfaces.badlydesigned;

public class MusicPlayer {

	public void playMusicStream(MusicStream stream) {
		
		if ( stream instanceof MP3 ) {
			
			((MP3)stream).decodeFromMP3();
			
		} else if ( stream instanceof AAC ) {
			
			((AAC)stream).decodeFromAAC();
			
		} else if ( stream instanceof WAV ) {
				
			((WAV)stream).decodeFromWAV();
			
		}
		
	}

}
