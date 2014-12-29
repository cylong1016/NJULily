package ui.differui.finace.init_account;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.warning.WarningFrame;
import vo.AccountaInitVO;
import blservice.accountinitblservice.AccountInitBLService;
import businesslogic.accountinitbl.AccountInitController;

public class InitAccount extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyTable table, table2, table3, table4;
	
	MyJButton button_check, button_out;
	public static JButton init;

	public InitAccount(){
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
		
		//String ID, String date, ArrayList<CommoditySortVO> commoditySorts, 
		//ArrayList<CommodityVO> commodities, ArrayList<ClientVO> clients, ArrayList<AccountVO> accounts
		
		String[] headers = {"编号", "日期", "分类编号", "分类名称"};
		table = new MyTable(headers);
		
		String[] headers2 = {"编号", "日期", "商品编号", "商品名称", "商品型号", "商品数量"};
		table2 = new MyTable(headers2);
		
		String[] headers3 = {"编号", "日期", "客户编号", "客户名称", "应收", "应付"};
		table3 = new MyTable(headers3);
		
		String[] headers4 = {"编号", "日期", "账户编号", "账户名称", "账户金额"};
		table4 = new MyTable(headers4);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(80, 90, 1085, 475/4);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		JScrollPane jsp2 = new JScrollPane(table2);
		jsp2.setBounds(80, 90 + (475/4)*1 + 10, 1085, 475/4 - 10);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		JScrollPane jsp4 = new JScrollPane(table4);
		jsp4.setBounds(80, 90 + (475/4)*3 + 10 + 20, 1085, 475/4 - 10);
		jsp4.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp4.setOpaque(false);
		jsp4.setVisible(true);
		this.add(jsp4);
		
		JScrollPane jsp3 = new JScrollPane(table3);
		jsp3.setBounds(80, 90 + (475/4)*2 + 10 + 15, 1085, 475/4 - 10);
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setVisible(true);
		this.add(jsp3);
		
		showAll();
		
		int x = 65 + 200 + 150 + 10 + 235 + 176;
		
		button_check = new MyJButton("查看");
		button_check.setBounds(250 + x - 10, 50, 90, 25);
		button_check.addActionListener(this);
		this.add(button_check);
		
		button_out = new MyJButton("期初建账");
		button_out.setBounds(210 + x, 575, 120, 25);
		button_out.addActionListener(this);
		this.add(button_out);
		
		init = new JButton();
		init.addActionListener(this);
		this.add(init);
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_out){
			ExitFinishFrame eff = new ExitFinishFrame("init account");
			eff.setVisible(true);
		}
		
		if(events.getSource() == init){
			AccountInitBLService controller = new AccountInitController();
			controller.buildAccount();
			
			WarningFrame wf = new WarningFrame("期初建账成功");
			wf.setVisible(true);
			
			showAll();
		}
		
		if(events.getSource() == button_check){
			showAll();
		}
	}
	
	public void showAll(){
		AccountInitBLService controller = new AccountInitController();
		ArrayList<AccountaInitVO> vo = controller.show();
		
	
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		DefaultTableModel tableModel2 = (DefaultTableModel) table2.getModel();
		DefaultTableModel tableModel3 = (DefaultTableModel) table3.getModel();
		DefaultTableModel tableModel4 = (DefaultTableModel) table4.getModel();
		
		int rowCount = table.getRowCount();
		int rowCount2 = table2.getRowCount();
		int rowCount3 = table3.getRowCount();
		int rowCount4 = table4.getRowCount();
		
		for(int i = 0; i < rowCount; i++)
			tableModel.removeRow(0);
		
		for(int i = 0; i < rowCount2; i++)
			tableModel2.removeRow(0);
		
		for(int i = 0; i < rowCount3; i++)
			tableModel3.removeRow(0);
		
		for(int i = 0; i < rowCount4; i++)
			tableModel4.removeRow(0);
		
		
		//"编号", "日期", "商品分类", "商品名称", "客户名称", "账户"
		
		if(vo != null)
			for(int i = 0; i < vo.size(); i++){
				AccountaInitVO avo = vo.get(i);
				
				for(int j = 0; j < avo.accounts.size(); j++){
					Object[] rowData = {avo.ID, avo.date
							, avo.commoditySorts.get(j).ID, avo.commoditySorts.get(j).name};
					tableModel.addRow(rowData);
				}
				
				for(int j = 0; j < avo.commodities.size(); j++){
					Object[] rowData = {avo.ID, avo.date, avo.commodities.get(j).ID,
							avo.commodities.get(j).name, avo.commodities.get(j).type, avo.commodities.get(j).inventoryNum};
					tableModel2.addRow(rowData);
				}
				
				for(int j = 0; j < avo.clients.size(); j++){
					Object[] rowData = {avo.ID, avo.date, avo.clients.get(j).ID, avo.clients.get(j).name, 
							avo.clients.get(j).receivable, avo.clients.get(j).payable};
					tableModel3.addRow(rowData);
				}
				
				for(int j = 0; j < avo.accounts.size(); j++){
					Object[] rowData = {avo.ID, avo.date, avo.accounts.get(j).ID
							, avo.accounts.get(j).name, avo.accounts.get(j).money};
					tableModel4.addRow(rowData);
				}
				
			}
	}
	
}
