package ui.saleui;

import ui.myui.MyBackground;
import ui.myui.MyFrame;
import ui.saleui.client_management.Panel_ClientManagement;

public class Frame_Salesman extends MyFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame_Salesman(){
		
		//the panel for client management
		Panel_ClientManagement panel_CM = new Panel_ClientManagement();
		this.add(panel_CM);
		
		MyBackground loginBackground = new MyBackground("image/back/backForNow.jpg");
		this.add(loginBackground);
	}
}
