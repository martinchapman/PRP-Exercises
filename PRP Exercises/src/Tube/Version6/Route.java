package Tube.Version6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a single route between stations.
 * 
 * Additions in Version 6:
 * 
 * 1. Field usedStops
 * 2. Constructor
 * 3. toString
 * 
 * @author Martin
 *
 */
public class Route {
	
	/**
	 * List the stops that we have gone through
	 * on this route. More generally, a route is 
	 * defined by a series of stops.
	 */
	private List<TubeStop> usedStops;

	/**
	 * Each Route must consist of one stop:
	 * the first station on the first line
	 * 
	 * @param station
	 * @param line
	 */
	public Route( Station station, Line line ) {
		
		usedStops = new ArrayList<TubeStop>();
		
		/* Each route always has a first stop:
		 * the start station */
		usedStops.add( new TubeStop(station, line) );
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Provides a String representation of a Route 
	 * that lists all the Stops on the Route.
	 */
	@Override
	public String toString() {
		
		/* Define a String that we will fill with values,
		 * and eventually return from this method.
		 */
		String completeString = "";
		
		/* Loop through each stop, and add this to the
		 * String that we are going to fill with Stops.
		 */
		for ( TubeStop stop : usedStops ) {
			
			completeString += stop + ", ";
		
		}
		
		/* A somewhat messy trick to remove the final comma, understanding this 
		 * line is not important; it is merely for aesthetics.
		 */
		return "[" + completeString.substring(0, completeString.length() - 2) + "]";
		
	}
	
}