package roomba;
public class RoombaMove {

	private double xMove;
  
	private double yMove;

	public RoombaMove( double xMove, double yMove ) {
	  
		this.xMove = xMove;
    
		this.yMove = yMove;
  
	}

	public double getX() {
	  
		return xMove;
  
	}

	public double getY() {
	  
		return yMove;
  
	}

}