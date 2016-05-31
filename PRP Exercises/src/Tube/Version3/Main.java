package Tube.Version3;

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
		
		// Create a new tube map
		TubeMap tubeMap = new TubeMap();
		
		// Add the central line to the tube map
		tubeMap.addLine(centralLine);
		
		/* Print the tube map, yielding the lines it contains, 
		 * and the stations on those lines (i.e. toString() is
		 * `recursively' called).
		 */
		System.out.println(tubeMap);
		
	}

}

