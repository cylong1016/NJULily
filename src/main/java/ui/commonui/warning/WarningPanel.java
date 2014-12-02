package ui.commonui.warning;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;

public class WarningPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_yes;
	
	public WarningPanel(String name){
		
		int width = 400;
		int height = 130;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		//information bar
		JLabel infoBar = new JLabel("提示",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		JLabel warn = new JLabel(name,JLabel.CENTER);
		warn.setForeground(Color.RED);
		warn.setBackground(new Color(0, 0, 0, 0));
		warn.setBounds(100, 40, 200, 25);
		this.add(warn);
		
		//button to choose to close the program
		button_yes = new MyJButton("返回");
		button_yes.setBounds(140, 80, 120, 25);
		button_yes.setForeground(foreColor);
		button_yes.setBackground(backColor);
		button_yes.addActionListener(this);
		this.add(button_yes);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == button_yes){	
			WarningFrame.button_close.doClick();
		}
	}
	
}
