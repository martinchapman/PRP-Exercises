package misc;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;

import javax.swing.JFrame;

public class MoveDemo extends JFrame {

	public static void main(String[] args) {
	
		MoveDemo move = new MoveDemo();
		
		Scanner in = new Scanner(System.in);
		
		while ( in.hasNextInt() ) {
			
			in.nextInt();
			
			move.move();
			
		}
		
		in.close();
	
	}
	
	public MoveDemo() {

		super("Move Demo");       
           
	    setSize(800, 600);    
	    
	    setLayout(null);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    setVisible(true);
	
	}
	
	private int x = 10;
	
	private int y = 10;
	
	public void paint(Graphics g) {
	    
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.draw(new Rectangle2D.Double(x, y, 100, 100));
	
	}
	
	public void move() {
		
		x = x + 10;
		
		y = y + 10;
		
		repaint();
		
	}

}