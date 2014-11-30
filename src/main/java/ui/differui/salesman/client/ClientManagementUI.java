package ui.differui.salesman.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dataenum.ClientCategory;
import businesslogic.clientbl.ClientController;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.differui.salesman.frame.Frame_Salesman;
import vo.ClientVO;

public class ClientManagementUI extends Frame_Salesman implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyJButton button_return, button_add, button_cam;
	MyTable table;
	public static MyJButton button_showAll;
	
	static int rowNum;
	
	ClientController controller;
	
	public ClientManagementUI(){
		
		controller = new ClientController();
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(53, 84, 94);
		
		//add a combo box (for choosing the selected way)
		String[] comboBoxStr = {"-------请选择一种搜索方式-------", "模糊查找"
				, "客户编号(ID)", "客户星级", "客户分类", "客户名称", "默认业务员"};
		MyComboBox comboBox = new MyComboBox(75, 70, 200, 25,comboBoxStr);
		comboBox.setBackground(backColor);
		comboBox.setForeground(foreColor);
		this.add(comboBox);
		
		//add a text field (for typing the selected way)
		MyTextField textField = new MyTextField(300, 70, 200, 25);
		textField.setText("  在此输入搜索关键字");
		textField.setBackground(backColor);
		textField.setForeground(foreColor);
		textField.setBorder(BorderFactory.createEmptyBorder());
		this.add(textField);
		
		//add a button for starting the searching process
		MyJButton button_search = new MyJButton("搜索");
		button_search.setBounds(525, 70, 130, 25);
		button_search.addActionListener(this);
		button_search.setBackground(backColor);
		button_search.setForeground(foreColor);
		this.add(button_search);		
		
		//add a button for showing all the client to the table
		button_showAll = new MyJButton("显示全部客户");
		button_showAll.setBounds(1070, 70, 130, 25);
		button_showAll.addActionListener(this);
		button_showAll.setBackground(backColor);
		button_showAll.setForeground(foreColor);
		this.add(button_showAll);	
		
		//add a table for showing the information of the clients(the table is contained in a scroll pane)
		String[] headers = {"客户编号","客户分类","客户星级"
				,"客户名称","默认业务员","应收付差额","应收","应付","应付额度"};
		table = new MyTable(headers);
		
		JScrollPane jsp=new JScrollPane(table);
		JTableHeader head = table.getTableHeader();
		head.setBackground(backColor);
		head.setForeground(foreColor);
		jsp.setBounds(75, 120, 1125, 450);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		//add a button for adding a new client
		button_add = new MyJButton("新增一名客户");
		button_add.setBounds(25 + 420 + 125, 610 - 26, 130, 25);
		button_add.setBackground(backColor);
		button_add.setForeground(foreColor);
		button_add.addActionListener(this);
		this.add(button_add);	
		
		//add a button for deleting a selected client
		MyJButton button_del = new MyJButton("删除所选客户");
		button_del.setBounds(165 + 420 + 125, 610 - 26, 130, 25);
		button_del.addActionListener(this);
		button_del.setBackground(backColor);
		button_del.setForeground(foreColor);
		this.add(button_del);	
		
		//add a button for checking and modifying the information of a selected client
		button_cam = new MyJButton("修改或查看所选客户详细信息");
		button_cam.setBounds(305 + 420 + 125, 610 - 26, 210, 25);
		button_cam.addActionListener(this);
		button_cam.setBackground(backColor);
		button_cam.setForeground(foreColor);
		this.add(button_cam);	
		
		//add a button for returning to the last UI
		button_return = new MyJButton("返回");
		button_return.setBounds(525 + 450 + 125, 610 - 26, 100, 25);
		button_return.addActionListener(this);
		button_return.setBackground(backColor);
		button_return.setForeground(foreColor);
		this.add(button_return);	
			
		// the background
		MyBackground background = new MyBackground("ui/image/salesman/background.png");
		this.add(background);
		
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_add){
			ClientAddingUI window_add = new ClientAddingUI();
			window_add.setVisible(true);
		}
		
		if(events.getSource() == button_cam){
			ClientDetailUI window_cam = new ClientDetailUI();
			window_cam.setVisible(true);
		}
		if(events.getSource() == button_showAll){
			
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
			if(rowNum != 0)
				for(int i = 0; i <= rowNum; i++)
					tableModel.removeRow(0);
			
			rowNum = 0;
			
			controller = new ClientController();
			for(int i = 0; i < controller.show().size(); i++){
				ClientVO cvo = controller.show().get(i);
				
				String[] str = {cvo.ID, getCategory(cvo.category.toString()), getLevel(cvo.level.toString())
						, cvo.name,"",String.valueOf(cvo.receivable - cvo.payable)
						,String.valueOf(cvo.receivable), String.valueOf(cvo.payable),String.valueOf(cvo.receivableLimit)};
				tableModel.addRow(str);
				rowNum = i;
			}		
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
