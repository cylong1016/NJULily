package ui.differui.inventory.warning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;

import ui.commonui.myui.MyPanel;


public class WarningIndex extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public WarningIndex(){
		
		//information bar
		JLabel infoBar = new JLabel("                     警报类单据");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);
		
	}
	
	public void actionPerformed(ActionEvent events) {
				
	}

}
