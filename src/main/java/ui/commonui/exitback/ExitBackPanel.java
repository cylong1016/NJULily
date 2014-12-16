package ui.commonui.exitback;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.differui.admin.AdminUI;
import ui.differui.finace.frame.Frame_Finace;
import ui.differui.inventory.frame.Frame_Inventory;
import ui.differui.manager.frame.Frame_Manager;
import ui.differui.salesman.frame.Frame_Salesman;

public class ExitBackPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes, button_no;
	
	String flag;
	
	public ExitBackPanel(String _flag){
		
		flag = _flag;
		
		int width = 400;
		int height = 130;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("确认是否注销账号",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//button to choose to close the program
		button_yes = new MyJButton("是");
		button_yes.setBounds(40, 60, 120, 25);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_yes);
		
		//button not to choose to close the program
		button_no = new MyJButton("否");
		button_no.setBounds(240, 60, 120, 25);
		button_no.setForeground(foreColor);
		button_no.setBackground(backColor);
		button_no.addActionListener(this);
		this.add(button_no);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == button_yes){
			Frame_Login fl2 = new Frame_Login();
			fl2.setVisible(true);
			ExitBackFrame.button_close.doClick();
			
			switch(flag){
				case "AdminUI" : AdminUI.bt_vanish.doClick();break;
				case "Frame_Salesman" : Frame_Salesman.bt_vanish.doClick();
										Frame_Salesman.flag = 0;break;
				case "Frame_Inventory" : Frame_Inventory.bt_vanish.doClick();
										 Frame_Inventory.flag = 0;break;
				case "Frame_Finace" : Frame_Finace.bt_vanish.doClick();
									  Frame_Finace.flag = 0;break;
				case "Frame_Manager" : Frame_Manager.bt_vanish.doClick();
								       Frame_Manager.flag = 0;break;
									
			}
		}
		
		if(events.getSource() == button_no){
			ExitBackFrame.button_close.doClick();
		}
	}
}

