package noughtsandcrosses;
import java.util.Scanner;

public class Main {

   public static void main(String args[]) {
	   
       Game game = new Game();
      
       Scanner in = new Scanner(System.in);

       Piece piece = new Piece(true);
       
       while( !game.gameOver() ) {
    	   
    	   //System.out.print( game + "\nNext move for " + piece + ": ");
           
    	   boolean valid = false;
           
    	   while ( !valid ) {
    		   
    		   int row = in.nextInt();
    		   
    		   int col = in.nextInt();
    		   
    		   Move move = new Move(row,col);
	         
               valid = game.play(piece,move);
               
    	   }
       
    	   piece = new Piece(piece);

       }
       
       System.out.print( game + "\n\nGame over.");
       
       if ( game.getResult() == null ) {
    	   
           System.out.print("Nobody ");
       
       } else {
    	   
           System.out.print( game.getResult() + " ");
       
       }
       
       System.out.println("won!");
   
   }

}