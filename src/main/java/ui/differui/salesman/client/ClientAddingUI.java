package ui.differui.salesman.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyWindow;

public class ClientAddingUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyButton button_return;
	ClientAddingPanel cap;
	public static JButton button_close;
	
	public ClientAddingUI(){
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		cap = new ClientAddingPanel();
		cap.setOpaque(true);
		cap.setBounds(340, 135, 600, 450);
		this.add(cap);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
	}

}
