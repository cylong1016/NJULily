package ui.commonui.myui;

import java.awt.Color;

import javax.swing.JButton;

public class MyJButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public MyJButton(String str){
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		this.setText(str);
		this.setVisible(true);
		this.setBackground(backColor);
		this.setForeground(foreColor);
	}
}
