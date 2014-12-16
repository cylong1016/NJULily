package ui.differui.salesman.frame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyBackground;
import ui.commonui.myui.MyButton;
import ui.commonui.myui.MyFrame;
import ui.differui.salesman.client.ClientManagementUI;
import ui.differui.salesman.in.InClient;
import ui.differui.salesman.in.InFinal;
import ui.differui.salesman.in.InGood;
import ui.differui.salesman.inback.InBackFinal;
import ui.differui.salesman.inback.InBackFirst;
import ui.differui.salesman.index.SaleIndex;
import ui.differui.salesman.sale.SaleUI;
import ui.differui.salesman.saleback.SaleBackUI;


public class Frame_Salesman extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyButton bt_index, bt_in, bt_client, bt_inBack, bt_sale, bt_saleBack;
	JLabel lb_index, lb_in, lb_client, lb_inBack, lb_sale, lb_saleBack;
	
	public static JButton bt_vanish;
	
	public static int flag = 0, destination = 0;
	
	static ClientManagementUI panel_cm;
	static SaleIndex panel_si;
	static InClient panel_inClient;
	static InGood panel_iu;
	static InBackFirst panel_ibu;
	static InBackFinal panel_inBackFinal;
	static SaleUI panel_su;
	static SaleBackUI panel_sbu;
	static InFinal panel_inFinal;
	
	static JLabel in_back;
	
	public Frame_Salesman(){
		
		bt_vanish = new JButton();
		bt_vanish.addActionListener(this);
		this.add(bt_vanish);
		
		Frame_Login.myNameis = "Frame_Salesman";
		
		//client management
		panel_cm = new ClientManagementUI();
		panel_cm.setVisible(false);
		this.add(panel_cm);
		
		panel_si = new SaleIndex();
		panel_si.setVisible(true);
		this.add(panel_si);
		
		panel_inClient = new InClient();
		panel_inClient.setVisible(false);
		this.add(panel_inClient);
		
		panel_inFinal = new InFinal();
		panel_inFinal.setVisible(false);
		this.add(panel_inFinal);
		
		panel_iu = new InGood();
		panel_iu.setVisible(false);
		this.add(panel_iu);
		
		panel_ibu = new InBackFirst();
		panel_ibu.setVisible(false);
		this.add(panel_ibu);
		
		panel_inBackFinal = new InBackFinal();
		panel_inBackFinal.setVisible(false);
		this.add(panel_inBackFinal);
		
		panel_su = new SaleUI();
		panel_su.setVisible(false);
		this.add(panel_su);
		
		panel_sbu = new SaleBackUI();
		panel_sbu.setVisible(false);
		this.add(panel_sbu);
		
		in_back = new JLabel(new ImageIcon("ui/image/salesman/in.png"));
		in_back.setBounds(0, 0, 1280, 630);
		in_back.setVisible(false);
		this.add(in_back);
			
		/////////////////////////////index///////////////////////////////
		
		lb_index = new JLabel(new ImageIcon("ui/image/salesman/index.jpg"));
		lb_index.setVisible(false);
		lb_index.setBounds(0, 0, 1280, 720);
		this.add(lb_index);
		lb_index.setVisible(false);
		
		bt_index = new MyButton(275, 666, 55, 30);
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
		
		lb_client = new JLabel(new ImageIcon("ui/image/salesman/client.jpg"));
		lb_client.setVisible(false);
		lb_client.setBounds(0, 0, 1280, 720);
		this.add(lb_client);
		lb_client.setVisible(false);
		
		bt_client = new MyButton(415, 666, 68, 30);
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
		
		lb_in = new JLabel(new ImageIcon("ui/image/salesman/in.jpg"));
		lb_in.setVisible(false);
		lb_in.setBounds(0, 0, 1280, 720);
		this.add(lb_in);
		lb_in.setVisible(false);
		
		bt_in = new MyButton(560, 652, 80, 30);
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
		
		lb_inBack = new JLabel(new ImageIcon("ui/image/salesman/inBack.jpg"));
		lb_inBack.setVisible(false);
		lb_inBack.setBounds(0, 0, 1280, 720);
		this.add(lb_inBack);
		lb_inBack.setVisible(false);
		
		bt_inBack = new MyButton(730, 652, 115, 30);
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
		
		lb_sale = new JLabel(new ImageIcon("ui/image/salesman/sale.jpg"));
		lb_sale.setVisible(false);
		lb_sale.setBounds(0, 0, 1280, 720);
		this.add(lb_sale);
		lb_sale.setVisible(false);
		
		bt_sale = new MyButton(935, 652, 80, 30);
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
		
		lb_saleBack = new JLabel(new ImageIcon("ui/image/salesman/saleBack.jpg"));
		lb_saleBack.setVisible(false);
		lb_saleBack.setBounds(0, 0, 1280, 720);
		this.add(lb_saleBack);
		lb_saleBack.setVisible(false);
		
		bt_saleBack = new MyButton(1095, 652, 120, 30);
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
		
		MyBackground background = new MyBackground("ui/image/salesman/background.jpg");
		this.add(background);
		
	}
	
	public static void visibleTrue(int i){
		
		flag = i;
		
		switch(i){
			case 0: panel_si.setVisible(true);break;
			case 1: panel_cm.setVisible(true);break;
			case 2: panel_iu.setVisible(true);
					in_back.setVisible(true);break;
			case 3: panel_ibu.setVisible(true);
					in_back.setVisible(true);break;
			case 4: panel_su.setVisible(true);break;
			case 5: panel_sbu.setVisible(true);break;
			
			//进货时的第二步 -添加客户
			case 6: panel_inClient.setVisible(true);
					flag = 2;break;
			//进货时最后一步 -确认生成
			case 7: panel_inFinal.setVisible(true);
					flag = 2;break;
					
			case 8: panel_inBackFinal.setVisible(true);
					flag = 3;break;
		}
	}
	
	public static void visibleFalse(int i){
		
		switch(i){
			case 0: panel_si.setVisible(false);break;
			case 1: panel_cm.setVisible(false);break;
			case 2: panel_iu.setVisible(false);
					panel_inClient.setVisible(false);
					panel_inFinal.setVisible(false);
					in_back.setVisible(false);break;
			case 3: panel_ibu.setVisible(false);
					panel_inBackFinal.setVisible(false);
					in_back.setVisible(false);break;
			case 4: panel_su.setVisible(false);break;
			case 5: panel_sbu.setVisible(false);break;
			
			//进货时的第二步 -添加客户
			case 6: in_back.setVisible(false);
					flag = 2;break;
			//进货退货第二步 -添加客户
			case 8: in_back.setVisible(false);
					flag = 3;break;
		}
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == bt_vanish){
			this.dispose();
		}
		
		if(events.getSource() == bt_index){
			if(flag != 0){
				destination = 0;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_client){
			if(flag == 0){			
				panel_cm.setVisible(true);
				panel_si.setVisible(false);
				flag = 1;
			}else if(flag == 1){
				
			}else{
				destination = 1;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_in){
			if(flag == 0){			
				panel_iu.setVisible(true);
				in_back.setVisible(true);
				InGood.ClearAll();
				panel_si.setVisible(false);
				flag = 2;
			}else if(flag == 2){
				
			}else{
				destination = 2;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_inBack){
			if(flag == 0){			
				panel_ibu.setVisible(true);
				in_back.setVisible(true);
				InBackFirst.ClearAll();
				panel_si.setVisible(false);
				flag = 3;
			}else if(flag == 3){
				
			}else{
				destination = 3;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_sale){
			if(flag == 0){			
				panel_su.setVisible(true);
				panel_si.setVisible(false);
				flag = 4;
			}else if(flag == 4){
				
			}else{
				destination = 4;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_saleBack){
			if(flag == 0){			
				panel_sbu.setVisible(true);
				panel_si.setVisible(false);
				flag = 5;
			}else if(flag == 5){
				
			}else{
				destination = 5;
				ExitFunctionFrame ef = new ExitFunctionFrame("Sale");
				ef.setVisible(true);
			}
		}
	}
}
