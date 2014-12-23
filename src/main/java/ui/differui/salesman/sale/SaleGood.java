package ui.differui.salesman.sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.myui.MyTree;
import ui.commonui.warning.WarningFrame;
import ui.differui.salesman.frame.Frame_Salesman;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommoditySortVO;
import vo.commodity.CommodityVO;
import blservice.commodityblservice.CommodityBLService;
import blservice.commoditysortblservice.CommoditySortBLService;
import businesslogic.commoditybl.CommodityController;
import businesslogic.commoditysortbl.CommoditySortController;
import dataenum.FindTypeCommo;

public class SaleGood extends MyPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_sort;
	MyJButton button_del2;

	static MyJButton button_showAll;

	MyJButton button_search;

	MyJButton button_del, button_add, button_finish;
	
	public static JButton button_close, showAll;
	
	JScrollPane jsp;
	MyTree tree;
	MyTable table, table2;
	MyComboBox comboBox;
	MyTextField textField;
	
	static String deleteID;
	int clickTime = 0;
	
	ArrayList<String> addCommoID;
	public static ArrayList<CommodityItemVO> commoList;
	
 	public SaleGood(){

		int y = 10;
		
		addCommoID = new ArrayList<String>();
		commoList = new ArrayList<CommodityItemVO>();
		commoList.clear();
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);

		JLabel infoBar = new JLabel("制定销售单 - 选择商品");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.WHITE);
		infoBar.setOpaque(false);
		this.add(infoBar);
				
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("所有商品分类"); 
		tree = new MyTree(root); 
					
		jsp = new JScrollPane(tree);
		jsp.getViewport().add(tree, null);
		jsp.setBounds(50 + 33, 60 + y, 225, 425 + 61);
		jsp.setVisible(true);
		this.add(jsp);
			
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "商品编号(ID)",  "商品分类", "商品名称"};
		comboBox = new MyComboBox(25 + 190 + 120, 60 + y, 200, 25,comboBoxStr);
		comboBox.setForeground(foreColor);
		comboBox.setBackground(backColor);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		textField = new MyTextField(235 + 190 + 120, 60 + y, 200, 25);
		textField.setText("在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		//add a button for starting the searching process
		button_search = new MyJButton("搜索");
		button_search.setBounds(445 + 190 + 120, 60 + y, 130, 25);
		button_search.addActionListener(this);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		button_finish = new MyJButton("下一步");
		button_finish.setBounds(944 + 150 - 30, 563 + y, 130, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);	
		
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
		
		JTableHeader head2 = table.getTableHeader();
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
		button_sort = new MyJButton("查看所选分类下的商品");
		button_sort.setBounds(50 + 33, 563 + y, 225, 25);
		button_sort.addActionListener(this);
		this.add(button_sort);	
		
		button_showAll = new MyJButton("显示全部商品");
		button_showAll.setBounds(944 + 150 - 30, 60 + y, 130, 25);
		button_showAll.addActionListener(this);
		this.add(button_showAll);
			
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
						
		showAll = new JButton();
		showAll.addActionListener(this);
		this.add(showAll);
		
		showAll.doClick();
	}
		
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
						
		if(events.getSource() == button_showAll){
			
			clickTime++;
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
			int rowCount = table.getRowCount();
			for(int k = 0; k < rowCount; k++)
				tableModel.removeRow(0);
			
			CommodityBLService controller = new CommodityController();
			
			for(int i = 0; i < controller.show().size(); i++){
				CommodityVO cvo = controller.show().get(i);
				
				//"商品编号","商品分类","商品名称","商品型号","库存数量"
				String[] str = {cvo.ID, getSortName(cvo.sortID), cvo.name, cvo.type, String.valueOf(cvo.inventoryNum)};
				tableModel.addRow(str);
			}		
			
			if(table.getRowCount() == 0 && clickTime != 1){
				WarningFrame wf = new WarningFrame("现在暂时没有商品");
				wf.setVisible(true);
			}
		}
		
		if(events.getSource() == button_search){
			
			if(comboBox.getSelectedIndex() == 0){
				
				WarningFrame wf = new WarningFrame("请选择一种搜索方式");
				wf.setVisible(true);
				
			}else{
				
				CommodityBLService controller = new CommodityController();
				ArrayList<CommodityVO> list = controller.findCommo(textField.getText()
						, getType(comboBox.getSelectedIndex()));
				
				if(list.size() == 0){
					WarningFrame wf = new WarningFrame("没有符合条件的商品！");
					wf.setVisible(true);
				}else{
					
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					
					int rowCount = table.getRowCount();
					for(int k = 0; k < rowCount; k++)
						tableModel.removeRow(0);
										
					for(int i = 0; i < list.size(); i++){
										
						CommodityVO cvo = list.get(i);
						
						String[] str = {cvo.ID, getSortName(cvo.sortID), cvo.name, cvo.type, String.valueOf(cvo.inventoryNum)};
						tableModel.addRow(str);
						
					}	
								
					WarningFrame wf = new WarningFrame("共有  " + list.size() + "  件商品符合条件！");
					wf.setVisible(true);
				}
			}
		}
		
		if(events.getSource() == button_add){
			
			if(table.getSelectedRow() < 0){
				WarningFrame wf = new WarningFrame("请选择一个欲添加的商品！");
				wf.setVisible(true);
			}else{
				if(Double.parseDouble((String)table.getValueAt(table.getSelectedRow(), 4)) == 0){
					WarningFrame wf = new WarningFrame("无法添加库存为0的商品！");
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
					Frame_Salesman.visibleFalse(9);
					Frame_Salesman.visibleTrue(9);
						
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
		
	private FindTypeCommo getType(int i){
		switch(i){
			case 1: return null;
			case 2: return FindTypeCommo.ID;
			case 3: return FindTypeCommo.SORT;
			default: return FindTypeCommo.NAME;
		}
	}
	
	public static void ClearAll(){
		commoList.clear();
	}
	
}
