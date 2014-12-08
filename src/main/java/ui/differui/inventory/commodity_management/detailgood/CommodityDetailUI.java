package ui.differui.inventory.commodity_management.detailgood;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;

import ui.commonui.myui.MyWindow;

public class CommodityDetailUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static JButton button_close;
	
	public CommodityDetailUI(){
				
		CommodityDetailPanel cdp = new CommodityDetailPanel();
		cdp.setOpaque(true);
		cdp.setBackground(new Color(0, 0, 0));
		cdp.setBounds(240, 90, 800, 560);
		this.add(cdp);
		
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
