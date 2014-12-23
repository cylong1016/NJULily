package ui.differui.manager.strategy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	// 我把private改成public了，主要是黄线。。。
	// TODO 这两个变量干嘛用的，没用到把
	public JPanel inPanel;
	
	public JPanel nextPanel;

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
	
	public void setPanel(JPanel inPanel, JPanel nextPanel) {
		this.inPanel = inPanel;
		this.addActionListener((ActionListener) inPanel);
		System.out.println("test");
		this.nextPanel = nextPanel;
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
			setForeground(Color.WHITE);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.getText())) {
			System.out.println("点击了");
		}
	}
}
