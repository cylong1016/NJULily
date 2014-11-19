package ui.commonui.myui;

import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MyPanel(){
		//this.setOpaque(false);
		this.setBounds(100, 20, 1100, 680);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(new Color(0, 0, 0, 0.25f));
	}
}
