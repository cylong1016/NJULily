package ui.commonui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyColor;
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
import blservice.userblservice.UserBLService;
import businesslogic.userbl.UserController;
import dataenum.UserIdentity;
import dataservice.userdataservice.LoginInfo;

public class Frame_Login extends MyFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	boolean flag = false;

	MyTextField userNameField;
	MyPasswordField passwordField;
	MyLabel label_field1, label_field2;
	MyButton button_Enter;
	MyBackground loginBackground2, loginBackground;

	public static String userName, userID;
	public static UserIdentity userIden;

	public Frame_Login() {
		
		MyColor color = new MyColor();
		color.toString();

		MyFrame.button_back.setVisible(false);

		//a text field for user name input 
		userNameField = new MyTextField(575, 480, 200, 40);
		userNameField.setFont(new Font("Arail", Font.BOLD, 20));
		userNameField.setForeground(Color.WHITE);
		userNameField.setOpaque(false);
		userNameField.setBorder(BorderFactory.createEmptyBorder());
		userNameField.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				label_field1.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				label_field1.setVisible(false);
			}
		});
		this.add(userNameField);

		//a password field for password input
		passwordField = new MyPasswordField(575, 560, 200, 40);
		passwordField.setFont(new Font("Arail", Font.PLAIN, 20));
		passwordField.setForeground(Color.WHITE);
		passwordField.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				label_field2.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				label_field2.setVisible(false);
			}
		});
		this.add(passwordField);
		
		//the button for action login
		button_Enter = new MyButton(530, 630, 250, 40);
		button_Enter.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				loginBackground.setVisible(false);
				loginBackground2.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				loginBackground.setVisible(true);
				loginBackground2.setVisible(false);
			}
		});
		button_Enter.registerKeyboardAction(this, 
		        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), 
		        JComponent.WHEN_IN_FOCUSED_WINDOW); 
		button_Enter.addKeyListener(new KeyAdapter(){ 
			
		    public void keyPressed(KeyEvent event){ 
		    	
		    	if (KeyEvent.getKeyText(event.getKeyCode()).compareToIgnoreCase("Enter") == 0){ 
		    		button_Enter.doClick(); 
		    	} 
	    	} 
		}); 
		button_Enter.addActionListener(this);
		this.add(button_Enter);

		//these are the effect for better UI
		label_field1 = new MyLabel(0, 0, 1280, 720);
		label_field1.setIcon(new ImageIcon("ui/image/login/back3.png"));
		label_field1.setVisible(false);
		label_field1.setOpaque(false);
		this.add(label_field1);

		label_field2 = new MyLabel(0, 0, 1280, 720);
		label_field2.setIcon(new ImageIcon("ui/image/login/back4.png"));
		label_field2.setVisible(false);
		label_field2.setOpaque(false);
		this.add(label_field2);

		//initialize the background for this frame
		loginBackground2 = new MyBackground("ui/image/login/backg2.png");
		loginBackground2.setVisible(false);
		this.add(loginBackground2);

		loginBackground = new MyBackground("ui/image/login/backg.png");
		this.add(loginBackground);

	}

	public void actionPerformed(ActionEvent events) {
		if (events.getSource() == button_Enter) {
			UserBLService controller = new UserController();

			UserIdentity ui =
								controller.login(new LoginInfo(userNameField.getText(), new String(passwordField.getPassword()), flag));
			userID = userNameField.getText();
			for(int i = 0; i < controller.show().size(); i++) {
				if (controller.show().get(i).username.equals(userID)) {
					userName = controller.show().get(i).name;
					userIden = controller.show().get(i).iden;
				}
			}

			if (ui == null) {
				WarningFrame wf = new WarningFrame("用户名或密码填写错误！");
				wf.setVisible(true);
			} else if (ui.equals(UserIdentity.ADMIN)) {

				AdminUI au = new AdminUI();
				au.setVisible(true);

				this.setVisible(false);

				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);

			} else if (ui.equals(UserIdentity.PUR_SALE_MANAGER) || ui.equals(UserIdentity.SALE_MANAGER)) {

				MyColor.setColor(2);

				Frame_Salesman fs = new Frame_Salesman();
				fs.setVisible(true);

				this.setVisible(false);
				

				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			} else if (ui.equals(UserIdentity.INVENTORY_MANAGER)) {

				MyColor.setColor(1);

				Frame_Inventory fi = new Frame_Inventory();
				fi.setVisible(true);

				this.setVisible(false);
				

				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);

			} else if (ui.equals(UserIdentity.FINANCE_MANAGER)) {

				MyColor.setColor(3);

				Frame_Finace ff = new Frame_Finace();
				ff.setVisible(true);

				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			} else if (ui.equals(UserIdentity.GENERAL_MANAGER)) {
				MyColor.setColor(4);
				
				Frame_Manager fm = new Frame_Manager();
				fm.setVisible(true);

				this.setVisible(false);
				
				WarningFrame wf = new WarningFrame("欢迎使用本系统！");
				wf.setVisible(true);
			}
		}
	}
}
