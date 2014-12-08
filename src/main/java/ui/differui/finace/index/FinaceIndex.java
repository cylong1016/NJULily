package ui.differui.finace.index;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class FinaceIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public FinaceIndex(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("主界面");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}
}
