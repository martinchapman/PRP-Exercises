package abstractclassesinterfaces.welldesigned;

public class MusicPlayer {

	public void playMusicStream(MusicStream stream) {
		
		stream.decodeFromStream();
		
	}
	
	public static void main(String[] args) {
		
		MusicPlayer mp3Player = new MusicPlayer();
		
		
		
	}

}
