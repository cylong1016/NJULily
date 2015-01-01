package ui.differui.manager.index;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dataenum.BillType;
import blservice.approvalblservice.ApprovalShowBLService;
import businesslogic.approvalbl.ApprovalShowController;
import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.text_conductor.BillFrame;
import ui.commonui.warning.WarningFrame;
import ui.differui.manager.frame.Frame_Manager;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.ValueObject;
import vo.sale.SalesVO;

public class ManagerIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyBackground indexBack0, indexBack1, indexBack3, indexBack4, indexBack5, indexBack6;
	MyButton bt1, bt3, bt4, bt5, bt6;
	MyJButton button_teach;
	JButton bt_check;
	MyTable table;
	
	public static JButton showAll;
	
	static ArrayList<ValueObject> listPool;
	static ArrayList<BillType> typePool;
	
	public ManagerIndex(){
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<BillType>();
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		button_teach = new MyJButton("使用帮助");
		button_teach.setBounds(1060, 625, 120, 25);
		button_teach.addActionListener(this);
		this.add(button_teach);
		
		initButtons();
		initInfo();
		initTable();
		initBackgrounds();
		
		showAll();
		
		showAll = new JButton();
		showAll.addActionListener(this);
		this.add(showAll);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_check){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请先选择要查看的单据！");
				wf.setVisible(true);
			}else{
				BillType billType = typePool.get(table.getSelectedRow());
				ValueObject bill = listPool.get(table.getSelectedRow());
				BillFrame bf = new BillFrame(billType, bill);
				bf.setVisible(true);
			}
		}
		
		if(events.getSource() == showAll){
			showAll();
		}
		
		if(events.getSource() == bt1){
			Frame_Manager.visibleTrue(1);
			this.setVisible(false);
		}
				
		if(events.getSource() == bt3){
			Frame_Manager.visibleTrue(2);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt4){
			Frame_Manager.visibleTrue(3);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt5){
			Frame_Manager.visibleTrue(4);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt6){
			Frame_Manager.visibleTrue(5);
			this.setVisible(false);
		}
				
	}
	
	private void initInfo(){
		JLabel word_1 = new JLabel("员工账号：" + Frame_Login.userID);
		word_1.setForeground(Color.WHITE);
		word_1.setFont(new Font("黑体", Font.BOLD, 15));
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(200, 145 - 10, 300, 40);
		word_1.setVisible(true);
		this.add(word_1);
		
		JLabel word_2 = new JLabel("员工名称：" + Frame_Login.userName);
		word_2.setForeground(Color.WHITE);
		word_2.setBackground(new Color(0, 0, 0, 0));
		word_2.setFont(new Font("黑体", Font.BOLD, 15));
		word_2.setBounds(200, 195 - 10, 300, 40);
		word_2.setVisible(true);
		this.add(word_2);
	}
	
	private void showAll(){
		listPool.clear();
		typePool.clear();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		for(int k = 0; k < rowCount; k++)
			tableModel.removeRow(0);
		
		ApprovalShowBLService controller = new ApprovalShowController();
		
		ArrayList<AccountBillVO> vo = controller.ShowApproving().accountBillVOs;
		ArrayList<CashBillVO> vo2 = controller.ShowApproving().cashBillVOs;
		ArrayList<InventoryBillVO> vo3 = controller.ShowApproving().inventoryBillVOs;
		ArrayList<PurchaseVO> vo4 = controller.ShowApproving().purchaseVOs;
		ArrayList<SalesVO> vo5 = controller.ShowApproving().salesVOs;
		
		for(int i = 0; i < vo.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo.get(i));
			typePool.add(vo.get(i).type);
		}
		
		for(int i = 0; i < vo2.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo2.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo2.get(i));
			typePool.add(BillType.CASH);
		}
		
		for(int i = 0; i < vo3.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo3.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo3.get(i));
			typePool.add(vo3.get(i).billType);
		}
		
		for(int i = 0; i < vo4.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo4.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo4.get(i));
			typePool.add(vo4.get(i).type);
		}
		
		for(int i = 0; i < vo5.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo5.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo5.get(i));
			typePool.add(vo5.get(i).type);
		}
		
	}
	
	private void initTable(){
		
		String[] headers = {"序号", "单据编号", "单据状态"};
		table = new MyTable(headers);
		table.getTableHeader().setBackground(new Color(26, 119, 119));
		table.getTableHeader().setForeground(Color.WHITE);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(0).setMaxWidth(55);
		table.getColumnModel().getColumn(0).setMinWidth(55);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.getColumnModel().getColumn(1).setMaxWidth(145);
		table.getColumnModel().getColumn(1).setMinWidth(145);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(85 + 50, 95 + 230, 305, 305 - 60);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);	
		
		bt_check = new JButton("查看所选单据内容");
		bt_check.setBounds(285, 580, 154, 25);
		bt_check.addActionListener(this);
		bt_check.setBackground(new Color(26, 119, 119));
		bt_check.setForeground(Color.WHITE);
		bt_check.setVisible(true);
		this.add(bt_check);
	}
	
	public void initButtons(){
		bt1 = new MyButton(503, 141, 680, 142);
		bt1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack1.setVisible(false);
			}
			}); 
		bt1.addActionListener(this);
		this.add(bt1);
			
		bt3 = new MyButton(503, 296, 224, 123);
		bt3.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack3.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack3.setVisible(false);
			}
			}); 
		bt3.addActionListener(this);
		this.add(bt3);
		
		bt4 = new MyButton(740, 296, 224, 123);
		bt4.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack4.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack4.setVisible(false);
			}
			}); 
		bt4.addActionListener(this);
		this.add(bt4);
		
		bt5 = new MyButton(969, 296, 224, 123);
		bt5.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack5.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack5.setVisible(false);
			}
			}); 
		bt5.addActionListener(this);
		this.add(bt5);
		
		bt6 = new MyButton(503, 430, 680, 158);
		bt6.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack6.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack6.setVisible(false);
			}
			}); 
		bt6.addActionListener(this);
		this.add(bt6);
	}
	
	public void initBackgrounds(){
		
		indexBack6 = new MyBackground("ui/image/manager/index6.png");
		indexBack6.setVisible(false);
		this.add(indexBack6);
		
		indexBack5 = new MyBackground("ui/image/manager/index5.png");
		indexBack5.setVisible(false);
		this.add(indexBack5);
		
		indexBack4 = new MyBackground("ui/image/manager/index4.png");
		indexBack4.setVisible(false);
		this.add(indexBack4);
		
		indexBack3 = new MyBackground("ui/image/manager/index3.png");
		indexBack3.setVisible(false);
		this.add(indexBack3);

		indexBack1 = new MyBackground("ui/image/manager/index1.png");
		indexBack1.setVisible(false);
		this.add(indexBack1);
		
		indexBack0 = new MyBackground("ui/image/manager/index0.png");
		this.add(indexBack0); 
	}
}

