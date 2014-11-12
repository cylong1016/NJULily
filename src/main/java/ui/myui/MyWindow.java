package ui.myui;

import java.awt.Color;

import javax.swing.JFrame;

public class MyWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public MyWindow(){
		this.setSize(1280, 720);
		this.setUndecorated(true);
		IOforUI io = new IOforUI();
		this.setLocation(io.getX(), io.getY());
		this.setLayout(null);
		this.setBackground(new Color(0, 0, 0, 0.7f));
	}
}
