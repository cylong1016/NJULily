package ui.differui.inventory.commodity_management.detailsort;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyWindow;

public class SortDetailUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static JButton button_close;
	
	public SortDetailUI(){
		
		SortDetailPanel sap = new SortDetailPanel();
		sap.setOpaque(true);
		sap.setBackground(new Color(0, 0, 0));
		sap.setBounds(340, 250, 600, 185);
		this.add(sap);
		
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
