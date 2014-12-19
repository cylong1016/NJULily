package ui.differui.manager.approve;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dataenum.BillType;
import ui.commonui.myui.MyWindow;
import vo.ValueObject;

public class ApprovalModifyUI extends MyWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	ApprovalModifyPanel efp;
	public static JButton button_close;
	
	
	public ApprovalModifyUI(BillType billType, ValueObject bill){
		
		efp = new ApprovalModifyPanel(billType, bill);
		efp.setOpaque(true);
		efp.setBackground(new Color(0, 0, 0, 0.8f));
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
