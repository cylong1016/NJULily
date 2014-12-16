package ui.differui.manager.frame;

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
import ui.differui.manager.approve.ApproveManagementUI;
import ui.differui.manager.business_condition.BusinessConditionUI;
import ui.differui.manager.business_process.BusinessProcessUI;
import ui.differui.manager.index.ManagerIndex;
import ui.differui.manager.sale_detail.SaleDetailUI;
import ui.differui.manager.strategy.StrategyManagementUI;


public class Frame_Manager extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyButton bt_index, bt_approve, bt_strategy, bt_saleDetail, bt_businessProcess, bt_businessCondition;
	JLabel lb_index, lb_approve, lb_strategy, lb_saleDetail, lb_businessProcess, lb_businessCondition;
	
	public static JButton bt_vanish;
	
	public static int flag = 0, destination = 0;
	
	static ManagerIndex panel_index;
	static ApproveManagementUI panel_approve;
	static StrategyManagementUI panel_strategy;
	static SaleDetailUI panel_saleDetail;
	static BusinessProcessUI panel_businessProcess;
	static BusinessConditionUI panel_businessCondition;
	
	public Frame_Manager(){

		bt_vanish = new JButton();
		bt_vanish.addActionListener(this);
		this.add(bt_vanish);
		
		Frame_Login.myNameis = "Frame_Manager";
		
		panel_index = new ManagerIndex();
		panel_index.setVisible(true);
		this.add(panel_index);
		
		panel_approve = new ApproveManagementUI();
		panel_approve.setVisible(false);
		this.add(panel_approve);
		
		panel_strategy = new StrategyManagementUI();
		panel_strategy.setVisible(false);
		this.add(panel_strategy);
		
		panel_saleDetail = new SaleDetailUI();
		panel_saleDetail.setVisible(false);
		this.add(panel_saleDetail);
		
		panel_businessProcess = new BusinessProcessUI();
		panel_businessProcess.setVisible(false);
		this.add(panel_businessProcess);
		
		panel_businessCondition = new BusinessConditionUI();
		panel_businessCondition.setVisible(false);
		this.add(panel_businessCondition);
		
		/////////////////////////////index///////////////////////////////
		
		lb_index = new JLabel(new ImageIcon("ui/image/manager/index.jpg"));
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
		
		lb_approve = new JLabel(new ImageIcon("ui/image/manager/approve.jpg"));
		lb_approve.setVisible(false);
		lb_approve.setBounds(0, 0, 1280, 720);
		this.add(lb_approve);
		lb_approve.setVisible(false);
		
		bt_approve = new MyButton(415, 666, 68, 30);
		bt_approve.addActionListener(this);
		bt_approve.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_approve.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_approve.setVisible(false);
			}
			}); 
		this.add(bt_approve);
		
		/////////////////////////////in///////////////////////////////
		
		lb_strategy = new JLabel(new ImageIcon("ui/image/manager/strategy.jpg"));
		lb_strategy.setVisible(false);
		lb_strategy.setBounds(0, 0, 1280, 720);
		this.add(lb_strategy);
		lb_strategy.setVisible(false);
		
		bt_strategy = new MyButton(1070, 652, 90, 30);
		bt_strategy.addActionListener(this);
		bt_strategy.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_strategy.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_strategy.setVisible(false);
			}
			}); 
		this.add(bt_strategy);
		
		/////////////////////////////inBack///////////////////////////////
		
		lb_saleDetail = new JLabel(new ImageIcon("ui/image/manager/saleDetail.jpg"));
		lb_saleDetail.setVisible(false);
		lb_saleDetail.setBounds(0, 0, 1280, 720);
		this.add(lb_saleDetail);
		lb_saleDetail.setVisible(false);
		
		bt_saleDetail = new MyButton(560, 652, 80, 30);
		bt_saleDetail.addActionListener(this);
		bt_saleDetail.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_saleDetail.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_saleDetail.setVisible(false);
			}
			}); 
		this.add(bt_saleDetail);
		
		/////////////////////////////sale///////////////////////////////
		
		lb_businessProcess = new JLabel(new ImageIcon("ui/image/manager/businessProcess.jpg"));
		lb_businessProcess.setVisible(false);
		lb_businessProcess.setBounds(0, 0, 1280, 720);
		this.add(lb_businessProcess);
		lb_businessProcess.setVisible(false);
		
		bt_businessProcess = new MyButton(730, 652, 85, 30);
		bt_businessProcess.addActionListener(this);
		bt_businessProcess.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_businessProcess.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_businessProcess.setVisible(false);
			}
			}); 
		this.add(bt_businessProcess);
		
		/////////////////////////////saleBack///////////////////////////////
		
		lb_businessCondition = new JLabel(new ImageIcon("ui/image/manager/businessCondition.jpg"));
		lb_businessCondition.setVisible(false);
		lb_businessCondition.setBounds(0, 0, 1280, 720);
		this.add(lb_businessCondition);
		lb_businessCondition.setVisible(false);
		
		bt_businessCondition = new MyButton(895, 652, 80, 30);
		bt_businessCondition.addActionListener(this);
		bt_businessCondition.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_businessCondition.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_businessCondition.setVisible(false);
			}
			}); 
		this.add(bt_businessCondition);
		
		/////////////////////////////back///////////////////////////////
		
		MyBackground background = new MyBackground("ui/image/manager/background.jpg");
		this.add(background);
		
	}
	
	public static void visibleTrue(int i){
		
		flag = i;
		
		switch(i){
			case 0: panel_index.setVisible(true);break;
			case 1: panel_approve.setVisible(true);break;
			case 5: panel_strategy.setVisible(true);break;
			case 2: panel_saleDetail.setVisible(true);break;
			case 3: panel_businessProcess.setVisible(true);break;
			case 4: panel_businessCondition.setVisible(true);break;
		}
	}
	
	public static void visibleFalse(int i){
		
		switch(i){
			case 0: panel_index.setVisible(false);break;
			case 1: panel_approve.setVisible(false);break;
			case 5: panel_strategy.setVisible(false);break;
			case 2: panel_saleDetail.setVisible(false);break;
			case 3: panel_businessProcess.setVisible(false);break;
			case 4: panel_businessCondition.setVisible(false);break;
		}
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == bt_vanish){
			this.dispose();
		}
		
		if(events.getSource() == bt_index){
			if(flag != 0){
				destination = 0;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_approve){
			if(flag == 0){			
				panel_approve.setVisible(true);
				panel_index.setVisible(false);
				flag = 1;
			}else if(flag == 1){
				
			}else{
				destination = 1;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_strategy){
			if(flag == 0){			
				panel_strategy.setVisible(true);
				panel_index.setVisible(false);
				flag = 5;
			}else if(flag == 5){
				
			}else{
				destination = 5;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_saleDetail){
			if(flag == 0){			
				panel_saleDetail.setVisible(true);
				panel_index.setVisible(false);
				flag = 2;
			}else if(flag == 2){
				
			}else{
				destination = 2;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_businessProcess){
			if(flag == 0){			
				panel_businessProcess.setVisible(true);
				panel_index.setVisible(false);
				flag = 3;
			}else if(flag == 3){
				
			}else{
				destination = 3;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_businessCondition){
			if(flag == 0){			
				panel_businessCondition.setVisible(true);
				panel_index.setVisible(false);
				flag = 4;
			}else if(flag == 4){
				
			}else{
				destination = 4;
				ExitFunctionFrame ef = new ExitFunctionFrame("manager");
				ef.setVisible(true);
			}
		}
	}
}
