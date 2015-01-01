package ui.commonui.text_conductor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import dataenum.BillType;
import blservice.accountbillblservice.AccountBillShowBLService;
import blservice.cashbillblservice.CashBillShowBLService;
import blservice.inventoryblservice.InventoryShowBLService;
import blservice.purchaseblservice.PurchaseShowBLService;
import blservice.saleblservice.SaleShowBLService;
import businesslogic.accountbillbl.AccountBillShowController;
import businesslogic.cashbillbl.CashBillShowController;
import businesslogic.inventorybl.InventoryShowController;
import businesslogic.purchasebl.PurchaseShowController;
import businesslogic.salebl.SaleShowController;
import ui.commonui.exitfunction.ExitFunctionFrame;
import ui.commonui.myui.MyColor;
import ui.commonui.myui.MyComboBox;
import ui.commonui.myui.MyFrame;
import ui.commonui.myui.MyJButton;
import ui.commonui.myui.MyPanel;
import ui.commonui.warning.WarningFrame;
import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.ValueObject;
import vo.sale.SalesVO;

public class SavePanel extends MyPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	MyJButton button_no, button_check, button_out;
	JTextArea ta;
	MyComboBox cbb;
	
	ArrayList<BillType> typePool;
	ArrayList<ValueObject> billPool;
	
	static BillType billType;
	static ValueObject bill;
	
	public SavePanel(){
		
		typePool = new ArrayList<BillType>();
		billPool = new ArrayList<ValueObject>();
			
		int width = 700;
		int height = 610;
		
		this.setBounds((1280 - width) / 2, (720 - height) / 2, width, height);
		
		Color foreColor = Color.WHITE;
		Color backColor = MyColor.getColor();
		
		//information bar
		JLabel infoBar = new JLabel("单据查看",JLabel.CENTER);
		infoBar.setBounds(0, 0, width, 20);
		infoBar.setOpaque(true);
		infoBar.setForeground(foreColor);
		infoBar.setBackground(backColor);
		this.add(infoBar);
		
		ta = new JTextArea();
		ta.setEditable(false);
		ta.setBackground(Color.WHITE);
		ta.setForeground(Color.BLACK);

		
		JScrollPane jsp2 = new JScrollPane(ta);
		jsp2.setBounds(25, 40 + 50, 650, 465);
		this.add(jsp2);
		
		button_no = new MyJButton("返回");
		button_no.setBounds(700 - 25 - 120, 560 - 25 - 10 + 50, 120, 25);
		button_no.setForeground(foreColor);
		button_no.setBackground(backColor);
		button_no.addActionListener(this);
		this.add(button_no);
		
		button_check = new MyJButton("查看");
		button_check.setBounds(700 - 25 - 120, 45, 120, 25);
		button_check.addActionListener(this);
		this.add(button_check);
		
		button_out = new MyJButton("导出至桌面");
		button_out.setBounds(700 - 25 - 120 - 120 - 10, 560 - 25 - 10 + 50, 120, 25);
		button_out.addActionListener(this);
		this.add(button_out);
		
		JLabel label = new JLabel("请选择欲查看的单据草稿：");
		label.setForeground(Color.WHITE);
		label.setBounds(25, 47, 208, 18);
		add(label);
		
		cbb = new MyComboBox(25 + 208 , 47, 248, 20, getSave());
		this.add(cbb);
		
	}
	
	private String[] getSave(){
		String str = "";
		typePool.clear();
		billPool.clear();
		
		if(MyFrame.myNameis.equals("Frame_Inventory")){
		
			InventoryShowBLService controller = new InventoryShowController();
			
			ArrayList<InventoryBillVO> list = controller.showAlarmDraft();
			if(list != null)
				for(int i = 0; i < list.size(); i++){
					str = str + list.get(i).ID + ";";
					typePool.add(list.get(i).billType);
					billPool.add(list.get(i));
				}
			
			ArrayList<InventoryBillVO> list2 = controller.showGiftsDraft();
			if(list2 != null)
				for(int i = 0; i < list2.size(); i++){
					str = str + list2.get(i).ID + ";";
					typePool.add(list2.get(i).billType);
					billPool.add(list2.get(i));
				}
			
			ArrayList<InventoryBillVO> list3 = controller.showLossDraft();
			if(list3 != null)
				for(int i = 0; i < list3.size(); i++){
					str = str + list3.get(i).ID + ";";
					typePool.add(list3.get(i).billType);
					billPool.add(list3.get(i));
				}
			
			ArrayList<InventoryBillVO> list4 = controller.showOverFlowDraft();
			if(list4 != null)
				for(int i = 0; i < list4.size(); i++){
					str = str + list4.get(i).ID + ";";
					typePool.add(list4.get(i).billType);
					billPool.add(list4.get(i));
				}
			
		}else if(MyFrame.myNameis.equals("Frame_Salesman")){
			PurchaseShowBLService controller = new PurchaseShowController();
			
			ArrayList<PurchaseVO> list = controller.showPurchaseDraft();
			if(list != null)
				for(int i = 0; i < list.size(); i++){
					str = str + list.get(i).ID + ";";
					typePool.add(list.get(i).type);
					billPool.add(list.get(i));
				}
			
			ArrayList<PurchaseVO> list2 = controller.showPurchaseBackDraft();
			if(list2 != null)
				for(int i = 0; i < list2.size(); i++){
					str = str + list2.get(i).ID + ";";
					typePool.add(list2.get(i).type);
					billPool.add(list2.get(i));
				}
			
			SaleShowBLService controller2 = new SaleShowController();
			
			ArrayList<SalesVO> list3 = controller2.showSaleDraft();
			if(list3 != null)
				for(int i = 0; i < list3.size(); i++){
					str = str + list3.get(i).ID + ";";
					typePool.add(list3.get(i).type);
					billPool.add(list3.get(i));
				}
			
			ArrayList<SalesVO> list4 = controller2.showSaleBackDraft();
			if(list4 != null)
<<<<<<< HEAD
=======
				// TODO
>>>>>>> origin/master
				for(int i = 0; i < list4.size(); i++){
					str = str + list4.get(i).ID + ";";
					typePool.add(list4.get(i).type);
					billPool.add(list4.get(i));
				}
			
		}else if(MyFrame.myNameis.equals("Frame_Finace")){
			AccountBillShowBLService controller = new AccountBillShowController();
			
			ArrayList<AccountBillVO> list = controller.showExpenseDraft();
			if(list != null)
				for(int i = 0; i < list.size(); i++){
					str = str + list.get(i).ID + ";";
					typePool.add(list.get(i).type);
					billPool.add(list.get(i));
				}
			
			ArrayList<AccountBillVO> list2 = controller.showPayDraft();
			if(list2 != null)
				for(int i = 0; i < list2.size(); i++){
					str = str + list2.get(i).ID + ";";
					typePool.add(list2.get(i).type);
					billPool.add(list2.get(i));
				}
			
			CashBillShowBLService controller2 = new CashBillShowController();
			
			ArrayList<CashBillVO> list3 = controller2.showDraft();
			if(list3 != null)
				for(int i = 0; i < list3.size(); i++){
					str = str + list3.get(i).ID + ";";
					typePool.add(BillType.CASH);
					billPool.add(list3.get(i));
				}
		}
		
		if(typePool.size() != 0){
			return str.split(";");
		}else{
			String[] str2 = {"无"};
			return str2;
		}
		
	}
	
	public void actionPerformed(ActionEvent events){
		
		if(events.getSource() == button_no){
			ExitFunctionFrame eff = new ExitFunctionFrame("SaveFrame");
			eff.setVisible(true);
		}
		
		if(events.getSource() == button_check){
			if(cbb.getSelectedItem().toString().equals("无")){
				WarningFrame wf = new WarningFrame("目前无单据可以查看!");
				wf.setVisible(true);
			}else{
				billType = typePool.get(cbb.getSelectedIndex());
				bill = billPool.get(cbb.getSelectedIndex());
				
				TextConductor tc = new TextConductor();
				ta.setText(tc.writeBill(billType, bill));
			}
		}
		
		if(events.getSource() == button_out){
			if(cbb.getSelectedItem().toString().equals("无")){
				WarningFrame wf = new WarningFrame("目前无单据可以导出!");
				wf.setVisible(true);
			}else{
				FileSystemView fsv = FileSystemView.getFileSystemView();
				String file=String.valueOf(fsv.getHomeDirectory())+"/草稿单" + bill.ID + ".txt";		
				writeto(ta.getText().replaceAll("\n", "\r\n"),file);
				
				WarningFrame wf = new WarningFrame("已成功导出至桌面！ ");
				wf.setVisible(true);
			}
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



