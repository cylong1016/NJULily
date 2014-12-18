package ui.commonui.text_conductor;

import java.util.ArrayList;

import blservice.commodityblservice.CommodityBLService;

import businesslogic.commoditybl.CommodityController;

import vo.AccountBillVO;
import vo.CashBillVO;
import vo.InventoryBillVO;
import vo.PurchaseVO;
import vo.ValueObject;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;
import vo.sale.SalesVO;
import dataenum.BillType;

public class TextConductor {

	public String writeBill(BillType billType, ValueObject bill){
		
		if(billType.equals(BillType.PURCHASE)){
			return writePurchase((PurchaseVO)bill);
		}else if(billType.equals(BillType.PURCHASEBACK)){
			return writePurchaseBack((PurchaseVO)bill);
		}else if(billType.equals(BillType.SALE)){
			return writeSale((SalesVO)bill);
		}else if(billType.equals(BillType.SALEBACK)){
			return writeSaleBack((SalesVO)bill);
		}else if(billType.equals(BillType.OVERFLOW)){
			return writeOverFlow((InventoryBillVO)bill);
		}else if(billType.equals(BillType.LOSS)){
			return writeLoss((InventoryBillVO)bill);
		}else if(billType.equals(BillType.ALARM)){
			return writeAlarm((InventoryBillVO)bill);
		}else if(billType.equals(BillType.GIFT)){
			return writeGift((InventoryBillVO)bill);
		}else if(billType.equals(BillType.EXPENSE)){
			return writeExpense((AccountBillVO)bill);
		}else if(billType.equals(BillType.PAY)){
			return writePay((AccountBillVO)bill);
		}else if(billType.equals(BillType.CASH)){
			return writeCash((CashBillVO)bill);
		}
		return null;
	}
	
	public String writePurchase(PurchaseVO bill){
	
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		
		ArrayList<CommodityItemVO> list = bill.commodities;
		double total = 0;
		
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
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "客户名称：" + bill.client + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.user + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "仓库名称：" + bill.storage + "\n";
		
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
		if(bill.remark == null){
			text = text + "无" + "\n" + "\n";
		}else{
			text = text + bill.remark + "\n" + "\n";
		}
	
		return text;
	}
	
	public String writePurchaseBack(PurchaseVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		double total = 0;
		String ID = bill.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 24; i++)
			blank = blank + blank4;
		text = text + blank + "进货退货单" + "\n";
		
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
		text = text + "客户名称：" + bill.client + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.user + "\n";
		
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
		if(bill.remark == null){
			text = text + "无" + "\n" + "\n";
		}else{
			text = text + bill.remark + "\n" + "\n";
		}
		return text;
	}
	
	public String writeSale(SalesVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		double total = 0;
		String ID = bill.ID;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "销售单" + "\n";
		
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
		text = text + "客户名称：" + bill.client + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.user + "\n";
		
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
		text = text + "商品优惠前总价：" + String.format("%.2f",total) + "元\n" ;
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "商品折让数额：" + String.format("%.2f",bill.allowance) + "元\n" ;
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "代金券数额：" + String.format("%.2f",bill.voucher) + "元\n\n" ;
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "商品优惠后总价："
			+ String.format("%.2f",total - bill.allowance - bill.voucher) + "元\n" + "\n" + "\n" ;
		
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
		if(bill.remark != null)
			text = text + bill.remark + "\n" + "\n";
	
		return text;
	}
	
	public String writeSaleBack(SalesVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		double total = 0;
	
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 24; i++)
			blank = blank + blank4;
		text = text + blank + "销售退货单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "客户名称：" + bill.client + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.user + "\n";
		
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
		if(bill.remark != null)
			text = text + bill.remark + "\n" + "\n";
	
		return text;
	} 
	
	public String writeOverFlow(InventoryBillVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "报溢单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int k = 0; k < list.size(); k++){
			
			CommodityBLService commo = new CommodityController();
			ArrayList<CommodityVO> cmList = commo.show();
			CommodityVO cvo = null ;
			
			for(int i = 0; i < cmList.size(); i++){
				if(cmList.get(i).ID.equals(list.get(k).ID)){
					cvo = cmList.get(i);
				}
			}
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据商品序号：" + (k + 1) + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品编号：" + cvo.ID + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品名称：" + cvo.name + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品型号：" + cvo.type + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品系统保存个数：" + cvo.inventoryNum + "件" + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品实际库存个数：" + list.get(k).number +  "件" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "报溢个数：" + (list.get(k).number - cvo.inventoryNum) + "件" +"\n"+"\n";	
			
		}
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "备注："+"\n";
		
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		if(bill.remark != null)
			text = text + bill.remark;
		
		return text;
	}
	
	public String writeLoss(InventoryBillVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "报损单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int k = 0; k < list.size(); k++){
			
			CommodityBLService commo = new CommodityController();
			ArrayList<CommodityVO> cmList = commo.show();
			CommodityVO cvo = null ;
			
			for(int i = 0; i < cmList.size(); i++){
				if(cmList.get(i).ID.equals(list.get(k).ID)){
					cvo = cmList.get(i);
				}
			}
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据商品序号：" + (k + 1) + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品编号：" + cvo.ID + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品名称：" + cvo.name + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品型号：" + cvo.type + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品系统保存个数：" + cvo.inventoryNum + "件" + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品实际库存个数：" + list.get(k).number +  "件" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "报损个数：" + (cvo.inventoryNum - list.get(k).number) + "件" +"\n"+"\n";				
		}
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "备注："+"\n";
		
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		if(bill.remark != null)
			text = text + bill.remark;
		
		return text;
	}
	
	public String writeAlarm(InventoryBillVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "报警单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int k = 0; k < list.size(); k++){
			
			CommodityBLService commo = new CommodityController();
			ArrayList<CommodityVO> cmList = commo.show();
			CommodityVO cvo = null ;
			
			for(int i = 0; i < cmList.size(); i++){
				if(cmList.get(i).ID.equals(list.get(k).ID)){
					cvo = cmList.get(i);
				}
			}
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据商品序号：" + (k + 1) + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品编号：" + cvo.ID + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品名称：" + cvo.name + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品型号：" + cvo.type + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品警戒数量：" + cvo.alarmNumber + "件" + "\n";
				
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品库存个数：" + list.get(k).number +  "件" +"\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "警报个数：" + (cvo.alarmNumber - list.get(k).number) + "件" +"\n"+"\n";				
		}
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "备注："+"\n";
		
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		if(bill.remark != null)
			text = text + bill.remark;
		
		return text;
	}
	
	public String writeGift(InventoryBillVO bill){
		ArrayList<CommodityItemVO> list = bill.commodities;
		
		String text = "";
		String blank4 = "    ";
		String blank = "";
		String line = "----";
		for(int i = 0; i < 25; i++)
			blank = blank + blank4;
		text = text + blank + "赠送单" + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "订单编号：" + bill.ID + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int k = 0; k < list.size(); k++){
			
			CommodityBLService commo = new CommodityController();
			ArrayList<CommodityVO> cmList = commo.show();
			CommodityVO cvo = null ;
			
			for(int i = 0; i < cmList.size(); i++){
				if(cmList.get(i).ID.equals(list.get(k).ID)){
					cvo = cmList.get(i);
				}
			}
			
			for(int i = 0; i < 7; i++)
				text = text + blank4;
			text = text + "单据商品序号：" + (k + 1) + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品编号：" + cvo.ID + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品名称：" + cvo.name + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品型号：" + cvo.type + "\n";
			
			for(int i = 0; i < 9; i++)
				text = text + blank4;
			text = text + "商品个数：" + list.get(k).number + "件" +"\n" +"\n";		
		}
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "备注：" + "\n";
		
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		
		text = text + bill.remark;
		
		return text;
	}
	
	public String writeExpense(AccountBillVO bill){
		
		String ID = bill.ID;
	
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
		text = text + "客户名称：" + bill.clientName + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.username + "\n";
		
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
		text = text + "转账账户：" + bill.bills.get(0).accountName + "\n";
			
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		text = text + "转账金额：" + bill.sumMoney + "元\n";
		
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
		text = text + bill.bills.get(0).remark + "\n" + "\n";
		
		return text;
	}
	
	public String writePay(AccountBillVO bill){
		
		String ID = bill.ID;
	
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
		text = text + "客户名称：" + bill.clientName + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.username + "\n";
		
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
		text = text + "转账账户：" + bill.bills.get(0).accountName + "\n";
			
		for(int i = 0; i < 9; i++)
			text = text + blank4;
		text = text + "转账金额：" + bill.sumMoney + "元\n";
		
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
		text = text + bill.bills.get(0).remark + "\n" + "\n";
		
		return text;
	}
	
	String writeCash(CashBillVO bill){
		
		String ID = bill.ID;
		
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
		text = text + "账户名称：" + bill.account + "\n";
		
		for(int i = 0; i < 35; i++)
			text = text + blank4;
		text = text + "操作人员：" + bill.user + "\n";
		
		for(int i = 0; i < 5; i++)
			text = text + blank4;
		
		for(int i = 0; i < 32; i++)
			text = text + line;
		text = text + "\n";
		
		for(int i = 0; i < 7; i++)
			text = text + blank4;
		text = text + "账目信息：" + "\n";
		
		for(int i = 0; i < bill.bills.size(); i++ ){
			
			for(int j = 0; j < 9; j++)
				text = text + blank4;
			text = text + "条目序号：" + (i + 1) + "\n";
			
			for(int j = 0; j < 9; j++)
				text = text + blank4;
			text = text + "条目名称：" + bill.bills.get(i).name + "\n";
				
			for(int j = 0; j < 9; j++)
				text = text + blank4;
			text = text + "条目数额：" + bill.bills.get(i).money + "元\n";
			
			total = total + (bill.bills.get(i).money);
			
			for(int j = 0; j < 9; j++)
				text = text + blank4;
			if(bill.bills.get(i).remark.equals("null")){
				text = text + "条目备注："  + "\n\n";
			}else{
				text = text + "条目备注：" + bill.bills.get(i).remark + "\n\n";
			}
			
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
	
		return text;
	}
}
