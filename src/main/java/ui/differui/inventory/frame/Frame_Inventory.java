package ui.differui.inventory.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import ui.differui.inventory.gift.GiftUI;
import ui.differui.inventory.inventory_checking.HistoryInventoryCheckingUI;
import ui.differui.inventory.inventory_checking.InventoryCheckingIndex;
import ui.differui.inventory.inventory_checking.InventoryCheckingUI;
import ui.differui.inventory.inventory_checking.PerformInventoryChecking;
import ui.differui.inventory.inventory_review.InventoryReviewUI;



public class Frame_Inventory extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JButton bt_IR, bt_Checking, bt_Gift, bt_Alarm, bt_Mail, bt_Cancel, bt_Index; 
	
	static int openningFlag = 0;
	
	public static JButton bt_CM, button_reset, bt_IC;
	
	InventoryCheckingUI panel_IC;
	HistoryInventoryCheckingUI panel_HIC;
	PerformInventoryChecking panel_PIC;
	GiftUI panel_gift;
	InventoryReviewUI panel_IR;
	CommodityManagementUI panel_CM;
	InventoryCheckingIndex panel_ICI;
	InventoryIndex panel_Index;
	
	public Frame_Inventory(){
		
		panel_Index = new InventoryIndex();
		panel_Index.setVisible(true);
		this.add(panel_Index);
		
		panel_CM = new CommodityManagementUI();
		panel_CM.setVisible(false);
		this.add(panel_CM);
		
		panel_ICI = new InventoryCheckingIndex();
		panel_ICI.setVisible(false);
		this.add(panel_ICI);
			
		panel_IC = new InventoryCheckingUI();
		panel_IC.setVisible(false);
		this.add(panel_IC);
		
		panel_HIC = new HistoryInventoryCheckingUI();
		panel_HIC.setVisible(false);
		this.add(panel_HIC);
		
		panel_PIC = new PerformInventoryChecking();
		panel_PIC.setVisible(false);
		this.add(panel_PIC);
		
		panel_gift = new GiftUI();
		panel_gift.setVisible(false);
		this.add(panel_gift);
		
		panel_IR = new InventoryReviewUI();
		panel_IR.setVisible(false);
		this.add(panel_IR);
		
		bt_Index = new JButton("主界面");
		bt_Index.setBounds(0, 20, 100, 60);
		bt_Index.setVisible(true);
		bt_Index.addActionListener(this);
		this.add(bt_Index);
		
		bt_CM = new JButton("商品分类和商品管理");
		bt_CM.setBounds(0, 80, 100, 60);
		bt_CM.setVisible(true);
		bt_CM.addActionListener(this);
		this.add(bt_CM);
		
		bt_IR = new JButton("库存查看");
		bt_IR.setBounds(0, 140, 100, 60);
		bt_IR.setVisible(true);
		bt_IR.addActionListener(this);
		this.add(bt_IR);
		
		bt_Checking = new JButton("库存盘点");
		bt_Checking.setBounds(0, 200, 100, 60);
		bt_Checking.setVisible(true);
		bt_Checking.addActionListener(this);
		this.add(bt_Checking);
		
		bt_Gift = new JButton("库存赠送");
		bt_Gift.setBounds(0, 260, 100, 60);
		bt_Gift.setVisible(true);
		bt_Gift.addActionListener(this);
		this.add(bt_Gift);
		
		bt_Alarm = new JButton("库存警报类单据");
		bt_Alarm.setBounds(0, 320, 100, 60);
		bt_Alarm.setVisible(true);
		bt_Alarm.addActionListener(this);
		this.add(bt_Alarm);
		
		bt_Alarm = new JButton("站内信");
		bt_Alarm.setBounds(1210, 665, 60, 40);
		bt_Alarm.setVisible(true);
		bt_Alarm.addActionListener(this);
		this.add(bt_Alarm);
		
		bt_Cancel = new JButton("注销");
		bt_Cancel.setBounds(1210, 625, 60, 40);
		bt_Cancel.setVisible(true);
		bt_Cancel.addActionListener(this);
		this.add(bt_Cancel);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
		
		button_reset = new JButton();
		button_reset.addActionListener(this);
		this.add(button_reset);	
		
		bt_IC = new JButton();
		bt_IC.addActionListener(this);
		this.add(bt_IC);	
		}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_Index){
			if(openningFlag != 0){
				
			}
		}
		
		if(events.getSource() == bt_CM){
			if(openningFlag == 0){
				panel_Index.setVisible(false);
				panel_CM.setVisible(true);
				openningFlag = 1;
			}else{
				
				switch(openningFlag){
					case 2:	 	ExitFunctionFrame efp2 = new ExitFunctionFrame("CommodityManagementUIwith2");
								efp2.setVisible(true);	
								break;
					case 3:		ExitFunctionFrame efp3 = new ExitFunctionFrame("CommodityManagementUIwith3");
								efp3.setVisible(true);	
								break;
					case 4:		ExitFunctionFrame efp4 = new ExitFunctionFrame("CommodityManagementUIwith4");
								efp4.setVisible(true);	
								break;
					case 5:		ExitFunctionFrame efp5 = new ExitFunctionFrame("CommodityManagementUIwith5");
								efp5.setVisible(true);	
								break;
						
					case 6:		ExitFunctionFrame efp6 = new ExitFunctionFrame("CommodityManagementUIwith6");
								efp6.setVisible(true);	
								break;
								
					default: 	break;
				}
				
				
			}
		}
		
		if(events.getSource() == bt_Checking){
			if(openningFlag == 0){
				panel_Index.setVisible(false);
				panel_ICI.setVisible(true);
			}else{
				
			}
		}
		
		if(events.getSource() == button_reset){
			openningFlag = 0;
		}
		
		if(events.getSource() == bt_IC){
			panel_IC.setVisible(true);
			openningFlag = 3;
		}
	}	
}
