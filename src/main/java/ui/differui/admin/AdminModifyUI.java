package ui.differui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyWindow;

public class AdminModifyUI extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyButton button_return;
	AdminModifyPanel aap;
	public static JButton button_close;
	
	public AdminModifyUI(){
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		aap = new AdminModifyPanel();
		aap.setOpaque(true);
		aap.setBounds(340, 185, 600, 350);
		this.add(aap);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
	}
}
