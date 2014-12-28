package ui.differui.finace.frame;

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
import ui.differui.finace.account.AccountManagementUI;
import ui.differui.finace.business_condition.BusinessConditionUI;
import ui.differui.finace.business_process.BusinessProcessUI;
import ui.differui.finace.index.FinaceIndex;
import ui.differui.finace.sale_detail.SaleDetailUI;
import ui.differui.finace.trade.TradeBill;
import ui.differui.finace.trade.TradeCash;
import ui.differui.finace.trade.TradeChooseUI;
import ui.differui.finace.trade.TradeFinish;

public class Frame_Finace extends MyFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	static MyButton bt_index, bt_account, bt_trade, bt_saleDetail, bt_businessProcess, bt_businessCondition;
	JLabel lb_index, lb_account, lb_trade, lb_saleDetail, lb_businessProcess, lb_businessCondition;
	
	static JLabel lb_super;
	
	static MyBackground background;
	
	public static JButton bt_vanish;
	
	public static int flag = 0, destination = 0;
	
	static FinaceIndex panel_index;
	static AccountManagementUI panel_account;
	static TradeBill panel_trade;
	static TradeCash panel_cash;
	static TradeFinish panel_finish;
	static SaleDetailUI panel_saleDetail;
	static BusinessProcessUI panel_businessProcess;
	static BusinessConditionUI panel_businessCondition;
	
	static JLabel trade_back;
	
	public Frame_Finace(){
		
		bt_vanish = new JButton();
		bt_vanish.addActionListener(this);
		this.add(bt_vanish);
		
		Frame_Login.myNameis = "Frame_Finace";
		
		panel_index = new FinaceIndex();
		panel_index.setVisible(true);
		this.add(panel_index);
		
		panel_account = new AccountManagementUI();
		panel_account.setVisible(false);
		this.add(panel_account);
		
		panel_trade = new TradeBill();
		panel_trade.setVisible(false);
		this.add(panel_trade);
		
		panel_cash = new TradeCash();
		panel_cash.setVisible(false);
		this.add(panel_cash);
		
		panel_finish = new TradeFinish();
		panel_finish.setVisible(false);
		this.add(panel_finish);
		
		panel_saleDetail = new SaleDetailUI();
		panel_saleDetail.setVisible(false);
		this.add(panel_saleDetail);
		
		panel_businessProcess = new BusinessProcessUI();
		panel_businessProcess.setVisible(false);
		this.add(panel_businessProcess);
		
		panel_businessCondition = new BusinessConditionUI();
		panel_businessCondition.setVisible(false);
		this.add(panel_businessCondition);
		
		trade_back = new JLabel(new ImageIcon("ui/image/finace/tradeBack2.png"));
		trade_back.setBounds(0, 0, 1280, 630);
		trade_back.setVisible(false);
		this.add(trade_back);
		
		lb_super = new JLabel(new ImageIcon("ui/image/inventory/super.png"));
		lb_super.setBounds(0, 0, 1280, 720);
		lb_super.setVisible(false);
		this.add(lb_super);
		
		/////////////////////////////index///////////////////////////////
		
		lb_index = new JLabel(new ImageIcon("ui/image/finace/index.jpg"));
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
		
		lb_account = new JLabel(new ImageIcon("ui/image/finace/account.jpg"));
		lb_account.setVisible(false);
		lb_account.setBounds(0, 0, 1280, 720);
		this.add(lb_account);
		lb_account.setVisible(false);
		
		bt_account = new MyButton(415, 666, 68, 30);
		bt_account.addActionListener(this);
		bt_account.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_account.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_account.setVisible(false);
			}
			}); 
		this.add(bt_account);
		
		/////////////////////////////in///////////////////////////////
		
		lb_trade = new JLabel(new ImageIcon("ui/image/finace/trade.jpg"));
		lb_trade.setVisible(false);
		lb_trade.setBounds(0, 0, 1280, 720);
		this.add(lb_trade);
		lb_trade.setVisible(false);
		
		bt_trade = new MyButton(560, 652, 80, 30);
		bt_trade.addActionListener(this);
		bt_trade.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				lb_trade.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				lb_trade.setVisible(false);
			}
			}); 
		this.add(bt_trade);
		
		/////////////////////////////inBack///////////////////////////////
		
		lb_saleDetail = new JLabel(new ImageIcon("ui/image/finace/saleDetail.jpg"));
		lb_saleDetail.setVisible(false);
		lb_saleDetail.setBounds(0, 0, 1280, 720);
		this.add(lb_saleDetail);
		lb_saleDetail.setVisible(false);
		
		bt_saleDetail = new MyButton(730, 652, 85, 30);
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
		
		lb_businessProcess = new JLabel(new ImageIcon("ui/image/finace/businessProcess.jpg"));
		lb_businessProcess.setVisible(false);
		lb_businessProcess.setBounds(0, 0, 1280, 720);
		this.add(lb_businessProcess);
		lb_businessProcess.setVisible(false);
		
		bt_businessProcess = new MyButton(895, 652, 80, 30);
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
		
		lb_businessCondition = new JLabel(new ImageIcon("ui/image/finace/businessCondition.jpg"));
		lb_businessCondition.setVisible(false);
		lb_businessCondition.setBounds(0, 0, 1280, 720);
		this.add(lb_businessCondition);
		lb_businessCondition.setVisible(false);
		
		bt_businessCondition = new MyButton(1070, 652, 90, 30);
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
		
		background = new MyBackground("ui/image/finace/background.jpg");
		this.add(background);
		
		buttonVanish();
		
	}
	
	private static void buttonVanish(){
		
		bt_index.setVisible(false);
		bt_account.setVisible(false);
		bt_trade.setVisible(false);
		bt_saleDetail.setVisible(false);
		bt_businessProcess.setVisible(false);
		bt_businessCondition.setVisible(false);
		background.setVisible(false);
		lb_super.setVisible(false);
	}
	
	private static void buttonTurnedUp(){
		
		bt_index.setVisible(true);
		bt_account.setVisible(true);
		bt_trade.setVisible(true);
		bt_saleDetail.setVisible(true);
		bt_businessProcess.setVisible(true);
		bt_businessCondition.setVisible(true);
		background.setVisible(true);
		lb_super.setVisible(true);
		
	}
	
	public static void visibleTrue(int i){
	
		flag = i;
		
		if(i == 0){
			buttonVanish();
		}else{
			buttonTurnedUp();
		}
		
		switch(i){
			case 0: panel_index.setVisible(true);break;
			case 1: panel_account.setVisible(true);break;
			case 2: TradeChooseUI choose = new TradeChooseUI();
					choose.setVisible(true);break;
			case 3: panel_saleDetail.setVisible(true);break;
			case 4: panel_businessProcess.setVisible(true);break;
			case 5: panel_businessCondition.setVisible(true);break;
			
			case 6: panel_trade.setVisible(true);
					panel_trade.showAllAccount();
					panel_trade.reset();
					trade_back.setVisible(true);
					flag = 2;break;
					
			case 7: panel_cash.setVisible(true);
					panel_cash.showAllAccount();
					panel_cash.reset();
					trade_back.setVisible(true);
					flag = 2;break;
					
			case 8: panel_finish.setVisible(true);
					trade_back.setVisible(false);
					flag = 2;break;
					
			case 9: panel_trade.setVisible(true);
					panel_trade.showAllAccount();
					trade_back.setVisible(true);
					flag = 2;break;
			
			case 10: panel_cash.setVisible(true);
					 panel_cash.showAllAccount();
					 trade_back.setVisible(true);
					 flag = 2;break;
		}
	}
	
	public static void visibleFalse(int i){
		
		switch(i){
			case 0: panel_index.setVisible(false);break;
			case 1: panel_account.setVisible(false);break;
			case 2: panel_trade.setVisible(false);
					panel_cash.setVisible(false);
					trade_back.setVisible(false);break;
			case 3: panel_saleDetail.setVisible(false);break;
			case 4: panel_businessProcess.setVisible(false);break;
			case 5: panel_businessCondition.setVisible(false);break;
		}
	}
	
	public void actionPerformed(ActionEvent events){
		if(events.getSource() == bt_vanish){
			this.setVisible(false);
		}
		
		if(events.getSource() == bt_index){
			if(flag != 0){
				destination = 0;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_account){
			if(flag == 0){			
				panel_account.setVisible(true);
				panel_index.setVisible(false);
				flag = 1;
			}else if(flag == 1){
				
			}else{
				destination = 1;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_trade){
			if(flag == 0){			
				TradeChooseUI choose = new TradeChooseUI();
				choose.setVisible(true);
				panel_index.setVisible(false);
				flag = 2;
			}else if(flag == 2){
				
			}else{
				destination = 2;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_saleDetail){
			if(flag == 0){			
				panel_saleDetail.setVisible(true);
				panel_index.setVisible(false);
				flag = 3;
			}else if(flag == 3){
				
			}else{
				destination = 3;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_businessProcess){
			if(flag == 0){			
				panel_businessProcess.setVisible(true);
				panel_index.setVisible(false);
				flag = 4;
			}else if(flag == 4){
				
			}else{
				destination = 4;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
		
		if(events.getSource() == bt_businessCondition){
			if(flag == 0){			
				panel_businessCondition.setVisible(true);
				panel_index.setVisible(false);
				flag = 5;
			}else if(flag == 5){
				
			}else{
				destination = 5;
				ExitFunctionFrame ef = new ExitFunctionFrame("finace");
				ef.setVisible(true);
			}
		}
	}
}
