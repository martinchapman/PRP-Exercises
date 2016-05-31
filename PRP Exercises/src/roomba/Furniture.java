package roomba;
public class Furniture {

   private double xPos;
   
   private double yPos;
   
   private double length;
   
   private double width;

   public Furniture ( double xPos, double yPos, double length, double width ) {
      
	  this.xPos = xPos;
      
      this.yPos = yPos;
      
      this.length = length;
      
      this.width = width;
      
   }

   public double getXpos ( int corner ) {
	   
      if ( corner == 0 || corner == 1 ) { 
    	  
    	  return xPos; 
    	  
      } else {
      
    	  return xPos + width;
      
      }
   
   }

   public double getYpos ( int corner ) {
	   
      if ( corner == 0 || corner == 3 ) { 
    	  
    	  return yPos; 
    	  
      } else {
      
    	  return yPos + length;
      
      }
   
   }
   
   public boolean overlaps ( Furniture furniture ) {
	     
      if ( !overlapsX( furniture ) || !overlapsY( furniture ) ) return false;
     
      return true;
   
   }
   
   
   private boolean overlapsX ( Furniture furniture ) {
	  
	  // If rightmost corner is left of furniture leftmost corner, or vice versa
	  // yPos + length <= f.yPos || f.yPos +f.length <= yPos
	  if ( getXpos(3) <= furniture.getXpos(0) || furniture.getXpos(3) <= getXpos(0) ) return false;
	  
	  // Any part left or right (i.e. overlapping on x)
	  // getXpos(2) > furniture.getXpos(0) && furniture.getXpos(3) > getXpos(1)
	  return true;
    
   }
   
   private boolean overlapsY ( Furniture furniture ) {
	  
	   // xPos + width <= f.xPos || f.xPos + f.width <= xPos
	  if ( getYpos(1) <= furniture.getYpos(0) || furniture.getYpos(1) <= getYpos(0) ) return false;
	  
	  // Any part above or below (i.e. overlapping on y)
	  // getYpos(1) > furniture.getYpos(3) && furniture.getYpos(2) > getYpos(0)
	  return true;
      
   }
   
   private boolean sideBySide ( Furniture furniture ) {
	   
	   if ( !overlapsX( furniture ) ) {
	    
		   if ( overlapsY( furniture ) ) {
          
			   return true;
      
		   }
      
	   }
	   
	   return false;
	   
   }
   
   private boolean aboveAndBelow ( Furniture furniture ) {
	   
	  if ( !overlapsY( furniture ) ) {
		  
	      if ( overlapsX( furniture ) ) {
	    	  
	          return true;
	      
	      }
	  
	  }
	  
	  return false;
	      
   }
   
   public boolean beside ( Furniture furniture ) {
	  
	  return sideBySide( furniture ) || aboveAndBelow( furniture );
      
   }

   public double distanceTo ( Furniture furniture ) {
	   
      if ( sideBySide( furniture ) ) {
    	  
    	  // If current furniture is right of other, latter will be negative, and vice-versa.
    	  return Math.max ( getXpos(0) - furniture.getXpos(3), furniture.getXpos(0) - getXpos(3) );
      
      } else {
    	
    	  // If current furniture is below other, latter will be negative, and vice-versa.
          return Math.max ( furniture.getYpos(0) - getYpos(1), getYpos(0) - furniture.getYpos(1) );
    	  
      }
     
   }
   
}
