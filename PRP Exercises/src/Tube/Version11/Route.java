package Tube.Version11;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 11:
 * 
 * 1. Method currentLine
 * 2. Method getRouteExtensions
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
	
	public Route( List<TubeStop> stops, TubeStop stop ) {
	
		this.usedStops = new ArrayList<TubeStop>( stops );
		
		this.usedStops.add( stop );
	
	}
	
	public Station headOfRoute() {
		
		return usedStops.get( usedStops.size() - 1 ).getStation();
	
	}
	
	/**
	 * Tells us which line the head of the route is currently on
	 * 
	 * @return
	 */
	private Line currentLine() {
		
		return usedStops.get( usedStops.size() - 1 ).getLine();
	
	}
	
	/**
	 * This method operates in the same way as the previous implementation,
	 * except now it does not just accept one line, but a list of 
	 * lines, which could all provide potential extensions.
	 * 
	 * @param lines
	 * @return
	 */
	public ArrayList<Route> getRouteExtensions( List<Line> lines ) {
		
		ArrayList<Route> extensions = new ArrayList<Route>();
		
		Station headOfRoute = headOfRoute();
		
		/* Because we are no longer supplying the current line to this method,
		 * this must be derived by examining the head of the route.
		 */
		Line currentLine = currentLine();

		/////////////////////////////////////////////////////////////////////////////////
		// THIRD POSSIBLE EXTENSION TO A ROUTE: Move to the same station on a new line //
		/////////////////////////////////////////////////////////////////////////////////
		
		// For each line provided
		for ( Line line : lines ) {
			
			/* If the head of the route (the place from which we wish to expand) is on that
			 * line...
			 */
			if ( line.contains( headOfRoute ) ) {
				
				/* Add it as a new route, that will effectively expand through the new line
				 * in future extensions of that route
				 */
				possiblyAddExtension( extensions, new TubeStop(headOfRoute, line) );
			
			}
			
		}
		
		Station newStation = currentLine.previousStation( headOfRoute );
		
		if ( newStation != null ) {
			
			possiblyAddExtension(  extensions, new TubeStop(newStation, currentLine) );
		
		}
		
		newStation = currentLine.nextStation( headOfRoute );
		
		if ( newStation != null ) {
			
			possiblyAddExtension( extensions, new TubeStop(newStation, currentLine) );
		
		}
		
		return extensions;
		
	}
	
	private void possiblyAddExtension(List<Route> extensions, TubeStop stop) {
	
		if ( !usedStops.contains(stop) ) {

			extensions.add( new Route( usedStops, stop ) );
		
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