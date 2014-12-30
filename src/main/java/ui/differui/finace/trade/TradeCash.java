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

import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import ui.differui.finace.frame.Frame_Finace;
import vo.AccountVO;
import blservice.accountblservice.AccountBLService;
import businesslogic.accountbl.AccountController;

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
		
	static String accountID = "", accountName = "", note ="", billItem = "";
	
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
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
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
				
		////////////////CASH/////////////////	
		word_1 = new JLabel("现金单账户为 :      " + accountName);
		word_1.setForeground(Color.WHITE);
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(335 + 50, 530, 300, 25);
		this.add(word_1);
		
		String[] headers3 = {"条目名称", "条目金额", "备注"};
		table3 = new MyTable(headers3, 0);
		
		table3.setDefaultRenderer(Object.class, tcr);
		
		TableColumn firsetColumn3 = table3.getColumnModel().getColumn(0);
		firsetColumn3.setPreferredWidth(500);
		firsetColumn3.setMaxWidth(500);
		firsetColumn3.setMinWidth(500);
		
		TableColumn firsetColumn4 = table3.getColumnModel().getColumn(1);
		firsetColumn4.setPreferredWidth(100);
		firsetColumn4.setMaxWidth(100);
		firsetColumn4.setMinWidth(100);
		
		JScrollPane jsp3 = new JScrollPane(table3);
		JTableHeader head3 = table3.getTableHeader();
		head3.setBackground(backColor);
		head3.setForeground(foreColor);
		jsp3.setBounds(75 + 290, 60, 1125 - 290, 120 + 335);
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
		
		button_finish = new MyJButton("完成现金费用单创建");
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
		billItem = "";
		word_1.setText("交易单账户为 :      " + accountName);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_finish){
			
			if(table3.isEditing())
				table3.getCellEditor().stopCellEditing();
			
			if(accountID.equals("")){
				WarningFrame wf = new WarningFrame("请添加一个账户！");
				wf.setVisible(true);
			}else{
				if(table3.getRowCount() == 0){
					WarningFrame wf = new WarningFrame("请添加条目清单！");
					wf.setVisible(true);
				}else{
					boolean flag = true;
						
					for(int i = 0; i < table3.getRowCount(); i++){
						for(int j = 0; j < 2; j++){
							if(table3.getValueAt(i, j).toString().isEmpty()){
								flag = false;
							}
						}
					}
						
					if(flag == false){
						WarningFrame wf = new WarningFrame("请将条目信息填写完整！");
						wf.setVisible(true);
					}else{
							
						flag = true;
							
						for(int i = 0; i < table3.getRowCount(); i++){
							if(Double.parseDouble((String) table3.getValueAt(i, 1)) <= 0){
								flag = false;
							}
							billItem = billItem + (String) table3.getValueAt(i, 0) + ":";
							billItem = billItem + (String) table3.getValueAt(i, 1) + ":";
							billItem = billItem + (String) table3.getValueAt(i, 2) + ";";
						}
							
						if(flag == false){
							WarningFrame wf = new WarningFrame("条目金额不能为0或负！");
							wf.setVisible(true);
						}else{
							note = tf.getText();
							TradeFinish.setType(3);
							Frame_Finace.visibleTrue(8);
							this.setVisible(false);
						}
					}
				}	
				
			}
		}
		
		
		//////////////////CASH/////////////////////////
		
		if(events.getSource() == button_add){
			DefaultTableModel tableModel = (DefaultTableModel) table3.getModel();
			String[] rowData = {"", ""};
			tableModel.addRow(rowData);
		}
		
		if(events.getSource() == button_del){
			if(table3.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择需要删除的条目");
				wf.setVisible(true);
			}else{
				DefaultTableModel tableModel = (DefaultTableModel) table3.getModel();
				tableModel.removeRow(table3.getSelectedRow());
			}
		}
		
		//////////////////ELSE/////////////////////////
			
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
	
}