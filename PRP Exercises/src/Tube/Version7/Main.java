package Tube.Version7;

import java.io.FileNotFoundException;

public class Main {

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
