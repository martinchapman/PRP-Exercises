package Tube.Version7;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 7: 
 * 
 * 1. Method headOfRoute
 * 
 * @author Martin
 *
 */
public class Route {
	
	private List<TubeStop> usedStops;

	public Route( Station station, Line line ) {
		
		usedStops = new ArrayList<TubeStop>();
		
		usedStops.add( new TubeStop(station, line) );
	
	}
	
	/**
	 * Returns the last station on the Route, typically
	 * the current station on the search for an end 
	 * station, which is being conducted using this route.
	 * 
	 * @return The last Station on the Route
	 */
	public Station headOfRoute() {
		
		/* Find the last TubeStop in the usedStops list, and return 
		 * the station associated with that stop.
		 */
		return usedStops.get( usedStops.size() - 1 ).getStation();
	
	}
	
	public String toString() {
	
		String completeString = "";
		
		for ( TubeStop stop : usedStops ) {
			
			completeString += stop + ", ";
		
		}
		
		return "[" + completeString.substring(0, completeString.length() - 2) + "]";
		
	}
	
}