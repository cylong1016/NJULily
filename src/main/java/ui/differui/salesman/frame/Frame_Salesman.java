package ui.differui.salesman.frame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyFrame;
import ui.differui.salesman.client.ClientManagementUI;


public class Frame_Salesman extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyButton bt_index, bt_in, bt_client, bt_inBack, bt_sale, bt_saleBack;
	JLabel lb_index, lb_in, lb_client, lb_inBack, lb_sale, lb_saleBack;
	
	public static JButton bt_vanish;
	
	public Frame_Salesman(){
		
		bt_vanish = new JButton();
		bt_vanish.addActionListener(this);
		this.add(bt_vanish);
		
		Frame_Login.myNameis = "Frame_Salesman";
		
		//client management
		ClientManagementUI cm = new ClientManagementUI();
		cm.setBounds(0, 0, 1280, 720);
		this.add(cm);
			
		/////////////////////////////index///////////////////////////////
		
		lb_index = new JLabel(new ImageIcon("ui/image/salesman/index.png"));
		lb_index.setVisible(false);
		lb_index.setBounds(0, 0, 1280, 720);
		this.add(lb_index);
		lb_index.setVisible(false);
		
		bt_index = new MyButton(375, 650, 60, 25);
		bt_index.addActionListener(this);
		bt_index.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_index.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_index.setVisible(false);
			}
			}); 
		this.add(bt_index);
		
		////////////////////////////client///////////////////////////////
		
		lb_client = new JLabel(new ImageIcon("ui/image/salesman/client.png"));
		lb_client.setVisible(false);
		lb_client.setBounds(0, 0, 1280, 720);
		this.add(lb_client);
		lb_client.setVisible(false);
		
		bt_client = new MyButton(492, 652, 77, 25);
		bt_client.addActionListener(this);
		bt_client.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_client.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_client.setVisible(false);
			}
			}); 
		this.add(bt_client);
		
		/////////////////////////////in///////////////////////////////
		
		lb_in = new JLabel(new ImageIcon("ui/image/salesman/in.png"));
		lb_in.setVisible(false);
		lb_in.setBounds(0, 0, 1280, 720);
		this.add(lb_in);
		lb_in.setVisible(false);
		
		bt_in = new MyButton(624, 652, 92, 25);
		bt_in.addActionListener(this);
		bt_in.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_in.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_in.setVisible(false);
			}
			}); 
		this.add(bt_in);
		
		/////////////////////////////inBack///////////////////////////////
		
		lb_inBack = new JLabel(new ImageIcon("ui/image/salesman/inBack.png"));
		lb_inBack.setVisible(false);
		lb_inBack.setBounds(0, 0, 1280, 720);
		this.add(lb_inBack);
		lb_inBack.setVisible(false);
		
		bt_inBack = new MyButton(760, 652, 130, 25);
		bt_inBack.addActionListener(this);
		bt_inBack.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_inBack.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_inBack.setVisible(false);
			}
			}); 
		this.add(bt_inBack);
		
		/////////////////////////////sale///////////////////////////////
		
		lb_sale = new JLabel(new ImageIcon("ui/image/salesman/sale.png"));
		lb_sale.setVisible(false);
		lb_sale.setBounds(0, 0, 1280, 720);
		this.add(lb_sale);
		lb_sale.setVisible(false);
		
		bt_sale = new MyButton(935, 652, 90, 25);
		bt_sale.addActionListener(this);
		bt_sale.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_sale.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_sale.setVisible(false);
			}
			}); 
		this.add(bt_sale);
		
		/////////////////////////////saleBack///////////////////////////////
		
		lb_saleBack = new JLabel(new ImageIcon("ui/image/salesman/saleBack.png"));
		lb_saleBack.setVisible(false);
		lb_saleBack.setBounds(0, 0, 1280, 720);
		this.add(lb_saleBack);
		lb_saleBack.setVisible(false);
		
		bt_saleBack = new MyButton(1075, 652, 130, 25);
		bt_saleBack.addActionListener(this);
		bt_saleBack.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_saleBack.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_saleBack.setVisible(false);
			}
			}); 
		this.add(bt_saleBack);
		
		/////////////////////////////back///////////////////////////////
		
		MyBackground background = new MyBackground("ui/image/salesman/background.png");
		this.add(background);
		
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == bt_vanish){
			this.setVisible(false);
		}
	}
}
