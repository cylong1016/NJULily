package ui.myUI;

import java.awt.Color;

import javax.swing.JButton;

public class MyJButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public MyJButton(String str){
		this.setText(str);
		this.setVisible(true);
		this.setBackground(Color.white);
	}
}
