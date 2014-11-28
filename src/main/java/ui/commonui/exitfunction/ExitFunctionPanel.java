package ui.commonui.exitfunction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.differui.inventory.commodity_management.addgood.CommodityAddingUI;
import ui.differui.inventory.commodity_management.addsort.SortAddingUI;
import ui.differui.inventory.commodity_management.detailgood.CommodityDetailUI;
import ui.differui.inventory.commodity_management.detailsort.SortDetailUI;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import ui.differui.inventory.inventory_checking.HistoryInventoryCheckingUI;
import ui.differui.inventory.inventory_checking.InventoryCheckingUI;
import ui.differui.inventory.inventory_checking.PerformInventoryChecking;
import ui.differui.salesman.client_management.adding.ClientAddingUI;
import ui.differui.salesman.client_management.detail.ClientDetailUI;
import ui.differui.salesman.client_management.index.ClientManagementUI;

public class ExitFunctionPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes, button_no;
	String flag;
	
	public ExitFunctionPanel(){
		
		int width = 400;
		int height = 130;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		//information bar
		JLabel infoBar = new JLabel("确认是否退出此功能",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(Color.black);
		infoBar.setBackground(new Color(0, 1, 1, 0.5f));
		this.add(infoBar);
		
		//button to choose to close the program
		button_yes = new MyJButton("是");
		button_yes.setBounds(40, 60, 120, 25);
		button_yes.setForeground(Color.BLACK);
		button_yes.setBackground(new Color(0, 1, 1, 0.65f));
		button_yes.addActionListener(this);
		this.add(button_yes);
		
		//button not to choose to close the program
		button_no = new MyJButton("否");
		button_no.setBounds(240, 60, 120, 25);
		button_no.setForeground(Color.BLACK);
		button_no.setBackground(new Color(0, 1, 1, 0.65f));
		button_no.addActionListener(this);
		this.add(button_no);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == button_yes){
			switch(flag){
			case "ClientAddingUI": ClientAddingUI.button_close.doClick();break;
			case "ClientManagementUI": ClientManagementUI.button_close.doClick();break;
			case "ClientDetailUI": ClientDetailUI.button_close.doClick();break;
			case "CommodityAddingUI": CommodityAddingUI.button_close.doClick();break;
			case "SortAddingUI": SortAddingUI.button_close.doClick();break;
			case "CommodityDetailUI": CommodityDetailUI.button_close.doClick();break;
			case "SortDetailUI": SortDetailUI.button_close.doClick();break;
			case "CommodityManagementUI": CommodityManagementUI.button_close.doClick();break;
			case "InventoryCheckingUI": InventoryCheckingUI.button_close.doClick();break;
			case "HistoryInventoryCheckingUI": HistoryInventoryCheckingUI.button_close.doClick();break;
			case "PerformInventoryChecking": PerformInventoryChecking.button_close.doClick();break;
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