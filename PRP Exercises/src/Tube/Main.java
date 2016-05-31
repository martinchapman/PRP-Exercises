package Tube;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// If we were to 'swallow' the exception, would have to do extra work in informing the user what went wrong
		// Instead, we throw it, so the exception propagates normally.
		TubeMap map = new TubeMap("map.txt");

		// If there's some way to continue then we'd try and catch (e.g. validating user input)
		//Station start = new Station(args[0]);
		
		Station start = new Station("WestActon");
		
		//Station end = new Station(args[1]);
		
		Station end = new Station("EastActon");

		Route route = new FindARoute(map, start, end).getRoute( map.getLine("Central") );

		System.out.println("To get from " + start + " to " + end + " try:");
		
		if ( route == null ) {
		
			System.out.println( "Walking." );
		
		} else {
			
			System.out.println( route );
		
		}
	
	}

}
