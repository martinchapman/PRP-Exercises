package nuclearreactor;
/**
 * An unsafe Nuclear reactor with a public temperature variable
 * that can be set to anything by an inexperienced user.
 * 
 * This example is designed to illustrate the importance of
 * private variables and encapsulation.
 * 
 * @author Martin
 *
 */
public class UnsafeNuclearReactor {

	/**
	 * IMPORTANT NOTE FROM REACTOR ENGINEER: temperature must not exceed 100.
	 */
	public int temperature;
	
	/**
	 * Setting a default value to the field is not
	 * sufficient to ensure that the temperature
	 * in the reactor is always at a safe level.
	 */
	public UnsafeNuclearReactor() {
		
		temperature = 100;
		
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
