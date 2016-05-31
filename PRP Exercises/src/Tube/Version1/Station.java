package Tube.Version1;

/**
 * A class that represents a tube station.
 * 
 * Additions in Version 1: 
 * 
 * 1. Field Name
 * 2. Constructor
 * 3. Method toString
 * 
 * @author Martin
 *
 */
public class Station {
	
	/**
	 * The name of the station
	 */
	private String name;
	
	/**
	 * Every Station must have a name
	 * 
	 * @param name
	 */
	public Station( String name ) {
	
		// Assign the supplied name to the station
		this.name = name;
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Provide a String representation of this Station,
	 * which consists of the station's name.
	 */
	@Override
	public String toString() {
		
		return name;
	
	}
	
}