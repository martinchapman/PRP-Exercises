package Tube.Version8;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 8:
 * 
 * 1. Second Constructor
 * 2. getRouteExtensions
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
	 * Extends a route by creating a new route object with
	 * any existing stops from the original route plus the
	 * new stop that exists as a part of the extension.
	 *  
	 * @param stops
	 * @param stop
	 */
	public Route( List<TubeStop> stops, TubeStop stop ) {
	
		this.usedStops = new ArrayList<TubeStop>( stops );
		
		this.usedStops.add( stop );
	
	}

	public Station headOfRoute() {
		
		return usedStops.get( usedStops.size() - 1 ).getStation();
	
	}
	
	/**
	 * Extends this route both `forwards' and `backwards', for each
	 * reachable stop.
	 * 
	 * Because the result of a route extension may be multiple
	 * new routes, it is easier to consider everything, including
	 * extensions to existing routes, as brand new Route objects.
	 * 
	 * If the number of routes that are returned by this method is
	 * greater than one, then a split has occurred. 
	 * 
	 * @param line
	 * @return
	 */
	public ArrayList<Route> getRouteExtensions( Line line ) {
		
		/* Create a place in which to store the route extensions
		 * that will be made in this method.
		 * 
		 * If the size of extensions is greater than 1, then there
		 * has been a split in this route.
		 */
		ArrayList<Route> extensions = new ArrayList<Route>();
		
		// It might be interesting to play with this line in order to see how routes are extended
		// List<TubeStop> originalRoute = usedStops;
		
		/* Store the head of a route for reference. To shorten this code,
		 * this method could be called repeatedly, rather than storing
		 * the result in a temporary variable.
		 */
		Station headOfRoute = headOfRoute();
		
		/////////////////////////////////////////////////////////////////////
		// FIRST POSSIBLE EXTENSION TO A ROUTE: Move to a previous station //
		/////////////////////////////////////////////////////////////////////
		
		Station newStation = line.previousStation( headOfRoute );
		
		/* If a previous station exists (i.e. we are not at the start of a line)
		 * then new station will not be equal to null. */
		if ( newStation != null ) {
			
			/* Extend this Route by taking the existing stops, and adding
			 * a new stop (containing the next station) to them */
			extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
		}
		
		////////////////////////////////////////////////////////////////////
		// SECOND POSSIBLE EXTENSION TO A ROUTE: Move to the next station //
		////////////////////////////////////////////////////////////////////
		
		/* Note that we don't redeclare the variable, can simply use 
		the variable from above */
		newStation = line.nextStation( headOfRoute );
		
		/* If there is a subsequent station on the line (i.e. we are not at the end
		 * of a line) then the new station will not be equal to null. */
		if ( newStation != null ) {
			
			/* Extend this Route by taking the existing stops, and adding
			 * a new stop (containing the previous station) to them */
			extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
		}
		
		// It might be interesting to play with this line in order to see how routes are extended
		// System.out.println("Returning " + extensions.size() + " extension(s) to " + originalRoute + ": " + extensions);
		
		// Return the list of extended routes.
		return extensions;
		
	}
	
	public String toString() {
		
		String completeString = "";
	
		for ( TubeStop stop : usedStops ) {
			
			completeString += stop + ", ";
		
		}
		
		return "[" + completeString.substring(0, completeString.length() - 2) + "]";
		
	}
	
}