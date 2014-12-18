package main;

import ui.commonui.login.Frame_Login;

/**
 * @author NJULily
 * @author 景诗为
 * @author 刘磊
 * @author 曾婧
 * @author 陈云龙
 * @version Oct 26, 2014 9:04:33 PM
 */
public class NJULilyMain {

	public static void main(String[] args) {

		System.setProperty("awt.useSystemAAFontSettings", "on");
		System.setProperty("swing.aatext", "true");
		//UI test
		Frame_Login fl = new Frame_Login();
		fl.setVisible(true);
		
//		Frame_Inventory fi = new Frame_Inventory();
//		fi .setVisible(true);
		
	}
}
