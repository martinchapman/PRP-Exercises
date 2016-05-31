package Tube;
/**
 * Information about one point on a route through 
 * the tube: the station and the line.
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object object ) {
		
		TubeStop stop = (TubeStop)object;
		
		return (stop.station.equals(station)) && (stop.line.equals(line));
	
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
	
}