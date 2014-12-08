package ui.differui.inventory.commodity_management.addgood;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyWindow;

public class CommodityAddingUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static JButton button_close;
	
	public CommodityAddingUI(){
			
		CommodityAddingPanel cap = new CommodityAddingPanel();
		cap.setOpaque(true);
		cap.setBackground(new Color(0, 0, 0, 0.3f));
		cap.setBounds(340, 115, 600, 500);
		this.add(cap);
				
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
