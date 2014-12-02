package ui.differui.admin;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import businesslogic.userbl.UserController;
import ui.commonui.myui.EmptyTextField;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyFrame;
import ui.commonui.myui.MyPasswordField;
import ui.commonui.myui.MyTable;
import vo.UserVO;


public class AdminUI extends MyFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	EmptyTextField tf_companyName; 
	MyPasswordField pf_oldPassword, pf_newPassword, pf_againPassword;
	MyButton bt_companyName, bt_password, bt_add, bt_del, bt_modify;
	MyBackground back_bt1, back_bt2, back_bt3, back_bt4, back_bt5;
	MyTable table;
	
	public static JButton bt_show;
	
	UserController controller;
	
	int rowNum;
	
	public AdminUI(){
		
		//textFields
		tf_companyName = new EmptyTextField(188, 122, 190 ,25);
		this.add(tf_companyName);
		
		//password Fields
		pf_oldPassword = new MyPasswordField(188, 348, 190 ,25);
		this.add(pf_oldPassword);
		
		pf_newPassword = new MyPasswordField(188, 417, 190 ,25);
		this.add(pf_newPassword);
		
		pf_againPassword = new MyPasswordField(188, 486, 190 ,25);
		this.add(pf_againPassword);
		
		//buttons
		bt_companyName = new MyButton(365, 165, 60, 15);
		bt_companyName.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back_bt1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back_bt1.setVisible(false);
			}
			}); 
		this.add(bt_companyName);
		
		bt_password = new MyButton(365, 570, 60, 15);
		bt_password.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back_bt2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back_bt2.setVisible(false);
			}
			}); 
		this.add(bt_password);
		
		bt_add = new MyButton(890, 570, 75, 15);
		bt_add.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back_bt3.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back_bt3.setVisible(false);
			}
			}); 
		bt_add.addActionListener(this);
		this.add(bt_add);
		
		bt_del = new MyButton(1000, 570, 90, 15);
		bt_del.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back_bt4.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back_bt4.setVisible(false);
			}
			}); 
		this.add(bt_del);
		
		bt_modify = new MyButton(1120, 570, 90, 15);
		bt_modify.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back_bt5.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back_bt5.setVisible(false);
			}
			}); 
		this.add(bt_modify);
		
		//the table
		String[] headers = {"员工编号", "员工姓名", "员工职务", "联系方式", "用户名称", "用户密码"};
		table = new MyTable(headers);
		table.setBackground(new Color(40, 42, 66));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Arail", Font.PLAIN, 14));
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
	  	
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setForeground(Color.WHITE);
		head.setResizingAllowed(false);
		
		showAllUserInfoInTable();
		
		jsp.setBounds(475, 80, 745, 465);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		
		//Some backgrounds
		back_bt1 = new MyBackground("ui/image/admin/admin2.png");
		back_bt1.setVisible(false);
		this.add(back_bt1);
		
		back_bt2 = new MyBackground("ui/image/admin/admin3.png");
		back_bt2.setVisible(false);
		this.add(back_bt2);
		
		back_bt3 = new MyBackground("ui/image/admin/ad1.png");
		back_bt3.setVisible(false);
		this.add(back_bt3);
		
		back_bt4 = new MyBackground("ui/image/admin/ad2.png");
		back_bt4.setVisible(false);
		this.add(back_bt4);
		
		back_bt5 = new MyBackground("ui/image/admin/ad3.png");
		back_bt5.setVisible(false);
		this.add(back_bt5);
		
		//INIT THE BACKGROUND
		MyBackground loginBackground = new MyBackground("ui/image/admin/admin.png");
		this.add(loginBackground);
		
		bt_show = new JButton();
		bt_show.addActionListener(this);
		this.add(bt_show);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_show){
			showAllUserInfoInTable();
		}
		
		
		if(events.getSource() == bt_add){
			AdminAddingUI aau = new AdminAddingUI();
			aau.setVisible(true);
		}		
	}
	
	private void showAllUserInfoInTable(){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		if(rowNum != 0)
			for(int i = 0; i < rowNum; i++)
				tableModel.removeRow(0);
		
		rowNum = 0;
		
		controller = new UserController();
		
		rowNum = controller.show().size();
		
		for(int i = 0; i < rowNum; i++){
			UserVO uvo = controller.show().get(i);
			
			String[] str = {uvo.ID, uvo.name, getUserIden(uvo.iden.name().toString())
					, uvo.phone, uvo.username, uvo.password};
			tableModel.addRow(str);
		}		
	}
	
	private String getUserIden(String userID){
		switch(userID){
			case "GENERAL_MANAGER" : return "总经理";
			case "INVENTORY_MANAGER" : return "库存管理人员";
			case "FINANCE_MANAGER" : return "财务人员";
			case "PUR_SALE_MANAGER" : return "进货销售人员";
			default : return "销售经理";
		}
	}
}
