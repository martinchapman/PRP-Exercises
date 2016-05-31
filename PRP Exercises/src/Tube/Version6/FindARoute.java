package Tube.Version6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that helps us find a Route between two stations.
 * 
 * Additions in Version 6:
 * 
 * 1. Constructor
 * 2. Field Map
 * 3. Field Start
 * 4. Field End
 * 
 * @author Martin
 *
 */
public class FindARoute {

	/**
	 * The map used to find a route
	 */
	private TubeMap map;
	
	/**
	 * The station from which we wish to start a route from
	 */
	private Station start;
	
	/**
	 * The station we wish to find
	 */
	private Station end;

	/**
	 * @param map
	 * @param start
	 * @param end
	 */
	public FindARoute( TubeMap map, Station start, Station end ) {
	
		// Assign the map passed in the constructor
		this.map = map;
		
		// Assign the start station passed in the constructor
		this.start = start;
		
		// Assign the end station passed in the constructor
		this.end = end;
	
	}

}