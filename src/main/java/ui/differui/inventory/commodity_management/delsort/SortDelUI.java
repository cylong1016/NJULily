package ui.differui.inventory.commodity_management.delsort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;

import ui.commonui.myui.MyWindow;

public class SortDelUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static JButton button_close;
	
	public SortDelUI(DefaultMutableTreeNode note){
		
		SortDelPanel sap = new SortDelPanel(note);
		sap.setOpaque(true);
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
