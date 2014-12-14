package ui.differui.manager.business_process;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTextField;

public class BusinessProcessUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyComboBox cbb_sort;
	MyJButton button_check;
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	
	public BusinessProcessUI(){
		
		int y = 65 + 200;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("经营历程表");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		String[] comboBoxStr = {"全部种类", "进货类单据", "销售类单据", "财务类单据", "库存类单据", "现金类单据"};
		cbb_sort = new MyComboBox(85 + 135, 56, 130, 25, comboBoxStr);
		this.add(cbb_sort);
		
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
			
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}
}
