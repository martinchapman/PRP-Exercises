package roomba;
public class Geom {

	/**
	 * 
	 * Distance in 2D = difference in X squared + difference in Y squared
	 * 
	 * @param point1X
	 * @param point1Y
	 * @param point2X
	 * @param point2Y
	 * @return
	 */
	public static double distance( double point1X, double point1Y, double point2X, double point2Y ) {
		
		return Math.sqrt ( Math.pow( point2X - point1X, 2 ) + Math.pow( point2Y - point1Y, 2 ) );
		
	}

}