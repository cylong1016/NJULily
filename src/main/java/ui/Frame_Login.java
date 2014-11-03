package ui;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import myUI.MyBackground;
import myUI.MyButton;
import myUI.MyFrame;
import myUI.MyLabel;
import myUI.MyPasswordField;
import myUI.MyTextField;

public class Frame_Login extends MyFrame {

	private static final long serialVersionUID = 1L;
	int i = 0;
	
	MyTextField userNameField;
	MyPasswordField passwordField;
	MyLabel label_field1, label_field2, label_checkbox;
	MyButton button_Enter, button_checkbox;
	
	public Frame_Login(){
		
		//�����û��������
		userNameField = new MyTextField(850, 200, 240, 48);
		userNameField.setFont(new Font("Arail",Font.BOLD,20));
		userNameField.setForeground(Color.WHITE);
		userNameField.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				label_field1.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				label_field1.setVisible(false);
			}
			}); 
		this.add(userNameField);
		
		//�������������
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
		
		//���ӵ�¼��ť
		final MyButton button_Enter = new MyButton(782,450,320,60);
		button_Enter.setIcon(new ImageIcon("image/login/loginButton.png"));
		button_Enter.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				button_Enter.setIcon(new ImageIcon("image/login/loginButton2.png"));
			}
			public void mouseExited(MouseEvent arg0) {
				button_Enter.setIcon(new ImageIcon("image/login/loginButton.png"));
			}
			}); 
		this.add(button_Enter);
		
		//���Ӹ�ѡ��
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
		
		//�����û������������������Լ���ѡ�����Ч
		label_field1 = new MyLabel(289, -135, 1280, 700);
		label_field1.setIcon(new ImageIcon("image/login/field.png"));
		label_field1.setVisible(false);
		this.add(label_field1);
		
		label_field2 = new MyLabel(289, -32, 1280, 700);
		label_field2.setIcon(new ImageIcon("image/login/field.png"));
		label_field2.setVisible(false);
		this.add(label_field2);
		
		label_checkbox = new MyLabel(160, 53, 1280, 700);
		label_checkbox.setIcon(new ImageIcon("image/login/checkbox.png"));
		label_checkbox.setVisible(false);
		this.add(label_checkbox);
		
		//���ӱ���ͼƬ����¼����
		MyBackground loginBackground = new MyBackground("image/login/loginBackground.png");
		this.add(loginBackground);
		
		}
}
