package ui.differui.finace.trade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyJButton;
import ui.commonui.warning.WarningFrame;
import ui.differui.finace.frame.Frame_Finace;
import vo.AccountBillItemVO;
import blservice.accountbillblservice.AccountBillBLService;
import blservice.cashbillblservice.CashBillBLService;
import businesslogic.accountbillbl.AccountBillController;
import businesslogic.cashbillbl.CashBillController;

public class TradeFinish extends JLabel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_back, button_finish, button_save, button_output;
	JTextArea ta;
	static JButton showText;
	
	String ID;
	static int type;
	
	public TradeFinish(){
		
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		JLabel infoBar = new JLabel("制定交易单 - 确认生成");
		infoBar.setFont(new Font("华文细黑", Font.BOLD, 18));
		infoBar.setBounds(80, 14, 1100, 20);
		infoBar.setForeground(Color.GRAY);
		infoBar.setOpaque(false);
		this.add(infoBar);
		
		ta = new JTextArea();
		ta.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(ta);
		jsp.setBounds(300, 70, 650, 490);
		this.add(jsp);
		
		button_back = new MyJButton("上一步");
		button_back.setBounds(75, 610 - 26 - 10, 130, 25);
		button_back.setBackground(backColor);
		button_back.setForeground(foreColor);
		button_back.addActionListener(this);
		this.add(button_back);
		
		button_finish = new MyJButton("完成货单创建");
		button_finish.setBounds(1090, 610 - 26 - 10, 130, 25);
		button_finish.setBackground(backColor);
		button_finish.setForeground(foreColor);
		button_finish.addActionListener(this);
		this.add(button_finish);
		
		button_output = new MyJButton("导出至桌面");
		button_output.setBounds(1090, 540, 130, 25);
		button_output.setBackground(backColor);
		button_output.setForeground(foreColor);
		button_output.addActionListener(this);
		this.add(button_output);
			
		showText = new JButton();
		showText.addActionListener(this);
		this.add(showText);	
		}
	
	public static void setType(int _type){
		type = _type;
		showText.doClick();
	}
	
	public void actionPerformed(ActionEvent events){
		
		if(events.getSource() == button_finish){
			
			if(type == 1){
				AccountBillBLService controller = new AccountBillController();
				controller.getExpenseID();
				controller.addAccountBill(TradeBill.clientID, TradeBill.clientName);
				controller.addBillItem(new AccountBillItemVO(TradeBill.accountName, TradeBill.money, TradeBill.note));
				controller.submit();				
			}else if(type == 2){
				AccountBillBLService controller = new AccountBillController();
				controller.getPayID();
				controller.addAccountBill(TradeBill.clientID, TradeBill.clientName);
				controller.addBillItem(new AccountBillItemVO(TradeBill.accountName, TradeBill.money, TradeBill.note));
				controller.submit();
			}else{
				CashBillBLService controller = new CashBillController();
				controller.getID();
				
				String[] str = TradeCash.billItem.split(";");
				
				for(int i = 0; i < str.length; i++ ){
					String[] str2 = str[i].split(":");
					controller.addBillItem(str2[0], Double.parseDouble(str2[1]), str2[2]);
				}
				
				controller.submit(TradeBill.accountName);
			}
			
			WarningFrame wf = new WarningFrame("添加成功！");
			wf.setVisible(true);
			this.setVisible(false);
			Frame_Finace.visibleTrue(0);
		}
		
		if(events.getSource() == button_back){
			this.setVisible(false);
			Frame_Finace.visibleTrue(10);
		}
		
		if(events.getSource() == button_output){
			FileSystemView fsv = FileSystemView.getFileSystemView();
			String file=String.valueOf(fsv.getHomeDirectory())+"/进货单"+ID+".txt";		
			writeto(ta.getText().replaceAll("\n", "\r\n"),file);
			
			WarningFrame wf = new WarningFrame("已成功导出至桌面！ ");
			wf.setVisible(true);
		}
		
		if(events.getSource() == showText){
			ta.setText(showText());
		}
	}
	
	public String showText(){
		
		if(type == 1){
			
			AccountBillBLService controller = new AccountBillController();
			ID = controller.getExpenseID();
		
			String text = "";
			String blank4 = "    ";
			String blank = "";
			String line = "----";
			for(int i = 0; i < 25; i++)
				blank = blank + blank4;
			text = text + blank + "收款单" + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "单据编号：" + ID + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "客户名称：" + TradeBill.clientName + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "操作人员：" + Frame_Login.userName + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "账目信息：" + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "转账账户：" + TradeBill.accountName + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "转账金额：" + TradeBill.money + "元\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
				
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据备注:" + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + TradeBill.note + "\n" + "\n";
			
			return text;
		}else if(type == 2){

			AccountBillBLService controller = new AccountBillController();
			ID = controller.getPayID();
			
			String text = "";
			String blank4 = "    ";
			String blank = "";
			String line = "----";
			for(int i = 0; i < 25; i++)
				blank = blank + blank4;
			text = text + blank + "付款单" + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "单据编号：" + ID + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "客户名称：" + TradeBill.clientName + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "操作人员：" + Frame_Login.userName + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "账目信息：" + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "转账账户：" + TradeBill.accountName + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "转账金额：" + TradeBill.money + "元\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
				
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据备注:" + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + TradeBill.note + "\n" + "\n";
			
			return text;
		}else{
			CashBillBLService controller = new CashBillController();
			ID = controller.getID();
			
			double total = 0;
			
			String text = "";
			String blank4 = "    ";
			String blank = "";
			String line = "----";
			for(int i = 0; i < 25; i++)
				blank = blank + blank4;
			text = text + blank + "现金费用单" + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "单据编号：" + ID + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "账户名称：" + TradeCash.accountName + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "操作人员：" + Frame_Login.userName + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "账目信息：" + "\n";
			
			
			String[] str = TradeCash.billItem.split(";");
			
			for(int i = 0; i < str.length; i++ ){
				
				String[] str2 = str[i].split(":");
				
				for(int j = 0; j < 9; j++)
					text = text + blank4;
				text = text + "条目序号：" + (i + 1) + "\n";
				
				for(int j = 0; j < 9; j++)
					text = text + blank4;
				text = text + "条目名称：" + str2[0] + "\n";
					
				for(int j = 0; j < 9; j++)
					text = text + blank4;
				text = text + "条目数额：" + str2[1] + "元\n";
				
				total = total + Double.parseDouble(str2[1]);
				
				for(int j = 0; j < 9; j++)
					text = text + blank4;
				if(str2[2].equals("null"))
					str2[2] = "无";
				text = text + "条目备注：" + str2[2] + "\n\n";
				
			}
		
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
			
			for(int i = 0; i < 35; i++)
				text = text + blank4;
			text = text + "条目总价：" + String.format("%.2f",total) + "\n" + "\n" + "\n";
			
			for(int i = 0; i < 5; i++)
				text = text + blank4;
			
			for(int i = 0; i < 32; i++)
				text = text + line;
			text = text + "\n";
					
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据备注:" + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + TradeCash.note + "\n" + "\n";
			
			return text;
		}	
	}
	public static void writeto(String a,String file){
		
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(a);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

