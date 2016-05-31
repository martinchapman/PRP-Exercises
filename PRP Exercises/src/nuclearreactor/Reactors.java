package nuclearreactor;

/**
 * @author Martin
 *
 */
public class Reactors {

	public static void main(String[] args) {
		
		/*
		 * Scenario: We are constructing a small program
		 * that models a nuclear reactor as an object, and
		 * subsequently allows us to set the temperature
		 * in an actual reactor.
		 * 
		 * We are told by an experienced engineer that the 
		 * temperature in the reactor should not exceed 100.
		 */
		
		 /* 
		  * We might be tempted to have a single public variable
		  * called temperature (see UnsafeNuclearReactor) that allows 
		  * us to quickly set the temperature in the reactor:
		  */
	
		  UnsafeNuclearReactor unsafeNucelarReactor = new UnsafeNuclearReactor();
		  
		  unsafeNucelarReactor.temperature = 90;
		  
		  /*
		   * However imagine if our code is used to control the reactor
		   * in the future by an inexperienced engineer who, driven
		   * by a demand for energy, decides to increase the temperature to
		   * 300.
		   * 
		   * The engineer is able to do this, because they have direct access
		   * to the reactor's temperature:
		   */
		  
		  unsafeNucelarReactor.temperature = 300;
		  
		  // This is bad news.
		  System.out.println(unsafeNucelarReactor.reactorUnsafe());
		  
		  /* Instead therefore, we do not provide anyone with direct access
		   * to our fields. Instead, we force them to set the values in our
		   * fields via methods.
		   * 
		   * In this case, we supply a set temperature method, and set the 
		   * temperature field to private, so that the only way to update
		   * the temperature in the reactor is via this method.
		   */
		  
		  SafeNuclearReactor safeNuclearReactor = new SafeNuclearReactor();
		  
		  safeNuclearReactor.setReactorTemperature(90);
		  
		  /* Because we know that, in order to set the temperature in the reactor,
		   * the flow of control in the reactor object must always go through
		   * the setReactorTemperature method, we are able to test any potential
		   * new temperature to see if it is reasonable (see SafeNuclearReactor).
		   * 
		   * If it is not, we can reject the new temperature, and inform any user
		   * that their suggested temperature is not valid.
		   * 
		   * This time, when the inexperienced engineer comes along and tries
		   * to set the temperature within the reactor to a dangerous level,
		   * they are unable to...
		   */
		  
		  safeNuclearReactor.setReactorTemperature(300);
		  
		  // ... even if they try and access the field directly.
		  // safeNuclearReactor.temperature = 300; NB: Code will not compile with this call
		  
		  // And everything is fine.
		  System.out.println(safeNuclearReactor.reactorUnsafe());
		
		
	}

}
