package Tube.Version8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions for Version 8:
 * 
 * Method getLine
 * 
 * @author Martin
 *
 */
public class TubeMap {

	private List<Line> lines;

	public TubeMap( String path ) throws FileNotFoundException {
	
		lines = new ArrayList<Line>();
	
		Scanner scanner = new Scanner( new File( path ) );
		
		while ( scanner.hasNextLine() ) {
		
			lines.add( new Line( scanner.nextLine() ) );
		
		}
		
		scanner.close();
		
	}

	public String toString() {
	
		return "Map: " + lines;
	
	}
	
	/**
	 * Returns a Line object based upon its name
	 * 
	 * @param name
	 * @return the Line associated with name
	 */
	public Line getLine( String name ) {
		
		// Loop through each of the Lines
		for ( Line line : lines ) {
			
			// If the name of the current line is equal to the desired name...
			if ( line.getName().equals(name) ) {
				
				// ...return this line
				return line;
				
			}
			
		}
		
		// If no line is found with the given name, return null.
		return null;
		
	}
	
}