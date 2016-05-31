package Tube.Version6;

/**
 * Additions in Version 6: 
 * 
 * 1. Field Station
 * 2. Field Line
 * 3. Constructor
 * 4. Method getStation
 * 5. Method getLine
 * 6. Method toString
 * 
 * @author Martin
 *
 */
public class TubeStop {
	
	/**
	 * The station associated with this tube stop
	 */
	private Station station;
	
	/**
	 * The line associated with this tube stop
	 */
	private Line line;

	/**
	 * @param station
	 * @param line
	 */
	public TubeStop( Station station, Line line ) {
		
		// Assign the station passed through the constructor
		this.station = station;
	
		// Assign the line passed through the constructor
		this.line = line;
	
	}

	/**
	 * Get the station associated with this stop
	 * 
	 * @return
	 */
	public Station getStation() {
	
		return station;
	
	}

	/**
	 * Get the line associated with this stop
	 * 
	 * @return
	 */
	public Line getLine() {
	
		return line;
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Provides a String representation of a Stop
	 * that tells us which station is associated with this stop,
	 * and which line it is on.
	 * 
	 * Addition of getName method in line class yields more
	 * specific information about the line.
	 * 
	 */
	@Override
	public String toString() {
	
		return station + " on " + line.getName();
	
	}
	
}