package ui.differui.finace.index;

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
import ui.commonui.text_conductor.SaveFrame;
import ui.commonui.warning.WarningFrame;
import ui.differui.finace.frame.Frame_Finace;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.ValueObject;

public class FinaceIndex extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyBackground indexBack0, indexBack1, indexBack2, indexBack3, indexBack4, indexBack5, indexBack6, indexBack7;
	MyButton bt1, bt2, bt3, bt4, bt5, bt6, bt7;
	MyJButton button_teach, button_save;
	JButton bt_check;
	MyTable table;
	
	public static JButton showAll;
	
	static ArrayList<ValueObject> listPool;
	static ArrayList<BillType> typePool;
	
	public FinaceIndex(){
		listPool = new ArrayList<ValueObject>();
		typePool = new ArrayList<BillType>();
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		button_save = new MyJButton("查看单据草稿");
		button_save.setBounds(1060, 625, 120, 25);
		button_save.addActionListener(this);
		this.add(button_save);
		
//		button_teach = new MyJButton("使用帮助");
//		button_teach.setBounds(1060, 625, 120, 25);
//		button_teach.addActionListener(this);
//		this.add(button_teach);
		
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
		
		if(events.getSource() == button_save){
			SaveFrame sf = new SaveFrame();
			sf.setVisible(true);
		}
		
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
			Frame_Finace.visibleTrue(1);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt2){
			Frame_Finace.visibleTrue(11);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt3){
			Frame_Finace.visibleTrue(3);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt4){
			Frame_Finace.visibleTrue(4);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt5){
			Frame_Finace.visibleTrue(5);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt6){
			Frame_Finace.visibleTrue(6);
			this.setVisible(false);
		}
		
		if(events.getSource() == bt7){
			Frame_Finace.visibleTrue(7);
			this.setVisible(false);
		}
		
	}
	
	private void showAll(){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		for(int k = 0; k < rowCount; k++)
			tableModel.removeRow(0);
		
		ApprovalShowBLService controller = new ApprovalShowController();
		ArrayList<AccountBillVO> vo = controller.ShowApproving().accountBillVOs;
		ArrayList<AccountBillVO> vo2 = controller.showFailure().accountBillVOs;
		ArrayList<AccountBillVO> vo3 = controller.showPass().accountBillVOs;
		ArrayList<CashBillVO> vox = controller.ShowApproving().cashBillVOs;
		ArrayList<CashBillVO> vo2x = controller.showFailure().cashBillVOs;
		ArrayList<CashBillVO> vo3x = controller.showPass().cashBillVOs;
		
		for(int i = 0; i < vo.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vo.get(i));
			typePool.add(vo.get(i).type);
		}
		
		for(int i = 0; i < vox.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vox.get(i).ID, "未审批"};
			tableModel.addRow(rowData);
			listPool.add(vox.get(i));
			typePool.add(BillType.CASH);
		}
		
		for(int i = 0; i < vo2.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo2.get(i).ID, "未通过"};
			tableModel.addRow(rowData);
			listPool.add(vo2.get(i));
			typePool.add(vo2.get(i).type);
		}
		
		for(int i = 0; i < vo2x.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo2x.get(i).ID, "未通过"};
			tableModel.addRow(rowData);
			listPool.add(vo2x.get(i));
			typePool.add(BillType.CASH);
		}
		
		for(int i = 0; i < vo3.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo3.get(i).ID, "已通过"};
			tableModel.addRow(rowData);
			listPool.add(vo3.get(i));
			typePool.add(vo3.get(i).type);
		}
		
		for(int i = 0; i < vo3x.size(); i++){
			Object[] rowData = {table.getRowCount() + 1, vo3x.get(i).ID, "已通过"};
			tableModel.addRow(rowData);
			listPool.add(vo3x.get(i));
			typePool.add(BillType.CASH);
		}
	}
	
	private void initTable(){
		
		String[] headers = {"序号", "单据编号", "单据状态"};
		table = new MyTable(headers);
		table.getTableHeader().setBackground(new Color(29, 72, 33));
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
		bt_check.setBackground(new Color(29, 72, 33));
		bt_check.setForeground(Color.WHITE);
		bt_check.setVisible(true);
		this.add(bt_check);
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
	
	public void initButtons(){
		bt1 = new MyButton(503, 141, 403, 142);
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
		
		bt2 = new MyButton(920, 141, 262, 142);
		bt2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack2.setVisible(false);
			}
			}); 
		bt2.addActionListener(this);
		this.add(bt2);
		
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
		
		bt6 = new MyButton(503, 430, 330, 158);
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
		
		bt7 = new MyButton(847, 430, 330, 158);
		bt7.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {			
				indexBack0.setVisible(false);
				indexBack7.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				indexBack0.setVisible(true);
				indexBack7.setVisible(false);
			}
			}); 
		bt7.addActionListener(this);
		this.add(bt7);
	}
	
	public void initBackgrounds(){
		indexBack7 = new MyBackground("ui/image/finace/index7.png");
		indexBack7.setVisible(false);
		this.add(indexBack7);
		
		indexBack6 = new MyBackground("ui/image/finace/index6.png");
		indexBack6.setVisible(false);
		this.add(indexBack6);
		
		indexBack5 = new MyBackground("ui/image/finace/index5.png");
		indexBack5.setVisible(false);
		this.add(indexBack5);
		
		indexBack4 = new MyBackground("ui/image/finace/index4.png");
		indexBack4.setVisible(false);
		this.add(indexBack4);
		
		indexBack3 = new MyBackground("ui/image/finace/index3.png");
		indexBack3.setVisible(false);
		this.add(indexBack3);
		
		indexBack2 = new MyBackground("ui/image/finace/index2.png");
		indexBack2.setVisible(false);
		this.add(indexBack2);
		
		indexBack1 = new MyBackground("ui/image/finace/index1.png");
		indexBack1.setVisible(false);
		this.add(indexBack1);
		
		indexBack0 = new MyBackground("ui/image/finace/index0.png");
		this.add(indexBack0); 
	}
}

