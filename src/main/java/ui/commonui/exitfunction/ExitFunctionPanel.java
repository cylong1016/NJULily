package ui.commonui.exitfunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.text_conductor.BillFrame;
import ui.commonui.text_conductor.SaveFrame;
import ui.differui.admin.AdminAddingUI;
import ui.differui.admin.AdminModifyUI;
import ui.differui.finace.frame.Frame_Finace;
import ui.differui.inventory.commodity_management.addgood.CommodityAddingUI;
import ui.differui.inventory.commodity_management.addsort.SortAddingUI;
import ui.differui.inventory.commodity_management.delsort.SortDelUI;
import ui.differui.inventory.commodity_management.detailgood.CommodityDetailUI;
import ui.differui.inventory.commodity_management.detailsort.SortDetailUI;
import ui.differui.inventory.frame.Frame_Inventory;
import ui.differui.inventory.inventory_checking.CommodityDetailUI2;
import ui.differui.manager.frame.Frame_Manager;
import ui.differui.manager.strategy.fuction.LevelFrame;
import ui.differui.manager.strategy.fuction.TotalFrame;
import ui.differui.salesman.client.ClientAddingUI;
import ui.differui.salesman.client.ClientDetailUI;
import ui.differui.salesman.frame.Frame_Salesman;

public class ExitFunctionPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes, button_no;
	String flag;
	
	public ExitFunctionPanel(){
		
		int width = 400;
		int height = 130;
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
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
								
			case "Sale" : Frame_Salesman.visibleFalse(Frame_Salesman.flag);
						  Frame_Salesman.visibleTrue(Frame_Salesman.destination);
						  Frame_Salesman.flag = Frame_Salesman.destination;
						  break;
						  
			case "finace" : Frame_Finace.visibleFalse(Frame_Finace.flag);
							Frame_Finace.visibleTrue(Frame_Finace.destination);
							Frame_Finace.flag = Frame_Finace.destination;
							break;
			case "manager" : Frame_Manager.visibleFalse(Frame_Manager.flag);
							 Frame_Manager.visibleTrue(Frame_Manager.destination);
							 Frame_Manager.flag = Frame_Manager.destination;
							 break;
								
			case "AdminAddingUI" : AdminAddingUI.button_close.doClick();break;
			
			case "AdminModifyUI" : AdminModifyUI.button_close.doClick();break;
			
			case "CommodityAddingUI" : CommodityAddingUI.button_close.doClick();break;
			
			case "SortAddingUI" : SortAddingUI.button_close.doClick();break;
			
			case "SortDelUI" : SortDelUI.button_close.doClick();break;
			
			case "SortDetailUI" : SortDetailUI.button_close.doClick();break;
			
			case "CommodityDetailUI" : CommodityDetailUI.button_close.doClick();break;
			
			case "CommodityDetailUI2" : CommodityDetailUI2.button_close.doClick();break;
			
			case "BillFrame" : BillFrame.button_close.doClick();break;
			
			case "LevelFrame" : LevelFrame.button_close.doClick();break;
			
			case "TotalFrame" : TotalFrame.button_close.doClick();break;
			
			case "SaveFrame" : SaveFrame.button_close.doClick();break; 
			
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