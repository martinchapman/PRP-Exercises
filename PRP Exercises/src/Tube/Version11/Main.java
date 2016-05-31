package Tube.Version11;

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

		Station start = new Station("OxfordCircus");
		
		Station end = new Station("LeicesterSquare");

		System.out.println(map);
		
		// Now parameter now required to getRoute (better usability)
		Route route = new FindARoute(map, start, end).getRoute();

		System.out.println("To get from " + start + " to " + end + " try:");
		
		if ( route == null ) {
		
			System.out.println( "Walking." );
		
		} else {
			
			System.out.println( route );
		
		}
		
	}

}
