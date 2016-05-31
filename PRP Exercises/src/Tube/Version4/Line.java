package Tube.Version4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 4:
 * 
 * 1. Constructor
 * 
 * Removed in Version 4:
 * 
 * 1. Method addStation
 * 
 * @author Martin
 *
 */
public class Line {

	private String name;

	private List<Station> stations;

	/**
	 * The constructor now not only accepts the name
	 * of the Line, but also a separated list of stations
	 * after this name, which indicates the stations on this
	 * line
	 * 
	 * @param nameAndStations
	 */
	public Line( String nameAndStations ) {
		
		stations = new ArrayList<Station>();
		
		/* Create a new Scanner object, where the input
		 * to the scanner is not System.in, but instead
		 * a String. */
		Scanner scanner = new Scanner( nameAndStations );
		
		/* Read from the first token from the parameter String
		 * (i.e. the name of the line: Central) */
		name = scanner.next();
		
		/* For the remaining part of the string (i.e. the
		 * list of stations: EalingBroadway WestActon etc.), 
		 * extract each station (token), delimited by a space. */
		while ( scanner.hasNext() ) {
			
			/* Create a new station object using the name
			 * of the station, and add this to the list of stations */
			stations.add( new Station( scanner.next() ) );
		
		}
		
		// Close the scanner, as usual.
		scanner.close();
		
	}

	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
}