package Tube.Version6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 6:
 * 
 * Method getName
 * 
 * 
 * @author Martin
 *
 */
public class Line {
	
	private String name;
	
	private List<Station> stations;
	
	public Line( String nameAndStations ) {
		
		stations = new ArrayList<Station>();
		
		Scanner scanner = new Scanner( nameAndStations );
		
		name = scanner.next();
		
		while ( scanner.hasNext() ) {
			
			stations.add( new Station(scanner.next()) );
		
		}
		
		scanner.close();
		
	}

	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
	/**
	 * Provide a more flexible implementation by offering 
	 * just the name of the line to an invoking class, as 
	 * opposed to the formatting given by the toString() method.
	 * 
	 * @return
	 */
	public String getName() {
		
		return name;
	
	}
	
}