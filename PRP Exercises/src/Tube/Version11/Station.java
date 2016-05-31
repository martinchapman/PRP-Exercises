package Tube.Version11;

/**
 * Additions in Version 11: NONE.
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

	@Override
	public boolean equals( Object object ) {
	
		Station otherStation = (Station) object;
		
		return this.name.equals( otherStation.name );
	
	}
	
}