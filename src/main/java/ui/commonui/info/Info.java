package ui.commonui.info;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Info extends JWindow{
	
	private static final long serialVersionUID = 1L;

	public Info(int x, int y, int width, int height, String info){
		this.setBounds(x, y, width, height);
		this.setBackground(new Color(1,1,1,0.1f));
		
		JLabel text = new JLabel(info);
		text.setForeground(Color.WHITE);
		text.setOpaque(false);
		this.add(text);
	}
	
}
