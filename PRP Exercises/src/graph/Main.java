package graph;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * @author Martin
 *
 */
public class Main extends JFrame {
	
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Histogram histogram = new Histogram();
		
		add(histogram);
		
		histogram.addBar(10);
		
		histogram.addBar(30);
		
		histogram.addBar(5);
		
		histogram.addBar(100);
		
		histogram.addBar(200);
		
		setMinimumSize(new Dimension(500,500));
		
		pack();
		
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		
		new Main();
	
	}
	
}	