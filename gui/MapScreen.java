package gui;

import javax.swing.*;
import java.awt.*;

public class MapScreen extends JFrame {
	
	final String guiTitle = "Map Generator";
	final Dimension guiSize = new Dimension(1000,700);
	
	public MapScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(guiTitle);
		setSize(guiSize);
		
		setVisible(true);
	}
}