package Tube;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 *
 */
public class Route {
	
	/**
	 * 
	 */
	private List<TubeStop> usedStops;

	/**
	 * @param station
	 * @param line
	 */
	public Route( Station station, Line line ) {
		
		usedStops = new ArrayList<TubeStop>();
		
		usedStops.add( new TubeStop(station, line) );
	
	}

	/**
	 * @param stops
	 * @param stop
	 */
	public Route( List<TubeStop> stops, TubeStop stop ) {
	
		this.usedStops = new ArrayList<TubeStop>( stops );
		
		this.usedStops.add( stop );
	
	}
	
	/**
	 * @return
	 */
	public Station headOfRoute() {
		
		return usedStops.get( usedStops.size() - 1 ).getStation();
	
	}

	/**
	 * @param line
	 * @return
	 */
	public ArrayList<Route> getRouteExtensions( Line line ) {
		
		ArrayList<Route> extensions = new ArrayList<Route>();
		
		List<TubeStop> originalRoute = usedStops;
		
		Station headOfRoute = headOfRoute();
		
		Station newStation = line.previousStation( headOfRoute );
		
		if ( newStation != null ) {
			
			//extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
			possiblyAddExtension(  extensions, new TubeStop(newStation, line) );
		
		}
		
		newStation = line.nextStation( headOfRoute );
		
		if ( newStation != null ) {
			
			//extensions.add( new Route( usedStops, new TubeStop(newStation, line) ) ); 
			
			possiblyAddExtension( extensions, new TubeStop(newStation, line) );
		
		}
		
		System.out.println("Returning " + extensions.size() + " extension(s) to " + originalRoute + ": " + extensions);
		
		return extensions;
		
	}
	
	/**
	 * @param lines
	 * @return
	 */
	public ArrayList<Route> getRouteExtensions( List<Line> lines ) {
		
		ArrayList<Route> extensions = new ArrayList<Route>();
		
		Station headOfRoute = headOfRoute();
		
		Line currentLine = currentLine();

		for ( Line line : lines ) {
			
			if ( line.contains( headOfRoute ) ) {
				
				possiblyAddExtension( extensions, new TubeStop(headOfRoute, line) );
			
			}
			
		}
		
		Station newStation = currentLine.previousStation( headOfRoute );
		
		if ( newStation != null ) {
			
			possiblyAddExtension(  extensions, new TubeStop(newStation, currentLine) );
		
		}
		
		newStation = currentLine.nextStation( headOfRoute );
		
		if ( newStation != null ) {
			
			possiblyAddExtension( extensions, new TubeStop(newStation, currentLine) );
		
		}
		
		return extensions;
		
	}

	/**
	 * @param extensions
	 * @param stop
	 */
	private void possiblyAddExtension(List<Route> extensions, TubeStop stop) {
		
		// Every time you see contains, must have an appropriate equals implementation (why? See API!)
		if ( !usedStops.contains(stop) ) {

			extensions.add( new Route( usedStops, stop ) );
			
			System.out.println("Adding new route by extending " + usedStops + " to " + usedStops + " and " + stop);
			
		}
		
	}

	/**
	 * @return
	 */
	private Line currentLine() {
		
		return usedStops.get( usedStops.size() - 1 ).getLine();
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String completeString = "";
		
		for ( TubeStop stop : usedStops ) {
			
			completeString += stop + ", "; // + "\n";
		
		}
		
		return "[" + completeString.substring(0, completeString.length() - 2) + "]";
		
	}
	
}