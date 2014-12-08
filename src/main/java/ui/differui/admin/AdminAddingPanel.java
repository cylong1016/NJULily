package ui.differui.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import message.ResultMessage;
import ui.commonui.exitfinish.ExitFinishFrame;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyPanel;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;

import vo.UserVO;

import businesslogic.userbl.User;
import dataenum.UserIdentity;

public class AdminAddingPanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyTextField textField_name, textField_username, textField_password, textField_phone;
	MyComboBox comboBox_iden;
	JButton button_add, button_return;
	public static JButton addConform;
	
	User controller; 
	
	public AdminAddingPanel(){
			
		int x1 = 120, y1 = 10, x2 = 120, y2 = 75;
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		//information bar
		JLabel infoBar = new JLabel("添加新员工",JLabel.CENTER);
		infoBar.setBounds(0, 0, 600, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
				
		//ui for tips
		JLabel word_tip1 = new JLabel("* 必填:",JLabel.CENTER);
		word_tip1.setForeground(Color.RED);
		word_tip1.setBackground(new Color(0, 0, 0, 0));
		word_tip1.setBounds(40, 45, 65, 25);
		this.add(word_tip1);
		
		JLabel word_tip2 = new JLabel("选填:",JLabel.CENTER);
		word_tip2.setForeground(Color.RED);
		word_tip2.setBackground(new Color(0, 0, 0, 0));
		word_tip2.setBounds(46, 233, 65, 25);
		this.add(word_tip2);
		
		//ui for name
		JLabel word_name = new JLabel("* 员工姓名:",JLabel.CENTER);
		word_name.setForeground(Color.WHITE);
		word_name.setBackground(new Color(0, 0, 0, 0));
		word_name.setBounds(30 + x1, 50 + y1, 65, 25);
		this.add(word_name);
		
		textField_name = new MyTextField(110 + x1, 50 + y1, 200, 25);
		this.add(textField_name);
		
		//ui for category
		JLabel word_iden = new JLabel("* 员工职务:",JLabel.CENTER);
		word_iden.setForeground(Color.WHITE);
		word_iden.setBackground(new Color(0, 0, 0, 0));
		word_iden.setBounds(30 + x1, 90 + y1, 65, 25);
		this.add(word_iden);
		
		String[] comboBoxStr = {"----------请选择一种职务----------", "总经理", "库存管理人员", "进货销售人员", "销售经理" ,"财务人员"};
		comboBox_iden = new MyComboBox(110 + x1, 90 + y1, 200, 25,comboBoxStr);
		this.add(comboBox_iden);
		
		//ui for level
		JLabel word_username = new JLabel("* 用户名称:",JLabel.CENTER);
		word_username.setForeground(Color.WHITE);
		word_username.setBackground(new Color(0, 0, 0, 0));
		word_username.setBounds(30 + x1, 130 + y1, 65, 25);
		this.add(word_username);
		
		textField_username = new MyTextField(110 + x1, 130 + y1, 200, 25);
		this.add(textField_username);
		
		//ui for receivableLimit
		JLabel word_password = new JLabel("* 用户密码:",JLabel.CENTER);
		word_password.setForeground(Color.WHITE);
		word_password.setBackground(new Color(0, 0, 0, 0));
		word_password.setBounds(30 + x1, 170 + y1, 65, 25);
		this.add(word_password);
		
		textField_password = new MyTextField(110 + x1, 170 + y1, 200, 25);
		this.add(textField_password);
				
		//ui for phone
		JLabel word_phone = new JLabel("联系方式:",JLabel.CENTER);
		word_phone.setForeground(Color.WHITE);
		word_phone.setBackground(new Color(0, 0, 0, 0));
		word_phone.setBounds(36 + x2, 170 + y2, 60, 25);
		this.add(word_phone);
		
		textField_phone = new MyTextField(110 + x2, 170 + y2, 200, 25);
		this.add(textField_phone);
					
		//the label for button_return
		button_return = new JButton();
		button_return.setBounds(490 , 320, 100, 20);
		button_return.setForeground(foreColor);
		button_return.setBackground(backColor);
		button_return.setText("返回");
		button_return.addActionListener(this);
		this.add(button_return);
		
		//ui for button add
		button_add = new JButton();
		button_add.setBounds(490 , 290, 100, 20);
		button_add.setForeground(foreColor);
		button_add.setBackground(backColor);
		button_add.setText("确认添加");
		button_add.addActionListener(this);
		this.add(button_add);
		
		addConform = new JButton();
		addConform.addActionListener(this);
		this.add(addConform);	
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button_return){
			ExitFunctionFrame epf = new ExitFunctionFrame("AdminAddingUI");
			epf.setVisible(true);
		}
		
		if(events.getSource() == button_add){
			
			if(!textField_name.getText().isEmpty() && !textField_username.getText().isEmpty() 
					&& comboBox_iden.getSelectedIndex() != 0 && !textField_password.getText().isEmpty()){
				ExitFinishFrame eff = new ExitFinishFrame("AdminAddingPanel");
				eff.setVisible(true);
			}else{
				WarningFrame wp = new WarningFrame("*请检查信息填写是否正确！");
				wp.setVisible(true);
			}	
		}	
		
		if(events.getSource() == addConform){
			
			controller = new User();	
			
			ResultMessage res = controller.add(new UserVO(controller.getID(), textField_username.getText(),
					textField_name.getText(), textField_password.getText(), 
					textField_phone.getText(), getIden(comboBox_iden.getSelectedIndex())));
			
			if(res.equals(ResultMessage.SUCCESS)) {
				
				WarningFrame wp = new WarningFrame("已成功添加！");
				wp.setVisible(true);
				AdminAddingUI.button_close.doClick();
				AdminUI.bt_show.doClick();
				
			}else{
				WarningFrame wp = new WarningFrame("用户名重复！");
				wp.setVisible(true);
			}			
		}
		
	
	}
		
	private UserIdentity getIden(int i){
		switch (i){
			case 1: return UserIdentity.GENERAL_MANAGER;
			case 2: return UserIdentity.INVENTORY_MANAGER;
			case 3: return UserIdentity.PUR_SALE_MANAGER;
			case 4: return UserIdentity.SALE_MANAGER;
			default: return UserIdentity.FINANCE_MANAGER;
		}		
	}
	
	
	public String getinfo(){
		return textField_name.getText();
	}
}
