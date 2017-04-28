package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapScreen extends JFrame {
	final Dimension guiSize = new Dimension(1250,750);

	Map map = new Map(guiSize);
	
	final String guiTitle = "Map Generator";
	JLabel currentScore = new JLabel("" + map.measureScore());


	JPanel mapPanel = new JPanel();
	
	public MapScreen() {
		makeMapPanel();
		makeGenerateButtonPanel();
		makeInteractivePanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(guiTitle);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		pack();

		setVisible(true);
	}

	private void makeMapPanel() {
		mapPanel.setBackground(Color.LIGHT_GRAY);
		mapPanel.setSize(guiSize);
		
		map.repaint();

		add(map, BorderLayout.CENTER);
	}

	private void makeGenerateButtonPanel() {
		JButton generateButton = new JButton("Generate");
		generateButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				map.populateMap();
				
				currentScore.setText("" + map.measureScore());
				map.repaint();
			}
		});

		add(generateButton, BorderLayout.SOUTH);
	}
	
	private void makeInteractivePanel() {
		add(currentScore, BorderLayout.NORTH);
	}
}