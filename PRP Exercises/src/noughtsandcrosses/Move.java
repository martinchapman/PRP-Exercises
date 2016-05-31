package noughtsandcrosses;
public class Move {

   private int row;
   
   private int col;

   public Move(int r,int c) {
	   
      row = r;
      
      col = c;
   
   }

   public boolean isValid() {
	   
      return (row >= 0 && row < 3 && col >= 0 && col < 3);
   
   }

   public int getR() { 
	   
	   return row; 
	   
   }
   
   public int getC() {  
	   
	   return col; 
	   
   }
   
}