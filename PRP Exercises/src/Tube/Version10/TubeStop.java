package Tube.Version10;

/**
 * Additions for Version 10: NONE.
 * 
 * @author Martin
 *
 */
public class TubeStop {

	private Station station;
	
	private Line line;

	public TubeStop( Station station, Line line ) {
		
		this.station = station;
	
		this.line = line;
	
	}

	public Station getStation() {
	
		return station;
	
	}

	public Line getLine() {
	
		return line;
	
	}

	public String toString() {
	
		return station + " on " + line.getName();
	
	}
	
	public boolean equals( Object object ) {
		
		TubeStop stop = (TubeStop)object;
		
		return (stop.station.equals(station)) && (stop.line.equals(line));
	
	}
	
}