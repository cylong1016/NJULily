package ui.myui;

import java.awt.Color;

import javax.swing.JWindow;

public class MyWindow extends JWindow{

	private static final long serialVersionUID = 1L;
	
	public MyWindow(){
		this.setSize(1280, 720);
		IOforUI io = new IOforUI();
		this.setLocation(io.getX(), io.getY());
		this.setBackground(new Color(0, 0, 0, 0.3f));
	}
}
