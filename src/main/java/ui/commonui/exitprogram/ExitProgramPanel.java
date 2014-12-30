package ui.commonui.exitprogram;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;

public class ExitProgramPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes, button_no;
	
	public ExitProgramPanel(){
		
		int width = 400;
		int height = 130;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		//information bar
		JLabel infoBar = new JLabel("确认是否退出系统",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		//button to choose to close the program
		button_yes = new MyJButton("是");
		button_yes.setBounds(40, 60, 120, 25);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_yes);
		
		//button not to choose to close the program
		button_no = new MyJButton("否");
		button_no.setBounds(240, 60, 120, 25);
		button_no.setForeground(foreColor);
		button_no.setBackground(backColor);
		button_no.addActionListener(this);
		this.add(button_no);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == button_yes){
			System.exit(0);
		}
		
		if(events.getSource() == button_no){
			this.setVisible(false);
			ExitProgramFrame.button_close.doClick();
		}
	}
}
