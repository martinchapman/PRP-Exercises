package Tube.Version4;

/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		
		// Information about the central line in String format
		String centralLine = "Central EalingBroadway WestActon NorthActon EastActon WhiteCity";
				
		// Create a new tube map
		TubeMap tubeMap = new TubeMap();
		
		/* The creation of stations has now been moved inside
		 * Line, and the creation of Lines inside TubeMap, 
		 * for a more natural representation.
		 * 
		 * The only thing supplied now is a String where the first
		 * word in that String is the name of the line, and the following
		 * words on the stops on that line. In this example, this is only 
		 * a partial list
		 */
		tubeMap.addLine(centralLine);
		
		// Print the map
		System.out.println(tubeMap);
				
			
	}

}
