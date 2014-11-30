package ui.differui.salesman.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyWindow;

public class ClientDetailUI extends MyWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	MyButton button_return;
	public static JButton button_close;
	
	public ClientDetailUI(){
		button_return = new MyButton(630 + 240, 610 + 45, 100, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		ClientDetailPanel cdp = new ClientDetailPanel();
		cdp.setOpaque(true);
		cdp.setBounds(240, 45, 800, 650);
		this.add(cdp);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_return){
			ExitFunctionFrame eff = new ExitFunctionFrame("ClientDetailUI");
			eff.setVisible(true);
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
	}
}
