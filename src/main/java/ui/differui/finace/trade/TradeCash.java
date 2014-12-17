package ui.differui.finace.trade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import vo.AccountVO;
import vo.client.ClientVO;
import blservice.accountblservice.AccountBLService;
import blservice.clientblservice.ClientBLService;
import businesslogic.accountbl.AccountController;
import businesslogic.clientbl.ClientController;
import dataenum.FindTypeClient;

public class TradeCash extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyComboBox comboBox_sort;
	
	MyComboBox comboBox;
	
	MyTextField textField, textField_money;
	
	MyTable table, table2, table3;
	
	MyJButton button_search, button_account, button_showAll
		, button_client, button_add, button_del, button_finish;
	
	JLabel word_1, word_2;
	
	JTextField tf;
		
	static String accountID = "", accountName = "", clientID = "", clientName = "";
	
	public TradeCash(){
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("制定现金费用单");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		////////////////////ACCOUNT////////////////////
			
		String[] headers = {"账户编号", "账户名称"};
		table = new MyTable(headers);
		
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(80);
		firsetColumn.setMaxWidth(80);
		firsetColumn.setMinWidth(80);
		
		TableColumn secondColumn = table.getColumnModel().getColumn(1);
		secondColumn.setPreferredWidth(180);
		secondColumn.setMaxWidth(180);
		secondColumn.setMinWidth(180);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(backColor);
		head.setForeground(foreColor);
		jsp.setBounds(80, 60, 260, 500);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		showAllAccount();
		
		button_account = new MyJButton("选择此账户");
		button_account.setBounds(80, 570, 260, 25);
		button_account.addActionListener(this);
		button_account.setBackground(backColor);
		button_account.setForeground(foreColor);
		this.add(button_account);
		
		///////////////////CLIENT///////////////////////
		
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"};
		comboBox = new MyComboBox(75 + 290, 70 - 10, 200, 25,comboBoxStr);
		comboBox.setBackground(backColor);
		comboBox.setForeground(foreColor);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		textField = new MyTextField(300 + 290, 70 - 10, 200, 25);
		textField.setText("  在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		//add a button for starting the searching process
		button_search = new MyJButton("搜索");
		button_search.setBounds(525 + 290, 70 - 10, 130, 25);
		button_search.addActionListener(this);
		button_search.setBackground(backColor);
		button_search.setForeground(foreColor);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		button_showAll = new MyJButton("显示全部客户");
		button_showAll.setBounds(1070, 70 - 10, 130, 25);
		button_showAll.addActionListener(this);
		button_showAll.setBackground(backColor);
		button_showAll.setForeground(foreColor);
		this.add(button_showAll);	
		
		String[] headers2 = {"客户编号","客户分类","客户星级"
				,"客户名称","默认业务员","应收付差额","应收","应付","应付额度"};
		table2 = new MyTable(headers2);
		
		table2.setDefaultRenderer(Object.class, tcr);
		
		JScrollPane jsp2 = new JScrollPane(table2);
		JTableHeader head2 = table2.getTableHeader();
		head2.setBackground(backColor);
		head2.setForeground(foreColor);
		jsp2.setBounds(75 + 290, 120 - 10, 1125 - 290, 200);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setBorder(BorderFactory.createEmptyBorder());
		jsp2.setVisible(true);
		this.add(jsp2);
		
		button_client = new MyJButton("选择此客户");
		button_client.setBounds(940, 320, 260, 25);
		button_client.addActionListener(this);
		button_client.setBackground(backColor);
		button_client.setForeground(foreColor);
		this.add(button_client);
		
		////////////////CASH/////////////////	
		word_1 = new JLabel("现金单账户为 :      " + accountName);
		word_1.setForeground(Color.WHITE);
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(365, 360, 300, 25);
		this.add(word_1);
		
		word_2 = new JLabel("现金单客户为 :      " + clientName);
		word_2.setForeground(Color.WHITE);
		word_2.setBackground(new Color(0, 0, 0, 0));
		word_2.setBounds(665, 360, 300, 25);
		this.add(word_2);
		
		String[] headers3 = {"条目序号", "条目名称", "条目金额"};
		table3 = new MyTable(headers3);
		
		table3.setDefaultRenderer(Object.class, tcr);
		
		TableColumn firsetColumn3 = table3.getColumnModel().getColumn(0);
		firsetColumn3.setPreferredWidth(80);
		firsetColumn3.setMaxWidth(80);
		firsetColumn3.setMinWidth(80);
		
		TableColumn secondColumn3 = table3.getColumnModel().getColumn(1);
		secondColumn3.setPreferredWidth(600);
		secondColumn3.setMaxWidth(600);
		secondColumn3.setMinWidth(600);
		
		JScrollPane jsp3 = new JScrollPane(table3);
		JTableHeader head3 = table3.getTableHeader();
		head3.setBackground(backColor);
		head3.setForeground(foreColor);
		jsp3.setBounds(75 + 290, 395, 1125 - 290, 120);
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setBorder(BorderFactory.createEmptyBorder());
		jsp3.setVisible(true);
		this.add(jsp3);
		
		button_add = new MyJButton("增加条目");
		button_add.setBounds(940, 530, 120, 25);
		button_add.addActionListener(this);
		button_add.setBackground(backColor);
		button_add.setForeground(foreColor);
		this.add(button_add);
		
		button_del = new MyJButton("移除条目");
		button_del.setBounds(1080, 530, 120, 25);
		button_del.addActionListener(this);
		button_del.setBackground(backColor);
		button_del.setForeground(foreColor);
		this.add(button_del);
		
		button_finish = new MyJButton("完成交易单创建");
		button_finish.setBounds(940, 570, 260, 25);
		button_finish.addActionListener(this);
		button_finish.setBackground(backColor);
		button_finish.setForeground(foreColor);
		this.add(button_finish);
		
		JLabel word3 = new JLabel("货单备注：");
		word3.setBounds(335 + 50, 570, 120, 25);
		word3.setBackground(null);
		word3.setForeground(Color.WHITE);
		word3.setVisible(true);
		this.add(word3);
		
		tf = new JTextField();
		tf.setBounds(470, 570, 400, 25);
		tf.setForeground(foreColor);
		tf.setBackground(backColor);
		tf.setVisible(true);
		this.add(tf);
			
	}
	
	public void reset(){
		accountID = "";
		accountName = "";
		clientID = "";
		clientName = "";
		word_1.setText("交易单账户为 :      " + accountName);
		word_2.setText("交易单客户为 :      " + clientName);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_finish){
			if(accountID.equals("")){
				WarningFrame wf = new WarningFrame("请添加一个账户！");
				wf.setVisible(true);
			}else{
				if(clientID.equals("")){
					WarningFrame wf = new WarningFrame("请添加一名客户！");
					wf.setVisible(true);
				}else{
					if(table3.getRowCount() == 0){
						WarningFrame wf = new WarningFrame("请添加条目清单！");
						wf.setVisible(true);
					}else{
						boolean flag = true;
						
						for(int i = 0; i < table3.getRowCount(); i++){
							if(Double.parseDouble((String) table3.getValueAt(i, 2)) <= 0){
								flag = false;
							}
						}
						
						if(flag == false){
							WarningFrame wf = new WarningFrame("条目金额不能为0或负！");
							wf.setVisible(true);
						}else{
							//do things
						}
					}	
				}
			}
		}
		
		
		//////////////////CASH/////////////////////////
		
		if(events.getSource() == button_add){
			DefaultTableModel tableModel = (DefaultTableModel) table3.getModel();
		}
		
		//////////////////ELSE/////////////////////////
		
		if(events.getSource() == button_search){
			
			if(comboBox.getSelectedIndex() == 0){
				
				WarningFrame wf = new WarningFrame("请选择一种搜索方式");
				wf.setVisible(true);
				
			}else{
				
				ClientBLService controller = new ClientController();
				ArrayList<ClientVO> list = controller.findClient(textField.getText()
						, getType(comboBox.getSelectedIndex()));
				
				if(list.size() == 0){
					WarningFrame wf = new WarningFrame("没有符合条件的客户！");
					wf.setVisible(true);
				}else{
					
					DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
					
					int rowCount = table2.getRowCount();
					for(int k = 0; k < rowCount; k++)
						tableModel.removeRow(0);
														
					for(int i = 0; i < list.size(); i++){
										
						ClientVO cvo = list.get(i);
						
						String[] str = {cvo.ID, getCategory(cvo.category.toString()), getLevel(cvo.level.toString())
								, cvo.name,cvo.salesman,String.valueOf(cvo.receivable - cvo.payable)
								,String.valueOf(cvo.receivable), String.valueOf(cvo.payable),String.valueOf(cvo.receivableLimit)};
						tableModel.addRow(str);
						
					}	
								
					WarningFrame wf = new WarningFrame("共有  " + list.size() + "  名客户符合条件！");
					wf.setVisible(true);
				}
			}
		}
		
		if(events.getSource() == button_showAll){
			
			DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
			
			int rowCount = table2.getRowCount();
			
			for(int i = 0; i < rowCount; i++)
				tableModel.removeRow(0);
				
			ClientBLService controller = new ClientController();
			
			for(int i = 0; i < controller.show().size(); i++){
				ClientVO cvo = controller.show().get(i);
				
				String[] str = {cvo.ID, getCategory(cvo.category.toString()), getLevel(cvo.level.toString())
						, cvo.name,cvo.salesman,String.valueOf(cvo.receivable - cvo.payable)
						,String.valueOf(cvo.receivable), String.valueOf(cvo.payable),String.valueOf(cvo.receivableLimit)};
				tableModel.addRow(str);
			}		
		}
		
		if(events.getSource() == button_client){
			if(table2.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择一个客户！");
				wf.setVisible(true);
			}else{
				clientName = table2.getValueAt(table2.getSelectedRow(), 3).toString();
				clientID = table2.getValueAt(table2.getSelectedRow(), 0).toString();
				word_2.setText("交易单客户为 :      " + clientName);
			}
		}
		
		if(events.getSource() == button_account){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择一个账户！");
				wf.setVisible(true);
			}else{
				accountName = table.getValueAt(table.getSelectedRow(), 1).toString();
				accountID = table.getValueAt(table.getSelectedRow(), 0).toString();
				word_1.setText("交易单账户为 :      " + accountName);
			}
		}
	}
	
	public void showAllAccount(){
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
		
		AccountBLService controller = new AccountController();
		ArrayList<AccountVO> accountVO = controller.show();
		
		for(int i = 0; i < accountVO.size(); i++){
			String[] rowData = {accountVO.get(i).ID, 
					accountVO.get(i).name, String.valueOf(accountVO.get(i).money) + "元"};
			tableModel.addRow(rowData);		
		}
	}
	
	private FindTypeClient getType(int i){
		switch(i){
			case 1: return null;
			case 2: return FindTypeClient.ID;
			case 3: return FindTypeClient.LEVEL;
			case 5: return FindTypeClient.NAME;
			case 6: return FindTypeClient.SALESMAN;
			default: return FindTypeClient.KIND;
		}
	}
	
	
	private String getCategory(String str){
		switch(str){
			case "PURCHASE_PERSON" : return "进货商";
			case "SALES_PERSON" : return "销售商";
			case "BOTH" :  return "进货商/销售商(两者都是)";
			default : return null;
		}
	}
	
	private String getLevel(String str){
		switch(str){
			case "LEVEL_1" : return "一星级";
			case "LEVEL_2" : return "二星级";
			case "LEVEL_3" :  return "三星级";
			case "LEVEL_4" : return "四星级";
			case "VIP" :  return "五星级(VIP)";
			default : return null;
		}
	}
}