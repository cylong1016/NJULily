package ui.differui.manager.strategy;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyJScrollPane extends JScrollPane{

	private static final long serialVersionUID = 1L;

	public MyJScrollPane() {
	}
	
	public MyJScrollPane(JTable table, int x, int y, int width, int height) {
		super(table);
		this.setBounds(x, y, width, height);
		this.getViewport().setBackground(new Color(0,0,0,0.3f));
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	
}
