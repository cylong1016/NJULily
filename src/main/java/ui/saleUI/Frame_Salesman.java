package ui.saleUI;

import ui.myUI.MyBackground;
import ui.myUI.MyFrame;
import ui.saleUI.clientManagement.Panel_ClientManagement;

public class Frame_Salesman extends MyFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame_Salesman(){
		
		//the panel for client management
		Panel_ClientManagement panel_CM = new Panel_ClientManagement();
		this.add(panel_CM);
		
		
		//initialize the background for this frame
		MyBackground loginBackground = new MyBackground("image/back/backForNow.jpg");
		this.add(loginBackground);
	}
}
