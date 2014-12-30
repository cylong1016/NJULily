package ui.differui.manager.strategy.myui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public JPanel inPanel;
	
	public JPanel nextPanel;

	public MyButton(String text, int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setText(text);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setBackground(new Color(0,0,0,0));
		this.setForeground(Color.WHITE);
		this.setFont(new Font("黑体", Font.BOLD, 18));
		this.addMouseListener(new MouseHandler());
		this.setVisible(true);
	}
	
	public void setPanel(JPanel inPanel, JPanel nextPanel) {
		this.inPanel = inPanel;
		this.addActionListener((ActionListener) inPanel);
		this.nextPanel = nextPanel;
	}
	
	class MouseHandler extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {	
			setForeground(Color.LIGHT_GRAY);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setForeground(Color.WHITE);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
