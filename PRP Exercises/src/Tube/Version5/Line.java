package Tube.Version5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 5: None.
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

	@Override
	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
}