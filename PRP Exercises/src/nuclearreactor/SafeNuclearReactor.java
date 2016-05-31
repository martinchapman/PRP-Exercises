package nuclearreactor;
/**
 * A safe nuclear reactor correctly encapsulates the temperature 
 * variable, so its assignment can be controlled via a method.
 * 
 * Within this method, appropriate checks are made to ensure
 * the new temperature variable is valid.
 * 
 * This example is designed to illustrate the importance of
 * private variables and encapsulation.
 * 
 * @author Martin
 *
 */
public class SafeNuclearReactor {

	/**
	 * IMPORTANT NOTE FROM REACTOR ENGINEER: temperature must not exceed 100.
	 */
	private int temperature;
	
	/**
	 * Set the default temperature to be 100.
	 */
	public SafeNuclearReactor() {
		
		temperature = 100;
		
	}
	
	/**
	 * Sets the temperature in the reactor *only* after first
	 * testing that the new temperature is at a reasonable level.
	 * 
	 * @param newTemperature
	 */
	public void setReactorTemperature(int newTemperature) {
		
		if ( newTemperature <= 100 ) {
			
			temperature = newTemperature;
			
		} else {
			
			// Throw exception, print error message.
			
		}
		
	}
	
	/**
	 * Tells us whether the reactor has exceeded a safe temperature level
	 * 
	 * @return Whether the reactor is unsafe
	 */
	public boolean reactorUnsafe() {
		
		if ( temperature > 100 ) return true;
		
		return false;
		
	}

}
