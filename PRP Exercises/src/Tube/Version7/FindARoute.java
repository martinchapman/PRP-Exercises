package Tube.Version7;

import java.util.ArrayList;
import java.util.List;

/**
 * Additions in Version 7: NONE.
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