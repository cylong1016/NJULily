package ui.commonui.login;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import ui.commonui.myui.IOforUI;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyFrame;
import ui.commonui.myui.MyLabel;
import ui.commonui.myui.MyPasswordField;
import ui.commonui.myui.MyTextField;
import ui.differui.salesman.frame.Frame_Salesman;

public class Frame_Login extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	int i = 0;
	
	MyTextField userNameField;
	MyPasswordField passwordField;
	MyLabel label_field1, label_field2, label_checkbox;
	MyButton button_Enter, button_checkbox;
	
	public Frame_Login(){
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		IOforUI io = new IOforUI();
		
		int X = getLocation(scrSize.width,1280);
		int Y = getLocation(scrSize.height,720);
		io.writeTo(getCurrentLocation(X, Y),"ui/data/location.txt" );
		this.setLocation(X, Y);
		
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
		button_Enter.setIcon(new ImageIcon("ui/image/login/loginButton.png"));
		button_Enter.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				button_Enter.setIcon(new ImageIcon("ui/image/login/loginButton2.png"));
			}
			public void mouseExited(MouseEvent arg0) {
				button_Enter.setIcon(new ImageIcon("ui/image/login/loginButton.png"));
			}
			}); 
		button_Enter.addActionListener(this);
		this.add(button_Enter);
		
		//a button act as a checkbox
		MyButton button_checkbox = new MyButton(800,390,25,25);
		button_checkbox.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
					if(i % 2 == 0){
						label_checkbox.setVisible(true);
					}else{
						label_checkbox.setVisible(false);
					}
					i++;
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
		MyBackground loginBackground = new MyBackground("ui/image/login/loginBackground.png");
		this.add(loginBackground);
			
	}
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == button_Enter){
			Frame_Salesman fs = new Frame_Salesman();
			fs.setVisible(true);
			this.setVisible(false);
		}
	}
	
	private int getLocation(int a,int b){
		return (a-b)/2;
	}
	
	
}
