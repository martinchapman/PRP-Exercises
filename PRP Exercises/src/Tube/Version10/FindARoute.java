package Tube.Version10;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 10:
 * 
 * Field routes
 * Field finalRoute
 * Method getRoute
 * Method endStationFound
 * Method extendAllRoutesOnLine
 * 
 * 
 * @author Martin
 *
 */
public class FindARoute {

	private TubeMap map;

	private Station start;
	
	private Station end;
	
	/**
	 * Keep a record of all the potential routes we have found
	 */
	private List<Route> routes;
	
	/**
	 * Storing the final route as a field
	 * is as a result of putting the check for a
	 * final station in a separate method
	 */
	private Route finalRoute;

	public FindARoute( TubeMap map, Station start, Station end ) {
	
		this.map = map;
		
		this.start = start;
		
		this.end = end;
	
	}
	
	/**
	 * This method contains the main functionality for
	 * finding a route on a SINGLE line.
	 * 
	 * @param the line upon which to find a route
	 * @return the finalRoute containing our desired stop
	 */
	public Route getRoute( Line line ) {
		
		/* Create a new 'stub' route by supplying
		 * the station at which we want to start,
		 * and the line upon which we want to find
		 * our route
		 */
		Route startOfRoute = new Route(start, line);
		
		/* Create a list that will store all the potential
		 * routes that emerge as a result of iteratively
		 * expanding our route, starting with the stub route.
		 * 
		 * In the case of a single line, this will be the
		 * routes left and right of the stub route
		 */
		routes = new ArrayList<Route>();
		
		// Add our stub route as the first route
		routes.add(startOfRoute);
		
		/* While our list of routes does not contain the desired
		 * end station (putting this task to a separate method
		 * for neatness) AND we have not exhausted every route...
		 */
		while ( !routes.isEmpty() && !endStationFound() ) {
			
			/* Extend all the possible routes on this line.
			 * Again this functionality is placed in a separate
			 * method */
			extendAllRoutesOnLine( line );

			/* It might be interesting to play with this in order to see 
			   how routes are extended incrementally */
			// System.out.println("Extensions: " + routes);
		
		}

		// Return the final route that has been found.
		return finalRoute;
		
	}
	
	/**
	 * Searches through all the potential routes and 
	 * returns true if the end station is found in one
	 * of these routes.
	 * 
	 * When a station is found, the 'finalRoute' variable
	 * is simultaneously set. 
	 * 
	 * @return whether one route contains the end station
	 */
	private boolean endStationFound() {
		
		// For each stored route
		for ( Route route: routes ) {
			
			/* If the head of that route is the desired
			 * end station
			 */
			if ( route.headOfRoute().equals(end) ) {
				
				// Record which route this is,
				finalRoute = route;
				
				// And return true;
				return true;
				
			}
			
		}
		
		// Otherwise, the destination station has not been found
		return false;
	
	}
	
	/**
	 * Given a set of existing routes, each of these routes is extended
	 * in a given direction, in order to conduct an expanding search
	 * of a given line.
	 * 
	 * @param line
	 */
	private void extendAllRoutesOnLine( Line line ) {
		
		/* The result of extending a route may not only be that route
		 * itself, but also additional routes that result from splitting 
		 * a route to go in different directions.
		 * 
		 * When we consider a single line, this occurs when the stub route 
		 * (i.e. the route that just contains the first station) is first 
		 * extended into two additional routes, one containing the previous 
		 * station, and one containing the next station, as the search branches 
		 * out from the first station.
		 * 
		 * To accommodate the fact that the number of routes we have may grow
		 * after one route is extended, we declare a local list to hold these 
		 * new routes.
		 */
		ArrayList<Route> longerAndSplitRoutes = new ArrayList<Route>();
		
		/* Now, actually extend each route, and store the result, which may only
		 * be the route itself, or multiple routes that have arisen from an extension.
		 * 
		 * Add this all to our list of existing (but longer) and new routes
		 */
		for ( Route route : routes ) {
			
			longerAndSplitRoutes.addAll( route.getRouteExtensions( line ) );
			
		}
		
		// It may be interesting to play with this, to see how route splitting occurs
		// if ( longerAndSplitRoutes.size() - routes.size() > 0 ) System.out.println((longerAndSplitRoutes.size() - routes.size()) + " new route(s) found");
		
		/* Overwrite the current routes with all of the expanded 
		existing routes, plus any new 'split' routes. */
		routes = longerAndSplitRoutes;
		
	}

}