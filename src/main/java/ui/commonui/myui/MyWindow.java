package ui.commonui.myui;

import java.awt.Color;

import javax.swing.JDialog;

public class MyWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	

	public MyWindow(){
		this.setSize(1280, 720);
		this.setUndecorated(true);
		GetLocation io = new GetLocation();
		this.setLocation(io.getX(), io.getY());
		this.setLayout(null);
		this.setBackground(new Color(0, 0, 0, 0.7f));	
	}
}
