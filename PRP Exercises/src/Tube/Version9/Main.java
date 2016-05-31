package Tube.Version9;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main( String[] args ) throws FileNotFoundException {
		
		TubeMap map = new TubeMap("map.txt");

		Station start = new Station("WestActon");
		
		Station end = new Station("EastActon");

		Route route = new Route( start, map.getLine("Central") );
		
		System.out.println(route);
		
		ArrayList<Route> firstRouteExtensions = route.getRouteExtensions( map.getLine("Central") );
		
		System.out.println(firstRouteExtensions);
		
		Route firstRoute = firstRouteExtensions.get(0);
		
		ArrayList<Route> secondRouteExtensions = firstRoute.getRouteExtensions( map.getLine("Central") );
		
		/* The first route now no longer has any extensions 
		 * because it is both at the end of the line,
		 * and has no unexplored lines.*/
		System.out.println(secondRouteExtensions);
		
	}

}
