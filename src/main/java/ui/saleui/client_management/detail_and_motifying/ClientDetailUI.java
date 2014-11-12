package ui.saleui.client_management.detail_and_motifying;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyButton;
import ui.myui.MyWindow;

public class ClientDetailUI extends MyWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	MyButton button_return, button_modify, button_check;
	
	public ClientDetailUI(){
		button_return = new MyButton(630 + 240, 610 + 45, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_modify = new MyButton(650 + 240, 275 + 45, 100, 20);
		button_modify.addActionListener(this);
		this.add(button_modify);
		
		button_check = new MyButton(650 + 240, 580 + 45, 100, 20);
		button_check.addActionListener(this);
		this.add(button_check);
		
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
		
		if(events.getSource() == button_modify){
			System.out.println("modifying the infornation of the client ...");
		}
		
		if(events.getSource() == button_check){
			System.out.println("now checking ...");
		}
	}
}
