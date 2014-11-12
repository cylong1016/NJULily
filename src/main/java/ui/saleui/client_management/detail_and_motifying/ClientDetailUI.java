package ui.saleui.client_management.detail_and_motifying;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyButton;
import ui.myui.MyWindow;

public class ClientDetailUI extends MyWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	MyButton button_return;
	
	public ClientDetailUI(){
		button_return = new MyButton(630 + 240, 610 + 45, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		
		
		ClientDetailPanel cdp = new ClientDetailPanel();
		cdp.setOpaque(true);
		cdp.setBackground(new Color(0, 0, 0, 0.5f));
		cdp.setBounds(240, 45, 800, 650);
		this.add(cdp);
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_return){
			this.setVisible(false);
		}
		
	}
}
