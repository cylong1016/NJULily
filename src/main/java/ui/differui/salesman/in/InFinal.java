package ui.differui.salesman.in;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import dataenum.BillType;
import dataenum.Storage;
import blservice.purchaseblservice.PurInputInfo;
import businesslogic.purchasebl.Purchase;
import ui.commonui.login.Frame_Login;
import ui.commonui.myui.MyJButton;
import ui.commonui.warning.WarningFrame;
import ui.differui.salesman.frame.Frame_Salesman;
import vo.commodity.CommodityItemVO;

public class InFinal extends JLabel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	MyJButton button_back, button_finish, button_save, button_output;
	JTextArea ta;
	static JButton showText;
	
	String ID;
	
	public InFinal(){
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		
		Color foreColor = new Color(158, 213, 220);
		Color backColor = new Color(46, 52, 101);
		
		JLabel infoBar = new JLabel("创建进货单 - 确认生成");
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
		
		button_save = new MyJButton("保存至草稿状态");
		button_save.setBounds(1090, 540, 130, 25);
		button_save.setBackground(backColor);
		button_save.setForeground(foreColor);
		button_save.addActionListener(this);
		this.add(button_save);
		
		button_output = new MyJButton("导出至桌面");
		button_output.setBounds(1090, 505, 130, 25);
		button_output.setBackground(backColor);
		button_output.setForeground(foreColor);
		button_output.addActionListener(this);
		this.add(button_output);
			
		showText = new JButton();
		showText.addActionListener(this);
		this.add(showText);	
		}
	
	public void actionPerformed(ActionEvent events){
		
		if(events.getSource() == button_finish){
			Purchase purController = new Purchase();
			ArrayList<CommodityItemVO> list = InGood.commoList;
			
			//ADD COMMODITIES
			for(int i = 0; i < list.size(); i++)
				purController.addCommodities(list.get(i));
			
			//SUBMIT
			purController.submit(new PurInputInfo(InClient.ClientID, Storage.STORAGE_ONE, InClient.note));
		}
		
		if(events.getSource() == button_back){
			this.setVisible(false);
			Frame_Salesman.visibleTrue(6);
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
		
		Purchase purController = new Purchase();
		ArrayList<CommodityItemVO> list = InGood.commoList;
		double total = 0;
		ID = purController.getPurchaseID();
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "进货单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + ID + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "客户名称：" + InClient.ClientName + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + Frame_Login.userName + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "仓库名称：" + InClient.storeName + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int k = 0; k < list.size(); k++){
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据商品序号：" + (k + 1) + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品编号：" + list.get(k).ID + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品名称：" + list.get(k).name + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品型号：" + list.get(k).type + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品个数：" + list.get(k).number + "件" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品单价：" + String.format("%.2f", list.get(k).price) + "元" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
		
			text = text + "商品总价：" + String.format("%.2f", list.get(k).price * list.get(k).number) + "元" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			String remark;
			if(list.get(k).remark == null){
				remark = "无";
			}else{
				remark = list.get(k).remark;
			}
			text = text + "商品备注：" + remark + "\n"+"\n";
			
			total = total + list.get(k).price * list.get(k).number;		
		}
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "商品总价：" + String.format("%.2f",total) + "\n" + "\n" + "\n" + "\n" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "货单备注:" + "\n";
		
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		text = text + InClient.note + "\n" + "\n";
	
		return text;
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
