package ui.differui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyFrame;

public class AdminUI extends MyFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public AdminUI(){
		
		
		//INIT THE BACKGROUND
		MyBackground loginBackground = new MyBackground("ui/image/admin/adminBackground.png");
		this.add(loginBackground);
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}
}
