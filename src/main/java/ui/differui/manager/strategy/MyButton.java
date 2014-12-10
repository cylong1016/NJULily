package ui.differui.manager.strategy;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyButton extends JButton{
	
	private static final long serialVersionUID = 1L;

	public MyButton(String text, int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setText(text);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setBackground(new Color(0,0,0,0));
		this.addMouseListener(new MouseHandler());
		this.setVisible(true);
	}
	
	class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
}
