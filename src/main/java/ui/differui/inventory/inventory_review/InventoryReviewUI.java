package ui.differui.inventory.inventory_review;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import blservice.inventoryblservice.InventoryBLService;
import businesslogic.inventorybl.InventoryController;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import vo.InventoryViewVO;

public class InventoryReviewUI extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_check, button_list;
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	MyTable table, table2;
	
	public static JButton button_close;
	
	public InventoryReviewUI(){
		
		int y = 90;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("库存查看");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		//adding the table 
		String[] headers = {"出库数量","入库数量","出库金额","入库金额","出入数量合计","出入金额核算"};
		table = new MyTable(headers);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25 + y, 150, 1050, 40);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		String[] headers2 = {"销售数量","进货数量","销售金额","进货金额","进销数量合计","进销金额核算"};
		table2 = new MyTable(headers2);
		
		JScrollPane jsp2=new JScrollPane(table2);
		jsp2.setBounds(25 + y, 270, 1050, 40);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		String[] headers3 = {"货单种类","货单编号","货单日期","应收","应付","应收付差额"};
		MyTable table3 = new MyTable(headers3);
		
		JScrollPane jsp3=new JScrollPane(table3);
		jsp3.setBounds(25 + y, 390, 1050, 140);
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setVisible(true);
		this.add(jsp3);
	
		//some text
		JLabel word_1 = new JLabel("出入库信息:    ");
		word_1.setForeground(Color.WHITE);
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(27 + y, 115, 120, 25);
		this.add(word_1);
		
		JLabel word_2 = new JLabel("销售进货信息:    ");
		word_2.setForeground(Color.WHITE);
		word_2.setBackground(new Color(0, 0, 0, 0));
		word_2.setBounds(27 + y, 235, 120, 25);
		this.add(word_2);
		
		JLabel word_3 = new JLabel("库存相关货单信息:    ");
		word_3.setForeground(Color.WHITE);
		word_3.setBackground(new Color(0, 0, 0, 0));
		word_3.setBounds(27 + y, 355, 120, 25);
		this.add(word_3);
		
		JLabel word_4 = new JLabel("选择查看时间段:    ");
		word_4.setForeground(Color.WHITE);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(27 + y, 50, 120, 25);
		this.add(word_4);
		
		//text fields
		tf_year1 = new MyTextField(27 + 176 + y, 80, 50, 15);
		this.add(tf_year1);
		
		JLabel word_year1 = new JLabel("年");
		word_year1.setForeground(Color.WHITE);
		word_year1.setBackground(new Color(0, 0, 0, 0));
		word_year1.setBounds(87 + 176 + y, 80, 20, 15);
		this.add(word_year1);
		
		tf_month1 = new MyTextField(110 + 176 + y, 80, 30, 15);
		this.add(tf_month1);
		
		JLabel word_month1 = new JLabel("月");
		word_month1.setForeground(Color.WHITE);
		word_month1.setBackground(new Color(0, 0, 0, 0));
		word_month1.setBounds(150 + 176 + y, 80, 20, 15);
		this.add(word_month1);
		
		tf_day1 = new MyTextField(170 + 176 + y, 80, 30, 15);
		this.add(tf_day1);
		
		JLabel word_day1 = new JLabel("日     ~     ");
		word_day1.setForeground(Color.WHITE);
		word_day1.setBackground(new Color(0, 0, 0, 0));
		word_day1.setBounds(210 + 176 + y, 80, 70, 15);
		this.add(word_day1);
		
		int x = 235 + 176 + y;
		
		tf_year2 = new MyTextField(27 + x, 80, 50, 15);
		this.add(tf_year2);
		
		JLabel word_year2 = new JLabel("年");
		word_year2.setForeground(Color.WHITE);
		word_year2.setBackground(new Color(0, 0, 0, 0));
		word_year2.setBounds(87 + x, 80, 20, 15);
		this.add(word_year2);
		
		tf_month2 = new MyTextField(110 + x, 80, 30, 15);
		this.add(tf_month2);
		
		JLabel word_month2 = new JLabel("月");
		word_month2.setForeground(Color.WHITE);
		word_month2.setBackground(new Color(0, 0, 0, 0));
		word_month2.setBounds(150 + x, 80, 20, 15);
		this.add(word_month2);
		
		tf_day2 = new MyTextField(170 + x, 80, 30, 15);
		this.add(tf_day2);
		
		JLabel word_day2 = new JLabel("日");
		word_day2.setForeground(Color.WHITE);
		word_day2.setBackground(new Color(0, 0, 0, 0));
		word_day2.setBounds(210 + x, 80, 80, 15);
		this.add(word_day2);
		
		button_check = new MyJButton("查看");
		button_check.setBounds(250 + x, 78, 90, 20);
		button_check.addActionListener(this);
		this.add(button_check);
							
		button_list = new MyJButton("查看所选货单信息");
		button_list.setBounds(400 + 525 + y, 610 + 20 - 60, 150, 25);
		button_list.addActionListener(this);
		this.add(button_list);	
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
	
	}
	
public void actionPerformed(ActionEvent events) {
			
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_check){
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			DefaultTableModel tableModel2 = (DefaultTableModel) table2.getModel();
			
			if(tableModel.getRowCount() != 0)
				tableModel.removeRow(0);
			
			if(tableModel2.getRowCount() != 0)
				tableModel2.removeRow(0);
			
			
			if(tf_year1.getText().isEmpty() || tf_year2.getText().isEmpty() 
					|| tf_month1.getText().isEmpty() || tf_month2.getText().isEmpty()
					 || tf_day1.getText().isEmpty() || tf_day2.getText().isEmpty()){
				
				WarningFrame wf = new WarningFrame("请检查时间段填写是否正确！");
				wf.setVisible(true);
			}else{
				InventoryBLService controller = new InventoryController();
				String beginDate = yearAddZero(tf_year1.getText()) + addZero(tf_month1.getText()) + addZero(tf_day1.getText());
				String endDate = yearAddZero(tf_year2.getText()) + addZero(tf_month2.getText()) + addZero(tf_day2.getText());
				InventoryViewVO ivvo = controller.viewInventory(beginDate, endDate);
				
				String[] str = {String.valueOf(ivvo.saleNumber) + "元", String.valueOf(ivvo.purNumber) + "件"
						, String.valueOf(ivvo.saleMoney) + "元", String.valueOf(ivvo.purMoney) + "件"
						, String.valueOf(ivvo.saleNumber + ivvo.purNumber) + "元"
						, String.valueOf(ivvo.saleMoney - ivvo.purMoney) + "元"};
			//	String[] str2 = {"100", "200", "100","100", "0", "100"};
				
				tableModel.addRow(str);
				tableModel2.addRow(str);
				
				WarningFrame wf = new WarningFrame("已显示此时间段内的信息！");
				wf.setVisible(true);
			}
		}
		
		if(events.getSource() == button_list){
			WarningFrame wf = new WarningFrame("暂不支持此功能!");
			wf.setVisible(true);
		}
	}

	private String addZero(String str){
		if(Integer.parseInt(str) < 10){
			return "0" + str;
		}else{
			return str;
		}
	}
	private String yearAddZero(String str){
		if(Integer.parseInt(str) < 10){
			return "000" + str;
		}else{
			if(Integer.parseInt(str) < 100){
				return "00" + str;
			}else{
				if(Integer.parseInt(str) < 1000){
					return "0" + str;
				}else{
					return str;
				}
			}
		}
	}
}
