package ui.myUI;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField {

	private static final long serialVersionUID = 1L;

	public MyPasswordField(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		//�������򱳾�
		this.setOpaque(false);
		//��������߿�
		this.setBorder(BorderFactory.createEmptyBorder());
	}
}
