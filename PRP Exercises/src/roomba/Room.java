package roomba;
public class Room {

   private double length;

   private double width;

   private Furniture[] furniture;
   
   private int itemsOfFurniture;

   public Room ( double length, double width, int itemsOfFurniture ) {
      
	  this.length = length;
	  
      this.width = width;
      
      furniture = new Furniture[itemsOfFurniture];
      
      this.itemsOfFurniture = 0;
   
   }
   
   /*public Room ( double length, double width, Furniture[] furniture ) {
	   
	   this.length = length;
		  
	   this.width = width;
	   
	   this.furniture = furniture;
	   
   }*/
   
   public void addFurniture ( Furniture f ) {
	   
	   furniture[ itemsOfFurniture++ ] = f;
      
   }

   private Roomba vac;
   
   public void addRoomba ( Roomba r ) {
	   
      vac = r;
      
   }

   public boolean runRoomba( RoombaMove rm ) {
	   
      for ( int item = 0; item < itemsOfFurniture; item++ ) {
    	  
         if ( vac.collisionOnMove(rm, furniture[item]) ) {
        	 
            return false;
         
         }
      
      }
      
      vac.doMove(rm);
      
      return true;
      
   }
   
   public boolean validVac() {
	   
      for ( int item = 0; item < itemsOfFurniture; item++ ) {
         
    	 if ( vac.inCollision( furniture[item] ) ) {
    		 
            return false;
         
    	 }
      
      }
      
      return true;
   
   }
   
   public boolean validFurniture() {
	      
	   for ( int item = 0; item < itemsOfFurniture; item++ ) {
		   
         for ( int corner = 0; corner < 4; corner++ ) {
        	 
            double x = furniture[item].getXpos(corner);
            
            if ( x < 0 || x > width ) {
            
            	//return false;
            
            }
            
            double y = furniture[item].getYpos(corner);
            
            if ( y < 0 || y > length ) {
            	
               //return false;
            
            }
         
         }
      
         System.out.println("==");
         
         for ( int otherItem = item + 1; otherItem < itemsOfFurniture; otherItem++ ) {
        	
        	System.out.println(item + " " + otherItem);
        	 
            if ( furniture[item].overlaps( furniture[otherItem] ) ) {
            	
               //return false;
            
            }
         
         }
      
	  }
      
	  return true;
   
   }

   public boolean validRoom() {
	   
      return validFurniture() && validVac();
   
   }

   public boolean canCleanAll() {
	   
      for ( int item = 0; item < itemsOfFurniture; item++ ) {
    	  
    	      // Distance from left wall
         if ( !vac.fits( furniture[item].getXpos(0) ) ||
        	  // Distance from bottom wall
              !vac.fits( furniture[item].getYpos(0) ) ||
              // Distance from right wall
              !vac.fits( width - furniture[item].getXpos(3) ) ||
              // Distance from top wall
              !vac.fits( length - furniture[item].getYpos(1)) ) {
        	 
            return false;
         
         }

         for( int otherItem = item + 1; otherItem < itemsOfFurniture; otherItem++ ) {
        	 
            if ( furniture[item].beside(furniture[otherItem]) ) {
            	
               if ( !vac.fits(furniture[item].distanceTo(furniture[otherItem])) ) {
            	   
                  return false;
               
               }
            
            }
         
         }
      
      }
      
      return true;
   
   }
   
}