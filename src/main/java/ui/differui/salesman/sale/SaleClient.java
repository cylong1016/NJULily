package ui.differui.salesman.sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import ui.differui.salesman.frame.Frame_Salesman;
import vo.client.ClientVO;
import vo.commodity.CommodityItemVO;
import vo.promotion.PromotionClientVO;
import vo.promotion.PromotionTotalVO;
import blservice.clientblservice.ClientBLService;
import blservice.saleblservice.SaleBLService;
import businesslogic.clientbl.ClientController;
import businesslogic.salebl.SaleController;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;

public class SaleClient extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_add, button_cam, button_del, button_search, button_choose;
	MyTable table, table2;
	public static MyJButton button_showAll;
	public static JButton button_delete;
	MyComboBox comboBox;
	MyTextField textField, tf_client, tf_inven, ta, tf_ticket;
	
	String deleteID = "";
	public static String ClientName, ClientID, note;
	static double  allowance, voucher;
	
	ClientBLService controller;
	
	public SaleClient(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		
		controller = new ClientController();
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		JLabel infoBar = new JLabel("制定销售单 - 完善信息");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.WHITE);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"};
		comboBox = new MyComboBox(75, 70 - 10, 200, 25,comboBoxStr);
		comboBox.setBackground(backColor);
		comboBox.setForeground(foreColor);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		textField = new MyTextField(300, 70 - 10, 200, 25);
		textField.setText("  在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		this.add(textField);
		
		//add a button for starting the searching process
		button_search = new MyJButton("搜索");
		button_search.setBounds(525, 70 - 10, 130, 25);
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
		
		button_delete = new JButton();
		button_delete.addActionListener(this);
		this.add(button_delete);
		
		//add a table for showing the information of the clients(the table is contained in a scroll pane)
		String[] headers = {"客户编号","客户分类","客户星级"
				,"客户名称","默认业务员","应收付差额","应收","应付","应付额度"};
		table = new MyTable(headers);
		
		JScrollPane jsp = new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(backColor);
		head.setForeground(foreColor);
		jsp.setBounds(75, 120 - 10, 1125, 450 - 235 + 180 - 230);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		JLabel wordx = new JLabel("可供选择的促销有：");
		wordx.setBounds(75, 120 - 10 + 230 - 52, 120, 25);
		wordx.setBackground(null);
		wordx.setForeground(Color.WHITE);
		wordx.setVisible(true);
		this.add(wordx);
		
		String[] headersClient = {"编号","起始时间","结束时间","条件","应送赠品","折扣","代金券"};
		table2 = new MyTable(headersClient);
		JScrollPane jsp2 = new JScrollPane(table2);
		JTableHeader head2 = table2.getTableHeader();
		head2.setBackground(backColor);
		head2.setForeground(foreColor);
		jsp2.setBounds(75, 120 - 10 + 230 - 10, 1125, 450 - 235 + 180 - 220);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setBorder(BorderFactory.createEmptyBorder());
		jsp2.setVisible(true);
		this.add(jsp2);
		
		//add a button for adding a new client
		button_add = new MyJButton("上一步");
		button_add.setBounds(75, 610 - 26 - 10, 130, 25);
		button_add.setBackground(backColor);
		button_add.setForeground(foreColor);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		JLabel word = new JLabel("本货单的客户为：");
		word.setBounds(230 + 360, 600 - 26 - 235 + 180 - 230, 120, 25);
		word.setBackground(null);
		word.setForeground(Color.WHITE);
		word.setVisible(true);
		this.add(word);
		
		tf_client = new MyTextField(360 + 360, 600 - 26 - 235 + 180 - 230, 140 + 90, 25);
		tf_client.setText("无");
		tf_client.setEditable(false);
		tf_client.setVisible(true);
		tf_client.setForeground(foreColor);
		tf_client.setBackground(backColor);
		tf_client.setHorizontalAlignment(JTextField.CENTER);
		this.add(tf_client);
		
		JLabel word2 = new JLabel("折让数额：");
		word2.setBounds(75, 600 - 26 - 235 + 180, 120, 25);
		word2.setBackground(null);
		word2.setForeground(Color.WHITE);
		word2.setVisible(true);
		this.add(word2);
		
		tf_inven = new MyTextField(155, 600 - 26 - 235 + 180, 120, 25);
		tf_inven.setVisible(true);
		tf_inven.setForeground(foreColor);
		tf_inven.setBackground(backColor);
		tf_inven.setHorizontalAlignment(JTextField.CENTER);
		this.add(tf_inven);
		
		JLabel word4 = new JLabel("元");
		word4.setBounds(285, 600 - 26 - 235 + 180, 40, 25);
		word4.setBackground(null);
		word4.setForeground(Color.WHITE);
		word4.setVisible(true);
		this.add(word4);
		
		JLabel word5 = new JLabel("代金券数额：");
		word5.setBounds(75 + 260, 600 - 26 - 235 + 180, 120, 25);
		word5.setBackground(null);
		word5.setForeground(Color.WHITE);
		word5.setVisible(true);
		this.add(word5);
		
		tf_ticket = new MyTextField(150 + 260, 600 - 26 - 235 + 180, 120, 25);
		tf_ticket.setVisible(true);
		tf_ticket.setForeground(foreColor);
		tf_ticket.setBackground(backColor);
		tf_ticket.setHorizontalAlignment(JTextField.CENTER);
		this.add(tf_ticket);
		
		JLabel word6 = new JLabel("元");
		word6.setBounds(285 + 260, 600 - 26 - 235 + 180, 40, 25);
		word6.setBackground(null);
		word6.setForeground(Color.WHITE);
		word6.setVisible(true);
		this.add(word6);
		
		JLabel word3 = new JLabel("货单备注：");
		word3.setBounds(230, 610 - 26 - 10, 120, 25);
		word3.setBackground(null);
		word3.setForeground(Color.WHITE);
		word3.setVisible(true);
		this.add(word3);
		
		ta = new MyTextField(330, 610 - 26 - 10, 620, 25);
		ta.setVisible(true);
		ta.setForeground(foreColor);
		ta.setBackground(backColor);
		ta.setHorizontalAlignment(JTextField.CENTER);
		this.add(ta);
			
		//add a button for checking and modifying the information of a selected client
		button_cam = new MyJButton("选择选中客户");
		button_cam.setBounds(525 + 450 + 15, 610 - 26 - 10 - 235 + 180 - 230, 210, 25);
		button_cam.addActionListener(this);
		button_cam.setBackground(backColor);
		button_cam.setForeground(foreColor);
		this.add(button_cam);	
		
		button_choose = new MyJButton("选择所选促销");
		button_choose.setBounds(525 + 450 + 15, 610 - 26 - 10 - 235 + 180, 210, 25);
		button_choose.addActionListener(this);
		button_choose.setBackground(backColor);
		button_choose.setForeground(foreColor);
		this.add(button_choose);
		
		//add a button for returning to the last UI
		button_return = new MyJButton("生成进货单");
		button_return.setBounds(525 + 450 + 125 - 110, 610 - 26 - 10, 210, 25);
		button_return.addActionListener(this);
		button_return.setBackground(backColor);
		button_return.setForeground(foreColor);
		this.add(button_return);	
			
		// the background
		this.setBackground(null);
		
	}
	
	private String getLevel(ClientLevel level){
		if(level.equals(ClientLevel.LEVEL_1)){
			return "一星级";
		}else if(level.equals(ClientLevel.LEVEL_2)){
			return "二星级";
		}else if(level.equals(ClientLevel.LEVEL_3)){
			return "三星级";
		}else if(level.equals(ClientLevel.LEVEL_4)){
			return "四星级";
		}else{
			return "五星级(VIP)";
		}
	}
	
	private String getAllowance(double d){
		switch(String.valueOf(d)){ 
		case "0.5" : return "5折";
		case "0.98" : return "98折";
		case "0.95": return "95折";
		case "0.9" : return "9折";
		case "0.88" : return "88折";
		case "0.85" : return "85折";
		case "0.8" : return "8折";
		case "0.79" : return "79折";
		case "0.75" : return "75折";
		case "0.7" : return "7折";
		case "0.65" : return "65折";
		case "0.6" : return "6折";
		case "0.58" : return "58折";
		default:return "无折扣";
		}
	}
	
	public void actionPerformed(ActionEvent events) {
			
		if(events.getSource() == button_add){
			this.setVisible(false);
			Frame_Salesman.visibleTrue(4);
		}
		
		/////////////////////////////FUNCTION SHOWALL////////////////////////////
		
		if(events.getSource() == button_showAll){
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
			int rowCount = table.getRowCount();
			
			for(int i = 0; i < rowCount; i++)
				tableModel.removeRow(0);
		
			controller = new ClientController();
			
			for(int i = 0; i < controller.show().size(); i++){
				ClientVO cvo = controller.show().get(i);
				
				if(!cvo.category.toString().equals("PURCHASE_PERSON")){
					String[] str = {cvo.ID, getCategory(cvo.category.toString()), getLevel(cvo.level.toString())
							, cvo.name,cvo.salesman,String.valueOf(cvo.receivable - cvo.payable)
							,String.valueOf(cvo.receivable), String.valueOf(cvo.payable),String.valueOf(cvo.receivableLimit)};
					tableModel.addRow(str);
				}
			}		
		}
		
		
		/////////////////////////////FUNCTION CAM////////////////////////////
		
		if(events.getSource() == button_choose){
			if(table2.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请选择需要添加的促销策略！");
				wf.setVisible(true);
			}else{
				SaleBLService controller = new SaleController();
				controller.getSaleID();
				
				ArrayList<CommodityItemVO> list = SaleGood.commoList;
				
				for(int i = 0; i < list.size(); i++)
					controller.addCommodities(list.get(i));
				
				controller.addClient(ClientID);
				
				String proID = (String)table2.getValueAt(0, table2.getSelectedRow());
				
				tf_inven.setText(String.valueOf(controller.setPromotion(proID)));
				
				ta.setText("使用了促销" + proID);
			}
		}

		if(events.getSource() == button_cam){
			if(table.getSelectedRow() < 0){
				WarningFrame wf = new WarningFrame("请选择一个客户！");
				wf.setVisible(true);
			}else{
				tf_client.setText((String)table.getValueAt(table.getSelectedRow(), 3));
				ClientName = (String)table.getValueAt(table.getSelectedRow(), 3);
				ClientID = (String)table.getValueAt(table.getSelectedRow(), 0);
				
				ArrayList<CommodityItemVO> list = SaleGood.commoList;
				
				SaleBLService controller = new SaleController();
				controller.getSaleID();
				
				for(int i = 0; i < list.size(); i++)
					controller.addCommodities(list.get(i));
				
				controller.addClient(ClientID);
				
				ArrayList<PromotionClientVO> clientList = controller.findFitPromotionClient();
				ArrayList<PromotionTotalVO> totalList = controller.findFitPromotionTotal();
				
				DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
				int rowCount = tableModel.getRowCount();
				for(int i = 0; i < rowCount; i++){
					tableModel.removeRow(0);
				}
				
				if(clientList != null){
					for(int i = 0; i < clientList.size(); i++){
						PromotionClientVO vo = clientList.get(i);
						if(vo.gifts.size() > 0){
							Object[] rowData = {vo.ID, vo.beginDate, vo.endDate, getLevel(vo.level)
									, vo.gifts.get(0).name + "(" + vo.gifts.get(0).number + "件)"
									, getAllowance(vo.allowance), vo.voucher + "元"};
							tableModel.addRow(rowData);
						}else{
							Object[] rowData = {vo.ID, vo.beginDate, vo.endDate, getLevel(vo.level)
									, "无", getAllowance(vo.allowance), vo.voucher + "元" };
							tableModel.addRow(rowData);
						}
					}
				}
				
				if(totalList != null){
					for(int i = 0; i < totalList.size(); i++){
						PromotionTotalVO vo = totalList.get(i);
						if(vo.gifts.size() > 0){
							Object[] rowData = {vo.ID, vo.beginDate, vo.endDate, vo.total + "元"
									, vo.gifts.get(0).name + "(" + vo.gifts.get(0).number + "件)"
									, getAllowance(vo.allowance), vo.voucher + "元"};
							tableModel.addRow(rowData);
						}else{
							Object[] rowData = {vo.ID, vo.beginDate, vo.endDate, vo.total + "元"
									, "无", getAllowance(vo.allowance), vo.voucher + "元" };
							tableModel.addRow(rowData);
						}
					}
				}
				
			}
		}
		
		if(events.getSource() == button_return){
			if(tf_client.getText().equals("无")){
				WarningFrame wf = new WarningFrame("请选择一个客户！");
				wf.setVisible(true);
			}else{
				
				Frame_Salesman.visibleTrue(10);
				this.setVisible(false);
				note = ta.getText();
				
				if(tf_inven.getText().isEmpty()){
					allowance = 0;
				}else{
					allowance = Double.parseDouble(tf_inven.getText());
				}

				if(tf_ticket.getText().isEmpty()){
					voucher = 0;
				}else{
					voucher = Double.parseDouble(tf_ticket.getText());
				}
				
				SaleFinal.showText.doClick();
				
			}
		}
		
		/////////////////////////////SEARCH////////////////////////////
		if(events.getSource() == button_search){
			if(comboBox.getSelectedIndex() == 0){
				
				WarningFrame wf = new WarningFrame("请选择一种搜索方式");
				wf.setVisible(true);
				
			}else{
				
				controller = new ClientController();
				ArrayList<ClientVO> list = controller.findClient(textField.getText(), getType(comboBox.getSelectedIndex()));
				
				if(list.size() == 0){
					WarningFrame wf = new WarningFrame("没有符合条件的客户！");
					wf.setVisible(true);
				}else{
					
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					
					int rowCount = table.getRowCount();
					for(int k = 0; k < rowCount; k++)
						tableModel.removeRow(0);
													
					for(int i = 0; i < list.size(); i++){
										
						ClientVO cvo = list.get(i);
						
						if(!cvo.category.toString().equals("PURCHASE_PERSON")){
							String[] str = {cvo.ID, getCategory(cvo.category.toString()), getLevel(cvo.level.toString())
									, cvo.name,cvo.salesman,String.valueOf(cvo.receivable - cvo.payable)
									,String.valueOf(cvo.receivable), String.valueOf(cvo.payable),String.valueOf(cvo.receivableLimit)};
							tableModel.addRow(str);
						}
						
					}	
								
					WarningFrame wf = new WarningFrame("共有  " + table.getRowCount() + "  名客户符合条件！");
					wf.setVisible(true);
				}
				
				
			}
		}
	}
	
	// "模糊查找", "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"
	
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
