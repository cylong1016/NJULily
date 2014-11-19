package ui.saleui.salesmanFrame;

import ui.myui.MyBackground;
import ui.myui.MyFrame;
import ui.saleui.client_management.index.ClientManagementUI;

public class Frame_Salesman extends MyFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame_Salesman(){
		
		//the panel for client management
		ClientManagementUI panel_CM = new ClientManagementUI();
		this.add(panel_CM);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
	}
}
