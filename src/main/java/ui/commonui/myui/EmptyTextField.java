package ui.commonui.myui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class EmptyTextField extends JTextField{

	private static final long serialVersionUID = 1L;
	
	public EmptyTextField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);	
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Arail", Font.BOLD, 14));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
