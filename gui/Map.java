package gui;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Map {
	int[][] map = new int[10][10];
	JPanel currentMapPanel = new JPanel();

	public Map() {
		drawMap();
	}

	public void drawMap() {
		populateMap();

		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(10,10));

		JPanel blockPanel;

		for (int[] row : map) {
			for (int col : row) {
				if (col == 1) {
					blockPanel = new JPanel();
					blockPanel.setBackground(Color.GREEN);
					blockPanel.setSize(new Dimension(10,10));
					mapPanel.add(blockPanel);
				}
				else {
					blockPanel = new JPanel();
					blockPanel.setBackground(Color.WHITE);
					blockPanel.setSize(new Dimension(10,10));
					mapPanel.add(blockPanel);
				}
			}
		}

		currentMapPanel = mapPanel;
	}

	private void populateMap() {
		Random rand = new Random();
		for (int[] row : map) {
			System.out.printf("[");
			for (int col : row) {
				col = rand.nextBoolean() ? 1 : 0;
				System.out.printf("%d,", col);
			}
			System.out.printf("]\n");
		}

		System.out.printf("\n----\n");
	}

	public JPanel getMapPanel() {
		return currentMapPanel;
	}
}