package ui.differui.manager.approve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import blservice.approvalblservice.ApprovalShowBLService;
import businesslogic.approvalbl.Approval;
import businesslogic.approvalbl.ApprovalShow;
import ui.commonui.myui.MyComboBox;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.sale.SalesVO;


public class ApproveManagementUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JTable table;
	DefaultTableModel model;
	
	Color foreColor = new Color(158, 213, 220);
	Color backColor = new Color(46, 52, 101);
	
	JButton bt_approval, bt_approvalAll, bt_search, bt_modify, bt_check, bt_out;
	MyComboBox cbb_isApproval, cbb_sort;
	JTextArea ta;
	
	private static int rowNum = 0;
	
	public ApproveManagementUI(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
			
		JLabel infoBar = new JLabel("审批单据");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		infoBar.setVisible(true);
		this.add(infoBar);
		
		String[] comboBoxStr = {"全部种类", "进货类单据", "销售类单据", "财务类单据", "库存类单据", "现金类单据"};
		cbb_sort = new MyComboBox(85 + 135, 56, 130, 25, comboBoxStr);
		this.add(cbb_sort);
		
		String[] comboBoxStr2 = {"全部状态", "待审批", "通过审批", "未通过审批"};
		cbb_isApproval = new MyComboBox(85, 56, 130, 25, comboBoxStr2);
		this.add(cbb_isApproval);
		
		initTable();
		initButtons();
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setBackground(backColor);
		ta.setForeground(foreColor);
		
		JScrollPane jsp2 = new JScrollPane(ta);
		jsp2.setBounds(520, 95, 650, 465);
		this.add(jsp2);
	}
	
	private void initButtons(){
		bt_search = new JButton("搜索");
		bt_search.setBounds(355, 56, 107, 25);
		bt_search.addActionListener(this);
		bt_search.setBackground(Color.WHITE);
		bt_search.setForeground(backColor);
		bt_search.setVisible(true);
		this.add(bt_search);
		
		bt_check = new JButton("查看所选单据内容");
		bt_check.setBounds(285, 572, 180, 25);
		bt_check.addActionListener(this);
		bt_check.setBackground(Color.WHITE);
		bt_check.setForeground(backColor);
		bt_check.setVisible(true);
		this.add(bt_check);
		
		bt_approvalAll = new JButton("通过所有所选单据");
		bt_approvalAll.setBounds(85, 572, 180, 25);
		bt_approvalAll.addActionListener(this);
		bt_approvalAll.setBackground(Color.WHITE);
		bt_approvalAll.setForeground(backColor);
		bt_approvalAll.setVisible(true);
		this.add(bt_approvalAll);
		
		bt_approval = new JButton("通过此单据");
		bt_approval.setBounds(1170 - 180, 572, 180, 25);
		bt_approval.addActionListener(this);
		bt_approval.setBackground(Color.WHITE);
		bt_approval.setForeground(backColor);
		bt_approval.setVisible(true);
		this.add(bt_approval);
		
		bt_modify = new JButton("修改单据内容");
		bt_modify.setBounds(520, 572, 180, 25);
		bt_modify.addActionListener(this);
		bt_modify.setBackground(Color.WHITE);
		bt_modify.setForeground(backColor);
		bt_modify.setVisible(true);
		this.add(bt_modify);
		
		bt_out = new JButton("导出单据至桌面");
		bt_out.setBounds(755, 572, 180, 25);
		bt_out.addActionListener(this);
		bt_out.setBackground(Color.WHITE);
		bt_out.setForeground(backColor);
		bt_out.setVisible(true);
		this.add(bt_out);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_approvalAll){
		//	Approval controller = new Approval();
			
		}
		
		if(events.getSource() == bt_search){
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			if(rowNum != 0)
				for(int k = 0; k < rowNum; k++)
					tableModel.removeRow(0);
			
			rowNum = 0;
			
			if(cbb_isApproval.getSelectedIndex() == 1){
				getApprovalData(cbb_sort.getSelectedIndex());
			}else if(cbb_isApproval.getSelectedIndex() == 2){
				getPassData(cbb_sort.getSelectedIndex());
			}else if(cbb_isApproval.getSelectedIndex() == 3){
				getFailureData(cbb_sort.getSelectedIndex());
			}else{
				getApprovalData(cbb_sort.getSelectedIndex());
				getPassData(cbb_sort.getSelectedIndex());
				getFailureData(cbb_sort.getSelectedIndex());
			}
		}
		
	}
	
	private void getApprovalData(int index){
		ApprovalShow controller = new ApprovalShow();
		ArrayList<PurchaseVO> approval_pur = controller.ShowApproving().purchaseVOs;
		ArrayList<SalesVO> approval_sale = controller.ShowApproving().salesVOs;
		ArrayList<AccountBillVO> approval_account = controller.ShowApproving().accountBillVOs;
		ArrayList<InventoryBillVO> approval_inventory = controller.ShowApproving().inventoryBillVOs;
		ArrayList<CashBillVO> approval_cashBill = controller.ShowApproving().cashBillVOs;
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0)
			for(int i = 1; i <= 5; i++)
				getApprovalData(i);
		
		if(index == 1)
			for(int i = 0; i < approval_pur.size(); i++){
				Object[] rowData = {new Boolean(false), "进货类单据", approval_pur.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 2)
			for(int i = 0; i < approval_sale.size(); i++){
				Object[] rowData = {new Boolean(false), "销售类单据", approval_sale.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 3)
			for(int i = 0; i < approval_account.size(); i++){
				Object[] rowData = {new Boolean(false), "财务类单据", approval_account.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 4)
			for(int i = 0; i < approval_inventory.size(); i++){
				Object[] rowData = {new Boolean(false), "库存类单据", approval_inventory.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 5)
			for(int i = 0; i < approval_cashBill.size(); i++){
				Object[] rowData = {new Boolean(false), "现金类单据", approval_cashBill.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
	}
	
	private void getPassData(int index){
		ApprovalShow controller = new ApprovalShow();
		ArrayList<PurchaseVO> approval_pur = controller.showPass().purchaseVOs;
		ArrayList<SalesVO> approval_sale = controller.showPass().salesVOs;
		ArrayList<AccountBillVO> approval_account = controller.showPass().accountBillVOs;
		ArrayList<InventoryBillVO> approval_inventory = controller.showPass().inventoryBillVOs;
		ArrayList<CashBillVO> approval_cashBill = controller.showPass().cashBillVOs;
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0)
			for(int i = 1; i <= 5; i++)
				getPassData(i);
		
		if(index == 1)
			for(int i = 0; i < approval_pur.size(); i++){
				Object[] rowData = {new Boolean(false), "进货类单据", approval_pur.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 2)
			for(int i = 0; i < approval_sale.size(); i++){
				Object[] rowData = {new Boolean(false), "销售类单据", approval_sale.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 3)
			for(int i = 0; i < approval_account.size(); i++){
				Object[] rowData = {new Boolean(false), "财务类单据", approval_account.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 4)
			for(int i = 0; i < approval_inventory.size(); i++){
				Object[] rowData = {new Boolean(false), "库存类单据", approval_inventory.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 5)
			for(int i = 0; i < approval_cashBill.size(); i++){
				Object[] rowData = {new Boolean(false), "现金类单据", approval_cashBill.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
	}
	
	private void getFailureData(int index){
		ApprovalShow controller = new ApprovalShow();
		ArrayList<PurchaseVO> approval_pur = controller.showFailure().purchaseVOs;
		ArrayList<SalesVO> approval_sale = controller.showFailure().salesVOs;
		ArrayList<AccountBillVO> approval_account = controller.showFailure().accountBillVOs;
		ArrayList<InventoryBillVO> approval_inventory = controller.showFailure().inventoryBillVOs;
		ArrayList<CashBillVO> approval_cashBill = controller.showFailure().cashBillVOs;
		
		model = (DefaultTableModel) table.getModel();
		
		if(index == 0)
			for(int i = 1; i <= 5; i++)
				getFailureData(i);
		
		if(index == 1)
			for(int i = 0; i < approval_pur.size(); i++){
				Object[] rowData = {new Boolean(false), "进货类单据", approval_pur.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 2)
			for(int i = 0; i < approval_sale.size(); i++){
				Object[] rowData = {new Boolean(false), "销售类单据", approval_sale.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 3)
			for(int i = 0; i < approval_account.size(); i++){
				Object[] rowData = {new Boolean(false), "财务类单据", approval_account.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 4)
			for(int i = 0; i < approval_inventory.size(); i++){
				Object[] rowData = {new Boolean(false), "库存类单据", approval_inventory.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
		
		if(index == 5)
			for(int i = 0; i < approval_cashBill.size(); i++){
				Object[] rowData = {new Boolean(false), "现金类单据", approval_cashBill.get(i).ID, "未通过"};
				model.addRow(rowData);
				rowNum++;
			}
	}
	
	private void initTable(){
		ApproveTableModel tablemodel = new ApproveTableModel();
		
		table = new JTable(tablemodel);
		table.setCellSelectionEnabled(false);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		JTableHeader head = table.getTableHeader();
		head.setForeground(foreColor);
		head.setBackground(backColor);
		
		TableColumn firsetColumn = table.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(30);
		firsetColumn.setMaxWidth(30);
		firsetColumn.setMinWidth(30);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setMaxWidth(110);
		table.getColumnModel().getColumn(1).setMinWidth(110);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setMaxWidth(180);
		table.getColumnModel().getColumn(2).setMinWidth(180);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(85, 95, 380, 465);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);	
	}

}