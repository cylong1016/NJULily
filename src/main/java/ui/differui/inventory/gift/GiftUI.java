package ui.differui.inventory.gift;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;

public class GiftUI extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_add, button_check, button_finish, button_del;
	
	public static JButton button_close;
	
	public GiftUI(){
		
		//information bar
		JLabel infoBar = new JLabel("                     库存赠送单");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);
		
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "商品编号(ID)",  "商品分类", "商品名称", "客户"};
		MyComboBox comboBox = new MyComboBox(25, 15 + 20, 200, 25,comboBoxStr);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(235, 15 + 20, 200, 25);
		textField.setText("在此输入搜索关键字");
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(445, 15 + 20, 130, 25);
		button_search.addActionListener(this);
		this.add(button_search);
		
		//add a button for showing all the goods to the table
		MyJButton button_showAll = new MyJButton("显示全部商品");
		button_showAll.setBounds(944, 15 + 20, 130, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);	
		
		//add a table for showing the information of the goods(the table is contained in a scroll pane)
		String[] headers = {"商品编号","商品名称","商品型号","库存均价","商品数量"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp2=new JScrollPane(table);
		jsp2.setBounds(25, 70, 1050, 270);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		String[] headers2 = {"商品编号","商品名称","商品型号","商品数量","赠送数量"};
		MyTable table2 = new MyTable(headers2);
		
		JScrollPane jsp=new JScrollPane(table2);
		jsp.setBounds(25, 390, 1050, 220);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//buttons
		button_add = new MyJButton("将选中商品添加至赠送区域");
		button_add.setBounds(525 + 360, 355, 190, 25);
		button_add.addActionListener(this);
		this.add(button_add);
		
		button_check = new MyJButton("查看选中商品详细信息");
		button_check.setBounds(525 + 160, 355, 190, 25);
		button_check.addActionListener(this);
		this.add(button_check);
		
		button_finish = new MyJButton("确认赠送");
		button_finish.setBounds(530 + 325, 610 + 20, 110, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);
		
		button_del = new MyJButton("取消赠送选中商品");
		button_del.setBounds(530 + 175, 610 + 20, 140, 25);
		button_del.addActionListener(this);
		this.add(button_del);
		
		//return button
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450, 610 + 20, 100, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
		
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame efp = new ExitFunctionFrame("GiftUI");
			efp.setVisible(true);
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
	}

}
