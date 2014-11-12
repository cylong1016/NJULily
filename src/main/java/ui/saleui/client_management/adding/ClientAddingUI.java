package ui.saleui.client_management.adding;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.myui.MyButton;
import ui.myui.MyWindow;

public class ClientAddingUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyButton button_return, button_add;
	
	public ClientAddingUI(){
		button_return = new MyButton(490 + 340 , 415 + 135, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_add = new MyButton(490 + 340 , 415 + 135 - 30, 100, 25);
		button_add.addActionListener(this);
		this.add(button_add);
		
		ClientAddingPanel cap = new ClientAddingPanel();
		cap.setOpaque(true);
		cap.setBackground(new Color(0, 0, 0, 0.4f));
		cap.setBounds(340, 135, 600, 450);
		this.add(cap);
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_return){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_add){
			System.out.println("adding client process...");
			this.setVisible(false);
		}
	}
	
	
}
