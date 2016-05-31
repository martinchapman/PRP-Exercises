package Tube.Version2;

/**
 * @author Martin
 *
 */
public class Main {

	public static void main( String[] args ) {
		
		// Create a single station called WestActon
		Station westActon = new Station("WestActon");
		
		// Create a single line called Central
		Line centralLine = new Line("Central");
		
		// Add WestActon to the Central Line
		centralLine.addStation(westActon);
		
		// Print the Central Line, yielding both its name, and the stations it contains
		System.out.println(centralLine);
		
	}

}
