package ui.commonui.text_conductor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import dataenum.BillType;
import ui.commonui.myui.MyWindow;
import vo.ValueObject;

public class BillFrame extends MyWindow implements ActionListener{

	private static final long serialVersionUID = 1L;

	BillPanel epp;
	public static JButton button_close;
	
	
	public BillFrame(BillType billType, ValueObject bill){
		
		epp = new BillPanel(billType, bill);
		epp.setOpaque(true);
		epp.setBackground(new Color(0, 0, 0, 0.3f));
		this.add(epp);
		
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

