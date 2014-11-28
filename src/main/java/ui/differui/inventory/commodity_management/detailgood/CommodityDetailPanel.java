package ui.differui.inventory.commodity_management.detailgood;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ui.commonui.exitfunction.ExitFunctionFrame;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;

import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;

public class CommodityDetailPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyTextField textField_name, textField_sort, textField_price;
	MyJButton button_return,button_modify, button_check;
	
	public CommodityDetailPanel(){
			
		int x1 = 80, y1 = 55, x2 = 390, y2 = -66;
		
		//information bar
		JLabel infoBar = new JLabel("修改或查看所选商品详细信息",JLabel.CENTER);
		infoBar.setBounds(0, 0, 800, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(Color.black);
		infoBar.setBackground(new Color(0, 1, 1, 0.5f));
		this.add(infoBar);
		
		//ui for tips
		JLabel word_tip1 = new JLabel("商品信息:",JLabel.CENTER);
		word_tip1.setForeground(Color.RED);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(30, 45, 65, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("价格信息:",JLabel.CENTER);
		word_tip2.setForeground(Color.RED);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(30, 215, 65, 25);
		this.add(word_tip2);
		
		JLabel word_tip3 = new JLabel("商品历史货单查看:",JLabel.CENTER);
		word_tip3.setForeground(Color.RED);
		word_tip3.setBackground(new Color(0, 0, 0, 0));
		word_tip3.setBounds(25, 315, 120, 25);
		this.add(word_tip3);
		
		//ui for id
		JLabel word_id = new JLabel("商品编号:",JLabel.CENTER);
		word_id.setForeground(Color.WHITE);
		word_id.setBackground(new Color(0, 0, 0, 0));
		word_id.setBounds(30 + x1, 10 + y1, 65, 25);
		this.add(word_id);
		
		MyTextField textField_id = new MyTextField(110 + x1, 10 + y1, 200, 25);
		textField_id.setEditable(false);
		this.add(textField_id);
		
		
		//ui for name
		JLabel word_name = new JLabel("商品名称:",JLabel.CENTER);
		word_name.setForeground(Color.WHITE);
		word_name.setBackground(new Color(0, 0, 0, 0));
		word_name.setBounds(36 + x2, 130 + y2, 60, 25);
		this.add(word_name);
		
		MyTextField textField_salesman = new MyTextField(110 + x2, 130 + y2, 200, 25);
		this.add(textField_salesman);
		
		//ui for model
		JLabel word_model = new JLabel(" 商品型号:",JLabel.CENTER);
		word_model.setForeground(Color.WHITE);
		word_model.setBackground(new Color(0, 0, 0, 0));
		word_model.setBounds(30 + x1, 50 + y1, 65, 25);
		this.add(word_model);
		
		textField_name = new MyTextField(110 + x1, 50 + y1, 200, 25);
		this.add(textField_name);
		
		//ui for num
		JLabel word_num = new JLabel(" 商品数量:",JLabel.CENTER);
		word_num.setForeground(Color.WHITE);
		word_num.setBackground(new Color(0, 0, 0, 0));
		word_num.setBounds(30 + x1, 90 + y1, 65, 25);
		this.add(word_num);
		
		MyTextField textField_num = new MyTextField(110 + x1, 90 + y1, 200, 25);
		textField_num.setEditable(false);
		this.add(textField_num);
	
		//ui for sort
		JLabel word_sort = new JLabel("商品分类:",JLabel.CENTER);
		word_sort.setForeground(Color.WHITE);
		word_sort.setBackground(new Color(0, 0, 0, 0));
		word_sort.setBounds(36 + x2, 170 + y2, 60, 25);
		this.add(word_sort);
		
		textField_sort = new MyTextField(110 + x2, 170 + y2, 200, 25);
		this.add(textField_sort);
		
		//ui for price
		JLabel word_price = new JLabel("商品单价:",JLabel.CENTER);
		word_price.setForeground(Color.WHITE);
		word_price.setBackground(new Color(0, 0, 0, 0));
		word_price.setBounds(36 + x2, 210 + y2, 60, 25);
		this.add(word_price);
		
		JLabel word_yuan = new JLabel("元",JLabel.CENTER);
		word_yuan.setForeground(Color.WHITE);
		word_yuan.setBackground(new Color(0, 0, 0, 0));
		word_yuan.setBounds(270 + x2, 210 + y2, 60, 25);
		this.add(word_yuan);
		
		textField_price = new MyTextField(110 + x2, 210 + y2, 175, 25);
		this.add(textField_price);
		
		//table for receivable and payable information
		String[] headers = {"进价","零售价","最近进价","最近零售价"};
		MyTable table_rap = new MyTable(headers);
		
		String[] str = {"100", "200", "100", "220"};
		DefaultTableModel tableModel_rap = (DefaultTableModel) table_rap.getModel();
		tableModel_rap.addRow(str);
		
		JScrollPane jsp1=new JScrollPane(table_rap);
		jsp1.setBounds(100, 250, 600, 40);
		jsp1.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp1.setOpaque(false);
		jsp1.setVisible(true);
		this.add(jsp1);
		
		//table for history checking
		String[] headers2 = {"货单编号","货单日期","商品进出个数","商品进出单价","商品进出总价"};
		MyTable table_hc = new MyTable(headers2);
		
		JScrollPane jsp2=new JScrollPane(table_hc);
		jsp2.setBounds(100, 350, 600, 120);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		//buttons
		button_return = new MyJButton("返回");
		button_return.setBounds(600 + 30, 575 + 35 - 90, 130, 20);
		button_return.addActionListener(this);
		this.add(button_return);
		
		button_modify = new MyJButton("确认修改");
		button_modify.setBounds(630, 275 - 90, 130, 20);
		button_modify.addActionListener(this);
		this.add(button_modify);
		
		button_check = new MyJButton("查看所选货单");
		button_check.setBounds(630, 580 - 90, 130, 20);
		button_check.addActionListener(this);
		this.add(button_check);			
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_modify){
			System.out.println("modifying the infornation of the client ...");
		}
		
		if(events.getSource() == button_check){
			System.out.println("now checking ...");
		}
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("CommodityDetailUI");
			epf.setVisible(true);
		}
	}

}
