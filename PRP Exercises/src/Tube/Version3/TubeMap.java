package Tube.Version3;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a tube map.
 * 
 * Additions in Version 3:
 * 
 * 1. Field Lines
 * 2. Constructor
 * 3. Method toString
 * 
 * @author Martin
 *
 */
public class TubeMap {

	/**
	 * The lines on this tube map
	 */
	private List<Line> lines;

	/**
	 * 
	 */
	public TubeMap() {
	
		// Create space in which to store the lines on the map
		lines = new ArrayList<Line>();
	
	}
	
	/**
	 * Adds a line to this map.
	 * 
	 * @param line
	 */
	public void addLine( Line line ) {
		
		lines.add(line);
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Print the list of lines, invoking toString() on each
	 * Line object, which `recursively' invokes toString() on
	 * each station object.
	 */
	public String toString() {
	
		return "Map: " + lines;
	
	}
	
}