package ui.differui.finace.account;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import dataenum.FindTypeAccount;
import message.ResultMessage;
import blservice.accountblservice.AccountBLService;
import businesslogic.accountbl.AccountController;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import vo.AccountVO;

public class AccountManagementUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_search, button_modify, button_del, button_add, button_finish;
	
	MyComboBox comboBox;
	
	MyTextField textField, textField_name, textField_money, textField_name2, textField_money2;
	
	MyTable table;
	
	static ArrayList<AccountVO> accountPool;
	
	public static JButton deleteAccount, modifyAccount;
	
	static String accountID = "";
	
	JLabel word_6;
	
	public AccountManagementUI(){
		
		accountPool = new ArrayList<AccountVO>();
		
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
		
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(80);
		firsetColumn.setMaxWidth(80);
		firsetColumn.setMinWidth(80);
		
		TableColumn secondColumn = table.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(250);
		secondColumn.setMaxWidth(250);
		secondColumn.setMinWidth(250);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
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
		
		word_6 = new JLabel("账户ID为 :    " + accountID);
		word_6.setForeground(Color.WHITE);
		word_6.setBackground(new Color(0, 0, 0, 0));
		word_6.setBounds(610, 370, 300, 25);
		this.add(word_6);
		
		JLabel word_7 = new JLabel("账户名称 :");
		word_7.setForeground(Color.WHITE);
		word_7.setBackground(new Color(0, 0, 0, 0));
		word_7.setBounds(610, 405, 60, 25);
		this.add(word_7);
		
		textField_name2 = new MyTextField(680, 405, 180, 25);
		textField_name2.setBackground(backColor);
		textField_name2.setForeground(foreColor);
		this.add(textField_name2);
		
		JLabel word_8 = new JLabel("账户余额 :");
		word_8.setForeground(Color.WHITE);
		word_8.setBackground(new Color(0, 0, 0, 0));
		word_8.setBounds(890, 405, 60, 25);
		this.add(word_8);
		
		textField_money2 = new MyTextField(960, 405, 180, 25);
		textField_money2.setBackground(backColor);
		textField_money2.setForeground(foreColor);
		this.add(textField_money2);
		
		button_finish = new MyJButton("修改账户");
		button_finish.setBounds(1105, 450, 100, 25);
		button_finish.addActionListener(this);
		button_finish.setBackground(backColor);
		button_finish.setForeground(foreColor);
		this.add(button_finish);
		
		showAll();
		
		deleteAccount = new JButton();
		deleteAccount.addActionListener(this);
		this.add(deleteAccount);
		
		modifyAccount =  new JButton();
		modifyAccount.addActionListener(this);
		this.add(modifyAccount);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_add){
			if(textField_name.getText().isEmpty() || textField_money.getText().isEmpty()){
				WarningFrame wf = new WarningFrame("请检查信息填写是否完整");
				wf.setVisible(true);
			}else{
				AccountBLService controller = new AccountController();
				ResultMessage rm = controller.add(new AccountVO(controller.getID(), 
						textField_name.getText(), Double.parseDouble(textField_money.getText())));
				
				if(rm.equals(ResultMessage.SUCCESS)){
					showAll();
					WarningFrame wf = new WarningFrame("账户添加成功！");
					wf.setVisible(true);
				}else{
					WarningFrame wf = new WarningFrame("账户添加失败！");
					wf.setVisible(true);
				}
			}
		}
		
		if(events.getSource() == button_del){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择要删除的账户！");
				wf.setVisible(true);
			}else{
				ExitFinishFrame wff = new ExitFinishFrame("delete a account");
				wff.setVisible(true);
			}
		}
		
		if(events.getSource() == deleteAccount){
			deleteAccount();
		}
		
		if(events.getSource() == modifyAccount){
			modifyAccount();
		}
		
		if(events.getSource() == button_modify){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请先选择要修改的账户！");
				wf.setVisible(true);
			}else{
				accountID = accountPool.get(table.getSelectedRow()).ID;
				word_6.setText("账户ID为 :     " + accountID);
				textField_name2.setText(accountPool.get(table.getSelectedRow()).name);
				textField_money2.setText(String.valueOf(accountPool.get(table.getSelectedRow()).money));
			}
		}
		
		if(events.getSource() == button_finish){
			if(accountID.equals("")){
				WarningFrame wf = new WarningFrame("请先选择要修改的账户！");
				wf.setVisible(true);
			}else{
				if(textField_name2.getText().isEmpty() || textField_money2.getText().isEmpty()){
					WarningFrame wf = new WarningFrame("请检查信息填写是否完整");
					wf.setVisible(true);
				}else{
					ExitFinishFrame wff = new ExitFinishFrame("modify a account");
					wff.setVisible(true);
				}
			}
		}
		
		if(events.getSource() == button_search){
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
			
			accountPool.clear();
			accountID = "";
			
			//"模糊查找", "账户编号(ID)", "账户名称", "账户余额"
			AccountBLService controller = new AccountController();
			ArrayList<AccountVO> accountVO;
			
			switch(comboBox.getSelectedIndex()){
				case 0 : accountVO = controller.find(textField.getText(), null);break;
				case 1 : accountVO = controller.find(textField.getText(), FindTypeAccount.ID);break;
				case 2 : accountVO = controller.find(textField.getText(), FindTypeAccount.NAME);break;
				default : accountVO = controller.find(textField.getText(), FindTypeAccount.MONEY);break;
			}
			
			for(int i = 0; i < accountVO.size(); i++){
				String[] rowData = {accountVO.get(i).ID, 
						accountVO.get(i).name, String.valueOf(accountVO.get(i).money)+"元"};
				tableModel.addRow(rowData);
				accountPool.add(accountVO.get(i));
			}
			
			WarningFrame wf = new WarningFrame("共有 " + table.getRowCount() + " 个账户符合条件！");
			wf.setVisible(true);
		}
	}
	
	public void showAll(){
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		accountPool.clear();
		accountID = "";
		
		AccountBLService controller = new AccountController();
		ArrayList<AccountVO> accountVO = controller.show();
		
		for(int i = 0; i < accountVO.size(); i++){
			String[] rowData = {accountVO.get(i).ID, 
					accountVO.get(i).name, String.valueOf(accountVO.get(i).money)+"元"};
			tableModel.addRow(rowData);
			accountPool.add(accountVO.get(i));
		}
	}
	
	public void deleteAccount(){
		AccountBLService controller = new AccountController();
		ResultMessage rm = controller.delete(accountPool.get(table.getSelectedRow()).ID);
		
		if(rm.equals(ResultMessage.SUCCESS)){
			showAll();
			WarningFrame wf = new WarningFrame("账户删除成功！");
			wf.setVisible(true);
		}else{
			WarningFrame wf = new WarningFrame("账户删除失败！");
			wf.setVisible(true);
		}
	}
	
	public void modifyAccount(){
		AccountBLService controller = new AccountController();
		ResultMessage rm = controller.update(new AccountVO(accountID, 
			textField_name2.getText(), Double.parseDouble(textField_money2.getText())));
		
		if(rm.equals(ResultMessage.SUCCESS)){
			showAll();
			WarningFrame wf = new WarningFrame("账户修改成功！");
			wf.setVisible(true);
		}else{
			WarningFrame wf = new WarningFrame("账户修改失败！");
			wf.setVisible(true);
		}
	}
}
