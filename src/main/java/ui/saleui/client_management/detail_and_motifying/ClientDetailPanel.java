package ui.saleui.client_management.detail_and_motifying;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ui.myui.MyComboBox;
import ui.myui.MyJButton;
import ui.myui.MyLabel;
import ui.myui.MyPanel;
import ui.myui.MyTable;
import ui.myui.MyTextField;

public class ClientDetailPanel extends MyPanel{

	private static final long serialVersionUID = 1L;

	MyTextField textField_name, textField_phone, textField_address, textField_post, textField_email, textField_limit;
	MyComboBox comboBox_category, comboBox_level;
	MyJButton button_add;
	
	public ClientDetailPanel(){
			
		int x1 = 80, y1 = 55, x2 = 390, y2 = -66;
		
		//information bar
		JLabel infoBar = new JLabel("修改或查看所选客户详细信息",JLabel.CENTER);
		infoBar.setBounds(0, 0, 800, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(Color.black);
		infoBar.setBackground(new Color(0, 1, 1, 0.5f));
		this.add(infoBar);
		
		//ui for tips
		JLabel word_tip1 = new JLabel("客户信息:",JLabel.CENTER);
		word_tip1.setForeground(Color.RED);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(30, 45, 65, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("收付情况:",JLabel.CENTER);
		word_tip2.setForeground(Color.RED);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(30, 235 + 70, 65, 25);
		this.add(word_tip2);
		
		JLabel word_tip3 = new JLabel("客户历史货单查看:",JLabel.CENTER);
		word_tip3.setForeground(Color.RED);
		word_tip3.setBackground(new Color(0, 0, 0, 0));
		word_tip3.setBounds(25, 335 + 70, 120, 25);
		this.add(word_tip3);
		
		//ui for id
		JLabel word_id = new JLabel("客户编号:",JLabel.CENTER);
		word_id.setForeground(Color.WHITE);
		word_id.setBackground(new Color(0, 0, 0, 0));
		word_id.setBounds(33 + x1, 10 + y1, 65, 25);
		this.add(word_id);
		
		MyTextField textField_id = new MyTextField(110 + x1, 10 + y1, 200, 25);
		textField_id.setEditable(false);
		this.add(textField_id);
		
		
		//ui for salesman
		JLabel word_salesman = new JLabel("客户编号:",JLabel.CENTER);
		word_salesman.setForeground(Color.WHITE);
		word_salesman.setBackground(new Color(0, 0, 0, 0));
		word_salesman.setBounds(36 + x2, 130 + y2, 60, 25);
		this.add(word_salesman);
		
		MyTextField textField_salesman = new MyTextField(110 + x2, 130 + y2, 200, 25);
		textField_salesman.setEditable(false);
		this.add(textField_salesman);
		
		//ui for name
		JLabel word_name = new JLabel("* 客户名称:",JLabel.CENTER);
		word_name.setForeground(Color.WHITE);
		word_name.setBackground(new Color(0, 0, 0, 0));
		word_name.setBounds(30 + x1, 50 + y1, 65, 25);
		this.add(word_name);
		
		textField_name = new MyTextField(110 + x1, 50 + y1, 200, 25);
		this.add(textField_name);
		
		//ui for category
		JLabel word_category = new JLabel("* 客户分类:",JLabel.CENTER);
		word_category.setForeground(Color.WHITE);
		word_category.setBackground(new Color(0, 0, 0, 0));
		word_category.setBounds(30 + x1, 90 + y1, 65, 25);
		this.add(word_category);
		
		String[] comboBoxStr = {"----------请选择一种分类----------", "进货商", "销售商", "进货商/销售商(两者都是)"};
		comboBox_category = new MyComboBox(110 + x1, 90 + y1, 200, 25,comboBoxStr);
		this.add(comboBox_category);
		
		//ui for level
		JLabel word_level = new JLabel("* 客户星级:",JLabel.CENTER);
		word_level.setForeground(Color.WHITE);
		word_level.setBackground(new Color(0, 0, 0, 0));
		word_level.setBounds(30 + x1, 130 + y1, 65, 25);
		this.add(word_level);
		
		String[] comboBoxStr2 = {"----------请选择起始星级----------", "一星", "二星", "三星", "四星", "五星(VIP)"};
		comboBox_category = new MyComboBox(110 + x1, 130 + y1, 200, 25,comboBoxStr2);
		this.add(comboBox_category);
		
		
		//ui for receivableLimit
		JLabel word_limit = new JLabel("* 应收额度:",JLabel.CENTER);
		word_limit.setForeground(Color.WHITE);
		word_limit.setBackground(new Color(0, 0, 0, 0));
		word_limit.setBounds(30 + x1, 170 + y1, 65, 25);
		this.add(word_limit);
		
		textField_limit = new MyTextField(110 + x1, 170 + y1, 180, 25);
		this.add(textField_limit);
		
		JLabel word_limit_yuan = new JLabel("元",JLabel.CENTER);
		word_limit_yuan.setForeground(Color.WHITE);
		word_limit_yuan.setBackground(new Color(0, 0, 0, 0));
		word_limit_yuan.setBounds(290 + x1, 170 + y1, 20, 25);
		this.add(word_limit_yuan);
		
		//ui for phone
		JLabel word_phone = new JLabel("客户电话:",JLabel.CENTER);
		word_phone.setForeground(Color.WHITE);
		word_phone.setBackground(new Color(0, 0, 0, 0));
		word_phone.setBounds(36 + x2, 170 + y2, 60, 25);
		this.add(word_phone);
		
		textField_phone = new MyTextField(110 + x2, 170 + y2, 200, 25);
		this.add(textField_phone);
		
		//ui for address
		JLabel word_address = new JLabel("客户地址:",JLabel.CENTER);
		word_address.setForeground(Color.WHITE);
		word_address.setBackground(new Color(0, 0, 0, 0));
		word_address.setBounds(36 + x2, 210 + y2, 60, 25);
		this.add(word_address);
		
		textField_address = new MyTextField(110 + x2, 210 + y2, 200, 25);
		this.add(textField_address);
		
		//ui for post
		JLabel word_post = new JLabel("客户邮编:",JLabel.CENTER);
		word_post.setForeground(Color.WHITE);
		word_post.setBackground(new Color(0, 0, 0, 0));
		word_post.setBounds(36 + x2, 250 + y2, 60, 25);
		this.add(word_post);
		
		textField_post = new MyTextField(110 + x2, 250 + y2, 200, 25);
		this.add(textField_post);
		
		//ui for email
		JLabel word_email = new JLabel("电子邮件:",JLabel.CENTER);
		word_email.setForeground(Color.WHITE);
		word_email.setBackground(new Color(0, 0, 0, 0));
		word_email.setBounds(36 + x2, 290 + y2, 60, 25);
		this.add(word_email);
		
		textField_email = new MyTextField(110 + x2, 290 + y2, 200, 25);
		this.add(textField_email);
		
		//table for receivable and payable information
		String[] headers = {"应付款数","应收款数","应收付差额"};
		MyTable table_rap = new MyTable(headers);
		
		String[] str = {"100", "200", "-100"};
		DefaultTableModel tableModel_rap = (DefaultTableModel) table_rap.getModel();
		tableModel_rap.addRow(str);
		
		JScrollPane jsp1=new JScrollPane(table_rap);
		jsp1.setBounds(100, 270 + 70, 600, 40);
		jsp1.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp1.setOpaque(false);
		jsp1.setVisible(true);
		this.add(jsp1);
		
		//table for history checking
		String[] headers2 = {"货单编号","货单日期","应收","应付","应收付差额"};
		MyTable table_hc = new MyTable(headers2);
		
		JScrollPane jsp2=new JScrollPane(table_hc);
		jsp2.setBounds(100, 370 + 70, 600, 120);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
			
		//the label for button_return
		MyLabel label_return = new MyLabel(600 + 30, 575 + 35, 100, 20);
		label_return.setForeground(Color.BLACK);
		label_return.setBackground(new Color(0, 1, 1, 0.65f));
		label_return.setText("返回");
		this.add(label_return);
		
		MyLabel label_motify = new MyLabel(490 + 140, 390 - 180 + 65, 100, 20);
		label_motify.setForeground(Color.BLACK);
		label_motify.setBackground(new Color(0, 1, 1, 0.65f));
		label_motify.setText("确认修改");
		this.add(label_motify);
		
		MyLabel label_check = new MyLabel(600 + 30, 580, 100, 20);
		label_check.setForeground(Color.BLACK);
		label_check.setBackground(new Color(0, 1, 1, 0.65f));
		label_check.setText("查看所选货单");
		this.add(label_check);
	}
}
