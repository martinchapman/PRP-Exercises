package Tube.Version6;

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
		
		// Create a new tube map
		TubeMap map = new TubeMap("map.txt");
		
		// Specify a start station
		Station start = new Station("WestActon");
		
		// Specify a destination station
		Station end = new Station("EastActon");
		
		// Supply all this information to the FindARoute class
		FindARoute findARoute = new FindARoute(map, start, end);
		
	}

}