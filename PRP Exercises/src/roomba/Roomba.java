package roomba;
public class Roomba {

  private double xPos;
  
  private double yPos;
  
  private double radius;

  public Roomba( double xPos, double yPos, double radius ) {
	  
     this.xPos = xPos;
     
     this.yPos = yPos;
     
     this.radius = radius;
  
  }

  public void moveTo( int xPos, int yPos ) {
	  
     this.xPos = xPos;
     
     this.yPos = yPos;
  
  }

  public String toString() {
	  
     return "Roomba radius " + radius + " at (" + xPos + "," + yPos + ")";
  
  }
  
  
  ////////////////////////////////
  
  public boolean collisionOnMove ( RoombaMove roombaMove, Furniture furniture ) {
	     
	  return inCollision ( xPos + roombaMove.getX(), yPos + roombaMove.getY(), furniture );
  
  }
  
  public boolean inCollision( double xPos, double yPos, Furniture furniture ) {
	  
	 // Because checks happen in order good to keep private

     if ( leftOfFurniture( xPos, yPos, furniture ) || rightOfFurniture( xPos, furniture) ) {
       
   	  	return false;
     
     }
     
     if ( belowFurniture( yPos, furniture ) || aboveFurniture( yPos, furniture) ) {
       
   	  	return false;
     
     }
    
     if ( inLineFurnitureX(xPos, furniture) || inLineFurnitureY(yPos, furniture) ) {
       
   	  	return true;
   	  
     }
    
     for ( int corner = 0; corner < 4; ++corner ) {
   	  
   	      if ( contactWithCorner(corner, xPos, yPos, furniture ) ) {
           
   	    	  return true;
       
   	      }
    
    }
    
    return false;
 
 }
  
  private boolean leftOfFurniture( double xPos, double yPos, Furniture furniture ) {
	  
	  return xPos + radius <= furniture.getXpos(0);
	  
  }
  
  private boolean rightOfFurniture( double xPos, Furniture furniture ) {
	  
	  return xPos - radius >= furniture.getXpos(3);
	  
  }
  
  private boolean belowFurniture( double yPos, Furniture furniture ) {
	  
	  return yPos + radius <= furniture.getYpos(0);
	  
  }
  
  private boolean aboveFurniture( double yPos, Furniture furniture ) {
	  
	  return yPos - radius >= furniture.getYpos(1);
	  
  }
  
  private boolean inLineFurnitureX( double xPos, Furniture furniture ) {
	  
	  // In order to negative, one of these distances has to be negative
	  // return ( xPos - furniture.getXpos(0) ) * ( xPos - furniture.getXpos(3) ) < 0; // Corners 1 and 2 also work
	  return xPos > furniture.getXpos(0) && xPos < furniture.getXpos(3);
	  
  }
  
  private boolean inLineFurnitureY( double yPos, Furniture furniture ) {
	  
	  // In order to be negative, one of these distances has to be negative
	  //return ( yPos - furniture.getYpos(0) ) * ( yPos - furniture.getYpos(1) ) < 0; // Corners 3 and 2 also work
	  return yPos > furniture.getYpos(0) && yPos < furniture.getYpos(1);
  }
  
  private boolean contactWithCorner( int corner, double xPos, double yPos, Furniture furniture ) {
	  
	  return Geom.distance(xPos, yPos, furniture.getXpos(corner), furniture.getYpos(corner)) < radius; // Math.pow(radius, 2); squared because distance wasn't square rooted
	  
  }
  
  public boolean inCollision ( Furniture furniture ) {
	  
	  return inCollision ( xPos, yPos, furniture );
	  
  }
  
  public boolean fits ( double distance ) {
	  
     return ( ( distance == 0 ) || ( 2 * radius <= distance ) );
  
  }

  public void doMove ( RoombaMove rm ) {
     
	 xPos += rm.getX();
	 
     yPos += rm.getY();
     
  }
  
}