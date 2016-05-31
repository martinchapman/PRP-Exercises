package noughtsandcrosses;
public class Piece {

   private boolean isNought;

   public Piece( boolean b ) {
	   
       isNought = b;
       
   }

   public Piece( Piece lastPiecePlayed ) {
	   
       isNought = !lastPiecePlayed.isNought;
   
   }

   public String toString() {
	   
	   if ( isNought ) {  return "O"; } 
	   else { return "X"; }
   
   }

   public boolean equals( Piece otherPiece ) {
	   
       if ( otherPiece == null ) return false;
       
       return otherPiece.isNought == isNought;
   
   }

}