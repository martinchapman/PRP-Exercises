package Tube.Version7;

/**
 * Additions in Version 7: 
 * 
 * 1. Method equals
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Assuming that we hold a list of stations, in order
	 * to search this list, it is important that there is
	 * a way in which to compare an entry in the list with
	 * the station that needs to be found.
	 * 
	 * Therefore, the logical approach is to override the
	 * equals method, so that we compare the names of two 
	 * different stations.
	 */
	@Override
	public boolean equals( Object object ) {
	
		/* Must cast the object passed as a station,
		 * because overriding requires us to only
		 * accept an object into this method.
		 */
		Station otherStation = (Station) object;
		
		/*
		 * Return the result of calling equals on the name
		 * of this station, and the name of the other 
		 * stations
		 */
		return this.name.equals( otherStation.name );
	
	}
	
}