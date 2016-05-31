package abstractclassesinterfaces.interfacesimple;

/**
 * A iPhone is an audio device, but it is not entirely defined by that device.
 * 
 * It would therefore not make sense for an iPhone to extend an audio device, 
 * instead it only makes sense for an iPhone to be a type of audio device.
 * 
 * @author Martin
 *
 */
public class iPhone extends Phone implements AudioDevice {

	@Override
	public void playMusic() {
		
		
		
	}


}
