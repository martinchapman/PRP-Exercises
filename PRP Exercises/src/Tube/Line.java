package Tube;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin
 *
 * Could implement List... but then would have to deal with lots of extra methods
 * Simplicity does not warrant this
 */
public class Line {
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * Coding to the interfaces RATHER than coding to the class
	 * 
	 * Not all classes that implement list also implement abstract list
	 */
	private List<Station> stations;
	
	/**
	 * @param sLine
	 */
	public Line( String nameAndStations ) {
		
		stations = new ArrayList<Station>();
		
		Scanner scanner = new Scanner( nameAndStations );
		
		name = scanner.next();
		
		while ( scanner.hasNext() ) {
			
			stations.add( new Station( scanner.next() ) );
		
		}
		
		scanner.close();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Line " + name + " " + stations;
	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object object ) {
		
		Line line = (Line) object;
		
		return line.name.equals( this.name ); // could omit this.
		
	}

	/**
	 * @param st
	 * @return
	 */
	public boolean contains( Station station ) {
		
		// Every time you see contains, must have an appropriate equals implementation (why? See API!)
		return stations.contains( station );
	
	}

	/**
	 * 'Previous' depends upon the order in which we load the stations onto the line
	 * @param s
	 * @return
	 */
	public Station previousStation( Station station ) {
		
		int positionOnLine = stations.indexOf( station );
		
		if ( positionOnLine > 0 ) {
		
			return stations.get(positionOnLine - 1);
		
		}
		
		return null;
	
	}
	
	/**
	 * @param station
	 * @return
	 */
	public Station nextStation( Station station ) {
	
		int positionOnLine = stations.indexOf( station );
		
		if ( positionOnLine < stations.size() - 1 ) {
			
			return stations.get(positionOnLine + 1);
		
		}
		
		return null;
		
	}

	/**
	 * @return
	 */
	public String getName() {
		
		return name;
	
	}
	
}