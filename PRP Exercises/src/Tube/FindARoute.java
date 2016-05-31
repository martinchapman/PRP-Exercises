package Tube;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 *
 */
public class FindARoute {

	/**
	 * 
	 */
	private TubeMap map;
	
	/**
	 * 
	 */
	private Station start;
	
	/**
	 * 
	 */
	private Station end;

	/**
	 * 
	 */
	private List<Route> routes;
	
	/**
	 * 
	 */
	private Route finalRoute;

	/**
	 * @param map
	 * @param start
	 * @param end
	 */
	public FindARoute( TubeMap map, Station start, Station end ) {
	
		this.map = map;
		
		this.start = start;
		
		this.end = end;
	
	}
	
	/**
	 * @return
	 */
	private boolean endStationFound() {
		
		for ( Route route: routes ) {
			
			if ( route.headOfRoute().equals(end) ) {
				
				finalRoute = route;
				
				return true;
				
			}
			
		}
		
		return false;
	
	}
	
	/**
	 * @param line
	 * @return
	 */
	public Route getRoute( Line line ) {
		
		Route startOfRoute = new Route(start, line);
		
		routes = new ArrayList<Route>();
		
		routes.add(startOfRoute);
		
		while ( !endStationFound() ) {
			
			extendAllRoutesOnLine( line );
		
		}

		return finalRoute;
		
	}
	
	/**
	 * @param line
	 */
	private void extendAllRoutesOnLine( Line line ) {
		
		// Place to hold any longer or split routes
		ArrayList<Route> longerAndSplitRoutes = new ArrayList<Route>();
		
		for ( Route route : routes ) {
			
			longerAndSplitRoutes.addAll( route.getRouteExtensions( line ) );
			
		}
		
		// System.out.println((longerAndSplitRoutes.size() - routes.size()) + " new route(s) found");
		
		// Overwrite the current routes with all of the expanded existing routes, plus any new 'split' routes.
		routes = longerAndSplitRoutes;
		
	}

	/**
	 * @return
	 */
	public Route getRoutes() {
		
		startAllRoutes();

		if ( routes.isEmpty() ) return finalRoute;
		
		while ( !endStationFound() ) {
			
			extendAllRoutes();
		
		}

		return finalRoute;
		
	}
	
	/**
	 * 
	 */
	private void startAllRoutes() {
		
		routes = new ArrayList<Route>();

		for ( Line line : map.getLines() ) {
			
			if ( line.contains(start) ) {
			
				routes.add( new Route(start, line) );
			
			}
			
		}
		
	}
	
	/**
	 * 
	 */
	private void extendAllRoutes() {
	
		ArrayList<Route> longerAndSplitRoutes = new ArrayList<Route>();
		
		for ( Route route : routes ) {
			
			longerAndSplitRoutes.addAll( route.getRouteExtensions( map.getLines() ) );
		
		}
		
		routes = longerAndSplitRoutes;
		
	}

}