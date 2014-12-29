package ui.differui.manager.business_process;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import dataenum.BillType;
import blservice.clientblservice.ClientBLService;
import blservice.recordblservice.BusinessStateInputInfo;
import blservice.recordblservice.RecordBLService;
import blservice.userblservice.UserBLService;
import businesslogic.clientbl.ClientController;
import businesslogic.recordbl.RecordController;
import businesslogic.userbl.UserController;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.text_conductor.TextConductor;
import ui.commonui.warning.WarningFrame;
import vo.ValueObject;

public class BusinessProcessUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static String theName = null;
	
	MyComboBox cbb_sort, cbb_client, cbb_user;
	MyJButton button_check;
	
	JButton bt_modify, bt_check, bt_out, bt_del, bt_see;
	JTextArea ta;
	
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	
	MyTable table;
	DefaultTableModel model;
	
	Color foreColor = new Color(158, 213, 220);
	Color backColor = new Color(46, 52, 101);
	
	static ArrayList<ValueObject> listPool;
	
	public BusinessProcessUI(){
		
		listPool = new ArrayList<ValueObject>();
		
		int y = 420;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		JLabel infoBar = new JLabel("经营历程表");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		String[] comboBoxStr = {"全部种类", "进货类单据", "销售类单据", "财务类单据", "库存类单据", "现金类单据"};
		cbb_sort = new MyComboBox(85, 56, 130, 25, comboBoxStr);
		this.add(cbb_sort);
		
		cbb_client = new MyComboBox(85 + 135, 56, 130, 25, getAllClient());
		cbb_client.setEditable(true);
		this.add(cbb_client);
		
		cbb_user = new MyComboBox(85 + 270, 56, 130, 25, getAllUser());
		cbb_user.setEditable(true);
		this.add(cbb_user);
		
		JLabel word_4 = new JLabel("选择查看时间段:    ");
		word_4.setForeground(Color.WHITE);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(80 + y, 50 + 6, 120, 25);
		this.add(word_4);
		
		//text fields
		tf_year1 = new MyTextField(27 + 176 + y, 55 + 6, 50, 15);
		this.add(tf_year1);
		
		JLabel word_year1 = new JLabel("年");
		word_year1.setForeground(Color.WHITE);
		word_year1.setBackground(new Color(0, 0, 0, 0));
		word_year1.setBounds(87 + 176 + y, 55 + 6, 20, 15);
		this.add(word_year1);
		
		tf_month1 = new MyTextField(110 + 176 + y, 55 + 6, 30, 15);
		this.add(tf_month1);
		
		JLabel word_month1 = new JLabel("月");
		word_month1.setForeground(Color.WHITE);
		word_month1.setBackground(new Color(0, 0, 0, 0));
		word_month1.setBounds(150 + 176 + y, 55 + 6, 20, 15);
		this.add(word_month1);
		
		tf_day1 = new MyTextField(170 + 176 + y, 55 + 6, 30, 15);
		this.add(tf_day1);
		
		JLabel word_day1 = new JLabel("日     ~     ");
		word_day1.setForeground(Color.WHITE);
		word_day1.setBackground(new Color(0, 0, 0, 0));
		word_day1.setBounds(210 + 176 + y, 55 + 6, 70, 15);
		this.add(word_day1);
		
		int x = 235 + 176 + y;
		
		tf_year2 = new MyTextField(27 + x, 55 + 6, 50, 15);
		this.add(tf_year2);
		
		JLabel word_year2 = new JLabel("年");
		word_year2.setForeground(Color.WHITE);
		word_year2.setBackground(new Color(0, 0, 0, 0));
		word_year2.setBounds(87 + x, 55 + 6, 20, 15);
		this.add(word_year2);
		
		tf_month2 = new MyTextField(110 + x, 55 + 6, 30, 15);
		this.add(tf_month2);
		
		JLabel word_month2 = new JLabel("月");
		word_month2.setForeground(Color.WHITE);
		word_month2.setBackground(new Color(0, 0, 0, 0));
		word_month2.setBounds(150 + x, 55 + 6, 20, 15);
		this.add(word_month2);
		
		tf_day2 = new MyTextField(170 + x, 55 + 6, 30, 15);
		this.add(tf_day2);
		
		JLabel word_day2 = new JLabel("日");
		word_day2.setForeground(Color.WHITE);
		word_day2.setBackground(new Color(0, 0, 0, 0));
		word_day2.setBounds(210 + x, 55 + 6, 80, 15);
		this.add(word_day2);
		
		button_check = new MyJButton("查看");
		button_check.setBounds(250 + x, 50 + 6, 90, 25);
		button_check.addActionListener(this);
		this.add(button_check);
		
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
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_see){
			if(table.getSelectedRowCount() == 0){
				WarningFrame wf = new WarningFrame("请先选择需要查看的单据！");
				wf.setVisible(true);
			}else{
				TextConductor writer = new TextConductor();
				
				
				
				String name = table.getValueAt(table.getSelectedRow(), 1).toString();
				theName = name;
				
				String[] type = name.split("-");
				BillType billtype = null;
				System.out.print(type[0]);
				switch(type[0]){
					case "JHD" : billtype = BillType.PURCHASE;break;
					case "JHTHD" : billtype = BillType.PURCHASEBACK;break;
					case "XSD" : billtype = BillType.SALE;break;
					case "XSTHD" : billtype = BillType.SALEBACK;break;
					case "ZSD" : billtype = BillType.GIFT;break;
					case "BYD" : billtype = BillType.OVERFLOW;break;
					case "BSD" : billtype = BillType.LOSS;break;
					//case "BZD" : billtype = BillType.ALARM;break;
					case "SKD" : billtype = BillType.EXPENSE;break;
					case "FKD" : billtype = BillType.PAY;break;
					case "XJFYD" : billtype = BillType.CASH;break;
				}
				ta.setText(writer.writeBill(billtype, listPool.get(table.getSelectedRow())));
			}
		}
		
		if(events.getSource() == button_check){
			
			listPool.clear();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			int rowCount = table.getRowCount();
			for(int i = 0; i < rowCount; i++){
				tableModel.removeRow(0);
			}
		
			RecordBLService controller = new RecordController();
			
			String beginDate, endDate;
			
			if(tf_year1.getText().isEmpty() || tf_year2.getText().isEmpty() 
					|| tf_month1.getText().isEmpty() || tf_month2.getText().isEmpty()
					 || tf_day1.getText().isEmpty() || tf_day2.getText().isEmpty()){
				beginDate = null;
				endDate = null;
			}else{
				beginDate = yearAddZero(tf_year1.getText()) + addZero(tf_month1.getText()) + addZero(tf_day1.getText());
				endDate = yearAddZero(tf_year2.getText()) + addZero(tf_month2.getText()) + addZero(tf_day2.getText());
			}
			
			ArrayList<BillType> billTypes = new ArrayList<BillType>();;
			
			switch(cbb_sort.getSelectedIndex()){
			case 0: billTypes.add(BillType.PURCHASE);
					billTypes.add(BillType.PURCHASEBACK);
					billTypes.add(BillType.SALE);
					billTypes.add(BillType.SALEBACK);
					billTypes.add(BillType.EXPENSE);
					billTypes.add(BillType.PAY);
					billTypes.add(BillType.OVERFLOW);
					billTypes.add(BillType.LOSS);
					billTypes.add(BillType.GIFT);
					billTypes.add(BillType.CASH);break;
			case 1: billTypes.add(BillType.PURCHASE);
					billTypes.add(BillType.PURCHASEBACK);break;
			case 2: billTypes.add(BillType.SALE);
					billTypes.add(BillType.SALEBACK);break;
			case 3: billTypes.add(BillType.EXPENSE);
					billTypes.add(BillType.PAY);break;
			case 4: billTypes.add(BillType.OVERFLOW);
					billTypes.add(BillType.LOSS);
					billTypes.add(BillType.GIFT);break;
			case 5: billTypes.add(BillType.CASH);break;
			}
			
			String clientName = null;
			if(cbb_client.getSelectedIndex() != 0)
				clientName = cbb_client.getSelectedItem().toString();
			
			String salesman = null;
			if(cbb_user.getSelectedIndex() != 0)
				clientName = cbb_client.getSelectedItem().toString();
					
			ArrayList<ValueObject> list = new ArrayList<ValueObject>();
			
			//String beginDate, String endDate, BillType billType, String clientName, String salesman, Storage storage
			for(int i = 0; i < billTypes.size() ; i++){
				ArrayList<ValueObject> currentList = controller.bussinessPro(new BusinessStateInputInfo(beginDate, endDate, 
						billTypes.get(i), clientName, salesman, null));
					if(currentList != null)
						for(int k = 0; k < currentList.size(); k++){
							list.add(currentList.get(k));
							listPool.add(currentList.get(k));
						}
			}
			
			if(list != null)
				for(int i = 0; i < list.size(); i++){
					Object[] rowData = {i + 1, list.get(i).ID}; 
					tableModel.addRow(rowData);
				}
			
			if(table.getRowCount() == 0){
				WarningFrame wf = new WarningFrame("目前没有符合条件的单据！");
				wf.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_out){
			if(theName != null){
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file = String.valueOf(fsv.getHomeDirectory()) + "/" + theName + ".txt";		
				System.out.print(file);
				writeto(ta.getText().replaceAll("\n", "\r\n"),file);
				
				WarningFrame wf = new WarningFrame("已成功导出至桌面！ ");
				wf.setVisible(true);
			}
		}
		
	}
	
	private String[] getAllClient(){
		ClientBLService controller = new ClientController();
		String str = "全部客户;";
		for(int i = 0; i < controller.show().size(); i++){
			str = str + controller.show().get(i).name + ";";
		}
		return str.split(";");
	}
	
	private String[] getAllUser(){
		UserBLService controller = new UserController();
		String str = "全部操作员;";
		for(int i = 0; i < controller.show().size(); i++){
			str = str + controller.show().get(i).name + ";";
		}
		return str.split(";");
	}
	
	private void initTable(){
		
		String[] headers = {"序号", "单据编号"};
		table = new MyTable(headers);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(0).setMaxWidth(110);
		table.getColumnModel().getColumn(0).setMinWidth(110);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(85, 95, 400, 465);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);	
	}
	
	private void initButtons(){
		
		bt_see = new JButton("查看所选单据内容");
		bt_see.setBounds(305, 572, 180, 25);
		bt_see.addActionListener(this);
		bt_see.setBackground(Color.WHITE);
		bt_see.setForeground(backColor);
		bt_see.setVisible(true);
		this.add(bt_see);
			
		bt_out = new JButton("导出单据至桌面");
		bt_out.setBounds(755 + 235, 572, 180, 25);
		bt_out.addActionListener(this);
		bt_out.setBackground(Color.WHITE);
		bt_out.setForeground(backColor);
		bt_out.setVisible(true);
		this.add(bt_out);
	}
	
	private String addZero(String str){
		if(Integer.parseInt(str) < 10){
			return "0" + str;
		}else{
			return str;
		}
	}
	private String yearAddZero(String str){
		if(Integer.parseInt(str) < 10){
			return "000" + str;
		}else{
			if(Integer.parseInt(str) < 100){
				return "00" + str;
			}else{
				if(Integer.parseInt(str) < 1000){
					return "0" + str;
				}else{
					return str;
				}
			}
		}
	}
	
	private void writeto(String a,String file){
		
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
