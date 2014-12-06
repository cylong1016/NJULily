package ui.differui.inventory.frame;

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
import ui.commonui.warning.WarningFrame;
import ui.differui.inventory.commodity_management.index.CommodityManagementUI;
import ui.differui.inventory.gift.GiftUI;
import ui.differui.inventory.index.InventoryIndex;
import ui.differui.inventory.inventory_checking.InventoryCheckingUI;
import ui.differui.inventory.inventory_review.InventoryReviewUI;
import ui.differui.inventory.warning.WarningIndex;

public class Frame_Inventory extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyButton bt_index, bt_good, bt_show, bt_gift, bt_checking, bt_alarm;
	JLabel lb_index, lb_good, lb_show, lb_gift, lb_checking, lb_alarm;

	static JLabel lb_good2;
	
	public static int flag = 0, destination = 0;
	
	public static JButton bt_vanish, bt_restart;
	
	static InventoryIndex panel_index;
	static CommodityManagementUI panel_good;
	static InventoryReviewUI panel_review;
	static InventoryCheckingUI panel_checking;
	static GiftUI panel_gift;
	static WarningIndex panel_alarm;
	
	public Frame_Inventory(){
		
		Frame_Login.myNameis = "Frame_Inventory";
		
		panel_index = new InventoryIndex();
		panel_index.setVisible(true);
		this.add(panel_index);
		
		panel_good = new CommodityManagementUI();
		panel_good.setVisible(false);
		this.add(panel_good);
		
		panel_review = new InventoryReviewUI();
		panel_review.setVisible(false);
		this.add(panel_review);
		
		panel_checking = new InventoryCheckingUI();
		panel_checking.setVisible(false);
		this.add(panel_checking);
		
		panel_gift = new GiftUI();
		panel_gift.setVisible(false);
		this.add(panel_gift);
		
		panel_alarm = new WarningIndex();
		panel_alarm.setVisible(false);
		this.add(panel_alarm);
		

		lb_good2 = new JLabel(new ImageIcon("ui/image/inventory/good.png"));
		lb_good2.setBounds(0, 0, 1280, 630);
		lb_good2.setVisible(false);
		this.add(lb_good2);
		
		lb_index = new JLabel(new ImageIcon("ui/image/inventory/index.jpg"));
		lb_index.setBounds(0, 0, 1280, 720);
		lb_index.setVisible(false);
		this.add(lb_index);
			
		lb_good = new JLabel(new ImageIcon("ui/image/inventory/good.jpg"));
		lb_good.setBounds(0, 0, 1280, 720);
		lb_good.setVisible(false);
		this.add(lb_good);
		
		lb_show = new JLabel(new ImageIcon("ui/image/inventory/check.jpg"));
		lb_show.setBounds(0, 0, 1280, 720);
		lb_show.setVisible(false);
		this.add(lb_show);
		
		lb_checking = new JLabel(new ImageIcon("ui/image/inventory/pandian.jpg"));
		lb_checking.setBounds(0, 0, 1280, 720);
		lb_checking.setVisible(false);
		this.add(lb_checking);
		
		lb_gift = new JLabel(new ImageIcon("ui/image/inventory/gift.jpg"));
		lb_gift.setBounds(0, 0, 1280, 720);
		lb_gift.setVisible(false);
		this.add(lb_gift);
		
		lb_alarm = new JLabel(new ImageIcon("ui/image/inventory/alarm.jpg"));
		lb_alarm.setBounds(0, 0, 1280, 720);
		lb_alarm.setVisible(false);
		this.add(lb_alarm);
			
		bt_index = new MyButton(275, 662, 55, 30);
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
		
		bt_good = new MyButton(408, 662, 146, 30);
		bt_good.addActionListener(this);
		bt_good.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_good.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_good.setVisible(false);
			}
			}); 
		this.add(bt_good);
		
		bt_show = new MyButton(630, 662, 75, 30);
		bt_show.addActionListener(this);
		bt_show.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_show.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_show.setVisible(false);
			}
			}); 
		this.add(bt_show);
		
		bt_checking = new MyButton(780, 662, 70, 30);
		bt_checking.addActionListener(this);
		bt_checking.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_checking.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_checking.setVisible(false);
			}
			}); 
		this.add(bt_checking);
		
		bt_gift = new MyButton(920, 662, 70, 30);
		bt_gift.addActionListener(this);
		bt_gift.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_gift.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_gift.setVisible(false);
			}
			}); 
		this.add(bt_gift);
		
		bt_alarm = new MyButton(1070, 662, 83, 30);
		bt_alarm.addActionListener(this);
		bt_alarm.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_alarm.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_alarm.setVisible(false);
			}
			}); 
		this.add(bt_alarm);
		
		MyBackground background = new MyBackground("ui/image/inventory/back.jpg");
		this.add(background);
		
		bt_vanish = new JButton();
		bt_vanish.addActionListener(this);
		this.add(bt_vanish);
		
		bt_restart = new JButton();
		bt_restart.addActionListener(this);
		this.add(bt_restart);
	}
	
	public static void visibleTrue(int i){
		
		flag = i;
		
		switch(i){
			case 0: panel_index.setVisible(true);break;
			case 1: panel_good.setVisible(true);
					lb_good2.setVisible(true);break;
			case 2: panel_review.setVisible(true);break;
			case 3: panel_checking.setVisible(true);break;
			case 4: panel_gift.setVisible(true);break;
			case 5: panel_alarm.setVisible(true);break;
		}
	}
	
	public static void visibleFalse(int i){
		
		switch(i){
			case 0: panel_index.setVisible(false);break;
			case 1: panel_good.setVisible(false);
					lb_good2.setVisible(false);break;
			case 2: panel_review.setVisible(false);break;
			case 3: panel_checking.setVisible(false);break;
			case 4: panel_gift.setVisible(false);break;
			case 5: panel_alarm.setVisible(false);break;
		}
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == bt_vanish){
			this.setVisible(false);
		}
				
		if(events.getSource() == bt_index){
			if(flag != 0){
				destination = 0;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		
		if(events.getSource() == bt_good){
			if(flag == 0){			
				panel_good.setVisible(true);
				panel_index.setVisible(false);
				lb_good2.setVisible(true);
				flag = 1;
			}else if(flag == 1){
				
			}else{
				destination = 1;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_show){
			if(flag == 0){			
				panel_review.setVisible(true);
				panel_index.setVisible(false);	
				flag = 2;
			}else if(flag == 2){
				
			}else{
				destination = 2;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_checking){
			if(flag == 0){			
				panel_checking.setVisible(true);
				panel_index.setVisible(false);	
				flag = 3;
			}else if(flag == 3){
				
			}else{
				destination = 3;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_gift){
			if(flag == 0){			
				panel_gift.setVisible(true);
				panel_index.setVisible(false);	
				flag = 4;
			}else if(flag == 4){
				
			}else{
				destination = 4;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_alarm){
			if(flag == 0){			
				panel_alarm.setVisible(true);
				panel_index.setVisible(false);	
				flag = 5;
			}else if(flag == 5){
				
			}else{
				destination = 5;
				ExitFunctionFrame ef = new ExitFunctionFrame("Inventory");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_restart){
			this.setVisible(false);
			flag = 0;
			Frame_Inventory fi = new Frame_Inventory();
			fi.setVisible(true);
			bt_good.doClick();
			
			WarningFrame wf = new WarningFrame("商品分类添加成功！");
			wf.setVisible(true);
		}
	}	
}
