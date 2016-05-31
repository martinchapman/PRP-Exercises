package Tube.Version3;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 3: NONE.
 * 
 * @author Martin
 *
 */
public class Line {
	
	private String name;
	
	private List<Station> stations;
	
	public Line( String name ) {
		
		this.name = name;
		
		stations = new ArrayList<Station>();
		
	}
	
	public void addStation( Station station ) {
		
		stations.add( station );
		
	}

	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
}