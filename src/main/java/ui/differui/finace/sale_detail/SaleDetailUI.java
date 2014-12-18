package ui.differui.finace.sale_detail;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import blservice.recordblservice.RecordBLService;
import blservice.recordblservice.SaleDetailInputInfo;
import businesslogic.recordbl.RecordController;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;

public class SaleDetailUI extends JLabel implements ActionListener{
	
	MyJButton button_check, button_out;
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	MyComboBox comboBox;
	MyTextField textField;
	MyTable table;
	
	private static final long serialVersionUID = 1L;
	
	public SaleDetailUI(){
		
		int y = 65 + 200 + 150;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("销售明细表");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		String[] headers = {"操作时间", "商品编号", "商品名称", "商品型号", "商品数量", "商品单价", "商品总额"};
		table = new MyTable(headers);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(80, 90, 1085, 475);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		String[] comboBoxStr2 = {"请选择查看方式", "商品名称", "客户名称", "业务员名称", "仓库名称"};
		comboBox = new MyComboBox(83, 50, 180, 25,comboBoxStr2);
		comboBox.setForeground(foreColor);
		comboBox.setBackground(backColor);
		this.add(comboBox);
		
		textField = new MyTextField(285, 50, 190, 25);
		textField.setText("在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		JLabel word_4 = new JLabel("选择查看时间段:    ");
		word_4.setForeground(Color.WHITE);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(80 + y, 50, 120, 25);
		this.add(word_4);
		
		//text fields
		tf_year1 = new MyTextField(27 + 176 + y, 55, 50, 15);
		this.add(tf_year1);
		
		JLabel word_year1 = new JLabel("年");
		word_year1.setForeground(Color.WHITE);
		word_year1.setBackground(new Color(0, 0, 0, 0));
		word_year1.setBounds(87 + 176 + y, 55, 20, 15);
		this.add(word_year1);
		
		tf_month1 = new MyTextField(110 + 176 + y, 55, 30, 15);
		this.add(tf_month1);
		
		JLabel word_month1 = new JLabel("月");
		word_month1.setForeground(Color.WHITE);
		word_month1.setBackground(new Color(0, 0, 0, 0));
		word_month1.setBounds(150 + 176 + y, 55, 20, 15);
		this.add(word_month1);
		
		tf_day1 = new MyTextField(170 + 176 + y, 55, 30, 15);
		this.add(tf_day1);
		
		JLabel word_day1 = new JLabel("日     ~     ");
		word_day1.setForeground(Color.WHITE);
		word_day1.setBackground(new Color(0, 0, 0, 0));
		word_day1.setBounds(210 + 176 + y, 55, 70, 15);
		this.add(word_day1);
		
		int x = 235 + 176 + y;
		
		tf_year2 = new MyTextField(27 + x, 55, 50, 15);
		this.add(tf_year2);
		
		JLabel word_year2 = new JLabel("年");
		word_year2.setForeground(Color.WHITE);
		word_year2.setBackground(new Color(0, 0, 0, 0));
		word_year2.setBounds(87 + x, 55, 20, 15);
		this.add(word_year2);
		
		tf_month2 = new MyTextField(110 + x, 55, 30, 15);
		this.add(tf_month2);
		
		JLabel word_month2 = new JLabel("月");
		word_month2.setForeground(Color.WHITE);
		word_month2.setBackground(new Color(0, 0, 0, 0));
		word_month2.setBounds(150 + x, 55, 20, 15);
		this.add(word_month2);
		
		tf_day2 = new MyTextField(170 + x, 55, 30, 15);
		this.add(tf_day2);
		
		JLabel word_day2 = new JLabel("日");
		word_day2.setForeground(Color.WHITE);
		word_day2.setBackground(new Color(0, 0, 0, 0));
		word_day2.setBounds(210 + x, 55, 80, 15);
		this.add(word_day2);
		
		button_check = new MyJButton("查看");
		button_check.setBounds(250 + x, 50, 90, 25);
		button_check.addActionListener(this);
		this.add(button_check);
		
		button_out = new MyJButton("导出至EXCEL");
		button_out.setBounds(220 + x, 575, 120, 25);
		button_out.addActionListener(this);
		this.add(button_out);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_check){
			
			
			RecordBLService controller = new RecordController();
			
			//String beginDate, String endDate, String commodityName, String clientName, String salesman, Storage storage
			System.out.println(controller.saleDetail(new SaleDetailInputInfo("20141201","20141220",null,null,null,null)));
		}
	}
}
