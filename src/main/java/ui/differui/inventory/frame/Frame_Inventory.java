package ui.differui.inventory.frame;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;


public class Frame_Inventory extends MyFrame{

	private static final long serialVersionUID = 1L;

	public Frame_Inventory(){
			
		CommodityManagementUI panel_CM = new CommodityManagementUI();
		this.add(panel_CM);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
	}
	
}
