package myUI;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;

	public MyPasswordField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		//Ïû³ıÊäÈë¿ò±³¾°
		this.setOpaque(false);
		//Ïû³ıÊäÈë¿ò±ß¿ò
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
