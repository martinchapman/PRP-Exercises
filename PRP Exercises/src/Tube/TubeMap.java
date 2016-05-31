package Tube;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * !! COMPILE OUTSIDE OF ECLIPSE TO WORK OUT WHEN MAP.TXT DEFINITELY NEEDS TO BE
 * 
 * @author Martin
 *
 */
public class TubeMap {

	/**
	 * 
	 */
	private List<Line> lines;

	/**
	 * @param file
	 * @throws IOException
	 */
	public TubeMap( String file ) throws IOException {
	
		lines = new ArrayList<Line>();
		
		// If we were to 'swallow' the exception, would have to do extra work in informing the user what went wrong
		// Instead, we throw it, so the exception propagates normally.
		Scanner scanner = new Scanner( new File( file ) );

		while ( scanner.hasNextLine() ) {
		
			String nameAndStations = scanner.nextLine();
			
			lines.add( new Line(nameAndStations) );
		
		}

		scanner.close();
	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	
		return "Map " + lines;
	
	}

	/**
	 * @return
	 */
	public List<Line> getLines() {
	
		return lines;
	
	}
	
	/**
	 * Helper method for incremental implementation
	 * 
	 * @param name
	 * @return
	 */
	public Line getLine( String name ) {
		
		for ( Line line : lines ) {
			
			if ( line.getName().equals(name) ) {
				
				return line;
				
			}
			
		}
		
		return null;
		
	}
	
}