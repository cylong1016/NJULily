package ui.commonui.myui;

import java.awt.Color;

import javax.swing.JComboBox;

public class MyComboBox extends JComboBox<String>{

	private static final long serialVersionUID = 1L;

	public MyComboBox(int x, int y, int width, int height, String[] str){
		
		this.setBounds(x, y, width, height);
		for(int i = 0; i < str.length; i++)
			this.addItem(str[i]);
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		this.setBackground(backColor);
		this.setForeground(foreColor);
		this.setVisible(true);
		
	}
}
