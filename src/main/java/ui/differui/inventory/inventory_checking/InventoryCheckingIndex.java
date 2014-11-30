package ui.differui.inventory.inventory_checking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ui.commonui.myui.MyPanel;
import ui.differui.inventory.frame.Frame_Inventory;

public class InventoryCheckingIndex extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	static JButton bt_vanish;
	
	JButton bt_IC, bt_HIC, bt_PIC;
	
	public InventoryCheckingIndex(){
		
		JLabel infoBar = new JLabel("                     选择库存盘点功能");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);
		
		bt_IC = new JButton("创建库存盘点单");
		bt_IC.setBounds(160, 220, 180, 180);
		bt_IC.addActionListener(this);
		bt_IC.setVisible(true);
		this.add(bt_IC);
		
		bt_HIC = new JButton("查看历史库存盘点单");
		bt_HIC.setBounds(450, 220, 180, 180);
		bt_HIC.addActionListener(this);
		bt_HIC.setVisible(true);
		this.add(bt_HIC);
		
		bt_PIC = new JButton("进行盘点差额申报");
		bt_PIC.setBounds(740, 220, 180, 180);
		bt_PIC.addActionListener(this);
		bt_PIC.setVisible(true);
		this.add(bt_PIC);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == bt_IC){
			Frame_Inventory.bt_IC.doClick();
			this.setVisible(false);
		}
	}

}
