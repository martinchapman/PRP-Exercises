package Tube.Version8;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main( String[] args ) throws FileNotFoundException {
		
		TubeMap map = new TubeMap("map.txt");

		Station start = new Station("WestActon");
		
		Station end = new Station("EastActon");

		/* Create a route that starts at WestActon 
		   and will proceed on the central line */
		Route route = new Route( start, map.getLine("Central") );
		
		// Print out the 'stub' route
		System.out.println(route);
		
		// Extend the route one stop in various directions
		ArrayList<Route> firstRouteExtensions = route.getRouteExtensions( map.getLine("Central") );
		
		// Print the extensions
		System.out.println(firstRouteExtensions);
		
		// Get the first route ( WestActon -> EalingBroadway )
		Route firstRoute = firstRouteExtensions.get(0);
		
		// Extend this first route
		ArrayList<Route> secondRouteExtensions = firstRoute.getRouteExtensions( map.getLine("Central") );
				
		// Print the extensions. Is this good behaviour?
		System.out.println(secondRouteExtensions);
		
	}

}
