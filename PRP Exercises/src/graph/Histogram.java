package graph;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Martin
 *
 */
public class Histogram extends JPanel {

	private ArrayList<Bar> bars;
	
	private final int BAR_GAP = 10;
	
	public Histogram() {
		
		super();
		
		bars = new ArrayList<Bar>();
		
		setMinimumSize(new Dimension(50, 50));
		
	}
	
	public void addBar( int height ) {
		
		bars.add(new Bar(height));
		
		this.updateUI();
		
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for ( int bar = 0; bar < bars.size(); bar++ ) {
			
			g.fillRect((bar * (Bar.width + BAR_GAP)), 0, Bar.width, bars.get(bar).getHeight());
		
		}
		
	}
		
}