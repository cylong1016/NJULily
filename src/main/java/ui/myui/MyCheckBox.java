package ui.myui;

import javax.swing.JCheckBox;

public class MyCheckBox extends JCheckBox{

	private static final long serialVersionUID = 1L;
	
	public MyCheckBox(int x,int y){
		this.setBounds(x, y, 30, 30);
		this.setOpaque(false);
		//this.setBorder(BorderFactory.createEmptyBorder());
		//this.setBackground(new Color(0,0,0,0));
		//this.setForeground(new Color(0,0,0,0));
		this.setVisible(true);
	}
}
