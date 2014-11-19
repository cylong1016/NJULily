package ui.differui.salesman.frame;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;
import ui.differui.salesman.client_management.index.ClientManagementUI;

public class Frame_Salesman extends MyFrame{

	private static final long serialVersionUID = 1L;
	
	public Frame_Salesman(){
		
		//the panel for client management(for now)
		ClientManagementUI panel_CM = new ClientManagementUI();
		this.add(panel_CM);
		
		MyBackground loginBackground = new MyBackground("ui/image/back/backForNow.jpg");
		this.add(loginBackground);
	}
}
