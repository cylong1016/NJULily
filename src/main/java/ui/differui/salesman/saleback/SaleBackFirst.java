package ui.differui.salesman.saleback;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTree;
import ui.commonui.warning.WarningFrame;
import ui.differui.salesman.frame.Frame_Salesman;
import vo.client.ClientVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommoditySortVO;
import vo.commodity.CommodityVO;
import vo.sale.SalesVO;
import blservice.approvalblservice.ApprovalShowBLService;
import blservice.clientblservice.ClientBLService;
import blservice.commodityblservice.CommodityBLService;
import blservice.commoditysortblservice.CommoditySortBLService;
import businesslogic.approvalbl.ApprovalShowController;
import businesslogic.clientbl.ClientController;
import businesslogic.commoditybl.CommodityController;
import businesslogic.commoditysortbl.CommoditySortController;
import dataenum.ClientCategory;

public class SaleBackFirst extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_sort;
	MyJButton button_del2;

	static MyJButton button_showAll;

	MyJButton button_choose;

	MyJButton button_del, button_add, button_finish;
	
	public static JButton button_close, showAll;
	
	JScrollPane jsp;
	MyTree tree;
	MyTable table, table2, table3;
	MyComboBox comboBox2;

	static String deleteID;
	int clickTime = 0;
	
	ArrayList<String> addCommoID;
	public static ArrayList<CommodityItemVO> commoList;
	
	public static ArrayList<CommodityItemVO> clientCommoList;
	ArrayList<SalesVO> billList;
	
	static String ClientName ,ClientID, note;
	
	JTextField tf;
	
 	public SaleBackFirst(){
		
 		billList = new ArrayList<SalesVO>();
 		
		int y = 10;
		
		addCommoID = new ArrayList<String>();
		commoList = new ArrayList<CommodityItemVO>();
		commoList.clear();
		
		clientCommoList = new ArrayList<CommodityItemVO>();
		clientCommoList.clear();
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);

		JLabel infoBar = new JLabel("制定销售退货单 - 填写信息");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.WHITE);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		String[] comboBoxStr2 = getClient().split(";");
		comboBox2 = new MyComboBox(83, 60 + y, 190, 25, comboBoxStr2);
		comboBox2.setForeground(foreColor);
		comboBox2.setBackground(backColor);
		comboBox2.setEditable(true);
		this.add(comboBox2);
		
		String[] headers3 = {"货单编号", "所含商品数量"};
		table3 = new MyTable(headers3);
		JTableHeader head3 = table3.getTableHeader();
		head3.setForeground(foreColor);
		head3.setBackground(backColor);
		
		TableColumn firsetColumn = table3.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(140);
		firsetColumn.setMaxWidth(140);
		firsetColumn.setMinWidth(140);
					
		jsp = new JScrollPane(table3);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBounds(50 + 33, 95 + y, 225, 425 + 61 - 35);
		jsp.setVisible(true);
		this.add(jsp);
		
		button_choose = new MyJButton("选择此客户");
		button_choose.setBounds(83 + 200, 60 + y, 120, 25);
		button_choose.addActionListener(this);
		this.add(button_choose);
		
		//add a table for showing the information of the goods(the table is contained in a scroll pane)
		String[] headers = {"商品编号","商品分类","商品名称","商品型号","库存数量"};
		table = new MyTable(headers);
		JTableHeader head = table.getTableHeader();
		head.setForeground(foreColor);
		head.setBackground(backColor);
		
		JScrollPane jsp2 = new JScrollPane(table);
		jsp2.setBounds(335, 95 + y, 860, 200);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		String[] headers2 = {"商品编号","商品名称","商品型号","商品数量","商品价格","商品备注"};
		table2 = new MyTable(headers2, true);
		
		JTableHeader head2 = table2.getTableHeader();
		head2.setForeground(foreColor);
		head2.setBackground(backColor);
		
		JScrollPane jsp3 = new JScrollPane(table2);
		jsp3.setBounds(335, 345 + y, 860, 200);
		jsp3.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp3.setOpaque(false);
		jsp3.setVisible(true);
		this.add(jsp3);
		
		//add a button for deleting a selected good
		button_del = new MyJButton("将所选商品从待处理区删除");
		button_del.setBounds(610 - 243, 310 + y, 210, 25);
		button_del.addActionListener(this);
		this.add(button_del);	
		
		//add a button for modifying the information of a selected good
		button_add = new MyJButton("将所选商品添加至待处理区");
		button_add.setBounds(960, 310 + y, 210, 25);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		///////////////////////////////////////////////////////////////////////////////
		
		//add a button for  modifying the information of a selected good sort
		button_sort = new MyJButton("查看所选货单所含的商品");
		button_sort.setBounds(50 + 33, 563 + y, 225, 25);
		button_sort.addActionListener(this);
		this.add(button_sort);	
		
		JLabel word3 = new JLabel("货单备注：");
		word3.setBounds(335, 563 + y, 120, 25);
		word3.setBackground(null);
		word3.setForeground(Color.WHITE);
		word3.setVisible(true);
		this.add(word3);
		
		tf = new JTextField();
		tf.setBounds(470, 563 + y, 400, 25);
		tf.setVisible(true);
		this.add(tf);
		
		button_showAll = new MyJButton("显示全部与所选客户相关的商品");
		button_showAll.setBounds(944 + 150 - 30 - 120, 60 + y, 250, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);
			
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
						
		showAll = new JButton();
		showAll.addActionListener(this);
		this.add(showAll);	
		
		button_finish = new MyJButton("下一步");
		button_finish.setBounds(944 + 150 - 30, 563 + y, 130, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);
	}
		
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_choose){
			
			clientCommoList.clear();
			
			DefaultTableModel tableModel = (DefaultTableModel) table3.getModel();
				
			int rowCount = table3.getRowCount();
			for(int k = 0; k < rowCount; k++)
				tableModel.removeRow(0);
		
			ClientBLService clientController = new ClientController();
			ArrayList<ClientVO> clientList = clientController.show();
			Boolean flag = false;
			String ID = "";
				
			for(int i = 0; i < clientList.size(); i++){
				if(comboBox2.getSelectedItem().toString().equals(clientList.get(i).name)){
					flag = true;
					ID = clientList.get(i).ID;
					ClientName = clientList.get(i).name;
					ClientID = ID;
				}
			}
				
			if(flag == false){
				WarningFrame wf = new WarningFrame("无此客户!");
				wf.setVisible(true);
			}else{
				
				ApprovalShowBLService appController = new ApprovalShowController();
				ArrayList<SalesVO> list = appController.showPass().salesVOs;
					
				DefaultTableModel model = (DefaultTableModel) table3.getModel();
					
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).clientID.equals(ID)){
						billList.add(list.get(i));
						String[] str = {list.get(i).ID, String.valueOf(addCommo(list.get(i).commodities))};
						model.addRow(str);
					}
				}
					
				if(table3.getRowCount() == 0){
					WarningFrame wf = new WarningFrame("暂时没有符合条件的货单！");
					wf.setVisible(true);
				}else{
					WarningFrame wf = new WarningFrame("目前有"+ table3.getRowCount() +"条货单符合条件!");
					wf.setVisible(true);
				}
				
			}
			
		}
		
		
		if(events.getSource() == button_sort){
			if(table3.getSelectedRow() < 0){
				WarningFrame wf = new WarningFrame("请选择需要查看的货单！");
				wf.setVisible(true);
			}else{
				
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				int rowCount = table.getRowCount();
				for(int k = 0; k < rowCount; k++)
					tableModel.removeRow(0);
				
				ArrayList<CommodityItemVO> commoArray = billList.get(table3.getSelectedRow()).commodities;
				
				CommodityBLService commoController = new CommodityController();
				for(int j = 0; j < commoArray.size(); j++){
					for(int i = 0; i < commoController.show().size(); i++){
						if(commoController.show().get(i).ID.equals(commoArray.get(j).ID)){
							String[] str = {commoController.show().get(i).ID, getSortName(commoController.show().get(i).sortID), 
									commoController.show().get(i).name, commoController.show().get(i).type, 
									String.valueOf(commoController.show().get(i).inventoryNum)};
							tableModel.addRow(str);
						}
					}
				}
			}
		}
		
		if(events.getSource() == button_showAll){
			
			if(clientCommoList.size() == 0){
				WarningFrame wf = new WarningFrame("暂时没有符合条件的商品！");
				wf.setVisible(true);
			}else{
			
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				int rowCount = table.getRowCount();
				
				for(int k = 0; k < rowCount; k++)
						tableModel.removeRow(0);
				
				CommodityBLService commoController = new CommodityController();
				for(int j = 0; j < clientCommoList.size(); j++){
					for(int i = 0; i < commoController.show().size(); i++){
						if(commoController.show().get(i).ID.equals(clientCommoList.get(j).ID)){
							String[] str = {commoController.show().get(i).ID, getSortName(commoController.show().get(i).sortID), 
									commoController.show().get(i).name, commoController.show().get(i).type, 
									String.valueOf(commoController.show().get(i).inventoryNum)};
							tableModel.addRow(str);
						}
					}
				}
				
				WarningFrame wf = new WarningFrame("共有"+ table.getRowCount() + "件商品与此客户有关！");
				wf.setVisible(true);
			}
		}
				
		if(events.getSource() == button_add){
			
			if(table.getSelectedRow() < 0){
				WarningFrame wf = new WarningFrame("请选择一个欲添加的商品！");
				wf.setVisible(true);
			}else{
				
				String commoID = (String)table.getValueAt(table.getSelectedRow(), 0);
				Boolean flag = true;
				
				for(int i = 0; i < addCommoID.size(); i++){
					if(addCommoID.get(i).equals(commoID)){
						WarningFrame wf = new WarningFrame("已经添加了此商品！");
						wf.setVisible(true);
						i = 1000;
						flag = false;
					}
				}
				
				if(flag == true){
					
					CommodityBLService controller = new CommodityController();
					ArrayList<CommodityVO> commoList = controller.show();
					
					for(int i = 0; i < commoList.size(); i++){
						if(commoList.get(i).ID.equals(commoID)){
							DefaultTableModel model = (DefaultTableModel)table2.getModel();
							String[] rowData = {commoList.get(i).ID, commoList.get(i).name, 
									commoList.get(i).type,"0",String.valueOf(commoList.get(i).salePrice)};
							model.addRow(rowData);
							addCommoID.add(commoID);
						}
					}
				}
			}
		}
		
		if(events.getSource() == button_del){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择一个欲除去的商品！");
				wf.setVisible(true);
			}else{
				String commoID = (String)table2.getValueAt(table2.getSelectedRow(), 0);
	
				for(int i = 0; i < addCommoID.size(); i++){					
					if(addCommoID.get(i).equals(commoID)){	
						addCommoID.remove(i);
					}
				}
				
				DefaultTableModel model = (DefaultTableModel)table2.getModel();
				model.removeRow(table2.getSelectedRow());
			}
		}
			
		if(events.getSource() == showAll){
			button_showAll.doClick();
		}
		
		if(events.getSource() == button_finish){
			
			commoList.clear();

			if(table2.isEditing())
				table2.getCellEditor().stopCellEditing();
			
			Boolean flag = true;
			
			if(addCommoID.size() == 0){
				WarningFrame wf = new WarningFrame("请选择需要添加的商品!");
				wf.setVisible(true);
			}else{
				
				for(int j = 0; j < addCommoID.size(); j++){
					if(Integer.parseInt((String) table2.getValueAt(j, 3))<= 0){
						flag = false;
					}
				}
				
				if(flag == false){
					WarningFrame wf = new WarningFrame("商品数量不能为0!");
					wf.setVisible(true);
				}else{
					this.setVisible(false);
					Frame_Salesman.visibleFalse(11);
					Frame_Salesman.visibleTrue(11);
						
					for(int i = 0; i < addCommoID.size(); i++){
						for(int j = 0; j < addCommoID.size(); j++){
							if(addCommoID.get(i).equals(table2.getValueAt(j, 0))){
								commoList.add(new CommodityItemVO((String)table2.getValueAt(j, 0)
										,Integer.parseInt((String) table2.getValueAt(j, 3)
												),Double.parseDouble((String) table2.getValueAt(j, 4)),
												(String)table2.getValueAt(j, 5),(String)table2.getValueAt(j, 1)
												,(String)table2.getValueAt(j, 2)));
							}
						}
					}	
					
					note = tf.getText();
					if(note.equals(null))
						note = "无";
					SaleBackFinal.showText.doClick();
				}
			}
		}	
	}
	
	public String getSortName(String ID){
		CommoditySortBLService controller = new CommoditySortController();
		ArrayList<CommoditySortVO> list = controller.show();
		
		for(int i = 1; i < list.size(); i++){
			if(list.get(i).ID.equals(ID)){
				return list.get(i).name;
			}
		}
		return null;
	}
	
	private int addCommo(ArrayList<CommodityItemVO> commodities){
		
		Boolean flag = false;
		
		for(int j = 0; j < commodities.size(); j++){
			for(int i = 0; i < clientCommoList.size(); i++){
				if(commodities.get(j).ID.equals(clientCommoList.get(i).ID)){
					flag = true;
				}
			}
			
			if(flag == false){
				clientCommoList.add(commodities.get(j));
			}
		}
		return commodities.size();
	}
			
	private String getClient(){
		String str = "";
		ClientBLService controller = new ClientController();
		for(int i = 0; i < controller.show().size(); i++){
			if(!controller.show().get(i).category.equals(ClientCategory.PURCHASE_PERSON))
				str = str + controller.show().get(i).name + ";";
		}
		return str;
	}
	
	public static void ClearAll(){
		commoList.clear();
		clientCommoList.clear();
	}
	
}

