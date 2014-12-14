package ui.differui.salesman.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;







import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import message.ResultMessage;
import dataenum.ClientCategory;
import dataenum.ClientLevel;
import dataenum.FindTypeClient;
import blservice.clientblservice.ClientBLService;
import businesslogic.clientbl.ClientController;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyLabel;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTable;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import vo.client.ClientAddVO;
import vo.client.ClientVO;

public class ClientDetailPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyTextField textField_id, textField_name, textField_phone, textField_address, 
		textField_post, textField_email, textField_limit, textField_salesman;
	MyComboBox comboBox_category, comboBox_level;
	MyButton button_modify, button_check;
	public static JButton bt_modify;
	String id, name, phone, address, post, email, limit; 
	double receivable, payable;
	
	public void setInformation(){
		
	}
	
	public ClientDetailPanel(ClientVO cvo){
			
		int x1 = 80, y1 = 55, x2 = 390, y2 = -66;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(53, 84, 94);
		
		//information bar
		JLabel infoBar = new JLabel("修改或查看所选客户详细信息",JLabel.CENTER);
		infoBar.setBounds(0, 0, 800, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
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
		
		textField_id = new MyTextField(110 + x1, 10 + y1, 200, 25);
		textField_id.setEditable(false);
		textField_id.setText(cvo.ID);
		this.add(textField_id);
		
		
		//ui for salesman
		JLabel word_salesman = new JLabel("业务员:",JLabel.CENTER);
		word_salesman.setForeground(Color.WHITE);
		word_salesman.setBackground(new Color(0, 0, 0, 0));
		word_salesman.setBounds(36 + x2, 130 + y2, 60, 25);
		this.add(word_salesman);
		
		textField_salesman = new MyTextField(110 + x2, 130 + y2, 200, 25);
		textField_salesman.setEditable(false);
		textField_salesman.setText(cvo.salesman);
		this.add(textField_salesman);
		
		//ui for name
		JLabel word_name = new JLabel("* 客户名称:",JLabel.CENTER);
		word_name.setForeground(Color.WHITE);
		word_name.setBackground(new Color(0, 0, 0, 0));
		word_name.setBounds(30 + x1, 50 + y1, 65, 25);
		this.add(word_name);
		
		textField_name = new MyTextField(110 + x1, 50 + y1, 200, 25);
		textField_name.setText(cvo.name);
		this.add(textField_name);
		
		//ui for category
		JLabel word_category = new JLabel("* 客户分类:",JLabel.CENTER);
		word_category.setForeground(Color.WHITE);
		word_category.setBackground(new Color(0, 0, 0, 0));
		word_category.setBounds(30 + x1, 90 + y1, 65, 25);
		this.add(word_category);
		
		String[] comboBoxStr = {"----------请选择一种分类----------", "进货商", "销售商", "进货商/销售商(两者都是)"};
		comboBox_category = new MyComboBox(110 + x1, 90 + y1, 200, 25,comboBoxStr);
		switch(cvo.category.toString()){
			case "PURCHASE_PERSON" : comboBox_category.setSelectedIndex(1);break;
			case "SALES_PERSON" : comboBox_category.setSelectedIndex(2);break;
			default : comboBox_category.setSelectedIndex(3);break;
		}
		this.add(comboBox_category);
		
		//ui for level
		JLabel word_level = new JLabel("* 客户星级:",JLabel.CENTER);
		word_level.setForeground(Color.WHITE);
		word_level.setBackground(new Color(0, 0, 0, 0));
		word_level.setBounds(30 + x1, 130 + y1, 65, 25);
		this.add(word_level);
		
		String[] comboBoxStr2 = {"----------请选择起始星级----------", "一星", "二星", "三星", "四星", "五星(VIP)"};
		comboBox_level = new MyComboBox(110 + x1, 130 + y1, 200, 25,comboBoxStr2);
		switch(cvo.level.toString()){
			case "LEVEL_1" : comboBox_level.setSelectedIndex(1);break;
			case "LEVEL_2" : comboBox_level.setSelectedIndex(2);break;
			case "LEVEL_3" : comboBox_level.setSelectedIndex(3);break;
			case "LEVEL_4" : comboBox_level.setSelectedIndex(4);break;
			default : comboBox_level.setSelectedIndex(5);break;
		}
		this.add(comboBox_level);
		
		
		//ui for receivableLimit
		JLabel word_limit = new JLabel("* 应收额度:",JLabel.CENTER);
		word_limit.setForeground(Color.WHITE);
		word_limit.setBackground(new Color(0, 0, 0, 0));
		word_limit.setBounds(30 + x1, 170 + y1, 65, 25);
		this.add(word_limit);
		
		textField_limit = new MyTextField(110 + x1, 170 + y1, 180, 25);
		textField_limit.setText(String.valueOf(cvo.receivableLimit));
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
		textField_phone.setText(cvo.phone);
		this.add(textField_phone);
		
		//ui for address
		JLabel word_address = new JLabel("客户地址:",JLabel.CENTER);
		word_address.setForeground(Color.WHITE);
		word_address.setBackground(new Color(0, 0, 0, 0));
		word_address.setBounds(36 + x2, 210 + y2, 60, 25);
		this.add(word_address);
		
		textField_address = new MyTextField(110 + x2, 210 + y2, 200, 25);
		textField_address.setText(cvo.address);
		this.add(textField_address);
		
		//ui for post
		JLabel word_post = new JLabel("客户邮编:",JLabel.CENTER);
		word_post.setForeground(Color.WHITE);
		word_post.setBackground(new Color(0, 0, 0, 0));
		word_post.setBounds(36 + x2, 250 + y2, 60, 25);
		this.add(word_post);
		
		textField_post = new MyTextField(110 + x2, 250 + y2, 200, 25);
		textField_post.setText(cvo.post);
		this.add(textField_post);
		
		//ui for email
		JLabel word_email = new JLabel("电子邮件:",JLabel.CENTER);
		word_email.setForeground(Color.WHITE);
		word_email.setBackground(new Color(0, 0, 0, 0));
		word_email.setBounds(36 + x2, 290 + y2, 60, 25);
		this.add(word_email);
		
		textField_email = new MyTextField(110 + x2, 290 + y2, 200, 25);
		textField_email.setText(cvo.email);
		this.add(textField_email);
		
		//table for receivable and payable information
		String[] headers = {"应付款数","应收款数","应收付差额"};
		MyTable table_rap = new MyTable(headers);
		JTableHeader head2 = table_rap.getTableHeader();
		head2.setForeground(foreColor);
		head2.setBackground(backColor);
		
		payable = cvo.payable;
		receivable = cvo.receivable;
		
		String[] str = {String.valueOf(cvo.payable), 
				String.valueOf(cvo.receivable), String.valueOf(payable - receivable)};
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
		JTableHeader head = table_hc.getTableHeader();
		head.setForeground(foreColor);
		head.setBackground(backColor);
		
		JScrollPane jsp2=new JScrollPane(table_hc);
		jsp2.setBounds(100, 370 + 70, 600, 120);
		jsp2.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp2.setOpaque(false);
		jsp2.setVisible(true);
		this.add(jsp2);
		
		//the label for button_return
		MyLabel label_return = new MyLabel(600 + 30, 575 + 35, 100, 20);
		label_return.setForeground(foreColor);
		label_return.setBackground(backColor);
		label_return.setText("返回");
		this.add(label_return);
			
		//ui for button motify and check
		MyLabel label_motify = new MyLabel(490 + 140, 390 - 180 + 65, 100, 20);
		label_motify.setForeground(foreColor);
		label_motify.setBackground(backColor);
		label_motify.setText("确认修改");
		this.add(label_motify);
		
		MyLabel label_check = new MyLabel(600 + 30, 580, 100, 20);
		label_check.setForeground(foreColor);
		label_check.setBackground(backColor);
		label_check.setText("查看所选货单");
		this.add(label_check);
		
		button_modify = new MyButton(630, 275, 100, 20);
		button_modify.addActionListener(this);
		this.add(button_modify);
		
		button_check = new MyButton(630, 580, 100, 20);
		button_check.addActionListener(this);
		this.add(button_check);
		
		bt_modify = new JButton();
		bt_modify.addActionListener(this);
		this.add(bt_modify);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		
		///////////////////////FUNCTION MODIFY///////////////////////////
		
		if(events.getSource() == button_modify){
			
			if(comboBox_level.getSelectedIndex() == 0 || comboBox_category.getSelectedIndex() == 0 
					|| textField_name.getText().isEmpty() || textField_limit.getText().isEmpty()){
				
				WarningFrame wf = new WarningFrame("请检查信息填写是否正确！");
				wf.setVisible(true);
				
			}else{
				ExitFinishFrame eff = new ExitFinishFrame("Modify a client");
				eff.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_modify){
					
			ClientBLService controller = new ClientController();
			
			ResultMessage rm = controller.updClient(new ClientAddVO(textField_id.getText()
					, getCategory(comboBox_category.getSelectedIndex()),getLevel(comboBox_level.getSelectedIndex()),
					textField_name.getText(), textField_phone.getText(),
					textField_address.getText(), textField_post.getText(), textField_email.getText()
					, Double.valueOf(textField_limit.getText()), textField_salesman.getText()));	
			
			if(rm.equals(ResultMessage.SUCCESS)){
				WarningFrame wf = new WarningFrame("客户信息修改成功！");
				wf.setVisible(true);
				
				this.setVisible(false);
				
				ClientManagementUI.button_showAll.doClick();
				
				ClientVO cvo2 = controller.findClient(textField_id.getText(), FindTypeClient.ID).get(0);
				
				ClientDetailUI cdf = new ClientDetailUI(cvo2);
				cdf.setVisible(true);
				
			}else{
				WarningFrame wf = new WarningFrame("客户信息修改失败！");
				wf.setVisible(true);
			}
			
		}
		
		if(events.getSource() == button_check){
			System.out.println("now checking ...");
		}
	}
	
	private ClientCategory getCategory(int i){
		switch (i){
			case 1: return ClientCategory.PURCHASE_PERSON;
			case 2: return ClientCategory.SALES_PERSON;
			case 3: return ClientCategory.BOTH;
			default: return null;
		}		
	}
	
	private ClientLevel getLevel(int i){
		switch (i){
			case 1: return ClientLevel.LEVEL_1;
			case 2: return ClientLevel.LEVEL_2;
			case 3: return ClientLevel.LEVEL_3;
			case 4: return ClientLevel.LEVEL_4;
			case 5: return ClientLevel.VIP;
			default: return null;
		}		
	}
}
