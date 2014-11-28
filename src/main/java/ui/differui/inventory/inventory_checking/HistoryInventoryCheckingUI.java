package ui.differui.inventory.inventory_checking;

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

public class HistoryInventoryCheckingUI extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_finish, button_check, button_checkItem;
	
	public static JButton button_close;
	
	public HistoryInventoryCheckingUI(){
		
		//the information bar
		JLabel infoBar = new JLabel("                     历史库存盘点单查看");
		infoBar.setBounds(0, 0, 1100, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(new Color(1, 1, 1, 0.55f));
		infoBar.setBackground(new Color(1, 1, 1, 0.05f));
		this.add(infoBar);
		
		//adding the table 
		String[] headers = {"行号","商品编号","商品名称"
				,"商品型号","库存均价","批次","批号","出厂日期","库存数量","实际盘点数量"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(25, 50 + 20, 1050, 550);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//combo box
		String[] comboBoxStr = {"-------请选择盘点单单号------", "PAD0001"
				, "PAD0002", "PAD0003", "PAD0004", "PAD0005", "PAD0005"};
		MyComboBox comboBox = new MyComboBox(25, 15 + 20, 200, 25,comboBoxStr);
		comboBox.setEditable(true);
		this.add(comboBox);
		
		//button to check the information of the selected item
		button_checkItem = new MyJButton("查看选中商品详细信息");
		button_checkItem.setBounds(200 + 435, 610 + 20, 190, 25);
		button_checkItem.addActionListener(this);
		this.add(button_checkItem);
		
		//button to finish checking
		button_finish = new MyJButton("导出至EXCEL");
		button_finish.setBounds(390 + 450, 610 + 20, 110, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);	
		
		//button to check
		button_check = new MyJButton("查看");
		button_check.setBounds(240, 15 + 20, 110, 25);
		button_check.addActionListener(this);
		this.add(button_check);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(515 + 450, 610 + 20, 110, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
	
	}
	
public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame efp = new ExitFunctionFrame("HistoryInventoryCheckingUI");
			efp.setVisible(true);
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
	}
}
	
