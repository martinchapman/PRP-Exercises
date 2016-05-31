package Tube.Version9;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 9:
 * 
 * 1. getRouteExtensions
 * 2. possiblyAddExtension
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
	 * Extends this route in a suitable direction that does not
	 * cause the route to go back on itself, for each reachable stop.
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
		
		ArrayList<Route> extensions = new ArrayList<Route>();
	
		Station headOfRoute = headOfRoute();
		
		Station newStation = line.previousStation( headOfRoute );
	
		if ( newStation != null ) {
			
			/* How does the below line affect the operation of your search?
			 * Try replacing 'possibleAddExtension' with this line, and track
			 * the progress of your search.
			 */
			//extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
			possiblyAddExtension(  extensions, new TubeStop(newStation, line) );
		
		}
		
		newStation = line.nextStation( headOfRoute );
		
		if ( newStation != null ) {
			
			/* How does the below line affect the operation of your search?
			 * Try replacing 'possibleAddExtension' with this line, and track
			 * the progress of your search.
			 */
			//extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
			possiblyAddExtension( extensions, new TubeStop(newStation, line) );
		
		}
		
		return extensions;
		
	}
	
	/**
	 * This method ensures that a route is only extended to include a new stop,
	 * if that stop has not already been visited. In other words, it stops the 
	 * search from going back on itself.
	 * 
	 * @param extensions
	 * @param stop
	 */
	private void possiblyAddExtension( List<Route> extensions, TubeStop stop ) {
		
		/* Checks whether the list of used stops contains the supplied stop.
		 * 
		 * The use of contains here necessitates the addition of an equals method
		 * to TubeStop, and thus an equals method to Line.
		 */
		if ( !usedStops.contains(stop) ) {

			/* If the proposed stop has not previously been on this route, 
			 * expand the current route (defined by all the usedStops) to 
			 * include the new stop (i.e. the extension) by creating
			 * a brand new Route object, using a new constructor.
			 */
			extensions.add( new Route( usedStops, stop ) );
			
			// Uncomment this line to see more of what is going on in the program.
			// System.out.println("Adding new route by extending " + usedStops + " to " + usedStops + " and " + stop);
			
		}
		
	}
	
	public String toString() {
		
		String completeString = "";
	
		for ( TubeStop stop : usedStops ) {
			
			completeString += stop + ", ";
		
		}
		
		return "[" + completeString.substring(0, completeString.length() - 2) + "]";
		
	}
	
}