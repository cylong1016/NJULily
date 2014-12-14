package ui.differui.inventory.inventory_checking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;

public class InventoryCheckingUI extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_finish, button_check;
	
	public static JButton button_close;
	
	public InventoryCheckingUI(){
		
		String no = "ICL0001";
		String date = "2014/11/28";
		
//		Color foreColor = new Color(158, 213, 220);
//		Color backColor = new Color(46, 52, 101);
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);

		JLabel infoBar = new JLabel("制定赠送单 - 选择商品");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		//adding the table 
		String[] headers = {"行号","商品编号","商品名称"
				,"商品型号","库存均价","批次","批号","出厂日期","库存数量","实际盘点数量"};
		MyTable table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(25 + 55, 50 + 20 + 14, 1120, 470);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//some text
		JLabel word_no = new JLabel("盘点单号:    " + no);
		word_no.setForeground(Color.WHITE);
		word_no.setBackground(new Color(0, 0, 0, 0));
		word_no.setBounds(27 + 55, 35 + 15, 120, 25);
		this.add(word_no);
		
		JLabel word_date = new JLabel("上次盘点日期:    " + date);
		word_date.setForeground(Color.WHITE);
		word_date.setBackground(new Color(0, 0, 0, 0));
		word_date.setBounds(165 + 55, 35 + 15, 200, 25);
		this.add(word_date);
		
		//button to check the information of the selected item
		button_check = new MyJButton("查看选中商品详细信息");
		button_check.setBounds(200 + 435 + 110 + 125, 610 + 20 - 55 - 5, 190, 25);
		button_check.addActionListener(this);
		this.add(button_check);
			
		//button to finish checking
		button_finish = new MyJButton("导出至EXCEL");
		button_finish.setBounds(390 + 450 + 110 + 125, 610 + 20 - 55 - 5, 110, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);	
		
		
		//add a button for returning to the last UI
		button_return = new MyJButton("刷新");
		button_return.setBounds(515 + 450 + 110, 610 + 20 - 55 - 525, 110, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
	
	}
	
public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame efp = new ExitFunctionFrame("InventoryCheckingUI");
			efp.setVisible(true);
			
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
	}
	
}
