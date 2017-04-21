package gui;

import java.util.Random;
import java.lang.Math;

import javax.swing.*;
import java.awt.*;

public class Map extends JComponent {
	final int numPoints = 1000;
	final int iterations = 900000;
	
	int[] xPoints = new int[numPoints];
	int[] yPoints = new int[numPoints];

	Dimension panelDim = new Dimension(1250,750);

	public Map(Dimension d) {
		panelDim = d;
		populateMap();
		
		for (int i=0;i<iterations;i++) {
			int[][] savedPoints = getPoints();
			double savedScore = measureScore();
			
			populateMap();
			
			System.out.printf("Old Score: %f | New Score: %f\n", savedScore, measureScore());
			
			if (Double.compare(measureScore(), savedScore) > 0) {
				System.out.printf("Old score was better, reverting.\n");
				xPoints = savedPoints[0];
				yPoints = savedPoints[1];
			}
		}
		
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
	
	public int[][] getPoints() {
		int[][] points = new int[2][numPoints];
		points[0] = xPoints;
		points[1] = yPoints;
		
		return points;
	}
	
	public double measureScore() {
		double score = 0;
		for (int i=1;i<numPoints;i++) {
			// Calculate distance between points
			score += Math.sqrt(Math.pow(((double)xPoints[i]-(double)xPoints[i-1]),2.0)+Math.pow(((double)yPoints[i]-(double)yPoints[i-1]),2.0));
		}
		
		return score;
	}
}