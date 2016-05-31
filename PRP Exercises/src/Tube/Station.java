package Tube;
/**
 * @author Martin
 *
 */
public class Station {
	
	/**
	 * 
	 */
	private String name;

	/**
	 * @param name
	 */
	public Station( String name ) {
	
		this.name = name;
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return name;
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object object ) {
	
		Station otherStation = (Station) object;
		
		return otherStation.name.equals( this.name );
	
	}
	
}
