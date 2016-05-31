package Tube.Version11;

/**
 * 
 * @author Martin
 *
 */
public class TubeStop {
	
	/**
	 * 
	 */
	private Station station;
	
	/**
	 * 
	 */
	private Line line;

	/**
	 * @param station
	 * @param line
	 */
	public TubeStop( Station station, Line line ) {
		
		this.station = station;
	
		this.line = line;
	
	}

	/**
	 * @return
	 */
	public Station getStation() {
	
		return station;
	
	}

	/**
	 * @return
	 */
	public Line getLine() {
	
		return line;
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return station + " on " + line.getName();
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Compares whether the station currently stopped at is 
	 * the same as the station stopped at in another TubeStop
	 * AND whether the line on each stop is the same.
	 * 
	 * To do this, we invoke the pre-overridden equals method
	 * from station in a nested call to equals, and add a new 
	 * equals method into line.
	 */
	@Override
	public boolean equals( Object object ) {
		
		TubeStop stop = (TubeStop)object;
		
		return (stop.station.equals(station)) && (stop.line.equals(line));
	
	}
	
}