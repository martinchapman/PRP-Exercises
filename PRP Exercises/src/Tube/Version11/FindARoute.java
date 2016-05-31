package Tube.Version11;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 11:
 * 
 * 1. getRoutes
 * 2. startAllRoutes
 * 3. extendAllRoutes
 * 
 * @author Martin
 *
 */
public class FindARoute {

	private TubeMap map;
	
	private Station start;
	
	private Station end;
	
	private List<Route> routes;
	
	private Route finalRoute;

	public FindARoute( TubeMap map, Station start, Station end ) {
	
		this.map = map;
		
		this.start = start;
		
		this.end = end;
	
	}
	
	/**
	 * We now rewrite this method, so that it does not consider
	 * that both the start and end station exist on the same line,
	 * or that the start station only exists on one line.
	 * 
	 * @return
	 */
	public Route getRoute() {
		
		/* Because we no longer assume that the start station
		 * only exists on one line, we call a method that
		 * creates numerous 'stub' routes for each line, and
		 * adds them as potential routes for expansion.
		 */
		startAllRoutes();

		while ( !routes.isEmpty() && !endStationFound() ) {
			
			extendAllRoutes();
			
			/* It might be interesting to play with this in order to see 
			   how routes are extended incrementally */
			//System.out.println("Extensions: " + routes);
			
		}

		return finalRoute;
		
	}
	
	/**
	 * Creates a stub route for each line that the
	 * first station may be on.
	 */
	private void startAllRoutes() {
		
		// Instantiate routes as before
		routes = new ArrayList<Route>();

		/* We now need a mechanism for getting all the
		 * stored lines back from the TubeMap. 
		 * 
		 * Using this information we can then loop through
		 * each line..
		 */
		for ( Line line : map.getLines() ) {
			
			/* ...and check whether that line contains our
			 * desired station. 
			 * 
			 * This necessitates the addition of a contains
			 * method to line, which tells us whether a station
			 * is on a given line.
			 */
			if ( line.contains(start) ) {
			
				/* It might be interesting to play with this in order to see 
				   which routes are started */
				//System.out.println("Starting: " + start + " " + line);
				
				routes.add( new Route(start, line) );
			
			}
			
		}
		
	}
	
	/**
	 * Differs from previous version only in that we now perform a route
	 * extension using all of the lines.
	 */
	private void extendAllRoutes() {
	
		ArrayList<Route> longerAndSplitRoutes = new ArrayList<Route>();
		
		for ( Route route : routes ) {
			
			// Pass all lines in order to perform route extension
			longerAndSplitRoutes.addAll( route.getRouteExtensions( map.getLines() ) );
		
		}
		
		routes = longerAndSplitRoutes;
		
	}

	private boolean endStationFound() {
		
		for ( Route route: routes ) {
			
			if ( route.headOfRoute().equals(end) ) {
			
				finalRoute = route;
				
				return true;
				
			}
			
		}
		
		return false;
	
	}

}