package Tube.Version4;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 4:
 * 
 * 1. Method addLine
 * 
 * @author Martin
 *
 */
public class TubeMap {

	private List<Line> lines;

	public TubeMap() {
	
		lines = new ArrayList<Line>();
		
	}
	
	/**
	 * Add line now accepts a String, which is
	 * used to add line objects to lines list 
	 * inside TubeMap itself.
	 * 
	 * @param line
	 */
	public void addLine( String line ) {
		
		lines.add( new Line( line ) );
		
	}

	public String toString() {
	
		return "Map: " + lines;
	
	}
	
}