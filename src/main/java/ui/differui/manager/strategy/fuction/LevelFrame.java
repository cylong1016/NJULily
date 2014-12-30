package ui.differui.manager.strategy.fuction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyWindow;

public class LevelFrame extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	LevelPanel epp;
	public static JButton button_close;
	
	
	public LevelFrame(){
		
		epp = new LevelPanel();
		epp.setOpaque(true);
		epp.setBackground(new Color(0, 0, 0, 0.3f));
		this.add(epp);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
			
	}
}

