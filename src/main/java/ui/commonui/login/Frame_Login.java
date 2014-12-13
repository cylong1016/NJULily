package ui.commonui.login;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyFrame;
import ui.commonui.myui.MyLabel;
import ui.commonui.myui.MyPasswordField;
import ui.commonui.myui.MyTextField;
import ui.commonui.warning.WarningFrame;
import ui.differui.admin.AdminUI;
import ui.differui.finace.frame.Frame_Finace;
import ui.differui.inventory.frame.Frame_Inventory;
import ui.differui.manager.frame.Frame_Manager;
import ui.differui.salesman.frame.Frame_Salesman;
import blservice.userblservice.LoginInfo;
import blservice.userblservice.UserBLService;
import businesslogic.userbl.UserController;
import dataenum.UserIdentity;


public class Frame_Login extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	boolean flag = false;
	
	MyTextField userNameField;
	MyPasswordField passwordField;
	MyLabel label_field1, label_field2, label_checkbox;
	MyButton button_Enter, button_checkbox;
	MyBackground loginBackground2;
	
	public static String userName;
	public static UserIdentity userIden;
	
	public Frame_Login(){
		
		MyFrame.button_back.setVisible(false);
		
		//a text field for user name input 
		userNameField = new MyTextField(850, 200, 240, 48);
		userNameField.setFont(new Font("Arail",Font.BOLD,20));
		userNameField.setForeground(Color.WHITE);
		userNameField.setOpaque(false);
		userNameField.setBorder(BorderFactory.createEmptyBorder());
		userNameField.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				label_field1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				label_field1.setVisible(false);
			}
			}); 
		this.add(userNameField);
		
		//a password field for password input
		passwordField = new MyPasswordField(850, 305, 240, 48);
		passwordField.setFont(new Font("Arail",Font.PLAIN,20));
		passwordField.setForeground(Color.WHITE);
		passwordField.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				label_field2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				label_field2.setVisible(false);
			}
			}); 
		this.add(passwordField);
		
		//the button for action login
		button_Enter = new MyButton(782,450,320,60);
		button_Enter.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				loginBackground2.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				loginBackground2.setVisible(false);
			}
			}); 
		button_Enter.addActionListener(this);
		this.add(button_Enter);
		
		//a button act as a checkbox
		MyButton button_checkbox = new MyButton(800,390,25,25);
		button_checkbox.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
					if(flag == false){
						label_checkbox.setVisible(true);
						flag = true;
					}else{
						label_checkbox.setVisible(false);
						flag = false;
					}
					
				}
			});
		this.add(button_checkbox);
		
		//these are the effect for better UI
		label_field1 = new MyLabel(289, -135, 1280, 700);
		label_field1.setIcon(new ImageIcon("ui/image/login/field.png"));
		label_field1.setVisible(false);
		label_field1.setOpaque(false);
		this.add(label_field1);
		
		label_field2 = new MyLabel(289, -32, 1280, 700);
		label_field2.setIcon(new ImageIcon("ui/image/login/field.png"));
		label_field2.setVisible(false);
		label_field2.setOpaque(false);
		this.add(label_field2);
		
		label_checkbox = new MyLabel(160, 53, 1280, 700);
		label_checkbox.setIcon(new ImageIcon("ui/image/login/checkbox.png"));
		label_checkbox.setVisible(false);
		label_checkbox.setOpaque(false);
		this.add(label_checkbox);
			
		//initialize the background for this frame
		loginBackground2 = new MyBackground("ui/image/login/loginBackground2.png");
		loginBackground2.setVisible(false);
		this.add(loginBackground2);
		
		MyBackground loginBackground = new MyBackground("ui/image/login/loginBackground.png");
		this.add(loginBackground);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_Enter){
			UserBLService controller = new UserController();
			
			userName = userNameField.getText();
			for(int i = 0; i < controller.show().size(); i++){
				if(controller.show().get(i).username.equals(userName)){
					userName = controller.show().get(i).name;
					userIden = controller.show().get(i).iden;
				}
			}
			
			UserIdentity ui = controller.login(new LoginInfo(userNameField.getText()
					, new String(passwordField.getPassword()),flag));
			
			if(ui == null){
				WarningFrame wf = new WarningFrame("用户名或密码填写错误！");
				wf.setVisible(true);
			}else if(ui.equals(UserIdentity.ADMIN)){
				
				AdminUI au = new AdminUI();
				au.setVisible(true);
				
				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
				
			
			}else if(ui.equals(UserIdentity.PUR_SALE_MANAGER) || ui.equals(UserIdentity.SALE_MANAGER)){
				
				Frame_Salesman fs = new Frame_Salesman();
				fs.setVisible(true);
				
				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			}else if(ui.equals(UserIdentity.INVENTORY_MANAGER)){
				
				Frame_Inventory fi = new Frame_Inventory();
				fi.setVisible(true);
				
				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
				
			}else if(ui.equals(UserIdentity.FINANCE_MANAGER)){
				Frame_Finace ff = new Frame_Finace();
				ff.setVisible(true);
				
				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			}else if(ui.equals(UserIdentity.GENERAL_MANAGER)){
				Frame_Manager fm = new Frame_Manager();
				fm.setVisible(true);
				
				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			}
		}
	}
}
