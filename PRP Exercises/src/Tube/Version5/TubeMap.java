package Tube.Version5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Additions in Version 5:
 * 
 * 1. Constructor
 * 
 * Removed in Version 5:
 * 
 * 1. addLine
 * 
 * @author Martin
 *
 */
public class TubeMap {

	private List<Line> lines;

	/**
	 * The TubeMap constructor now accepts a String
	 * that points us to a file containing a list of line
	 * in the accepted format (e.g. map.txt).
	 * 
	 * This constructor throws an exception, because
	 * reading a file throws a checked exception (i.e.
	 * one that must be caught, or passed on).
	 * 
	 * In this instance, we have chosen to let the exception
	 * propagate, as there is no simple way to proceed from 
	 * this exception (i.e. nothing to straight forward to 
	 * do, if the exception is caught, to rectify an incorrect
	 * path).
	 * 
	 * @throws FileNotFoundException 
	 */
	public TubeMap( String path ) throws FileNotFoundException {
	
		lines = new ArrayList<Line>();
		
		/* Create a new Scanner object, where the input
		 * to the scanner is not System.in or a String, 
		 * but instead a File object. The constructor
		 * of a file object accepts a path to that file,
		 * effectively opening it, so the contents can be read.
		 * 
		 * (We might consider surrounding this with a try-catch
		 * if we want to use it to close the scanner) */
		Scanner scanner = new Scanner( new File( path ) );
		
		/* Instead of looping while there are individual tokens
		 * (i.e. words surrounded by space) to be read, loop
		 * while there are complete lines to be read.
		 */
		while ( scanner.hasNextLine() ) {
		
			/* Read in that complete line from the file,
			 * pass it into the constructor of the Line class, 
			 * in the same way that we did previously, except 
			 * this time the line is read dynamically from a file.
			 */
			lines.add( new Line( scanner.nextLine() ) );
		
		}
		
		// Close the scanner, as always
		scanner.close();
		
	}

	public String toString() {
	
		return "Map " + lines;
	
	}
	
}