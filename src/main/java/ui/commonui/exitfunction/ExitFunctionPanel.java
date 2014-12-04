package ui.commonui.exitfunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.differui.admin.AdminAddingUI;
import ui.differui.admin.AdminModifyUI;
import ui.differui.inventory.commodity_management.addgood.CommodityAddingUI;
import ui.differui.inventory.commodity_management.addsort.SortAddingUI;
import ui.differui.inventory.frame.Frame_Inventory;
import ui.differui.salesman.client.ClientAddingUI;
import ui.differui.salesman.client.ClientDetailUI;

public class ExitFunctionPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes, button_no;
	String flag;
	
	public ExitFunctionPanel(){
		
		int width = 400;
		int height = 130;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		//information bar
		JLabel infoBar = new JLabel("确认是否退出此功能",JLabel.CENTER);
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
			switch(flag){
			case "ClientAddingUI" : ClientAddingUI.button_close.doClick();break;
			
			case "ClientDetailUI" : ClientDetailUI.button_close.doClick();break;
			
			case "Inventory" : 	Frame_Inventory.visibleFalse(Frame_Inventory.flag);
								Frame_Inventory.visibleTrue(Frame_Inventory.destination);
								Frame_Inventory.flag = Frame_Inventory.destination;
								break;
								
			case "AdminAddingUI" : AdminAddingUI.button_close.doClick();break;
			
			case "AdminModifyUI" : AdminModifyUI.button_close.doClick();break;
			
			case "CommodityAddingUI" : CommodityAddingUI.button_close.doClick();break;
			
			case "SortAddingUI" : SortAddingUI.button_close.doClick();break;
			
			}
			ExitFunctionFrame.button_close.doClick();
		}
		
		if(events.getSource() == button_no){	
			ExitFunctionFrame.button_close.doClick();
		}
		
		this.setVisible(false);
	}
	
	public void setFlag(String _flag){
		flag = _flag;
	}
}