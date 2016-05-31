package Tube.Version5;

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
		
		/* The work of adding stations is now entirely performed inside
		 * TubeMap, with the added flexibility of specifying the stations
		 * on a series of lines in an external file.
		 */
		TubeMap map = new TubeMap("map.txt");
		
		// Print the map and its associated Lines and Stations, read from map.txt.
		System.out.println(map);
		
	}

}