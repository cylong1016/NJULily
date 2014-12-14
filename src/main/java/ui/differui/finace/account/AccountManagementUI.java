package ui.differui.finace.account;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;

public class AccountManagementUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_search, button_modify, button_del, button_add, button_finish;
	
	MyComboBox comboBox;
	
	MyTextField textField, textField_name, textField_money, textField_name2, textField_money2;
	
	MyTable table;
	
	public AccountManagementUI(){
		String accountID = "";
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		JLabel infoBar = new JLabel("账户管理");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		////////////////////////////ACCOUNT INFORMATION//////////////////////////
		
		JLabel word_1 = new JLabel("账户信息 :    ");
		word_1.setForeground(Color.WHITE);
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(27 + 55, 50, 120, 25);
		this.add(word_1);
		
		String[] comboBoxStr = {"模糊查找", "账户编号(ID)", "账户名称", "账户余额"};
		comboBox = new MyComboBox(80, 70 - 10 + 25, 120, 25,comboBoxStr);
		comboBox.setBackground(backColor);
		comboBox.setForeground(foreColor);
		this.add(comboBox);
		
		textField = new MyTextField(220, 70 - 10 + 25, 180, 25);
		textField.setText("  在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		button_search = new MyJButton("搜索");
		button_search.setBounds(420, 70 - 10 + 25, 80, 25);
		button_search.addActionListener(this);
		button_search.setBackground(backColor);
		button_search.setForeground(foreColor);
		this.add(button_search);	
		
		String[] headers = {"账户编号", "账户名称", "账户余额"};
		table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(backColor);
		head.setForeground(foreColor);
		jsp.setBounds(80, 130, 420, 430);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		button_modify = new MyJButton("修改所选账户信息");
		button_modify.setBounds(300, 570, 200, 25);
		button_modify.addActionListener(this);
		button_modify.setBackground(backColor);
		button_modify.setForeground(foreColor);
		this.add(button_modify);
		
		button_del = new MyJButton("删除所选账户");
		button_del.setBounds(80, 570, 200, 25);
		button_del.addActionListener(this);
		button_del.setBackground(backColor);
		button_del.setForeground(foreColor);
		this.add(button_del);
		
		////////////////////////////ADDING ACCOUNT//////////////////////////
		
		JLabel word_2 = new JLabel("添加账户 :    ");
		word_2.setForeground(Color.WHITE);
		word_2.setBackground(new Color(0, 0, 0, 0));
		word_2.setBounds(550, 125, 120, 25);
		this.add(word_2);
		
		JLabel word_3 = new JLabel("账户名称 :");
		word_3.setForeground(Color.WHITE);
		word_3.setBackground(new Color(0, 0, 0, 0));
		word_3.setBounds(610, 160, 60, 25);
		this.add(word_3);
		
		textField_name = new MyTextField(680, 160, 180, 25);
		textField_name.setBackground(backColor);
		textField_name.setForeground(foreColor);
		this.add(textField_name);
		
		JLabel word_4 = new JLabel("账户余额 :");
		word_4.setForeground(Color.WHITE);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(890, 160, 60, 25);
		this.add(word_4);
		
		textField_money = new MyTextField(960, 160, 180, 25);
		textField_money.setBackground(backColor);
		textField_money.setForeground(foreColor);
		this.add(textField_money);
		
		button_add = new MyJButton("添加账户");
		button_add.setBounds(1105, 205, 100, 25);
		button_add.addActionListener(this);
		button_add.setBackground(backColor);
		button_add.setForeground(foreColor);
		this.add(button_add);
		
		////////////////////////////MODIFYING ACCOUNT//////////////////////////
		JLabel word_5 = new JLabel("修改账户 :    ");
		word_5.setForeground(Color.WHITE);
		word_5.setBackground(new Color(0, 0, 0, 0));
		word_5.setBounds(550, 335, 120, 25);
		this.add(word_5);
		
		JLabel word_6 = new JLabel("账户ID为 :" + accountID);
		word_6.setForeground(Color.WHITE);
		word_6.setBackground(new Color(0, 0, 0, 0));
		word_6.setBounds(610, 370, 60, 25);
		this.add(word_6);
		
		JLabel word_7 = new JLabel("账户名称 :");
		word_7.setForeground(Color.WHITE);
		word_7.setBackground(new Color(0, 0, 0, 0));
		word_7.setBounds(610, 405, 60, 25);
		this.add(word_7);
		
		textField_name = new MyTextField(680, 405, 180, 25);
		textField_name.setBackground(backColor);
		textField_name.setForeground(foreColor);
		this.add(textField_name);
		
		JLabel word_8 = new JLabel("账户余额 :");
		word_8.setForeground(Color.WHITE);
		word_8.setBackground(new Color(0, 0, 0, 0));
		word_8.setBounds(890, 405, 60, 25);
		this.add(word_8);
		
		textField_money = new MyTextField(960, 405, 180, 25);
		textField_money.setBackground(backColor);
		textField_money.setForeground(foreColor);
		this.add(textField_money);
		
		button_finish = new MyJButton("修改账户");
		button_finish.setBounds(1105, 450, 100, 25);
		button_finish.addActionListener(this);
		button_finish.setBackground(backColor);
		button_finish.setForeground(foreColor);
		this.add(button_finish);
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}
}
