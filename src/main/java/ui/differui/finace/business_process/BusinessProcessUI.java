package ui.differui.finace.business_process;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;







import dataenum.BillType;
import dataenum.Storage;
import blservice.clientblservice.ClientBLService;
import blservice.recordblservice.RecordBLService;
import blservice.userblservice.UserBLService;
import businesslogic.clientbl.ClientController;
import businesslogic.recordbl.RecordController;
import businesslogic.userbl.UserController;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;

public class BusinessProcessUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyComboBox cbb_sort, cbb_client, cbb_user;
	MyJButton button_check;
	
	JButton bt_modify, bt_check, bt_out, bt_del;
	JTextArea ta;
	
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	
	MyTable table;
	DefaultTableModel model;
	
	Color foreColor = new Color(158, 213, 220);
	Color backColor = new Color(46, 52, 101);
	
	public BusinessProcessUI(){
		
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
		
		if(events.getSource() == button_check){
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
			
			//String beginDate, String endDate, BillType billType, String clientName, String salesman, Storage storage
			//controller.bussinessPro(new BusinessStateInputInfo(beginDate, endDate, ));
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
		
		String[] headers = {"单据种类", "单据编号"};
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
		
		bt_check = new JButton("查看所选单据内容");
		bt_check.setBounds(305, 572, 180, 25);
		bt_check.addActionListener(this);
		bt_check.setBackground(Color.WHITE);
		bt_check.setForeground(backColor);
		bt_check.setVisible(true);
		this.add(bt_check);
		
		bt_modify = new JButton("红冲操作");
		bt_modify.setBounds(520, 572, 180, 25);
		bt_modify.addActionListener(this);
		bt_modify.setBackground(Color.WHITE);
		bt_modify.setForeground(backColor);
		bt_modify.setVisible(true);
		this.add(bt_modify);
		
		bt_del = new JButton("红冲并复制");
		bt_del.setBounds(755, 572, 180, 25);
		bt_del.addActionListener(this);
		bt_del.setBackground(Color.WHITE);
		bt_del.setForeground(backColor);
		bt_del.setVisible(true);
		this.add(bt_del);
		
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
}
