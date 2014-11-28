package ui.differui.inventory.frame;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;
import ui.differui.inventory.inventory_review.InventoryReviewUI;



public class Frame_Inventory extends MyFrame{

	private static final long serialVersionUID = 1L;

	public Frame_Inventory(){
			
//		CommodityManagementUI panel_CM = new CommodityManagementUI();
//		this.add(panel_CM);
		
//		InventoryCheckingUI panel_IC = new InventoryCheckingUI();
//		this.add(panel_IC);
		
//		HistoryInventoryCheckingUI panel_HIC = new HistoryInventoryCheckingUI();
//		this.add(panel_HIC);
		
//		PerformInventoryChecking panel_PIC = new PerformInventoryChecking();
//		this.add(panel_PIC);
		
//		GiftUI panel_gift = new GiftUI();
//		this.add(panel_gift);
		
		InventoryReviewUI panel_IR = new InventoryReviewUI();
		this.add(panel_IR);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
	}
	
}
