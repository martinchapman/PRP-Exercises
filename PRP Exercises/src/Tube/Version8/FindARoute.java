package Tube.Version8;

/**
 * Additions in Version 8: NONE;
 * 
 * @author Martin
 *
 */
public class FindARoute {

	private TubeMap map;

	private Station start;
	
	private Station end;

	public FindARoute( TubeMap map, Station start, Station end ) {
	
		this.map = map;
		
		this.start = start;
		
		this.end = end;
	
	}

}