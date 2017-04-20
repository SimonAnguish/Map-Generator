package gui;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Map extends JComponent {
	final int numPoints = 1000;
	int[] xPoints = new int[numPoints];
	int[] yPoints = new int[numPoints];

	Dimension panelDim = new Dimension(1250,750);

	public Map(Dimension d) {
		panelDim = d;
		populateMap();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		// Draw Water
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, panelDim.width, panelDim.height);
		
		g2.setColor(Color.GREEN);
		g2.fillPolygon(xPoints, yPoints, numPoints);
	}

	public void populateMap() {
		Random rand = new Random();
		for(int i=0;i<numPoints;i++) {
			xPoints[i] = rand.nextInt(panelDim.width);
			yPoints[i] = rand.nextInt(panelDim.height);
		}
		
	}
}