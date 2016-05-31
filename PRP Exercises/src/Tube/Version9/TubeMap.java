package Tube.Version9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Additions for Version 9: NONE.
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
	
	public Line getLine( String name ) {
		
		for ( Line line : lines ) {
			
			if ( line.getName().equals(name) ) {
				
				return line;
				
			}
			
		}
		
		return null;
		
	}
	
}