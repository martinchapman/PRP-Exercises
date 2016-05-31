package Tube.Version11;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 11:
 * 
 * 1. Method contains
 * 
 * @author Martin
 *
 */
public class Line extends Object {

	private String name;

	private List<Station> stations;
	
	public Line( String nameAndStations ) {
		
		stations = new LinkedList<Station>();
		
		Scanner scanner = new Scanner( nameAndStations );
		
		name = scanner.next();
		
		while ( scanner.hasNext() ) {
		
			stations.add( new Station(scanner.next()) );
		
		}
		
		scanner.close();
		
	}
	
	public Station previousStation( Station station ) {
		
		int positionOnLine = stations.indexOf( station );
		
		if ( positionOnLine > 0 ) {
		
			return stations.get( positionOnLine - 1 );
		
		}
		
		return null;
	
	}
	
	/**
	 * @param station
	 * @return
	 */
	public Station nextStation( Station station ) {
	
		int positionOnLine = stations.indexOf( station );
		
		if ( positionOnLine >= 0 && positionOnLine < stations.size() - 1 ) {
		
			return stations.get( positionOnLine + 1 );
		
		}
	
		return null;
		
	}
	
	/**
	 * Tells us whether a Line contains a given station.
	 * 
	 * @param station
	 * @return
	 */
	public boolean contains( Station station ) {
		
		/* We already have the appropriate equals implementation in Station
		 * to support the functionality of contains.
		 */
		return stations.contains( station );
	
	}
	
	@Override
	public boolean equals( Object object ) {
		
		Line line = (Line) object;
		
		return line.name.equals( this.name );
		
	}

	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
	public String getName() {
		
		return name;
	
	}
	
}