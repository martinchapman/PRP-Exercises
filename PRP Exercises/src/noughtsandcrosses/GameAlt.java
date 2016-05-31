package noughtsandcrosses;
public class GameAlt {

    private Piece[][] board;
    
    private Piece winner;
    
    private boolean finished;
    
    private int plays;

    public GameAlt() {
    	
        board = new Piece[3][3];
	
        for ( int i = 0; i < 3; ++i ) {
	        	
		    for ( int j = 0; j < 3; ++j ) {
	               
		    	board[i][j] = null;
		    	
	        }
        
        }
        
        winner = null;
    
        finished = false;
        
        plays = 0;
    
    }


    public Piece getPiece(int row, int col) {
    	
        return board[row][col];
    
    }

    public void play(Piece p, Move m) {
    	
    	board[m.getR()][m.getC()] = p;
        
    	plays++;
        
    	if ( plays == 9 ) finished = true;
        
    	checkWinner();
    
    }

    private void checkWinner() {
    	
        for( int row = 0; row < 3; ++row ) {
        	
           checkRow(row);
        
        }
        
        if ( winner == null ) {
        	
            for ( int col = 0; col < 3; col++ ) {
            	
                checkCol(col);
            
            }
        
        }
        
        if ( winner == null) {
        	
            checkForwardDiagonal();
            
            checkBackDiagonal();
            
        }
    
    }

    private void checkRow( int row ) {
    	
        Piece p = board[row][0];
        
        if ( p != null && p.equals(board[row][1]) && p.equals(board[row][2]) ) {
        	
           winner = p;
        
           finished = true;
        
        }
        
    }

    private void checkCol( int col ) {
    	
        Piece p = board[0][col];
        
        if ( p != null && p.equals(board[1][col]) && p.equals(board[2][col]) ) {
        	
           winner = p;
        
           finished = true;
        
        }
        
    }

    private void checkForwardDiagonal() {
        
    	Piece p = board[2][0];
        
        if ( p != null && p.equals(board[1][1]) && p.equals(board[0][2])) {
           
           winner = p;
        
           finished = true;
        
        }
        
    }

    private void checkBackDiagonal() {
    	
        Piece p = board[0][0];
        
        if( p != null && p.equals(board[1][1]) && p.equals(board[2][2]) ) {
        	
           winner = p;
           
           finished = true;
        
        }
    
    }
    
    public boolean canPlay(Move m) {
    	
        return board[m.getR()][m.getC()] == null;
    
    }

    public boolean gameOver() {
    	
        return finished;
    
    }

    public Piece getResult() {
    	
        return winner;
    
    }

    public String toString() {
    	
        String s = "+---+---+---+\n";
        
        for ( int i = 0;i < 3;++i ) {
        	
            s = s + "| ";
            
            for( int j = 0; j < 3; ++j) {
            	
                if ( board[i][j] == null ) {
                	
                   s = s + "  | ";
                
                } else {
                
                	s = s + board[i][j] + " | ";
                
                }
                
            }
            
            s = s + "\n+---+---+---+\n";
        
        }
        
        return s;
    
    }

}
