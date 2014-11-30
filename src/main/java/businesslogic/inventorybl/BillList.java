package businesslogic.inventorybl;

import java.util.ArrayList;

import po.CommodityItemPO;
import vo.CommodityItemVO;

/**
 * 库存赠送单
 * （库存赠送单，选择一些库存中的商品进行赠送，单据审批后，系统从库存中减掉这些商品。
 * 我们假设很快本公司就会使用适当的方法将这些商品赠送出去。 ）
 * @author Zing
 * @version Nov 28, 20142:49:20 PM
 */
public class BillList {
	private ArrayList<BillListItem> items;
	private String remark;
	
	public BillList() {
		items = new ArrayList<BillListItem>();
	}
	
	public void addItem(BillListItem item){
		items.add(item);
	}
	
	public ArrayList<CommodityItemVO> getCommodityVOs(){
		return null;
	}
	
	public ArrayList<CommodityItemPO> getCommodityPOs(){
		return null;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

}
