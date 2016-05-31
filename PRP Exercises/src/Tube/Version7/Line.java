package Tube.Version7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 7:
 * 
 * 1. Method PreviousStation
 * 2. Method NextStation
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
	
	/**
	 * Given a station, find out what the previous 
	 * station on the line is (for some definition of
	 * 'previous'), if one exists. If it does not,
	 * return null.
	 * 
	 * The operation of this method relies on the existence
	 * of a suitable 'equals' method inside Station.
	 * 
	 * @param station
	 * @return
	 */
	public Station previousStation( Station station ) {
		
		/* Find the index of the passed Station in the
		 * list of stations. Relies on a suitable implementation
		 * of the equals method inside Station.
		 */
		int positionOnLine = stations.indexOf( station );
		
		/* This check confirms two things:
		 * 1. That there is at least one station before
		 * the current station (i.e. it is not the first
		 * station on the line and there is therefore 
		 * no previous station).
		 * 2. That the station exists. Index of will
		 * return -1 if the supplied station does not exist.
		 */
		if ( positionOnLine > 0 ) {
		
			/* Return the station that is at an index which
			 * is one less than the current index.
			 */
			return stations.get( positionOnLine - 1 );
		
		}
		
		/* If the constraints of the above IF statement are
		 * not satisfied, return null.
		 */
		return null;
	
	}
	
	/**
	 * Given a station, find out what the next 
	 * station on the line is (for some definition of
	 * 'next'), if one exists. If it does not, return null.
	 * 
	 * The operation of this method relies on the existence
	 * of a suitable 'equals' method inside Station.
	 * 
	 * @param station
	 * @return
	 */
	public Station nextStation( Station station ) {
	
		/* Find the index of the passed Station in the
		 * list of stations. Relies on a suitable implementation
		 * of the equals method inside Station.
		 */
		int positionOnLine = stations.indexOf( station );
		
		/* The first clause is now purely to check whether
		 * the station exists on the line (i.e. the index of 
		 * the station is not -1)
		 * 
		 * The second clause checks that there is at least
		 * one more station on the line (i.e. it is not the last
		 * station and therefore there is no next station).
		 * 
		 */
		if ( positionOnLine >= 0 && positionOnLine < stations.size() - 1 ) {
			
			/* Return the station that is at a position that is 
			 * one greater than the current index.
			 */
			return stations.get( positionOnLine + 1 );
		
		}
		
		/* If the constraints of the above IF statement are not
		 * satisfied, return null.
		 */
		return null;
		
	}

	public String toString() {
		
		return "Line: " + name + " Stations: " + stations;
	
	}
	
	public String getName() {
		
		return name;
	
	}
	
}