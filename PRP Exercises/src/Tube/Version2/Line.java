package Tube.Version2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a tube line.
 * 
 * Additions in Version 2:
 * 
 * 1. Field Name
 * 2. Field Stations
 * 3. Constructor
 * 4. Method addStation
 * 5. Method toString
 * 
 * @author Martin
 *
 */
public class Line {
	
	/**
	 * The name of the line
	 */
	private String name;
	
	/**
	 * A list of the stations on this line
	 */
	private List<Station> stations;
	
	/**
	 * Every Line must have a name
	 * 
	 * @param name
	 */
	public Line( String name ) {
		
		// Store the name of the line
		this.name = name;
		
		// Create space to store the list of stations
		stations = new ArrayList<Station>();
		
	}
	
	/**
	 * Adds a station to this line.
	 * 
	 * @param station
	 */
	public void addStation( Station station ) {
		
		stations.add( station );
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Create a String representation of this line, which
	 * includes the list of stations. 
	 * 
	 * Printing the stations List invokes toString() on 
	 * each item in the List, thus giving a readable representation.
	 */
	@Override
	public String toString() {
	
		return "Line: " + name + " Stations: " + stations;
	
	}
	
}