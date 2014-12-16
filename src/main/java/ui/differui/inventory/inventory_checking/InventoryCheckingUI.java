package ui.differui.inventory.inventory_checking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import blservice.commodityblservice.CommodityBLService;
import blservice.inventoryblservice.InventoryBLService;
import businesslogic.commoditybl.CommodityController;
import businesslogic.inventorybl.InventoryController;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.frame.Frame_Inventory;
import vo.InventoryCheckVO;
import vo.commodity.CheckCommodityItemVO;
import vo.commodity.CommodityVO;

public class InventoryCheckingUI extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_finish, button_check;
	
	public static JButton button_close;
	
	String no = "";
	String date = "";
	
	MyTable table;
	ArrayList<CommodityVO> list;

	public InventoryCheckingUI(){
		
		list = new ArrayList<CommodityVO>();
		
//		Color foreColor = new Color(158, 213, 220);
//		Color backColor = new Color(46, 52, 101);
				
		JLabel word_4 = new JLabel("*表格中商品批号、批次、出厂日期以及实际数量请在导出后根据盘点实际情况进行填写！");
		word_4.setForeground(Color.RED);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(76, 50, 600, 25);
		this.add(word_4);
			
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);

		JLabel infoBar = new JLabel("制定赠送单 - 选择商品");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		//adding the table 
		String[] headers = {"行号","商品编号","商品名称"
				,"商品型号","库存均价","批号","批次","出厂日期","库存数量","实际数量"};
		table = new MyTable(headers);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(25 + 55, 50 + 20 + 14, 1120, 470);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
			
		//button to check the information of the selected item
		button_check = new MyJButton("查看选中商品详细信息");
		button_check.setBounds(200 + 435 + 110 + 125 + 15 - 140, 610 + 20 - 55 - 5, 190, 25);
		button_check.addActionListener(this);
		this.add(button_check);
			
		//button to finish checking
		button_finish = new MyJButton("完成创建盘点单并导出至EXCEL");
		button_finish.setBounds(390 + 450 + 110 + 125 + 15 - 140, 610 + 20 - 55 - 5, 250, 25);
		button_finish.addActionListener(this);
		this.add(button_finish);	
		
		
		//add a button for returning to the last UI
		button_return = new MyJButton("刷新");
		button_return.setBounds(515 + 450 + 110 + 15, 610 + 20 - 55 - 525, 110, 25);
		button_return.addActionListener(this);
		this.add(button_return);	
				
		button_close = new JButton();
		button_close.addActionListener(this);
		this.add(button_close);
		
		showAll();
	
	}
	
	public void actionPerformed(ActionEvent events) {
				
		if(events.getSource() == button_return){
			showAll();
		}
		
		if(events.getSource() == button_close){
			this.setVisible(false);
		}
		
		if(events.getSource() == button_check){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择一个商品");
				wf.setVisible(true);
			}else{
				CommodityDetailUI2 cdu = new CommodityDetailUI2(list.get(table.getSelectedRow()).ID);
				cdu.setVisible(true);
			}
		}
		
		if(events.getSource() == button_finish){
			if(table.getRowCount() == 0){
				WarningFrame wf = new WarningFrame("暂时没有需要进行盘点的商品");
				wf.setVisible(true);
			}else{
				Frame_Inventory.setTable(table);
			}
		}
	}
	
	public void showAll(){
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowCount = table.getRowCount();
		
		for(int i = 0; i < rowCount; i++){
			tableModel.removeRow(0);
		}
			
		list.clear();
		
		InventoryBLService controller = new InventoryController();
		InventoryCheckVO vo = controller.checkRecord();
		CommodityBLService commoController = new CommodityController();
		ArrayList<CommodityVO> commoVO = commoController.show();
		ArrayList<CheckCommodityItemVO> checkVO = vo.commodities;
	
		
		for(int i = 0; i < checkVO.size(); i++){
			for(int j = 0; j < commoVO.size(); j++){
				if(commoVO.get(j).name.equals(checkVO.get(i).name) 
						&& commoVO.get(j).type.equals(checkVO.get(i).type)){
					
					CommodityVO good = commoVO.get(j);
					list.add(commoVO.get(j));
					
					String[] str = {String.valueOf(i + 1), good.ID, good.name,
							 good.type, String.valueOf(good.avePur), "", "", "", String.valueOf(good.inventoryNum),""}; 
					
					tableModel.addRow(str);
					
					j = commoVO.size();
				}
			}			
		}
	}	
}
