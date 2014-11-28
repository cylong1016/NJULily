package ui.differui.inventory.frame;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import ui.differui.inventory.inventory_checking.HistoryInventoryCheckingUI;
import ui.differui.inventory.inventory_checking.InventoryCheckingUI;
import ui.differui.inventory.inventory_checking.PerformInventoryChecking;


public class Frame_Inventory extends MyFrame{

	private static final long serialVersionUID = 1L;

	public Frame_Inventory(){
			
		//CommodityManagementUI panel_CM = new CommodityManagementUI();
		//this.add(panel_CM);
		
//		InventoryCheckingUI panel_IC = new InventoryCheckingUI();
//		this.add(panel_IC);
		
		HistoryInventoryCheckingUI panel_HIC = new HistoryInventoryCheckingUI();
		this.add(panel_HIC);
		
//		PerformInventoryChecking panel_PIC = new PerformInventoryChecking();
//		this.add(panel_PIC);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
	}
	
}
