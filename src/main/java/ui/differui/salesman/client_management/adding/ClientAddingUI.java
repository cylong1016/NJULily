package ui.differui.salesman.client_management.adding;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyWindow;

public class ClientAddingUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyButton button_return;
	ClientAddingPanel cap;
	MyButton button_add;
	public static JButton button_close;
	
	public ClientAddingUI(){
		
		button_return = new MyButton(490 + 340, 415 + 135, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_add = new MyButton(490 + 340, 390 + 135, 100, 25);
		button_add.addActionListener(this);
		this.add(button_add);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		cap = new ClientAddingPanel();
		cap.setOpaque(true);
		cap.setBackground(new Color(0, 0, 0));
		cap.setBounds(340, 135, 600, 450);
		this.add(cap);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("ClientAddingUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_add){
			this.setVisible(false);
			System.out.println("adding client process...");
			System.out.println(cap.getinfo());
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
	}
		
}
