package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapScreen extends JFrame {

	Map map = new Map();
	
	final String guiTitle = "Map Generator";
	final Dimension guiSize = new Dimension(1000,700);


	JPanel mapPanel = new JPanel();
	
	public MapScreen() {
		makeMapPanel();
		makeGenerateButtonPanel();

		pack();

		// Standard build stuff. Maybe find some way to make this cleaner
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(guiTitle);
		setSize(guiSize.width, guiSize.height);
		setLocation(150,100);
		setResizable(false);

		setVisible(true);
	}

	private void makeMapPanel() {
		mapPanel.setBackground(Color.LIGHT_GRAY);
		mapPanel.setSize(new Dimension(guiSize.width, guiSize.height));

		map.drawMap();

		mapPanel.add(map.getMapPanel(), BorderLayout.CENTER);

		add(mapPanel, BorderLayout.CENTER);
	}

	private void makeGenerateButtonPanel() {
		JButton generateButton = new JButton("Generate");
		generateButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				map.drawMap();
				makeMapPanel();
			}
		});

		add(generateButton, BorderLayout.SOUTH);
	}
}