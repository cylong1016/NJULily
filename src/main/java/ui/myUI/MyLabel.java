package ui.myUI;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public MyLabel(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
	}
}
