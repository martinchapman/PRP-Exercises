package Tube.Version9;

/**
 * Additions for Version 9: NONE;
 * 
 * @author Martin
 *
 */
public class Station {

	private String name;

	public Station( String name ) {
	
		this.name = name;
	
	}

	public String toString() {
		
		return name;
	
	}
	
	public boolean equals( Object object ) {
	
		Station otherStation = (Station) object;
		
		return this.name.equals( otherStation.name );
	
	}
	
}