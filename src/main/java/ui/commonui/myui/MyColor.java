package ui.commonui.myui;

import java.awt.Color;

public class MyColor {
	
	public static Color color;

	public MyColor(){
		color = new Color(46, 52, 101);
	}
	
	public static void setColor(int i){
		switch(i){
		case 1 : color = new Color(47, 76, 130);
		case 2 : color = new Color(113, 55, 73);
		case 3 : color = new Color(29, 72, 33);
		case 4 : color = new Color(26, 119, 119);
		}
		
	}
}
