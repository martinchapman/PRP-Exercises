package Tube.Version8;

/**
 * Additions for Version 8: NONE.
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
	
}