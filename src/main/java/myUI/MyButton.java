package myUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyButton extends JButton{

	private static final long serialVersionUID = 1L;

	public MyButton(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
	}
}
