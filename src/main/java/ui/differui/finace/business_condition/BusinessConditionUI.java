package ui.differui.finace.business_condition;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import blservice.recordblservice.RecordBLService;
import businesslogic.recordbl.RecordController;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import vo.BusinessStateVO;
import vo.SaleDetailVO;

public class BusinessConditionUI extends JLabel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	MyTextField tf_year1, tf_month1, tf_day1, tf_year2, tf_month2, tf_day2;
	MyJButton button_check, button_list;
	MyTable table;

	public BusinessConditionUI(){
	
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		this.setOpaque(false);
		
		int y = 90;
		
		JLabel infoBar = new JLabel("经营情况表");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		JLabel word_4 = new JLabel("选择查看时间段:    ");
		word_4.setForeground(Color.WHITE);
		word_4.setBackground(new Color(0, 0, 0, 0));
		word_4.setBounds(27 + y, 50, 120, 25);
		this.add(word_4);
		
		JLabel word_1 = new JLabel("经营情况:    ");
		word_1.setForeground(Color.WHITE);
		word_1.setBackground(new Color(0, 0, 0, 0));
		word_1.setBounds(27 + y, 115, 120, 25);
		this.add(word_1);
		
		String[] headers = {"序号","科目分类","科目名称","金额"};
		table = new MyTable(headers);
		
		table.getTableHeader().setResizingAllowed(false);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setMaxWidth(180);
		table.getColumnModel().getColumn(1).setMinWidth(180);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(380);
		table.getColumnModel().getColumn(2).setMaxWidth(380);
		table.getColumnModel().getColumn(2).setMinWidth(380);
		
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25 + y + 100, 150, 800, 400);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setVisible(true);
		this.add(jsp);
		
		//text fields
		tf_year1 = new MyTextField(27 + 176 + y, 80, 50, 15);
		this.add(tf_year1);
		
		JLabel word_year1 = new JLabel("年");
		word_year1.setForeground(Color.WHITE);
		word_year1.setBackground(new Color(0, 0, 0, 0));
		word_year1.setBounds(87 + 176 + y, 80, 20, 15);
		this.add(word_year1);
		
		tf_month1 = new MyTextField(110 + 176 + y, 80, 30, 15);
		this.add(tf_month1);
		
		JLabel word_month1 = new JLabel("月");
		word_month1.setForeground(Color.WHITE);
		word_month1.setBackground(new Color(0, 0, 0, 0));
		word_month1.setBounds(150 + 176 + y, 80, 20, 15);
		this.add(word_month1);
		
		tf_day1 = new MyTextField(170 + 176 + y, 80, 30, 15);
		this.add(tf_day1);
		
		JLabel word_day1 = new JLabel("日     ~     ");
		word_day1.setForeground(Color.WHITE);
		word_day1.setBackground(new Color(0, 0, 0, 0));
		word_day1.setBounds(210 + 176 + y, 80, 70, 15);
		this.add(word_day1);
		
		int x = 235 + 176 + y;
		
		tf_year2 = new MyTextField(27 + x, 80, 50, 15);
		this.add(tf_year2);
		
		JLabel word_year2 = new JLabel("年");
		word_year2.setForeground(Color.WHITE);
		word_year2.setBackground(new Color(0, 0, 0, 0));
		word_year2.setBounds(87 + x, 80, 20, 15);
		this.add(word_year2);
		
		tf_month2 = new MyTextField(110 + x, 80, 30, 15);
		this.add(tf_month2);
		
		JLabel word_month2 = new JLabel("月");
		word_month2.setForeground(Color.WHITE);
		word_month2.setBackground(new Color(0, 0, 0, 0));
		word_month2.setBounds(150 + x, 80, 20, 15);
		this.add(word_month2);
		
		tf_day2 = new MyTextField(170 + x, 80, 30, 15);
		this.add(tf_day2);
		
		JLabel word_day2 = new JLabel("日");
		word_day2.setForeground(Color.WHITE);
		word_day2.setBackground(new Color(0, 0, 0, 0));
		word_day2.setBounds(210 + x, 80, 80, 15);
		this.add(word_day2);
		
		button_check = new MyJButton("查看");
		button_check.setBounds(250 + x, 78, 90, 20);
		button_check.addActionListener(this);
		this.add(button_check);
		
		button_list = new MyJButton("导出至Excel");
		button_list.setBounds(400 + 525 + y - 150, 610 + 20 - 60, 150, 25);
		button_list.addActionListener(this);
		this.add(button_list);		
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_check){
			if(tf_year1.getText().isEmpty() || tf_year2.getText().isEmpty() 
					|| tf_month1.getText().isEmpty() || tf_month2.getText().isEmpty()
					 || tf_day1.getText().isEmpty() || tf_day2.getText().isEmpty()){
				
				WarningFrame wf = new WarningFrame("请检查时间段填写是否正确！");
				wf.setVisible(true);
			}else{
				String beginDate = yearAddZero(tf_year1.getText()) + addZero(tf_month1.getText()) + addZero(tf_day1.getText());
				String endDate = yearAddZero(tf_year2.getText()) + addZero(tf_month2.getText()) + addZero(tf_day2.getText());
				
				RecordBLService controller = new RecordController();
				BusinessStateVO vo = controller.businessState(beginDate, endDate);
				
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				
				String[] rowData = {String.valueOf(table.getRowCount() + 1), "收入类",
						"销售收入", String.format("%.2f", vo.saleIncome) + "元"};
				tableModel.addRow(rowData);
				
				String[] rowData2 = {String.valueOf(table.getRowCount() + 1),
						"收入类", "商品报溢收入", String.format("%.2f", vo.overflowIncome) + "元"};
				tableModel.addRow(rowData2);
				
				String[] rowData3 = {String.valueOf(table.getRowCount() + 1),
						"收入类", "成本调价收入", String.format("%.2f", vo.costIncome) + "元"};
				tableModel.addRow(rowData3);
				
				String[] rowData4 = {String.valueOf(table.getRowCount() + 1),
						"收入类", "代金券与实际收款差额收入", String.format("%.2f", vo.voucherIncome) + "元"};
				tableModel.addRow(rowData4);
				
				String[] rowData5 = {String.valueOf(table.getRowCount() + 1),
						"收入类", "折让后总收入", String.format("%.2f", vo.totalIncome) + "元"};
				tableModel.addRow(rowData5);
				
				String[] rowData6 = {String.valueOf(table.getRowCount() + 1),
						"支出类", "折让数额", String.format("%.2f", vo.allowance) + "元"};
				tableModel.addRow(rowData6);
				
				String[] rowData7 = {String.valueOf(table.getRowCount() + 1),
						"支出类", "销售成本", String.format("%.2f", vo.saleCost) + "元"};
				tableModel.addRow(rowData7);
				
				String[] rowData8 = {String.valueOf(table.getRowCount() + 1),
						"支出类", "商品报损", String.format("%.2f", vo.lossExpen) + "元"};
				tableModel.addRow(rowData8);
				
				String[] rowData9 = {String.valueOf(table.getRowCount() + 1),
						"支出类", "商品赠出", String.format("%.2f", vo.giftExpen) + "元"};
				tableModel.addRow(rowData9);
				
				String[] rowData10 = {String.valueOf(table.getRowCount() + 1),
						"支出类", "商品总支出", String.format("%.2f", vo.totalExpen) + "元"};
				tableModel.addRow(rowData10);
				
				String[] rowData11 = {String.valueOf(table.getRowCount() + 1),
						"收支汇总", "利润", String.format("%.2f", vo.profit) + "元"};
				tableModel.addRow(rowData11);
			}
		}
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
