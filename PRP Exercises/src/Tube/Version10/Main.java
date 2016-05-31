package Tube.Version10;

import java.io.FileNotFoundException;

/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main( String[] args ) throws FileNotFoundException {
		
		TubeMap map = new TubeMap("map.txt");

		Station start = new Station("WestActon");
		
		Station end = new Station("EastActon");

		/* A FindARoute object is created here temporarily, solely
		 * for the purpose of getting the desired route back from 
		 * the getRoute method */
		Route route = new FindARoute(map, start, end).getRoute( map.getLine("Central") );
		
		// Introduce the route with text
		System.out.println("To get from " + start + " to " + end + " try ");
		
		/* If there isn't a route (perhaps the desired
		 * station doesn't exist, or isn't on our map), suggest
		 * (somewhat curtly) that the commuter try walking */
		if ( route == null ) {
		
			System.out.println( "Walking." );
		
		// Otherwise, print the located route.
		} else {
			
			System.out.println( route );
		
		}
		
	}

}
