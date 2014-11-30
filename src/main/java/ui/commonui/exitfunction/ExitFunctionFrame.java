package ui.commonui.exitfunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.myui.MyWindow;

public class ExitFunctionFrame extends MyWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	ExitFunctionPanel efp;
	public static JButton button_close;
	
	
	public ExitFunctionFrame(String flag){
		
		efp = new ExitFunctionPanel();
		efp.setOpaque(true);
		efp.setBackground(new Color(0, 0, 0, 0.8f));
		efp.setFlag(flag);
		this.add(efp);
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		this.setBackground(new Color(0, 0, 0, 0.6f));
			
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
			
	}
}